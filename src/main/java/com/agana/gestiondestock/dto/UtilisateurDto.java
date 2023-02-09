package com.agana.gestiondestock.dto;

import com.agana.gestiondestock.model.Adresse;
import com.agana.gestiondestock.model.Entreprise;
import com.agana.gestiondestock.model.Roles;
import com.agana.gestiondestock.model.Utilisateur;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Builder
@Data
public class UtilisateurDto {
    private Integer id;
    private String firstName;

    private String lastName;

    private AdresseDto adresse;

    private String picture;

    private Instant dateBirth;

    private String email;

    private String password;

    private EntrepriseDto entreprise;

    @JsonIgnore
    private List<RolesDto> roles;

    public UtilisateurDto fromEntity(Utilisateur utilisateur) {
        if (utilisateur == null){
            return null;

            // TODO throw and exception
        }
        return UtilisateurDto.builder()
                .id(utilisateur.getId())
                .firstName(utilisateur.getFirstName())
                .lastName(utilisateur.getLastName())
                .picture(utilisateur.getPicture())
                .dateBirth(utilisateur.getDateBirth())
                .email(utilisateur.getEmail())
                .password(utilisateur.getPassword())
                .build();
    }

    public Utilisateur toEntity(UtilisateurDto utilisateurDto) {
        if (utilisateurDto == null){
            return null;

            // TODO throw and exception
        }
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(utilisateurDto.getId());
        utilisateur.setFirstName(utilisateurDto.getFirstName());
        utilisateur.setLastName(utilisateurDto.getLastName());
        utilisateur.setPicture(utilisateurDto.getPicture());
        utilisateur.setDateBirth(utilisateurDto.getDateBirth());
        utilisateur.setEmail(utilisateurDto.getEmail());
        utilisateur.setPassword(utilisateurDto.getPassword());
        return utilisateur;
    }
}
