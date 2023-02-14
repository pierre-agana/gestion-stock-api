package com.agana.gestiondestock.dto;
import com.agana.gestiondestock.model.LigneCommandeClient;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class LigneCommandeClientDto {
    private Integer id;
    private ArticleDto article;
    private CommandeClientDto commandeClient;
    private BigDecimal quantity;
    private Integer idEntreprise;
    private BigDecimal prixUnitaire;

    public static LigneCommandeClientDto fromEntity(LigneCommandeClient ligneCommandeClient) {
        if (ligneCommandeClient == null){
            return null;

            // TODO throw and exception
        }
        return LigneCommandeClientDto.builder()
                .id(ligneCommandeClient.getId())
                .quantity(ligneCommandeClient.getQuantity())
                .prixUnitaire(ligneCommandeClient.getPrixUnitaire())
                .idEntreprise(ligneCommandeClient.getIdEntreprise())
                .build();
    }

    public static LigneCommandeClient toEntity(LigneCommandeClientDto ligneCommandeClientDto) {
        if (ligneCommandeClientDto == null){
            return null;

            // TODO throw and exception
        }
        LigneCommandeClient ligneCommandeClient = new LigneCommandeClient();
        ligneCommandeClient.setId(ligneCommandeClientDto.getId());
        ligneCommandeClient.setQuantity(ligneCommandeClientDto.getQuantity());
        ligneCommandeClient.setPrixUnitaire(ligneCommandeClientDto.getPrixUnitaire());
        ligneCommandeClient.setIdEntreprise(ligneCommandeClientDto.getIdEntreprise());
        return ligneCommandeClient;
    }
}
