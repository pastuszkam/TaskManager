package com.lyczkul.taskmanager.Repository;

import com.lyczkul.taskmanager.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Tomek on 11.06.2017.
 */
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
