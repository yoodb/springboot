package com.yoodb.study.demo08.service;


import com.yoodb.study.demo08.bean.Article;

import java.util.Iterator;
import java.util.List;

public interface IElasticService {

    public void save(Article article);

    public void saveAll(List<Article> list);

    public Iterator<Article> findAll();

    public List<Article> findArticleByTitle(String title);

}

