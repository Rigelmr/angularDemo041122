package com.cgi.rigel.mapper;

import com.cgi.rigel.domain.ArticleRequest.ArticleRequest;
import com.cgi.rigel.domain.ArticleResponse.ArticleResponse;
import com.cgi.rigel.entity.ArticleEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ArticleMapper {

    public ArticleResponse mapArticleEntityToArticleResponse(ArticleEntity entity);
    public ArticleEntity mapArticleRequestToArticleEntity(ArticleRequest request);
}
