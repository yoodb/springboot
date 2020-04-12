package com.yoodb.study.demo08.service.impl;

import com.yoodb.study.demo08.bean.Article;
import com.yoodb.study.demo08.config.ElasticRepository;
import com.yoodb.study.demo08.service.IElasticService;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service("elasticService")
public class ElasticServiceImpl implements IElasticService {

    @Autowired
    private ElasticRepository elasticRepository;


    @Override
    public void save(Article article) {
        elasticRepository.deleteAll();
        elasticRepository.save(article);
    }

    @Override
    public void saveAll(List<Article> list) {
        elasticRepository.saveAll(list);
    }

    @Override
    public Iterator<Article> findAll() {
        return elasticRepository.findAll().iterator();
    }

    public List<Article> findArticleByTitle(String title) {
        //matchQuery 会对关键字分词后进行搜索:谷歌中国---> 谷歌  中国
        MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("title", title);
        QueryBuilders.commonTermsQuery("title",title);
        Iterable<Article> search = elasticRepository.search(matchQueryBuilder);
        Iterator<Article> iterator = search.iterator();
        List<Article> list = new ArrayList<>();
        while (iterator.hasNext()){
            Article next = iterator.next();
            list.add(next);
        }
        return list;
    }
}

