package com.lyczkul.security.model;

import com.fasterxml.jackson.annotation.*;
import com.lyczkul.taskmanager.model.Comment;
import com.lyczkul.taskmanager.model.Company;
import com.lyczkul.taskmanager.model.Project;
import com.lyczkul.taskmanager.model.Task;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Tomek on 2017-06-05.
 */
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;

    @ManyToOne
    @JoinColumn(name = "role")
    @JsonBackReference
    private Role role;

    @OneToMany(targetEntity = Task.class, mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Task> tasks;

    @ManyToMany(mappedBy = "users", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("users")
    private Set<Company> companies;

    @ManyToMany(mappedBy = "users", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("users")
    private Set<Project> projects;

    @OneToMany(targetEntity = Comment.class, mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Comment> comments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Set<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(Set<Company> companies) {
        this.companies = companies;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }
}
