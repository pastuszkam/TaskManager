package com.lyczkul.security.repository;

import com.lyczkul.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Tomek on 05.06.2017.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
