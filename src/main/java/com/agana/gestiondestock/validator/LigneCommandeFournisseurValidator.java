package com.agana.gestiondestock.validator;

import com.agana.gestiondestock.dto.LigneCommandeFournisseurDto;

import java.util.ArrayList;
import java.util.List;

public class LigneCommandeFournisseurValidator {

    public static List<String> validate(LigneCommandeFournisseurDto ligneCommandeFournisseurDto) {
        List<String> errors = new ArrayList<>();

        if (ligneCommandeFournisseurDto == null) {
            errors.add("Veuillez selectionner le fournisseur");
            errors.add("Veuillez selectionner l'article");
            errors.add("Veuillez saisir le prix unitaire l'article");
            errors.add("Veuillez saisir une quantité l'article");
            return errors;
        }

            if(ligneCommandeFournisseurDto.getCommandeFournisseur() == null) {
                errors.add("Veuillez selectionner le fournisseur");
            }

            if(ligneCommandeFournisseurDto.getArticle() == null) {
                errors.add("Veuillez selectionner l'article");
            }

            if(ligneCommandeFournisseurDto.getPrixUnitaire() == null) {
                errors.add("Veuillez saisir le prix unitaire l'article");
            }

            if(ligneCommandeFournisseurDto.getQuantity() == null) {
                errors.add("Veuillez saisir une quantité l'article");
            }
        return errors;
    }
}
