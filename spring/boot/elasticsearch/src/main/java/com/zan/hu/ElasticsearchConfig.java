package com.zan.hu;

import lombok.Data;
import org.apache.http.HttpHost;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @Author hupeng
 * @Date 2019-11-13 11:25
 * @Description todo
 **/
@Data
@Configuration
@ConfigurationProperties(prefix = "elkconfig")
public class ElasticsearchConfig {
    private String clusterName;
    private String index;
    @NestedConfigurationProperty
    private List<Hosts> hosts;

    @Data
    public static class Hosts {
        private String ip;
        private int port;
        private String schema;
    }

    public static void main(String[] args) {
        List<Hosts> hosts = new ArrayList<>();
        Hosts hosts1 = new Hosts();
        hosts1.setIp("1");
        hosts1.setPort(200);
        hosts1.setSchema("http");
        hosts.add(hosts1);
        Hosts hosts2 = new Hosts();
        hosts2.setIp("2");
        hosts2.setPort(300);
        hosts2.setSchema("http");
        hosts.add(hosts2);
        HttpHost[] httpHosts = new HttpHost[hosts.size()];
        for (int i = 0; i < hosts.size(); i++) {
            Hosts host = hosts.get(i);
            httpHosts[i] = new HttpHost(host.ip, host.port, host.schema);
        }
        System.out.println(httpHosts);
    }
}


