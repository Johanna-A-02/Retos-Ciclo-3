package com.reto.controller;

import com.reto.model.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/Category")
public interface CategoryAPI {

    @GetMapping(value = "/all", produces = "application/json")
    ResponseEntity<?> getCategory();

    @PostMapping (value = "/save", produces = "application/json")
    ResponseEntity<?> postCategory(@RequestBody Category category);

}
