package com.reto.controller;

import com.reto.model.AdminUser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/AdminUser")
public interface AdminUserAPI {

    @GetMapping(value = "/all", produces = "application/json")
    ResponseEntity<?> getAdminUser();
    @PostMapping(value = "/save", produces = "application/json")
    ResponseEntity<?> postAdminUser(@RequestBody AdminUser adminUser);
}
