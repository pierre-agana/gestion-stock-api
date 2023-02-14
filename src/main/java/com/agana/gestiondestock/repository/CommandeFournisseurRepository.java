package com.agana.gestiondestock.repository;

import com.agana.gestiondestock.model.CommandeClient;
import com.agana.gestiondestock.model.CommandeFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

    public interface CommandeFournisseurRepository extends JpaRepository<CommandeFournisseur, Integer> {

    // creer un  methode
    //creqtion de la methode find by codeArticle
    Optional<CommandeFournisseur> findCommandeFournisseurByCode(String code);
}
