package com.agana.gestiondestock.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "category")
public class Category extends AbstractEntity{

    @Column(name = "codecategory")
    private String codeCategory;

    @Column(name = "designation")
    private String designation;

    @Column(name = "idCompanies")
    private Integer idCompanies;

    @OneToMany(mappedBy = "category")
    private List<Article> articles;
}
