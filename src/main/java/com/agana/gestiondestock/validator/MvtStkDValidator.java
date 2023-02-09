package com.agana.gestiondestock.validator;

import com.agana.gestiondestock.dto.MvtStkDto;

import java.util.ArrayList;
import java.util.List;

public class MvtStkDValidator {

    public static List<String> validate(MvtStkDto mvtStkDto) {
        List<String> errors = new ArrayList<>();

        if (mvtStkDto == null) {
            errors.add("Veuillez saisir la date de l'opération");
            errors.add("Veuillez saisir la quantité");
            errors.add("Veuillez sélection l'article");
            errors.add("Veuillez sélectionner le type d'opération");
            return errors;
        }

            if (mvtStkDto.getDateMvt() == null) {
                errors.add("Veuillez saisir la date de l'opération");
            }

            if (mvtStkDto.getQuantity() == null) {
                errors.add("Veuillez saisir la quantité");
            }

            if (mvtStkDto.getArticle() == null) {
                errors.add("Veuillez sélection l'article");
            }

            if (mvtStkDto.getTypeMvt() == null) {
                errors.add("Veuillez sélectionner le type d'opération");
            }

        return errors;
    }
}
