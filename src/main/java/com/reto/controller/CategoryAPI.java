package com.reto.controller;

import com.reto.model.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/Category")
@CrossOrigin(origins = {"*"})
public interface CategoryAPI {

    @GetMapping(value = "/all", produces = "application/json")
    ResponseEntity<?> getCategory();

    @PostMapping (value = "/save", produces = "application/json")
    ResponseEntity<?> postCategory(@RequestBody Category category);

    @PutMapping(value = "/update", produces = "application/json")
    ResponseEntity<?> putCategory(@RequestBody Category category);

    @GetMapping(value = "/{idCategory}", produces = "application/json")
    ResponseEntity<?> getCategoryById(@PathVariable(value = "idCategory") Integer idCategory);

    @DeleteMapping(value = "/{idCategory}")
    ResponseEntity<?> deleteCategory(@PathVariable(value = "idCategory")Integer idCategory);
}
