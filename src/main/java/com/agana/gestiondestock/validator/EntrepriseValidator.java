package com.agana.gestiondestock.validator;

import com.agana.gestiondestock.dto.EntrepriseDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class EntrepriseValidator {
    public static List<String> validate(EntrepriseDto entrepriseDto) {
        List<String> errors = new ArrayList<>();

        if (entrepriseDto == null) {
            errors.add("Veuillez saisir le nom de la compagnie");
            errors.add("Veuillez saisir l'email de la compagnie");
            errors.add("Veuillez saisir le contact de la compagnie");
            errors.add("Veuillez saisir la description de la compagnie");
            errors.add("Veuillez renseigner l'adresse");
            errors.add("Veuillez saisir le code tax de la compagnie");
            return errors;
        }

            if (!StringUtils.hasLength(entrepriseDto.getName())) {
                errors.add("Veuillez saisir le nom de la compagnie");
            }

            if (!StringUtils.hasLength(entrepriseDto.getEmail())) {
                errors.add("Veuillez saisir l'email de la compagnie");
            }

            if (!StringUtils.hasLength(entrepriseDto.getPhone())) {
                errors.add("Veuillez saisir le contact de la compagnie");
            }

            if (!StringUtils.hasLength(entrepriseDto.getDescription())) {
                errors.add("Veuillez saisir la description de la compagnie");
            }

            if(entrepriseDto.getAdresse() == null) {
                errors.add("Veuillez renseigner l'adresse");
            } else {
                if(entrepriseDto.getAdresse().getAddressOne() == null) {
                    errors.add("Veuillez renseigner l'adresse");
                }
                if(entrepriseDto.getAdresse().getCountry() == null) {
                    errors.add("Veuillez renseigner le pays");
                }
                if(entrepriseDto.getAdresse().getCodePostale() == null) {
                    errors.add("Veuillez renseigner le code postal");
                }
                if(entrepriseDto.getAdresse().getVille() == null) {
                    errors.add("Veuillez renseigner la ville");
                }
            }

            if (entrepriseDto.getTaxCode() == null) {
                errors.add("Veuillez saisir le code tax de la compagnie");
            }

        return errors;
    }
}
