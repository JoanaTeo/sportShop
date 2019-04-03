package com.joana.sportShop.services;

import com.joana.sportShop.models.Manufacturer;
import com.joana.sportShop.repository.ManufacturerRepository;

import java.util.List;
import java.util.Optional;

public class serviceManifacturerImpl implements serviceManufacturer {
    ManufacturerRepository manufacturerRepository;
    public serviceManifacturerImpl (){
        manufacturerRepository=new ManufacturerRepository();
    }

    @Override
    public List<Manufacturer> findAllManufacturer() {
        return manufacturerRepository.findAllManufacturers();
    }

    @Override
    public Manufacturer findById(Long id) {
        Optional<Manufacturer> manufacturer = manufacturerRepository.findById(id);
        return manufacturer.get();
    }
}
