package com.lyczkul.taskmanager.web;

import com.lyczkul.security.model.User;
import com.lyczkul.security.service.impl.UserDataService;
import com.lyczkul.taskmanager.model.Task;
import com.lyczkul.taskmanager.repository.ProjectRepository;
import com.lyczkul.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

/**
 * Created by Tomek on 2017-06-12.
 */
@RestController
@RequestMapping(value = "/api/task")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserDataService userService;

    @RequestMapping(value = "/user/{user_id}", method = RequestMethod.GET)
    public List<Task> tasks(@PathVariable(value = "user_id") Long userId) {
        return taskRepository.findAllByUserId(userId);
    }

    @RequestMapping(value = "/project/{project_id}", method = RequestMethod.GET)
    public List<Task> projectTasks(@PathVariable(value = "project_id") Long projectId) {
        return taskRepository.findAllByProject(projectRepository.findOne(projectId));
    }

    @RequestMapping(value = "/{task_id}", method = RequestMethod.GET)
    public Task task(@PathVariable(value = "task_id") Long taskId) {
        return taskRepository.findOne(taskId);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Task create(@RequestBody Task task, Principal principal) {
        User user = userService.getUser(principal);
        task.setUser(user);
        taskRepository.save(task);
        return task;
    }

    @RequestMapping(value = "/delete/{task_id}", method = RequestMethod.DELETE)
    public int delete(@PathVariable(value = "task_id") Long taskId) {
        taskRepository.delete(taskId);
        return 200;
    }
}