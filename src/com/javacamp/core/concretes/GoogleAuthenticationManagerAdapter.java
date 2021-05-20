package com.javacamp.core.concretes;

import com.javacamp.core.abstracts.AuthService;
import com.javacamp.googleAuth.GoogleAuthenticatorManager;

public class GoogleAuthenticationManagerAdapter implements AuthService {
    GoogleAuthenticatorManager manager=new GoogleAuthenticatorManager();

    @Override
    public void register(int id, String firstName, String lastName, String email, String password) {
        manager.register(id,firstName,lastName,email,password);
        System.out.println("Google ile kayıt olundu : " + email);
    }

    @Override
    public void login(String email, String password) {
        manager.login(email, password);
        System.out.println("Google ile giriş yapılıyor : " + email);
    }
}