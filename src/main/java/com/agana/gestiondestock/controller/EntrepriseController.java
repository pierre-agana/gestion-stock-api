package com.agana.gestiondestock.controller;

import com.agana.gestiondestock.controller.api.EntrepriseApi;
import com.agana.gestiondestock.dto.EntrepriseDto;
import com.agana.gestiondestock.services.EntrepriseService;

import java.util.List;

public class EntrepriseController implements EntrepriseApi {
    private EntrepriseService entrepriseService;

    public EntrepriseController(EntrepriseService entrepriseService) {this.entrepriseService = entrepriseService;}
    @Override
    public EntrepriseDto save(EntrepriseDto entrepriseDto) {
        return this.entrepriseService.save(entrepriseDto);
    }

    @Override
    public EntrepriseDto findById(Integer id) {
        return entrepriseService.findById(id);
    }

    @Override
    public List<EntrepriseDto> findAll() {
        return entrepriseService.findAll();
    }

    @Override
    public void delete(Integer id) {
        entrepriseService.delete(id);
    }
}
