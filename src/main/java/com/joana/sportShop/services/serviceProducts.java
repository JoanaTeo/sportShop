package com.joana.sportShop.services;

import com.joana.sportShop.exceptions.NoSuchProductException;
import com.joana.sportShop.models.Category;
import com.joana.sportShop.models.Manufacturer;
import com.joana.sportShop.models.Product;

import java.util.List;

public interface serviceProducts {
  List<Product> findAllProducts();
  Product findProductById(Long id) throws NoSuchProductException;
  Product addProduct(String name, Long manufacturerId, Long category, String url);
}
