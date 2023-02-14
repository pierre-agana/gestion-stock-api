package com.agana.gestiondestock.dto;

import com.agana.gestiondestock.model.CommandeFournisseur;
import com.agana.gestiondestock.model.Entreprise;
import com.agana.gestiondestock.model.Fournisseur;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Builder
@Data
public class CommandeFournisseurDto {
    private Integer id;
    private String code;

    private Instant dateCommande;

    private Fournisseur fournisseur;
private Integer  idEntreprise;
    private List<LigneCommandeFournisseurDto> ligneCommandeFournisseurs;

    public static CommandeFournisseurDto fromEntity(CommandeFournisseur commandeFournisseur) {
        if (commandeFournisseur == null){
            return null;

            // TODO throw and exception
        }

        return CommandeFournisseurDto.builder()
                .id(commandeFournisseur.getId())
                .code(commandeFournisseur.getCode())
                .dateCommande(commandeFournisseur.getDateCommande())
                .idEntreprise(commandeFournisseur.getIdEntreprise())
                .fournisseur(commandeFournisseur.getFournisseur())
                .build();
    }

    public static CommandeFournisseur toEntity(CommandeFournisseurDto commandeFournisseurDto) {
        if (commandeFournisseurDto == null){
            return null;

            // TODO throw and exception
        }

        CommandeFournisseur commandeFournisseur = new CommandeFournisseur();
        commandeFournisseur.setId(commandeFournisseurDto.getId());
        commandeFournisseur.setCode(commandeFournisseurDto.getCode());
        commandeFournisseur.setDateCommande(commandeFournisseurDto.getDateCommande());
        commandeFournisseur.setIdEntreprise(commandeFournisseurDto.getIdEntreprise());
        commandeFournisseur.setFournisseur(commandeFournisseurDto.getFournisseur());

        return commandeFournisseur;
    }
}
