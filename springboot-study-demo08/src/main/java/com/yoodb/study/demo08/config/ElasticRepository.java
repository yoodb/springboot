package com.yoodb.study.demo08.config;

        import com.yoodb.study.demo08.bean.Article;
        import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ElasticRepository extends ElasticsearchRepository<Article, String> {

}
