package com.joana.sportShop.services;

import com.joana.sportShop.models.Category;
import com.joana.sportShop.models.Manufacturer;

import java.util.List;

public interface serviceCategory {
    public List<Category> findAllCategories();
    public  Category findById(Long id);
}
