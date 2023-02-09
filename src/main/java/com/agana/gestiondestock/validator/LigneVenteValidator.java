package com.agana.gestiondestock.validator;

import com.agana.gestiondestock.model.LigneVente;

import java.util.ArrayList;
import java.util.List;

public class LigneVenteValidator {

    public static List<String> validate(LigneVente ligneVente) {
        List<String> errors = new ArrayList<>();

        if (ligneVente == null) {
            errors.add("Veuillez saisir la quantité");
            errors.add("Veuillez saisir le prix unitaire");
            errors.add("Veuillez sélectionner l'opération de vente");

            return errors;
        }

            if (ligneVente.getVentes() == null) {
                errors.add("Veuillez sélectionner l'opération de vente");
            }
            if (ligneVente.getPrixUnitaire() == null) {
                errors.add("Veuillez saisir le prix unitaire");
            }
            if (ligneVente.getQuantity() == null) {
                errors.add("Veuillez saisir la quantité");
            }
        return errors;
    }
}
