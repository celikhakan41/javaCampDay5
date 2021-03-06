package com.javacamp.Dao.concretes;

import com.javacamp.Dao.abstracts.UserDao;
import com.javacamp.entities.concretes.User;

import java.util.ArrayList;
import java.util.List;

public class mhakancelikUserDao implements UserDao {

    List<User> users = new ArrayList<User>();

    @Override
    public void add(User user) {
        users.add(user);
        System.out.println(user.getFirstName()+" adlı kullanıcı eklendi");
    }

    @Override
    public void update(User user) {
        User userUpdate= getById(user.getId());
        userUpdate.setFirstName(user.getFirstName());
        userUpdate.setLastName(user.getLastName());
        userUpdate.setEmail(user.getEmail());
        userUpdate.setPassword(user.getPassword());

    }

    @Override
    public void delete(User user) {
        users.removeIf(u->u.getId()==user.getId());
    }

    @Override
    public User getById(int id) {
        for (User user : users) {
            if (user.getId()==id) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User getByMail(String email) {
        for(User user:users) {
            if(user.getEmail()==email) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public User getByEmailAndPassword(String email, String password) {
        for(User user:users) {
            if(user.getEmail()==email && user.getPassword()==password) {
                return user;
            }
        }
        return null;
    }

}