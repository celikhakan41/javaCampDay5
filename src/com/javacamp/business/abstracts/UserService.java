package com.javacamp.business.abstracts;

import com.javacamp.entities.concretes.User;

import java.util.List;

public interface UserService {
    void add(User user);
    void update(User user);
    void delete(User user);
    User getById(int id);
    User getByMail(String email);
    User getByEmailAndPassword(String email, String password);
    List<User> getAll();
}
