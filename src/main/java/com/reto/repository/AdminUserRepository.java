package com.reto.repository;

import com.reto.model.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminUserRepository extends JpaRepository <AdminUser, Integer> {
}
