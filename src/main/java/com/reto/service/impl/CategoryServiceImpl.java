package com.reto.service.impl;

import com.reto.model.Category;
import com.reto.repository.CategoryRepository;
import com.reto.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getCategory(){
        List<Category> response = new ArrayList<>();
        categoryRepository.findAll().forEach(response::add);
        return response;
    }

    @Override
    public Category postCategory(Category category) {
        categoryRepository.save(category);
        return category;
    }
}
