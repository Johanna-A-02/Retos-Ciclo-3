package com.reto.controller;

import com.reto.model.AdminUser;
import com.reto.model.Client;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
