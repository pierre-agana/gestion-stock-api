package com.agana.gestiondestock.repository;

import com.agana.gestiondestock.model.Ventes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VentesRepository extends JpaRepository<Ventes, Integer> {

    //recherche pqa code
    Optional<Ventes> findVentesByCode(String code);
}
