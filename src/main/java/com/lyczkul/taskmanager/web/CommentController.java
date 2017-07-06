package com.lyczkul.taskmanager.web;

import com.lyczkul.security.model.User;
import com.lyczkul.security.service.impl.UserDataService;
import com.lyczkul.taskmanager.model.Comment;
import com.lyczkul.taskmanager.model.Company;
import com.lyczkul.taskmanager.repository.CommentRepository;
import com.lyczkul.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Tomek on 2017-07-06.
 */
@RestController
@RequestMapping(value = "/api/comment")
public class CommentController {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserDataService userService;

    @Autowired
    private TaskRepository taskRepository;

    @RequestMapping(value = "/{task_id}", method = RequestMethod.GET)
    public List<Comment> allComments(@PathVariable(value = "task_id") Long taskId){
        return commentRepository.findAllByTask(taskRepository.findOne(taskId));
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Comment create(@RequestBody Comment comment, Principal principal){
        User user = userService.getUser(principal);
        comment.setUser(user);
        commentRepository.save(comment);
        return comment;
    }

    @RequestMapping(value = "/delete/{comment_id}", method = RequestMethod.DELETE)
    public Integer delete(@PathVariable(value = "comment_id") Long commentId){
        commentRepository.delete(commentId);
        return 200;
    }
}
