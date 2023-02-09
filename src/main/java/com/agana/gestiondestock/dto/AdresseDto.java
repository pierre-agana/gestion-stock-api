package com.agana.gestiondestock.dto;

import com.agana.gestiondestock.model.Adresse;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AdresseDto {
    private Integer id;
    private String addressOne;

    private String addressTwo;

    private String ville;

    private String codePostale;

    private String country;

    //mapping de Adresse -> AdresseDto
    public AdresseDto formEntity(Adresse adresse) {
        if (adresse == null){
            return null;
            // TODO throw and exception
        }

        return AdresseDto.builder()
                .addressOne(adresse.getAddressOne())
                .addressTwo(adresse.getAddressTwo())
                .ville(adresse.getVille())
                .codePostale(adresse.getCodePostale())
                .country(adresse.getCountry())
                .build();
    }

    //mapping de AdresseDto -> Adresse
    public  Adresse toEntity(AdresseDto adresseDto) {
        if (adresseDto == null){
            return null;
            // TODO throw and exception
        }
        //mapping de AdresseDto -> Adresse
        Adresse adresse = new Adresse();
        adresse.setAddressOne(adresseDto.getAddressOne());
        adresse.setAddressTwo(adresseDto.getAddressTwo());
        adresse.setVille(adresseDto.getVille());
        adresse.setCodePostale(adresseDto.getCodePostale());
        adresse.setCountry(adresseDto.getCountry());

        return adresse;
    }
}
