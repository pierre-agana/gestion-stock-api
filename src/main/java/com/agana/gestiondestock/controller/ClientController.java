package com.agana.gestiondestock.controller;

import com.agana.gestiondestock.controller.api.ClientApi;
import com.agana.gestiondestock.dto.ClientDto;
import com.agana.gestiondestock.services.ClientService;

import java.util.List;

public class ClientController implements ClientApi {

    private ClientService clientService;

    public ClientController(ClientService clientService) {this.clientService = clientService;}
    @Override
    public ClientDto save(ClientDto clientDto) {
        return this.clientService.save(clientDto);
    }

    @Override
    public ClientDto findById(Integer id) {
        return clientService.findById(id);
    }

    @Override
    public List<ClientDto> findAll() {
        return clientService.findAll();
    }

    @Override
    public void delete(Integer id) {
        clientService.delete(id);
    }
}
