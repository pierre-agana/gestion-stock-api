package com.agana.gestiondestock.validator;

import com.agana.gestiondestock.dto.FournisseurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class FournisseurValidator {

    public static List<String> validate(FournisseurDto fournisseurDto){
        List<String> errors = new ArrayList<>();

        if (fournisseurDto == null){
            errors.add("Veuillez renseigner le nom du fournisseur");
            errors.add("Veuillez renseigner le prenom du fournisseur");
            errors.add("Veuillez renseigner l'email du fournisseur");
            errors.add("Veuillez renseigner le telephone du fournisseur");
            errors.add("Veuillez renseigner l'adresse'du fournisseur");

            return errors;
        }

        if (!StringUtils.hasLength(fournisseurDto.getFirstName())){
            errors.add("Veuillez renseigner le nom du fournisseur");
        }
        if (!StringUtils.hasLength(fournisseurDto.getLastName())){
            errors.add("Veuillez renseigner le prenom du fournisseur");
        }
        if (!StringUtils.hasLength(fournisseurDto.getEmail())){
            errors.add("Veuillez renseigner l'email du fournisseur");
        }
        if (!StringUtils.hasLength(fournisseurDto.getPicture())){
            errors.add("Veuillez renseigner le telephone du fournisseur");
        }
        //Verifaction , validation de adresse
        if (fournisseurDto.getAdresse() == null){
            errors.add("Veuillez renseigner l'adresse'du fournisseur");
        }else {
            //Verifaction , validation des champs de adresse
            if (!StringUtils.hasLength(fournisseurDto.getAdresse().getAddressOne())){
                errors.add("Le champ 'Adresse 1' est obligatoire" );
            }
            if (!StringUtils.hasLength(fournisseurDto.getAdresse().getVille())){
                errors.add("Le champ 'Ville' est obligatoire" );
            }
            if (!StringUtils.hasLength(fournisseurDto.getAdresse().getCodePostale())){
                errors.add("Le champ 'Code postale' est obligatoire" );
            }
            if (!StringUtils.hasLength(fournisseurDto.getAdresse().getCountry())){
                errors.add("Le champ 'Pays' est obligatoire" );
            }
        }

        return  errors;
    }
}
