package com.reto.controller;

import com.reto.model.AdminUser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/AdminUser")
@CrossOrigin(origins = {"*"})
public interface AdminUserAPI {

    @GetMapping(value = "/all", produces = "application/json")
    ResponseEntity<?> getAdminUser();
    @PostMapping(value = "/save", produces = "application/json")
    ResponseEntity<?> postAdminUser(@RequestBody AdminUser adminUser);

    @PutMapping(value = "/update", produces = "application/json")
    ResponseEntity<?> putAdminUser(@RequestBody AdminUser adminUser);

    @GetMapping(value = "/{idAdminUser}", produces = "application/json")
    ResponseEntity<?> getAdminUserById(@PathVariable(value = "idAdminUser") Integer idClient);

    @DeleteMapping(value = "/{idAdminUser}")
    ResponseEntity<?> deleteAdminUser(@PathVariable(value = "idAdminUser")Integer idAdminUser);
}
