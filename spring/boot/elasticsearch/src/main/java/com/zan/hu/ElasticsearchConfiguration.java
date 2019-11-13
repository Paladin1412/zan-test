package com.zan.hu;

import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @version 1.0
 * @Author hupeng
 * @Date 2019-11-13 11:04
 * @Description todo
 **/
@Configuration
public class ElasticsearchConfiguration implements FactoryBean<RestHighLevelClient>, InitializingBean, DisposableBean {

    @Autowired
    private ElasticsearchConfig elasticsearchConfig;

    /**
     * 超时时间设为5分钟
     */
    private static final int TIME_OUT = 5 * 60 * 1000;


    private RestHighLevelClient restHighLevelClient;

    @Override
    public void destroy() throws Exception {
        try {
            if (restHighLevelClient != null) {
                restHighLevelClient.close();
            }
        } catch (Exception e) {
        }
    }

    @Override
    public RestHighLevelClient getObject() throws Exception {
        return restHighLevelClient;
    }

    @Override
    public Class<?> getObjectType() {
        return RestHighLevelClient.class;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("restHighLevelClient构建中");
        RestClientBuilder builder = RestClient.builder(makeHttpHost());
        builder.setRequestConfigCallback((RequestConfig.Builder requestConfigBuilder) -> {
            return requestConfigBuilder.setSocketTimeout(TIME_OUT);
        });
        restHighLevelClient = new RestHighLevelClient(builder);
    }

    private HttpHost[] makeHttpHost() {
        List<ElasticsearchConfig.Hosts> hosts = elasticsearchConfig.getHosts();
        HttpHost[] httpHosts = new HttpHost[hosts.size()];
        for (int i = 0; i < hosts.size(); i++) {
            ElasticsearchConfig.Hosts host = hosts.get(i);
            httpHosts[i] = new HttpHost(host.getIp(), host.getPort(), host.getSchema());
        }
        return httpHosts;
    }
}
