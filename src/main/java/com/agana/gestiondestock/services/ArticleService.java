package com.agana.gestiondestock.services;

import com.agana.gestiondestock.dto.ArticleDto;

import java.util.List;

public interface ArticleService {

    ArticleDto save(ArticleDto articleDto);
    ArticleDto findById(Integer id);
    ArticleDto findByCodeArticle(String codeArticle);
    List<ArticleDto> findAll();
    Void delete(Integer id);
}
