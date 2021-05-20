package com.javacamp.business.concretes;

import com.javacamp.Dao.abstracts.UserDao;
import com.javacamp.business.abstracts.UserService;
import com.javacamp.entities.concretes.User;

import java.util.List;

public class UserManager implements UserService {
    UserDao userDao;
    public UserManager(UserDao userDao) {
        this.userDao=userDao;
    }

    @Override
    public void add(User user) {
        userDao.add(user);
        System.out.println("Kullanıcı Eklendi");

    }

    @Override
    public void update(User user) {
        userDao.update(user);
        System.out.println("Kullanıcı güncellendi.");
    }

    @Override
    public void delete(User user) {
        userDao.delete(user);
        System.out.println("Kullanıcı silindi");

    }

    @Override
    public User getById(int id) {

        return userDao.getById(id);
    }

    @Override
    public User getByMail(String email) {

        return userDao.getByMail(email);
    }

    @Override
    public User getByEmailAndPassword(String email, String password) {

        return userDao.getByEmailAndPassword(email, password);
    }

    @Override
    public List<User> getAll() {

        return userDao.getAll();
    }
}
