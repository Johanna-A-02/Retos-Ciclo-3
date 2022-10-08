package com.reto.service;

import com.reto.model.AdminUser;
import com.reto.model.Client;

import java.util.List;

public interface AdminUserService {

    List<AdminUser> getAdminUser();

    AdminUser postAdminUser(AdminUser adminUser);
}
