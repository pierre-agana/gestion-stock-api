package com.agana.gestiondestock.handlers;

import com.agana.gestiondestock.exception.ErrorCodes;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorDto {

    private  Integer httpCode;
    private ErrorCodes errorCodes;
    private  String message;
    private List<String> errors = new ArrayList<>();
}
