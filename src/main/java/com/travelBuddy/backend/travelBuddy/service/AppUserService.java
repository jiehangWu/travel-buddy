package com.travelBuddy.backend.travelBuddy.service;

import com.travelBuddy.backend.travelBuddy.entity.AppUser;
import org.springframework.stereotype.Service;

@Service
public interface AppUserService {
    AppUser findAppUserById(int id);
    AppUser findAppUserByEmailPassword(String email, String password);
}