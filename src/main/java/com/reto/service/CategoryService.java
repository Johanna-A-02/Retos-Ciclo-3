package com.reto.service;

import com.reto.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getCategory();

    Category postCategory(Category category);
}
