package com.reto.service;

import com.reto.model.AdminUser;

import java.util.List;
import java.util.Optional;

public interface AdminUserService {

    List<AdminUser> getAdminUser();

    AdminUser postAdminUser(AdminUser adminUser);
    AdminUser putAdminUser(AdminUser adminUser);

    Optional<AdminUser> getAdminUserById(Integer idAdminUser);

    boolean deleteAdminUser(Integer idAdminUser);
}
