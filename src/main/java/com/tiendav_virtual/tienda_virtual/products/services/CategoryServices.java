package com.tiendav_virtual.tienda_virtual.products.services;

import java.util.List;

import com.tiendav_virtual.tienda_virtual.products.models.dtos.CategoryDTO;

public interface CategoryServices {
    void createCategory(CategoryDTO categoryDTO);
    List<CategoryDTO> getCategories();
}
