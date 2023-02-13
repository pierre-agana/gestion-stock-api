package com.agana.gestiondestock.repository;

import com.agana.gestiondestock.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

}
