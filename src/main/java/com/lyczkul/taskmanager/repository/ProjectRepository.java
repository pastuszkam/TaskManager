package com.lyczkul.taskmanager.repository;

import com.lyczkul.security.model.User;
import com.lyczkul.taskmanager.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Tomek on 11.06.2017.
 */
public interface ProjectRepository extends JpaRepository<Project, Long> {
    public List<Project> findAllByUsers(User user);
}
