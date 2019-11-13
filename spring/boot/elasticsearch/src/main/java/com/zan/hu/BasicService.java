package com.zan.hu;

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
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.IndicesClient;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * @version 1.0
 * @Author hupeng
 * @Date 2019-11-13 16:35
 * @Description todo
 **/
@Service
public class BasicService {

    private RestHighLevelClient highLevelClient;

    public BasicService(ElasticsearchConfiguration configuration) throws Exception {
        this.highLevelClient = configuration.getObject();
    }

    boolean createIndex(String indexName, XContentBuilder xContentBuilder) throws Exception {
//        XContentBuilder builder = XContentFactory.jsonBuilder()
//                .startObject()
//                .field("properties")
//                .startObject()
//                .field("name").startObject().field("index", "true").field("type", "keyword").endObject()
//                .field("age").startObject().field("index", "true").field("type", "integer").endObject()
//                .field("money").startObject().field("index", "true").field("type", "double").endObject()
//                .field("address").startObject().field("index", "true").field("type", "text").field("analyzer", "ik_max_word").endObject()
//                .field("birthday").startObject().field("index", "true").field("type", "date").field("format", "strict_date_optional_time||epoch_millis").endObject()
//                .endObject()
//                .endObject();
        CreateIndexRequest createIndexRequest = new CreateIndexRequest(indexName);
        createIndexRequest.mapping(xContentBuilder);
        CreateIndexResponse createIndexResponse = highLevelClient.indices().create(createIndexRequest, RequestOptions.DEFAULT);
        return createIndexResponse.isAcknowledged();
    }

    boolean indexExists(String indexName) throws IOException {
        GetIndexRequest getIndexRequest = new GetIndexRequest(indexName);
        getIndexRequest.humanReadable(true);
        IndicesClient indices = highLevelClient.indices();
        return indices.exists(getIndexRequest, RequestOptions.DEFAULT);
    }

    boolean deleteIndex(String[] indexName) throws IOException {
        DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest(indexName);
        deleteIndexRequest.indicesOptions(IndicesOptions.LENIENT_EXPAND_OPEN);
        AcknowledgedResponse acknowledgedResponse = highLevelClient.indices().delete(deleteIndexRequest, RequestOptions.DEFAULT);
        return acknowledgedResponse.isAcknowledged();
    }

    boolean createDocment(String indexName, String type, Object object) throws IOException {
        IndexRequest indexRequest = new IndexRequest(indexName, type);
        indexRequest.source(object);
        IndexResponse indexResponse = highLevelClient.index(indexRequest, RequestOptions.DEFAULT);
        return indexResponse.status().getStatus() == 200;

    }

    boolean createDocument(String indexName, String type, List<Object> objects) throws IOException {
        BulkRequest requests = new BulkRequest();
        objects.forEach(o -> {
            IndexRequest indexRequest = new IndexRequest(indexName, type);
            indexRequest.source(o);
            requests.add(indexRequest);
        });
        BulkResponse bulkResponse = highLevelClient.bulk(requests, RequestOptions.DEFAULT);
        return bulkResponse.status().getStatus() == 200;
    }

    boolean updateDocument(String indexName, String type, String id, Object o) throws IOException {
        UpdateRequest updateRequest = new UpdateRequest(indexName, type, id);
        updateRequest.doc(o);
        UpdateResponse updateResponse = highLevelClient.update(updateRequest, RequestOptions.DEFAULT);
        return updateResponse.status().getStatus() == 200;
    }

    boolean deleteDocument(String indexName, String type, List<String> ids) throws IOException {
        BulkRequest requests = new BulkRequest();
        ids.forEach(id -> {
            DeleteRequest deleteRequest = new DeleteRequest(indexName, type, id);
            requests.add(deleteRequest);
        });
        BulkResponse bulkResponse = highLevelClient.bulk(requests, RequestOptions.DEFAULT);
        return bulkResponse.status().getStatus() == 200;
    }

    boolean deleteDocument(String indexName, String type, String id) throws IOException {
        DeleteRequest deleteRequest = new DeleteRequest(indexName, type, id);
        DeleteResponse deleteResponse = highLevelClient.delete(deleteRequest, RequestOptions.DEFAULT);
        return deleteResponse.status().getStatus() == 200;
    }

    SearchResponse searchDocument(SearchRequest searchRequest) throws IOException {
        SearchResponse searchResponse = highLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        return searchResponse;
    }
}
