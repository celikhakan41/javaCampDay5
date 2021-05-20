package com.javacamp.googleAuth;

public class GoogleAuthenticatorManager {
    public boolean register(int id, String firstName, String lastName, String email, String password) {

        System.out.println("Üyelik işlemlerinin tamamlanabilmesi için email doğrulaması gerekiyor");
        return true;
    }
    public boolean login(String email, String password) {

        System.out.println("Google ile giriş yapıldı");
        return true;
    }
}
