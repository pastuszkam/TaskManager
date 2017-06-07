package com.lyczkul.security.repository;

import com.lyczkul.security.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Tomek on 2017-06-07.
 */
public interface RoleRepository extends JpaRepository<Role, Long>{
    Role findByName(String name);
}
