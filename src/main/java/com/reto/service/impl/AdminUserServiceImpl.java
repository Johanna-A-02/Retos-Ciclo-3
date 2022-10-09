package com.reto.service.impl;

import com.reto.model.AdminUser;
import com.reto.model.Reservation;
import com.reto.repository.AdminUserRepository;
import com.reto.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    private AdminUserRepository adminUserRepository;

    @Override
    public List<AdminUser> getAdminUser(){
        List<AdminUser> response = adminUserRepository.findAll();
        return response;
    }

    @Override
    public AdminUser postAdminUser(AdminUser adminUser) {

        if(adminUser.getIdAdminUser() == null){
            adminUserRepository.save(adminUser);
        }else{
            Optional<AdminUser> adminUserOptional = adminUserRepository.findById(adminUser.getIdAdminUser());
            if(adminUserOptional.isEmpty()){
                adminUser = adminUserRepository.save(adminUser);
            }else{
                adminUser = adminUserOptional.get();
            }
        }

        return adminUser;
    }
}
