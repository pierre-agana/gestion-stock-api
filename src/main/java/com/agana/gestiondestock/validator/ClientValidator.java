package com.agana.gestiondestock.validator;

import com.agana.gestiondestock.dto.ClientDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ClientValidator {

    public static List<String> validate(ClientDto clientDto){

        List<String> errors = new ArrayList<>();

        if (clientDto == null){
            errors.add("Veuillez rensiegner le nom du client");
            errors.add("Veuillez rensiegner le prenom du client");
            errors.add("Veuillez rensiegner l'email' du client");
            errors.add("Veuillez rensiegner le telephone du client");
            return errors;
        }

        if (!StringUtils.hasLength(clientDto.getFirstName())){
            errors.add("Veuillez rensiegner le nom du client");
        }
        if (!StringUtils.hasLength(clientDto.getLastName())){
            errors.add("Veuillez rensiegner le prenom du client");
        }
        if (!StringUtils.hasLength(clientDto.getEmail())){
            errors.add("Veuillez rensiegner l'email' du client");
        }
        if (!StringUtils.hasLength(clientDto.getPhone())){
            errors.add("Veuillez rensiegner le telephone du client");
        }

        return errors;
    }
}
