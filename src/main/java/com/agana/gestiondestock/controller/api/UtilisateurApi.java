package com.agana.gestiondestock.controller.api;

import com.agana.gestiondestock.dto.UtilisateurDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import static com.agana.gestiondestock.utilis.Constants.*;

public interface UtilisateurApi {
    @PostMapping(value =BASE_URL + "/utilisateur/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    UtilisateurDto save(@RequestBody UtilisateurDto utilisateurDto);
    @GetMapping(value = BASE_URL + "/utilisateur/{idUtilisateur}",produces = MediaType.APPLICATION_JSON_VALUE)
    UtilisateurDto findById(@PathVariable("idUtilisateur") Integer id);
    @GetMapping(value = BASE_URL + "/utilisateur/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<UtilisateurDto> findAll();

    @GetMapping(value = BASE_URL + "/utilisateur/{idUtilisateur}", produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(@PathVariable("idUtilisateur") Integer id);
}
