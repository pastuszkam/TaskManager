package com.lyczkul.taskmanager.model;

import com.lyczkul.security.model.User;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Tomek on 08.06.2017.
 */
@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_company", joinColumns = @JoinColumn(name = "company_id",
            referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
    private Set<User> users;

    @OneToMany(targetEntity = Project.class, mappedBy = "company", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Project> projects;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}