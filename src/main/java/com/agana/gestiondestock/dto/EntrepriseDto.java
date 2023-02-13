package com.agana.gestiondestock.dto;

import com.agana.gestiondestock.model.Entreprise;
import com.agana.gestiondestock.model.Utilisateur;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class EntrepriseDto {
    private Integer id;

    private String name;

    private String description;

    private AdresseDto adresse;

    private String taxCode;

    private String logo;

    private String email;

    private String phone;

    private String webSite;

    @JsonIgnore
    private List<UtilisateurDto> utilisateurs;

    public static EntrepriseDto fromEntity(Entreprise entreprise) {
        if (entreprise == null){
            return null;

            // TODO throw and exception
        }
        return EntrepriseDto.builder()
                .id(entreprise.getId())
                .name(entreprise.getName())
                .description(entreprise.getDescription())
                .taxCode(entreprise.getTaxCode())
                .logo(entreprise.getLogo())
                .email(entreprise.getEmail())
                .phone(entreprise.getPhone())
                .webSite(entreprise.getWebSite())
                .build();
    }

    public static Entreprise toEntity(EntrepriseDto entrepriseDto) {
        if (entrepriseDto == null){
            return null;

            // TODO throw and exception
        }
        Entreprise entreprise = new Entreprise();
        entreprise.setId(entrepriseDto.getId());
        entreprise.setName(entrepriseDto.getName());
        entreprise.setDescription(entrepriseDto.getDescription());
        entreprise.setTaxCode(entrepriseDto.getTaxCode());
        entreprise.setLogo(entrepriseDto.getLogo());
        entreprise.setEmail(entrepriseDto.getEmail());
        entreprise.setPhone(entrepriseDto.getPhone());
        entreprise.setWebSite(entrepriseDto.getWebSite());
        return entreprise;
    }
}
