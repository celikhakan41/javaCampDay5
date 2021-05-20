package com.javacamp.Dao.abstracts;

import com.javacamp.entities.concretes.User;

import java.util.List;

public interface UserDao {
    void add(User user);
    void update(User user);
    void delete(User user);
    User getById(int id);
    User getByMail(String email);

    List<User> getAll();

    User getByEmailAndPassword(String email,String password);
}
