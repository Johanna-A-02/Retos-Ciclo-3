package com.reto.controller;

import com.reto.model.Cabin;
import com.reto.model.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
