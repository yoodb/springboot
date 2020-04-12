package com.yoodb.study.demo08.bean;

import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

@Document(indexName = "blog",type = "article")
public class Article {
    /**
     * 主键ID
     */
    @Field(type = FieldType.Keyword)
    private String id;

    /**
     * 文章标题
     */
    @Field(type = FieldType.Text, analyzer = "ik_max_word",searchAnalyzer = "ik_max_word")
    private String title;

    /**
     * 文章内容
     */
    @Field(type = FieldType.Text, analyzer = "ik_max_word",searchAnalyzer = "ik_max_word")
    private String content;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
