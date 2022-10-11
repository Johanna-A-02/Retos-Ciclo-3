package com.reto.controller.impl;

import com.reto.controller.AdminUserAPI;
import com.reto.model.AdminUser;
import com.reto.model.Client;
import com.reto.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminUserControllerImpl implements AdminUserAPI {

    @Autowired
    private AdminUserService adminUserService;

    @Override
    public ResponseEntity<?> getAdminUser(){
        ResponseEntity<?> response = new ResponseEntity(adminUserService.getAdminUser(), HttpStatus.OK);
        return response;
    }

    @Override
    public ResponseEntity<?> postAdminUser(AdminUser adminUser) {
        ResponseEntity<?> response = new ResponseEntity(adminUserService.postAdminUser(adminUser), HttpStatus.CREATED);
        return response;
    }
    @Override
    public ResponseEntity<?> putAdminUser(AdminUser adminUser) {
        ResponseEntity<?> response = new ResponseEntity(adminUserService.putAdminUser(adminUser), HttpStatus.CREATED);
        return response;
    }

    @Override
    public ResponseEntity<?> getAdminUserById(Integer idAdminUser) {
        ResponseEntity<?> response = new ResponseEntity(adminUserService.getAdminUserById(idAdminUser), HttpStatus.OK);
        return response;
    }

    @Override
    public ResponseEntity<?> deleteAdminUser(Integer idAdminUser) {
        ResponseEntity<?> response = new ResponseEntity(adminUserService.deleteAdminUser(idAdminUser), HttpStatus.NO_CONTENT);
        return response;
    }

}
