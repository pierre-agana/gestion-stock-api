package com.agana.gestiondestock.dto;

import com.agana.gestiondestock.model.LigneVente;
import com.agana.gestiondestock.model.Ventes;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class LigneVenteDto {
    private Integer id;
    private VentesDto ventes;
    private ArticleDto article;
    private BigDecimal prixUnitaire;

    private BigDecimal quantity;

    private Integer idEntreprise;

    public LigneVenteDto fromEntity(LigneVente ligneVente) {
        if (ligneVente == null){
            return null;

            // TODO throw and exception
        }
        return LigneVenteDto.builder()
                .id(ligneVente.getId())
                .prixUnitaire(ligneVente.getPrixUnitaire())
                .quantity(ligneVente.getQuantity())
                .idEntreprise(ligneVente.getIdEntreprise())
                .build();
    }

    public LigneVente toEntity(LigneVenteDto ligneVenteDto) {
        if (ligneVenteDto == null){
            return null;

            // TODO throw and exception
        }
        LigneVente ligneVente = new LigneVente();
        ligneVente.setId(ligneVenteDto.getId());
        ligneVente.setPrixUnitaire(ligneVenteDto.getPrixUnitaire());
        ligneVente.setQuantity(ligneVenteDto.getQuantity());
        ligneVente.setIdEntreprise(ligneVenteDto.getIdEntreprise());
        ligneVente.setIdEntreprise(ligneVenteDto.getIdEntreprise());
        return ligneVente;
    }
}
