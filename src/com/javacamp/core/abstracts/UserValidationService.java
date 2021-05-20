package com.javacamp.core.abstracts;

import com.javacamp.entities.concretes.User;

public interface UserValidationService {
    boolean registerValidator(User user);
    boolean loginValidator(String email, String password);
}
