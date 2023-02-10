package com.agana.gestiondestock.repository;

import com.agana.gestiondestock.model.Ventes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentesRepository extends JpaRepository<Integer, Ventes> {
}
