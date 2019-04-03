package com.joana.sportShop.repository;

import com.joana.sportShop.models.Manufacturer;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ManufacturerRepository {
    public List<Manufacturer> listManufacturer;
    private Long counter;
    @PostConstruct
    public void  init(){
        counter = 1L;
        listManufacturer =new ArrayList<>();
        Manufacturer c1=new Manufacturer();
        c1.setId(getNextId());
        c1.setName("nike");
        listManufacturer.add(c1);

        Manufacturer c2=new Manufacturer();
        c1.setId(getNextId());
        c1.setName("adidas");
        listManufacturer.add(c2);
    }
    public List<Manufacturer> findAllManufacturers() {
        return listManufacturer;
    }

    public Manufacturer save(Manufacturer manufacturer){
        manufacturer.setId(getNextId());
        listManufacturer.add(manufacturer);
        return manufacturer;
    }

    public void delete(Long manufacturerId) {
        listManufacturer.removeIf(v-> {
            return v.getId().equals(manufacturerId);
        });
    }

    private Long getNextId() {
        return counter++;
    }

    public Optional<Manufacturer> findById(Long manufacturerId) {
        return listManufacturer.stream().filter(v-> v.getId().equals(manufacturerId)).findAny();
    }
}
