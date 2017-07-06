package com.lyczkul.taskmanager.repository;

import com.lyczkul.taskmanager.model.Comment;
import com.lyczkul.taskmanager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Tomek on 11.06.2017.
 */
public interface CommentRepository extends JpaRepository<Comment, Long> {
    public List<Comment> findAllByTask(Task task);
}
