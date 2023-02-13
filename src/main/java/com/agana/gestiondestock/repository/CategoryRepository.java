package com.agana.gestiondestock.repository;

import com.agana.gestiondestock.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
