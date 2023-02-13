package com.agana.gestiondestock.controller.api;

import com.agana.gestiondestock.dto.ArticleDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import static com.agana.gestiondestock.utilis.Constants.*;

public interface ArticleApi {

    @PostMapping(value = BASE_URL + "/article/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto save(@RequestBody  ArticleDto articleDto);

    @GetMapping(value = BASE_URL + "/article/{idArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto findById(@PathVariable("idArticle") Integer id);

    @GetMapping(value = BASE_URL + "/article/{codeArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto findByCodeArticle(@PathVariable("codeArticle") String codeArticle);
    @GetMapping(value = BASE_URL + "/article/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ArticleDto> findAll();
    @GetMapping(value = BASE_URL + "/article/delete/{idArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(@PathVariable("idArticle") Integer id);
}
