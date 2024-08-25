package com.tiendav_virtual.tienda_virtual.products.services.implement;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tiendav_virtual.tienda_virtual.products.models.dtos.CategoryDTO;
import com.tiendav_virtual.tienda_virtual.products.services.CategoryServices;

@Service
public class CategoryServicesImpl implements CategoryServices{
    @Override
    public void createCategory(CategoryDTO categoryDTO){
        System.out.println("Creating category");
    }

    @Override
    public List<CategoryDTO> getCategories() {
        List<CategoryDTO> categories = Arrays.asList(
            new CategoryDTO("001","Deportivo"),
            new CategoryDTO("002","Clasico"),
            new CategoryDTO("003","Inteligente")
        );
        return categories;
        
    }
}
