package com.agana.gestiondestock.validator;

import com.agana.gestiondestock.dto.UtilisateurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UtilisateurValidator {

    public static List<String> validate(UtilisateurDto utilisateurDto){
        List<String> errors = new ArrayList<>();

        if (utilisateurDto == null){
            errors.add("Veuillez renseigner le nom de l'utilisateur");
            errors.add("Veuillez renseigner les prenoms de l'utilisateur");
            errors.add("Veuillez renseigner l'adresse'de l'utilisateur");
            errors.add("Veuillez renseigner la date de naissance de l'utilisateur");
            errors.add("Veuillez renseigner l'email de l'utilisateur");
            errors.add("Veuillez renseigner le mot de passe de l'utilisateur");
            return errors;
        }

        if (!StringUtils.hasLength(utilisateurDto.getFirstName())){
            errors.add("Veuillez renseigner le nom de l'utilisateur");
        }

        if (!StringUtils.hasLength(utilisateurDto.getLastName())){
            errors.add("Veuillez renseigner les prenoms de l'utilisateur");
        }
        //Verifaction , validation de adresse
        if (utilisateurDto.getAdresse() == null){
            errors.add("Veuillez renseigner l'adresse'de l'utilisateur");
        }else {
            //Verifaction , validation des champs de adresse
            if (!StringUtils.hasLength(utilisateurDto.getAdresse().getAddressOne())){
                errors.add("Le champ 'Adresse 1' est obligatoire" );
            }
            if (!StringUtils.hasLength(utilisateurDto.getAdresse().getVille())){
                errors.add("Le champ 'Ville' est obligatoire" );
            }
            if (!StringUtils.hasLength(utilisateurDto.getAdresse().getCodePostale())){
                errors.add("Le champ 'Code postale' est obligatoire" );
            }
            if (!StringUtils.hasLength(utilisateurDto.getAdresse().getCountry())){
                errors.add("Le champ 'Pays' est obligatoire" );
            }
        }
        //Verifaction , validation de date de naissance
        if (utilisateurDto.getDateBirth() == null){
            errors.add("Veuillez renseigner la date de naissance de l'utilisateur");
        }

        if (!StringUtils.hasLength(utilisateurDto.getEmail())){
            errors.add("Veuillez renseigner l'email de l'utilisateur");
        }
        if (!StringUtils.hasLength(utilisateurDto.getPassword())){
            errors.add("Veuillez renseigner le mot de passe de l'utilisateur");
        }
        return  errors;
    }
}
