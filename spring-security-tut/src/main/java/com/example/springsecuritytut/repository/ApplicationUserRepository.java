package com.example.springsecuritytut.repository;

import com.example.springsecuritytut.auth.ApplicationUser;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApplicationUserRepository {
    Optional<ApplicationUser> getApplicationUser(String username);
}
