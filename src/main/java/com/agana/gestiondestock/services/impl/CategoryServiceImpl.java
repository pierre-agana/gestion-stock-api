package com.agana.gestiondestock.services.impl;

import com.agana.gestiondestock.dto.CategoryDto;
import com.agana.gestiondestock.exception.EntityNotFoundException;
import com.agana.gestiondestock.exception.ErrorCodes;
import com.agana.gestiondestock.exception.InvalidEntityException;
import com.agana.gestiondestock.model.Category;
import com.agana.gestiondestock.repository.CategoryRepository;
import com.agana.gestiondestock.services.CategoryService;
import com.agana.gestiondestock.validator.CategoryValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;
    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {this.categoryRepository = categoryRepository;}
    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        List<String> errors = CategoryValidator.validate(categoryDto);
        if (!errors.isEmpty()){
            log.error("Category is not valid {}", categoryDto);
            throw new InvalidEntityException("La categorie n'est pas valide ", ErrorCodes.CATEGORY_NOT_VALID, errors);
        }
        return CategoryDto.fromEntity(
                categoryRepository.save(
                        CategoryDto.toEntity(categoryDto)
                )
        );
    }

    @Override
    public CategoryDto findById(Integer id) {
        if (id == null){
            log.error("Category  ID is nul");
            return null;
        }
        Optional<Category> category = categoryRepository.findById(id);

        return Optional.of(
                CategoryDto.fromEntity(category.get())).orElseThrow(()-> new EntityNotFoundException(
                        "Category not found with ID  "+id, ErrorCodes.CATEGORY_NOT_FOUND
                )
        );
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryRepository.findAll().stream().map(CategoryDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {

        if (id == null){
            log.error("Category ID is null");
            return;
        }
        this.categoryRepository.deleteById(id);
    }
}
