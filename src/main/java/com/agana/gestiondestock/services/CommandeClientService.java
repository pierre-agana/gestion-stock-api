package com.agana.gestiondestock.services;

import com.agana.gestiondestock.dto.ArticleDto;
import com.agana.gestiondestock.dto.CommandeClientDto;
import com.agana.gestiondestock.dto.UtilisateurDto;

import java.util.List;

public interface CommandeClientService {
    CommandeClientDto save(CommandeClientDto commandeClientDto);
    CommandeClientDto findById(Integer id);
    CommandeClientDto findByCode(String code);
    List<CommandeClientDto> findAll();
    void delete(Integer id);
}
