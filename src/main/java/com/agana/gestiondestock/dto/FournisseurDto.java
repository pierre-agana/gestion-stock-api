package com.agana.gestiondestock.dto;
import com.agana.gestiondestock.model.Fournisseur;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class FournisseurDto {
    private Integer id;
    private String firstName;

    private String lastName;

    private Integer idEntreprise;

    private AdresseDto adress;

    private String picture;

    private String email;

    private String phone;

    @JsonIgnore
    private List<CommandeFournisseurDto> commandeFournisseurs;

    public FournisseurDto fromEntity(Fournisseur fournisseur) {
        if (fournisseur == null){
            return null;

            // TODO throw and exception
        }
        return FournisseurDto.builder()
                .id(fournisseur.getId())
                .firstName(fournisseur.getFirstName())
                .lastName(fournisseur.getLastName())
                .picture(fournisseur.getPicture())
                .email(fournisseur.getEmail())
                .phone(fournisseur.getPhone())
                .build();
    }

    public Fournisseur toEntity(FournisseurDto fournisseurDto) {
        if (fournisseurDto == null){
            return null;

            // TODO throw and exception
        }
        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setId(fournisseurDto.getId());
        fournisseur.setFirstName(fournisseurDto.getFirstName());
        fournisseur.setLastName(fournisseurDto.getLastName());
        fournisseur.setPicture(fournisseurDto.getPicture());
        fournisseur.setEmail(fournisseurDto.getEmail());
        fournisseur.setPhone(fournisseurDto.getPhone());
        return fournisseur;
    }
}