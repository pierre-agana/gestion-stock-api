package com.agana.gestiondestock.dto;

import com.agana.gestiondestock.model.Article;
import com.agana.gestiondestock.model.Category;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class ArticleDto {
    private Integer id;
    private String codeArticle;

    private String designation;

    private BigDecimal prixUnitaireHt;

    private BigDecimal tauxTva;

    private BigDecimal prixUnitaireTtc;

    private String picture;

    private Integer idEntreprise;

    private CategoryDto category;

    //mapping de Article -> ArticleDto
    public ArticleDto fromEntity(Article article) {
        if (article == null){
            return null;

            // TODO throw and exception
        }
        //mapping de Article -> ArticleDto
        return ArticleDto.builder()
                .id(article.getId())
                .codeArticle(article.getCodeArticle())
                .designation(article.getDesignation())
                .prixUnitaireHt(article.getPrixUnitaireHt())
                .tauxTva(article.getTauxTva())
                .prixUnitaireTtc(article.getPrixUnitaireTtc())
                .picture(article.getPicture())
                .build();
    }

    //mapping de ArticleDto -> Article
    public Article toEntity(ArticleDto articleDto) {
        if (articleDto == null){
            return null;

            // TODO throw and exception
        }

        //mapping de ArticleDto -> Article
        Article article = new Article();
        article.setId(articleDto.getId());
        article.setCodeArticle(articleDto.getCodeArticle());
        article.setDesignation(articleDto.getDesignation());
        article.setPrixUnitaireHt(articleDto.getPrixUnitaireHt());
        article.setTauxTva(articleDto.getTauxTva());
        article.setPrixUnitaireTtc(articleDto.getPrixUnitaireTtc());
        article.setPicture(articleDto.getPicture());

        return article;

    }
}
