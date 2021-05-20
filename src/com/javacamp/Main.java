package com.javacamp;

import com.javacamp.Dao.concretes.mhakancelikUserDao;
import com.javacamp.business.abstracts.UserService;
import com.javacamp.business.concretes.UserManager;
import com.javacamp.core.abstracts.AuthService;
import com.javacamp.core.concretes.AuthManager;
import com.javacamp.core.concretes.EmailVerificationManager;
import com.javacamp.core.concretes.UserValidationManager;

public class Main {

    public static void main(String[] args) {
        UserService userService = new UserManager(new mhakancelikUserDao());

        AuthService authService = new AuthManager(userService,new EmailVerificationManager(),new UserValidationManager());
        authService.register(1, "Muhammed Hakan", "CELIK", "celikhakan41@yahoo.com", "12345");
        authService.login("celikhakan41@yahoo.com", "12345");
    }
}
