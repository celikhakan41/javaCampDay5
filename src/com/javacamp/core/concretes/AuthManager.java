package com.javacamp.core.concretes;

import com.javacamp.business.abstracts.UserService;
import com.javacamp.core.abstracts.AuthService;
import com.javacamp.core.abstracts.UserValidationService;
import com.javacamp.core.abstracts.VerificationService;
import com.javacamp.entities.concretes.User;

public class AuthManager implements AuthService {
    UserService userService;
    UserValidationService userValidationService;
    VerificationService verificationService;



    public AuthManager() {

    }

    public AuthManager(UserService userService,VerificationService verificationService,UserValidationService userValidationService) {
        super();
        this.userService = userService;
        this.verificationService=verificationService;
        this.userValidationService=userValidationService;

    }
    @Override
    public void register(int id, String firstName, String lastName, String email, String password) {

        User userToRegister = new User(id, firstName, lastName, email, password);
        if(!this.userValidationService.registerValidator(userToRegister))
        {
            System.out.println("Kullanıcı bilgileri kontrol ediniz...");
        }

        if(!checkIfUserExists(email))
        {
            System.out.println("Tanımlanmış mail adresi girildi. Lütfen baþka bir mail adresi giriniz.");
            return;
        }
        if (!this.verificationService.verification(userToRegister)) {
            System.out.println("Üyelik doğrulama başarısız.");
            return;
        }

        userService.add(userToRegister);

    }

    @Override
    public void login(String email, String password) {
        if(!this.userValidationService.loginValidator(email, password))
        {
            System.out.println("Giriş bilgilerinizi kontrol ediniz");
            return;
        }
        User userToLogin=userService.getByEmailAndPassword(email, password);

        if (userToLogin == null) {
            System.out.println("E-posta veya şifrenizi kontrol ediniz!");
            return;
        }
        if(!checkIfUserVerified(userToLogin))
        {
            System.out.println("Giriş için doğrulama yapılması gerekiyor");
            return;
        }
        System.out.println("Giriş başarılı, Hoşgeldiniz " + userToLogin.getFirstName() + " " + userToLogin.getLastName());
    }

    private boolean checkIfUserExists(String email)
    {
        return userService.getByMail(email)==null;
    }

    private boolean checkIfUserVerified(User user)
    {
        return verificationService.verification(user);
    }

}
