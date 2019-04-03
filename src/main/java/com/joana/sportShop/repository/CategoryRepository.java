package com.joana.sportShop.repository;

import com.joana.sportShop.models.Category;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepository {
    public List<Category> listCategory;
    private Long counter;
    @PostConstruct
    public void  init(){
        counter = 1L;
     listCategory=new ArrayList<>();
        Category c1=new Category();
        c1.setId(getNextId());
        c1.setName("sneakers");
        listCategory.add(c1);

        Category c2=new Category();
        c1.setId(getNextId());
        c1.setName("tshirt");
        listCategory.add(c2);
    }
    public List<Category> findAllCategories() {
        return listCategory;
    }

    public Category save(Category category){
        category.setId(getNextId());
        listCategory.add(category);
        return category;
    }

    public void delete(Long categoryId) {
        listCategory.removeIf(v-> {
            return v.getId().equals(categoryId);
        });
    }

    private Long getNextId() {
        return counter++;
    }

    public Optional<Category> findById(Long categoryId) {
        return listCategory.stream().filter(v-> v.getId().equals(categoryId)).findAny();
    }
}
