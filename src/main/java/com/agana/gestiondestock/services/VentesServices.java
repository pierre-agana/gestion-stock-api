package com.agana.gestiondestock.services;

import com.agana.gestiondestock.dto.CommandeFournisseurDto;
import com.agana.gestiondestock.dto.UtilisateurDto;
import com.agana.gestiondestock.dto.VentesDto;

import java.util.List;

public interface VentesServices {

    VentesDto save(VentesDto ventesDto);
    VentesDto findById(Integer id);
    VentesDto findVentesByCode(String code);
    List<VentesDto> findAll();
    void delete(Integer id);
}
