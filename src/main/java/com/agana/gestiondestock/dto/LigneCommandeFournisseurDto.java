package com.agana.gestiondestock.dto;
import com.agana.gestiondestock.model.LigneCommandeFournisseur;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class LigneCommandeFournisseurDto {
    private Integer id;

    private ArticleDto article;

    private CommandeFournisseurDto commandeFournisseur;

    private BigDecimal quantity;

    private BigDecimal prixUnitaire;

    private Integer idEntreprise;

    public static LigneCommandeFournisseurDto formEntity(LigneCommandeFournisseur ligneCommandeFournisseur) {
        if (ligneCommandeFournisseur == null){
            return null;

            // TODO throw and exception
        }
        return LigneCommandeFournisseurDto.builder()
                .id(ligneCommandeFournisseur.getId())
                .quantity(ligneCommandeFournisseur.getQuantity())
                .prixUnitaire(ligneCommandeFournisseur.getPrixUnitaire())
                .idEntreprise(ligneCommandeFournisseur.getIdEntreprise())
                .build();
    }

    public static LigneCommandeFournisseur toEntity(LigneCommandeFournisseurDto ligneCommandeFournisseurDto) {
        if (ligneCommandeFournisseurDto == null){
            return null;

            // TODO throw and exception
        }

        LigneCommandeFournisseur ligneCommandeFournisseur = new LigneCommandeFournisseur();
        ligneCommandeFournisseur.setId(ligneCommandeFournisseurDto.getId());
        ligneCommandeFournisseur.setQuantity(ligneCommandeFournisseurDto.getQuantity());
        ligneCommandeFournisseur.setPrixUnitaire(ligneCommandeFournisseurDto.getPrixUnitaire());
        ligneCommandeFournisseur.setIdEntreprise(ligneCommandeFournisseurDto.getIdEntreprise());
        return ligneCommandeFournisseur;
    }
}
