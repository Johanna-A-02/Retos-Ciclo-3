package com.reto.service;

import com.reto.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> getCategory();

    Category postCategory(Category category);
    Category putCategory(Category category);

    Optional<Category> getCategoryById(Integer idCategory);

    boolean deleteCategory(Integer idCategory);
}
