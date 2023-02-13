package com.agana.gestiondestock.controller.api;

import com.agana.gestiondestock.dto.FournisseurDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import static com.agana.gestiondestock.utilis.Constants.*;

public interface FournisseurApi {

    @PostMapping(value = BASE_URL + "/fournisseur/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    FournisseurDto save(@RequestBody FournisseurDto fournisseurDto);

    @GetMapping(value = BASE_URL + "/fournissuer/{idFournisseur}", produces = MediaType.APPLICATION_JSON_VALUE)
    FournisseurDto findById(@PathVariable("idFournisseur") Integer id);

    @GetMapping(value = BASE_URL + "/fournisseur/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<FournisseurDto> findAll();

    @GetMapping(value = BASE_URL + "/fournisseur/delete/{idFournisseur}", produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(@PathVariable("idFournisseur") Integer id);
}
