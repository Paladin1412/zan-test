package com.zan.hu;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.IndicesOptions;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.json.JsonXContent;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @Author hupeng
 * @Date 2019-10-21 17:09
 * @Description todo
 **/
@RestController
@RequestMapping("/es")
public class ESController {

    private RestHighLevelClient highLevelClient;

    public ESController(ElasticsearchConfiguration configuration) throws Exception {
        this.highLevelClient = configuration.getObject();
    }

    @GetMapping
    public void create() throws IOException {
        CreateIndexRequest request = new CreateIndexRequest("pybbs");
        request.settings(Settings.builder()
            .put("index.number_of_shards", 1)
            .put("index.number_of_shards", 5));
        XContentBuilder mappingBuilder = JsonXContent.contentBuilder()
            .startObject()
            .startObject("properties")
            .startObject("title")
            .field("type", "keyword")
            //                .field("analyzer", "ik_max_word")
            //                .field("fielddata", "true")
            .endObject()
            .startObject("content")
            .field("type", "keyword")
            //                .field("analyzer", "ik_max_word") // ik_max_word 这个分词器是ik的，可以去github上搜索安装es的ik分词器插件
            //.field("fielddata", true)
            .endObject()
            .endObject()
            .endObject();
        request.mapping("topic", mappingBuilder);

        CreateIndexResponse response = highLevelClient.indices().create(request, RequestOptions.DEFAULT);
        System.out.println(response.toString());
        System.out.println(response.isAcknowledged());
    }

    @GetMapping("/document")
    public void createDocument() throws IOException {
        Map<String, Object> map = new HashMap<>();
        map.put("title", "上海自来水来自海上232313300");
        map.put("content", "llllkkkk");

        IndexRequest request = new IndexRequest("pybbs",
            "topic"); // 这里最后一个参数是es里储存的id，如果不填，es会自动生成一个，个人建议跟自己的数据库表里id保持一致，后面更新删除都会很方便
        request.source(map);
        IndexResponse response = highLevelClient.index(request, RequestOptions.DEFAULT);
        System.out.println();
    }

    @GetMapping("/search")

    public void searchDocument() throws IOException {
        SearchRequest request = new SearchRequest("pybbs");
        SearchSourceBuilder builder = new SearchSourceBuilder();
        // builder.from(0).size(2); // 分页
        // builder.query(QueryBuilders.matchQuery("content", "llll"));
        TermsAggregationBuilder aggregation = AggregationBuilders.terms("by_company")
            .field("content");
        builder.aggregation(aggregation);

        //        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        //        RangeQueryBuilder rangeQueryBuilder = QueryBuilders.rangeQuery("createdTime");
        //        boolQueryBuilder.must(rangeQueryBuilder.gte(1571712755000l));
        //        boolQueryBuilder.must(rangeQueryBuilder.lte(1571971955000l));
        //        builder.query(boolQueryBuilder);

        //        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        //聚合查询
        //        TermsAggregationBuilder aggregation = AggregationBuilders.terms("numberOfWorkOrdersEnteredSum")
        //                .field("operator");
        //多条件查询
        //        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery().must(QueryBuilders.matchQuery
        //        ("merchantId", request.getMerchantId()))
        //                .must(QueryBuilders.matchQuery("type", WorkOrderBehavior.ENTRY.name()))
        //                .must(builderBoolQueryBuilder(request));
        //        searchSourceBuilder.query(boolQueryBuilder);
        //        searchSourceBuilder.aggregation(aggregation);

        request.source(builder);

        SearchResponse response = highLevelClient.search(request, RequestOptions.DEFAULT);
        Aggregations aggregations = response.getAggregations();
        Terms parsedStringTerms = (Terms)aggregations.get("by_company");
        List<? extends Terms.Bucket> buckets = parsedStringTerms.getBuckets();
        for (Terms.Bucket bucket : buckets) {
            System.out.println(bucket.getKeyAsString());
            System.out.println(bucket.getDocCount());
        }
        for (SearchHit documentFields : response.getHits()) {
            String sourceAsString = documentFields.getSourceAsString();
            System.out.println(sourceAsString);
            // System.out.println(String.format("result:%s, code:%s, status: %s", JSON.toJSONString(documentFields),
            // response.status().getStatus(), response.status().name()));
        }
    }

    @DeleteMapping
    public void deleteDocument() throws IOException {
        DeleteRequest request = new DeleteRequest("pybbs", "topic", "fijFAW4BcwLIiPEMC3SC");
        DeleteResponse response = highLevelClient.delete(request, RequestOptions.DEFAULT);
        System.out.println(response.status().getStatus());
        // exist: result: code: 200, status: OK
        // not exist: result: code: 404, status: NOT_FOUND
    }

    @DeleteMapping("/index")
    public void deleteIndex() throws IOException {
        DeleteIndexRequest request = new DeleteIndexRequest("pybbs");
        request.indicesOptions(IndicesOptions.LENIENT_EXPAND_OPEN);
        AcknowledgedResponse response = highLevelClient.indices().delete(request, RequestOptions.DEFAULT);
        System.out.println(String.format("result:%s", response.isAcknowledged()));
    }

    public void bulkDocument() throws IOException {
        BulkRequest requests = new BulkRequest();

        Map<String, Object> map1 = new HashMap<>();
        map1.put("title", "我是中国人");
        IndexRequest request1 = new IndexRequest("pybbs", "topic", "1");
        request1.source(map1);
        requests.add(request1);

        Map<String, Object> map2 = new HashMap<>();
        map2.put("title", "武汉市长江大桥欢迎您");
        IndexRequest request2 = new IndexRequest("pybbs", "topic", "2");
        request2.source(map2);
        requests.add(request2);

        Map<String, Object> map3 = new HashMap<>();
        map3.put("title", "上海自来水来自海上");
        IndexRequest request3 = new IndexRequest("pybbs", "topic", "3");
        request3.source(map3);
        requests.add(request3);
        BulkResponse responses = highLevelClient.bulk(requests, RequestOptions.DEFAULT);
        // not exist: result: code: 200, status: OK
        // exist: result: code: 200, status: OK
    }
}
