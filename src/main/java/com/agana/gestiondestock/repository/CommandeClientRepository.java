package com.agana.gestiondestock.repository;

import com.agana.gestiondestock.model.CommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommandeClientRepository extends JpaRepository<CommandeClient, Integer> {
    // creer un  methode
    //creqtion de la methode find by codeArticle
    Optional<CommandeClient> findCommandeClientByCode(String code);
}
