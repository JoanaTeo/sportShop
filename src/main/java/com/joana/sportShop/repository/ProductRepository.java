package com.joana.sportShop.repository;

import com.joana.sportShop.models.Category;
import com.joana.sportShop.models.Product;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {
    List<Product> listProduct;
    Long counter;

    @PostConstruct
    public void init(){
        counter=1L;
        listProduct=new ArrayList<>();
        Product p=new Product();
        p.setId(getNextId());
        p.setName("airmax");
        p.setUrlImage("sneaker.com");
        listProduct.add(p);

        Product p2=new Product();
        p2.setId(getNextId());
        p2.setName("airforce");
        p2.setUrlImage("sneaker.com");
        listProduct.add(p2);
    }
    public List<Product> findAllProducts() {
        return listProduct;
    }

    public Product save(Product product){
        product.setId(getNextId());
        listProduct.add(product);
        return product;
    }

    public void delete(Long productId) {
        listProduct.removeIf(v-> {
            return v.getId().equals(productId);
        });
    }

    private Long getNextId() {
        return counter++;
    }

    public Optional<Product> findById(Long productId) {
        return listProduct.stream().filter(v-> v.getId().equals(productId)).findAny();
    }
}
