package com.cgi.rigel.domain.ArticleRequest;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ArticleRequest {
    private Long id;
    private String name;
    private String description;
    private int views;
}
