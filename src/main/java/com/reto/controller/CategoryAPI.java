package com.reto.controller;

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

}
