package com.joana.sportShop.services;

import com.joana.sportShop.exceptions.NoSuchProductException;
import com.joana.sportShop.models.Category;
import com.joana.sportShop.models.Manufacturer;
import com.joana.sportShop.models.Product;
import com.joana.sportShop.repository.ManufacturerRepository;
import com.joana.sportShop.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

public class serviceProductImpl implements serviceProducts {
    ProductRepository productRepository;
    serviceManufacturer serviceManufacturer;
    serviceCategory serviceCategory;
    public serviceProductImpl(){
        productRepository= new ProductRepository();
        serviceManufacturer=new serviceManifacturerImpl() ;
        serviceCategory=new serviceCategoryImpl();
    }
    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAllProducts();
    }

    @Override
    public Product findProductById(Long id) throws NoSuchProductException {

        Optional<Product> product = productRepository.findById(id);
        return product.get();
    }

    @Override
    public Product addProduct(String name, Long manufacturerId, Long categoryId, String url) {
        Product p = new Product();
        p.setName(name);
        p.setUrlImage(url);
        Optional<Manufacturer> man = serviceManufacturer.findAllManufacturer().stream().filter(v -> v.getId().equals(manufacturerId)).findAny();
        p.setManufacturer(man.get());
        Optional<Category> cat = serviceCategory.findAllCategories().stream().filter(v -> v.getId().equals(manufacturerId)).findAny();
        p.setCategory(cat.get());
        productRepository.save(p);
        return p;

    }
}
