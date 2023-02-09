package com.agana.gestiondestock.validator;

import com.agana.gestiondestock.dto.RolesDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class RolesValidator {

    public static List<String> validate(RolesDto rolesDto) {
        List<String> errors = new ArrayList<>();

        if (rolesDto == null ||!StringUtils.hasLength(rolesDto.getRoleName())) {
            errors.add("Veuillez saisir le nom du role");
        }
        return errors;
    }
}
