package com.agana.gestiondestock.services;

import com.agana.gestiondestock.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    CategoryDto save( CategoryDto categoryDto);
    CategoryDto findById(Integer id);
    List<CategoryDto> findAll();
    void delete(Integer id);
}
