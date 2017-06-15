package com.lyczkul.taskmanager.repository;

import com.lyczkul.taskmanager.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Tomek on 11.06.2017.
 */
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
