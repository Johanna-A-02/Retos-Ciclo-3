package com.reto.service.impl;

import com.reto.model.AdminUser;
import com.reto.model.Client;
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

    @Override
    public AdminUser putAdminUser(AdminUser adminUser){
        if(adminUser.getIdAdminUser() != null){
            Optional<AdminUser> adminUserOptional = adminUserRepository.findById(adminUser.getIdAdminUser());
            if(adminUserOptional.isPresent()){
                AdminUser adminUserUpdate = adminUserOptional.get();
                adminUserUpdate.setName(adminUser.getName() != null ? adminUser.getName(): adminUserUpdate.getName());
                adminUserUpdate.setEmail(adminUser.getEmail() != null ? adminUser.getEmail(): adminUserUpdate.getEmail());
                adminUserUpdate.setPassword(adminUser.getPassword() != null ? adminUser.getPassword(): adminUserUpdate.getPassword());

               //clientUpdate.setMessages(client.getMessages() != null ? client.getMessages(): clientUpdate.getMessages());
                //clientUpdate.setReservations(client.getReservations() != null ? client.getReservations(): clientUpdate.getReservations());

                adminUser = adminUserRepository.save(adminUserUpdate);
            }
        }
        return adminUser;
    }

    @Override
    public Optional<AdminUser> getAdminUserById(Integer idAdminUser){
        return adminUserRepository.findById(idAdminUser);
    }

    @Override
    public boolean deleteAdminUser(Integer idAdminUser){
        Boolean flag = adminUserRepository.findById(idAdminUser).map(adminUser -> {
            adminUserRepository.delete(adminUser);
            return true;
        }).orElse(false);

        return flag;
    }
}
