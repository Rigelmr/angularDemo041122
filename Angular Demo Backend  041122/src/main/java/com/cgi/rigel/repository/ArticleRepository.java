package com.cgi.rigel.repository;

import com.cgi.rigel.domain.ArticleResponse.ArticleResponse;
import com.cgi.rigel.entity.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<ArticleEntity, Long> {

    @Query("SELECT art FROM ARTICLES art WHERE art.name LIKE %:searchTerm%")
    List<ArticleEntity> findByNameContainsIgnoreCase(String searchTerm);

}
