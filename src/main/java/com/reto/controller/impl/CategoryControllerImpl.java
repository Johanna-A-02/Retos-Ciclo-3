package com.reto.controller.impl;

import com.reto.controller.CategoryAPI;
import com.reto.model.Category;
import com.reto.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryControllerImpl implements CategoryAPI{

    @Autowired
    private CategoryService categoryService;

    @Override
    public ResponseEntity<?> getCategory(){
        ResponseEntity<?> response = new ResponseEntity(categoryService.getCategory(), HttpStatus.OK);
        return response;
    }

    @Override
    public ResponseEntity<?> postCategory(Category category) {
        ResponseEntity<?> response = new ResponseEntity(categoryService.postCategory(category), HttpStatus.CREATED);
        return response;
    }
    @Override
    public ResponseEntity<?> putCategory(Category category) {
        ResponseEntity<?> response = new ResponseEntity(categoryService.putCategory(category), HttpStatus.CREATED);
        return response;
    }

    @Override
    public ResponseEntity<?> getCategoryById(Integer idCategory) {
        ResponseEntity<?> response = new ResponseEntity(categoryService.getCategoryById(idCategory), HttpStatus.OK);
        return response;
    }

    @Override
    public ResponseEntity<?> deleteCategory(Integer idCategory) {
        ResponseEntity<?> response = new ResponseEntity(categoryService.deleteCategory(idCategory), HttpStatus.NO_CONTENT);
        return response;
    }
}
