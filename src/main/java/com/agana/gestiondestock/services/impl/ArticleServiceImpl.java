package com.agana.gestiondestock.services.impl;

import com.agana.gestiondestock.dto.ArticleDto;
import com.agana.gestiondestock.exception.EntityNotFoundException;
import com.agana.gestiondestock.exception.ErrorCodes;
import com.agana.gestiondestock.exception.InvalidEntityException;
import com.agana.gestiondestock.model.Article;
import com.agana.gestiondestock.repository.ArticleRepository;
import com.agana.gestiondestock.services.ArticleService;
import com.agana.gestiondestock.validator.ArticleValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ArticleServiceImpl  implements ArticleService {

    //instance du repository
    private ArticleRepository articleRepository;

    //injection du repository par constructeur
    @Autowired
    public  ArticleServiceImpl(ArticleRepository articleRepository){
        this.articleRepository = articleRepository;
    }
    @Override
    public ArticleDto save(ArticleDto articleDto) {
        //verifie si l'article est valide
        List<String> errors = ArticleValidator.validate(articleDto);
        if (!errors.isEmpty()){
            log.error("Article is not valid {}", articleDto);
            throw new InvalidEntityException("L'article n'est pas valide", ErrorCodes.ARTICLE_NOT_VALID, errors);
        }
        //sauvegarder l'article
        return ArticleDto.fromEntity(
                articleRepository.save(
                        ArticleDto.toEntity(articleDto)
                )
        );
    }

    @Override
    public ArticleDto findById(Integer id) {
        if (id == null){
            log.error("Article ID is null");
            return  null;
        }
        Optional<Article> article = articleRepository.findById(id);

        return Optional.of(
                ArticleDto.fromEntity(article.get())).orElseThrow(()-> new EntityNotFoundException(
                "Article not found with ID  "+id, ErrorCodes.ARTICLE_NOT_FOUND
                )
        );
    }

    //fonction find By CodeArticle
    @Override
    public ArticleDto findByCodeArticle(String codeArticle) {
        if (!StringUtils.hasLength(codeArticle) ){
            log.error("Article CODE is null");
            return  null;
        }
        Optional<Article> article = articleRepository.findArticleByCodeArticle(codeArticle);
        return Optional.of(
                ArticleDto.fromEntity(article.get())).orElseThrow(()-> new EntityNotFoundException(
                        "Article not found with Code  "+codeArticle, ErrorCodes.ARTICLE_NOT_FOUND
                )
        );
    }

    @Override
    public List<ArticleDto> findAll() {
        return articleRepository.findAll().stream().map(ArticleDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null){
            log.error("Article ID is null");
            return;
        }
       this.articleRepository.deleteById(id);
    }
}
