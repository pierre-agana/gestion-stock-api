package com.agana.gestiondestock.services;

import com.agana.gestiondestock.dto.ClientDto;

import java.util.List;

public interface ClientService {

    ClientDto save( ClientDto clientDto);
    ClientDto findById(Integer id);
    List<ClientDto> findAll();
    void delete(Integer id);
}
