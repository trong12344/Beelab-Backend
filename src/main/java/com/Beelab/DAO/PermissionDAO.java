package com.Beelab.DAO;

import com.Beelab.Entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionDAO extends JpaRepository<Permission, String> {
}
