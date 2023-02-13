package com.agana.gestiondestock.repository;

import com.agana.gestiondestock.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

    // creer un  methode
    //creqtion de lq methode find by codeArticle
    Optional<Article> findArticleByCodeArticle(String codeArticle);

}
