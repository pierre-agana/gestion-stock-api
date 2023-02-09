package com.agana.gestiondestock.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "lignecommandefournisseur")
public class LigneCommandeFournisseur extends AbstractEntity{

    @ManyToOne
    @JoinColumn(name = "idarticle")
    private Article article;

    @ManyToOne
    @JoinColumn(name = "idcommandefourmisseur")
    private CommandeFournisseur commandeFournisseur;

    @Column(name = "quantity")
    private BigDecimal quantity;

    @Column(name = "prixuniteire")
    private BigDecimal prixUnitaire;

    @Column(name = "idEntreprise")
    private Integer idEntreprise;
}
