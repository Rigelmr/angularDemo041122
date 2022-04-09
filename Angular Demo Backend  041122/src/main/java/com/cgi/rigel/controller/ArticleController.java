package com.cgi.rigel.controller;

import com.cgi.rigel.domain.ArticleRequest.ArticleRequest;
import com.cgi.rigel.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/articles")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping
    public ResponseEntity getArticles(){
        return ResponseEntity.status(HttpStatus.OK).body(articleService.getArticles());
    }

    @GetMapping(value="/?name={searchTerm}")
    public ResponseEntity getArticlesByNameContaining(@PathVariable String searchTerm ){
        return ResponseEntity.status(HttpStatus.OK).body(articleService.findByNameContainingIgnoreCase(searchTerm));
    }

    @GetMapping(value="/{id}")
    public ResponseEntity getArticleById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(articleService.getArticleById(id));
    }

    @PostMapping
    public ResponseEntity addArticle(@RequestBody ArticleRequest request){
        articleService.addArticle(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity updateArticle(@RequestBody ArticleRequest request){
        articleService.updateArticle(request);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity deleteArticle(@PathVariable Long id) {
        articleService.deleteArticle(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
