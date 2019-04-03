package com.joana.sportShop.services;

import com.joana.sportShop.models.Category;
import com.joana.sportShop.models.Manufacturer;
import com.joana.sportShop.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

public class serviceCategoryImpl implements serviceCategory {
    CategoryRepository categoryRepository;
    public  serviceCategoryImpl()
    {
        categoryRepository=new CategoryRepository();
    }
    @Override
    public List<Category> findAllCategories() {
        return categoryRepository.findAllCategories();
    }

    @Override
    public Category findById(Long id) {

        Optional<Category> category = categoryRepository.findById(id);
        return category.get();
    }
}
