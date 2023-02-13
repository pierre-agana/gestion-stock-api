package com.agana.gestiondestock.services.impl;

import com.agana.gestiondestock.dto.ArticleDto;
import com.agana.gestiondestock.exception.ErrorCodes;
import com.agana.gestiondestock.exception.InvalidEntityException;
import com.agana.gestiondestock.repository.ArticleRepository;
import com.agana.gestiondestock.services.ArticleService;
import com.agana.gestiondestock.validator.ArticleValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return null;
    }

    @Override
    public ArticleDto findByCodeArticle(String codeArticle) {
        return null;
    }

    @Override
    public List<ArticleDto> findAll() {
        return null;
    }

    @Override
    public Void delete(Integer id) {
        return null;
    }
}
