package com.agana.gestiondestock.validator;

import com.agana.gestiondestock.dto.LigneCommandeClientDto;

import java.util.ArrayList;
import java.util.List;

public class LigneCommandeClientValidator {

    public static List<String> validate(LigneCommandeClientDto ligneCommandeClientDto){
        List<String> errors = new ArrayList<>();

        if (ligneCommandeClientDto == null){
            errors.add("Veuillez selectionner le client");
            errors.add("Veuillez selectionner l'article");
            errors.add("Veuillez saisir le prix unitaire l'article");
            errors.add("Veuillez saisir une quantité l'article");
            return errors;
        }

        if (ligneCommandeClientDto.getArticle() == null){
            errors.add("Veuillez selectionner l'article");
        }
        if (ligneCommandeClientDto.getCommandeClient() == null){
            errors.add("Veuillez selectionner le client");
        }
        if (ligneCommandeClientDto.getQuantity() == null){
            errors.add("Veuillez saisir une quantité l'article");
        }
        if (ligneCommandeClientDto.getPrixUnitaire() == null){
            errors.add("Veuillez saisir le prix unitaire l'article");
        }

        return errors;
    }
}
