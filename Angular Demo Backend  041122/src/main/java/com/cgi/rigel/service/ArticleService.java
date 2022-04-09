package com.cgi.rigel.service;

import com.cgi.rigel.domain.ArticleRequest.ArticleRequest;
import com.cgi.rigel.domain.ArticleResponse.ArticleResponse;

import java.util.List;

public interface ArticleService {

    public ArticleResponse getArticleById(Long id);
    public List<ArticleResponse> getArticles();
    public List<ArticleResponse> findByNameContainingIgnoreCase(String searchterm);
    public void addArticle(ArticleRequest request);
    public void updateArticle(ArticleRequest request);
    public void deleteArticle(Long id);
}
