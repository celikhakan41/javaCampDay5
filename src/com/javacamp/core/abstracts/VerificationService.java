package com.javacamp.core.abstracts;

import com.javacamp.entities.concretes.User;

public interface VerificationService {
    boolean verification(User user);
}
