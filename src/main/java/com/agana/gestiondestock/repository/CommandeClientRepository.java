package com.agana.gestiondestock.repository;

import com.agana.gestiondestock.model.CommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeClientRepository extends JpaRepository<CommandeClient, Integer> {
}
