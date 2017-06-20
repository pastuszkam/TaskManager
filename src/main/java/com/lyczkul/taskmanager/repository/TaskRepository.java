package com.lyczkul.taskmanager.repository;

import com.lyczkul.taskmanager.model.Project;
import com.lyczkul.taskmanager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Tomek on 11.06.2017.
 */
public interface TaskRepository extends JpaRepository<Task, Long> {
    public List<Task> findAllByUserId(Long userId);

    public List<Task> findAllByProject(Project project);
}
