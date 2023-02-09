package com.agana.gestiondestock.validator;

import com.agana.gestiondestock.dto.VentesDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class VentesValidator {

    public static List<String> validate(VentesDto ventesDto) {
        List<String> errors = new ArrayList<>();

        if (ventesDto ==  null) {
            errors.add("Veuillez saisir le code");
            errors.add("Veuillez saisir l'observation");
            errors.add("Veuillez saisir la date de vente");
        }
        else {
            if(!StringUtils.hasLength(ventesDto.getCode())) {
                errors.add("Veuillez saisir le code");
            }
            if(ventesDto.getDateventes() == null) {
                errors.add("Veuillez saisir la date de vente");
            }
            if(!StringUtils.hasLength(ventesDto.getRemark())) {
                errors.add("Veuillez saisir l'observation");
            }
        }
        return errors;
    }
}
