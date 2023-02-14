package com.agana.gestiondestock.controller;

import com.agana.gestiondestock.controller.api.UtilisateurApi;
import com.agana.gestiondestock.dto.FournisseurDto;
import com.agana.gestiondestock.dto.UtilisateurDto;
import com.agana.gestiondestock.services.UtilisateurService;

import java.util.List;

public class UtilisateurController implements UtilisateurApi {

    private UtilisateurService utilisateurService;

    public UtilisateurController(UtilisateurService utilisateurService){this.utilisateurService = utilisateurService;}
    @Override
    public UtilisateurDto save(UtilisateurDto utilisateurDto) {
        return this.utilisateurService.save(utilisateurDto);
    }

    @Override
    public UtilisateurDto findById(Integer id) {
        return utilisateurService.findById(id);
    }

    @Override
    public List<UtilisateurDto> findAll() {
        return utilisateurService.findAll();
    }

    @Override
    public void delete(Integer id) {
       utilisateurService.delete(id);
    }
}
