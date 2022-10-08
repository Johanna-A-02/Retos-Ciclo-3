package com.reto.service.impl;

import com.reto.model.AdminUser;
import com.reto.repository.AdminUserRepository;
import com.reto.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    private AdminUserRepository adminUserRepository;

    @Override
    public List<AdminUser> getAdminUser(){
        List<AdminUser> response = new ArrayList<>();
        adminUserRepository.findAll().forEach(response::add);
        return response;
    }

    @Override
    public AdminUser postAdminUser(AdminUser adminUser) {
        adminUserRepository.save(adminUser);
        return adminUser;
    }
}
