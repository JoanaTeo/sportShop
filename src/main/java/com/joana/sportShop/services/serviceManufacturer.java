package com.joana.sportShop.services;

import com.joana.sportShop.models.Manufacturer;

import java.util.List;

public interface serviceManufacturer {
    public List<Manufacturer> findAllManufacturer();
    public  Manufacturer findById(Long id);
}
