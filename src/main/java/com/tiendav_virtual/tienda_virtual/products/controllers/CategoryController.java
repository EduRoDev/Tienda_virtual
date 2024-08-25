package com.tiendav_virtual.tienda_virtual.products.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiendav_virtual.tienda_virtual.products.models.dtos.CategoryDTO;
import com.tiendav_virtual.tienda_virtual.products.services.CategoryServices;

@RestController
public class CategoryController {
    private final CategoryServices categoryServices;

    public CategoryController(CategoryServices categoryServices) {
        this.categoryServices = categoryServices;
    }

    @PostMapping("/categories")
    public void createCategory(CategoryDTO categoryDTO) {
        categoryServices.createCategory(categoryDTO);
    }

    @GetMapping("/categories")
    public List<CategoryDTO> getAllCategories() {
        return categoryServices.getCategories();
    }
}
