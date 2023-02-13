package com.agana.gestiondestock.controller;

import com.agana.gestiondestock.controller.api.CategoryApi;
import com.agana.gestiondestock.dto.CategoryDto;
import com.agana.gestiondestock.services.CategoryService;

import java.util.List;

public class CategoryController implements CategoryApi {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }
    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        return this.categoryService.save(categoryDto);
    }

    @Override
    public CategoryDto findById(Integer id) {
        return categoryService.findById(id);
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryService.findAll();
    }

    @Override
    public void delete(Integer id) {
        categoryService.delete(id);
    }
}
