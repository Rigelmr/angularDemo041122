package com.cgi.rigel.service.impl;

import com.cgi.rigel.domain.ArticleRequest.ArticleRequest;
import com.cgi.rigel.domain.ArticleResponse.ArticleResponse;
import com.cgi.rigel.entity.ArticleEntity;
import com.cgi.rigel.mapper.ArticleMapper;
import com.cgi.rigel.repository.ArticleRepository;
import com.cgi.rigel.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__ ({@Autowired}))
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository articleRepository;
    private final ArticleMapper articleMapper;

    @Override
    public ArticleResponse getArticleById(Long id){
        Optional<ArticleEntity> articleEntityOptional= articleRepository.findById(id);
        ArticleResponse articleResponse= null;
        if(articleEntityOptional.isPresent()){
            articleResponse= articleMapper.mapArticleEntityToArticleResponse(articleEntityOptional.get());
        }

        return articleResponse;
    }

    @Override
    public List<ArticleResponse> getArticles() {
        List<ArticleEntity> articles = articleRepository.findAll();
        List<ArticleResponse> articleResponses = new ArrayList<>();

        articles.forEach(article-> articleResponses.add(articleMapper.mapArticleEntityToArticleResponse(article)));

        return articleResponses;
    }

    @Override
    public List<ArticleResponse> findByNameContainingIgnoreCase(String searchterm) {
        List<ArticleEntity> articles = articleRepository.findByNameContainsIgnoreCase(searchterm);
        List<ArticleResponse> articleResponses = new ArrayList<>();

        articles.forEach(article-> articleResponses.add(articleMapper.mapArticleEntityToArticleResponse(article)));
        articleResponses.forEach(System.out::println);

        return articleResponses;
    }

    @Override
    public void addArticle(ArticleRequest request) {
        ArticleEntity articleEntity = articleMapper.mapArticleRequestToArticleEntity(request);
        articleRepository.save(articleEntity);
    }

    @Override
    public void updateArticle(ArticleRequest request){
        ArticleEntity articleEntity = articleMapper.mapArticleRequestToArticleEntity(request);
        articleRepository.save(articleEntity);
    }

    @Override
    public void deleteArticle(Long id) { articleRepository.deleteById(id); }

}
