package com.yoodb.study.demo08.config;

import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.net.InetAddress;

@Slf4j
@Configuration
@EnableElasticsearchRepositories(basePackages = "com.yoodb.study.demo08.service")
public class ElasticsearchConfig {

    @Value("${elasticsearch.host}")
    private String esHost;

    @Value("${elasticsearch.port}")
    private int esPort;

    @Value("${elasticsearch.clustername}")
    private String esClusterName;

    @Value("${elasticsearch.search.pool.size}")
    private Integer threadPoolSearchSize;


    @Bean
    public Client client() throws Exception {
        Settings esSettings = Settings.builder()
                .put("cluster.name", esClusterName)
                //增加嗅探机制，找到ES集群,非集群置为false
                .put("client.transport.sniff", true)
                //增加线程池个数
                .put("thread_pool.search.size", threadPoolSearchSize)
                .build();
        return new PreBuiltTransportClient(esSettings)
                .addTransportAddress(new TransportAddress(InetAddress.getByName(esHost), esPort));
    }

    @Bean(name="elasticsearchTemplate")
    public ElasticsearchOperations elasticsearchTemplateCustom() throws Exception {
        ElasticsearchTemplate elasticsearchTemplate;
        try {
            elasticsearchTemplate = new ElasticsearchTemplate(client());
            return elasticsearchTemplate;
        } catch (Exception e) {
            return new ElasticsearchTemplate(client());
        }
    }
}

