package com.agana.gestiondestock.controller;

import com.agana.gestiondestock.controller.api.FournisseurApi;
import com.agana.gestiondestock.dto.FournisseurDto;
import com.agana.gestiondestock.services.FournisseurService;

import java.util.List;

public class FournisseurController implements FournisseurApi {
    private FournisseurService fournisseurService;
    public FournisseurController(FournisseurService fournisseurService) {this.fournisseurService = fournisseurService;}
    @Override
    public FournisseurDto save(FournisseurDto fournisseurDto) {
        return this.fournisseurService.save(fournisseurDto);
    }

    @Override
    public FournisseurDto findById(Integer id) {
        return fournisseurService.findById(id);
    }

    @Override
    public List<FournisseurDto> findAll() {
        return fournisseurService.findAll();
    }

    @Override
    public void delete(Integer id) {
        fournisseurService.delete(id);
    }
}
