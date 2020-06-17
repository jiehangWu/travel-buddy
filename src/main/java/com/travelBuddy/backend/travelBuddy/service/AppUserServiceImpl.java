package com.travelBuddy.backend.travelBuddy.service;

import com.travelBuddy.backend.travelBuddy.dao.AppUserDao;
import com.travelBuddy.backend.travelBuddy.entity.AppUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AppUserServiceImpl implements AppUserService {
    @Autowired
    private AppUserDao appUserDao;

    @Transactional
    @Override
    public AppUser findAppUserById(int id) {
        return appUserDao.findAppUserById(id);
    }

    @Override
    public AppUser findAppUserByEmailPassword(String email, String password) {
        return appUserDao.findAppUserByEmailPassword(email, password);
    }

    
}