package com.lyczkul.taskmanager.Repository;


import com.lyczkul.security.model.User;
import com.lyczkul.taskmanager.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

/**
 * Created by Tomek on 08.06.2017.
 */
public interface CompanyRepository extends JpaRepository<Company, Long>{
    Set<Company> findAllByUsers(User user);
}
