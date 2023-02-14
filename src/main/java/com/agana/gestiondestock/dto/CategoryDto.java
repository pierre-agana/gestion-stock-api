package com.agana.gestiondestock.dto;

import com.agana.gestiondestock.model.Article;
import com.agana.gestiondestock.model.Category;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class CategoryDto {
    private Integer id;

    private String codeCategory;

    private String designation;

    private Integer idEntreprise;

    @JsonIgnore
    private List<ArticleDto> articles;

    //mapping de Category -> CategoryDto
    public static CategoryDto fromEntity(Category category) {
        if (category == null){
            return null;

            // TODO throw and exception
        }
        //mapping de Category -> CategoryDto
        return CategoryDto.builder()
                .id(category.getId())
                .codeCategory(category.getCodeCategory())
                .designation(category.getDesignation())
                .idEntreprise(category.getIdEntreprise())
                .build();
    }

    //mapping de CategoryDto -> Category
    public static  Category toEntity(CategoryDto categoryDto) {
        if (categoryDto == null){
            return null;

            // TODO throw and exception
        }
        //mapping de CategoryDto -> Category
        /*return Category.builder()
                .codeCategory(categoryDto.getCodeCategory())
                .designation(categoryDto.getDesignation())
                .build();*/
        Category  category = new Category();
        category.setId(categoryDto.getId());
        category.setCodeCategory(categoryDto.getCodeCategory());
        category.setDesignation(categoryDto.getDesignation());
        category.setIdEntreprise(categoryDto.getIdEntreprise());

        return category;
    }
}
