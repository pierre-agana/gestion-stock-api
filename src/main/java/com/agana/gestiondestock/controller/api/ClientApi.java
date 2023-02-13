package com.agana.gestiondestock.controller.api;

import com.agana.gestiondestock.dto.ClientDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import static com.agana.gestiondestock.utilis.Constants.*;
public interface ClientApi {

    @PostMapping(value = BASE_URL + "/client/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDto save(@RequestBody ClientDto clientDto);

    @GetMapping(value = BASE_URL + "/client/{idClient}", produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDto findById(@PathVariable("idClient") Integer id);

    @GetMapping(value = BASE_URL + "/client/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ClientDto> findAll();

    @GetMapping(value = BASE_URL + "/client/delete/{idClient}")
    void delete(@PathVariable("idClient") Integer id);
}
