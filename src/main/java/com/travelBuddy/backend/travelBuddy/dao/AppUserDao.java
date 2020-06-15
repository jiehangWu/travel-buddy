package com.travelBuddy.backend.travelBuddy.dao;

import com.travelBuddy.backend.travelBuddy.entity.AppUser;

public interface AppUserDao {
    AppUser findAppUserById(int id);
}