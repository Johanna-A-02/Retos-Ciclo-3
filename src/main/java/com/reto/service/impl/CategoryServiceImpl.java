package com.reto.service.impl;

import com.reto.model.Cabin;
import com.reto.model.Category;
import com.reto.repository.CategoryRepository;
import com.reto.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getCategory(){
        List<Category> response = categoryRepository.findAll();
        return response;
    }

    @Override
    public Category postCategory(Category category) {

        if(category.getId() == null){
            categoryRepository.save(category);
        }else{
            Optional<Category> categoryOptional = categoryRepository.findById(category.getId());
            if(categoryOptional.isEmpty()){
                category = categoryRepository.save(category);
            }else{
                category = categoryOptional.get();
            }
        }

        return category;
    }
}
