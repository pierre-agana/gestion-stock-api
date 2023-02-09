package com.agana.gestiondestock.validator;

import com.agana.gestiondestock.dto.CommandeFournisseurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CommandeFournisseurValidator {

    public static List<String> validate(CommandeFournisseurDto commandeFournisseurDto){
        List<String> errors = new ArrayList<>();

        if (commandeFournisseurDto == null){
            errors.add("Veuillez renseigner le code");
            errors.add("Veuillez renseigner la date commande");
            errors.add("Veuillez selectionner un fournisseur");

            return errors;
        }
        if (!StringUtils.hasLength(commandeFournisseurDto.getCode())){
            errors.add("Veuillez renseigner le code");
        }
        if (commandeFournisseurDto.getDateCommande() == null){
            errors.add("Veuillez renseigner la date commande");
        }
        if (commandeFournisseurDto.getFournisseur() == null){
            errors.add("Veuillez selectionner un fournisseur");
        }

        return errors;
    }
}
