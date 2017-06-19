package com.lyczkul.taskmanager.web;

import com.lyczkul.taskmanager.model.Task;
import com.lyczkul.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Tomek on 2017-06-12.
 */
@RequestMapping(value = "/api")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @RequestMapping(value = "/tasks/{user_id}", method = RequestMethod.GET)
    public List<Task> tasks(@PathVariable(value = "user_id") Long userId){
        return taskRepository.findAllByUserId(userId);
    }
}
