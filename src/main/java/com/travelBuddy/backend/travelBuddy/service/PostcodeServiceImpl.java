package com.travelBuddy.backend.travelBuddy.service;

import com.travelBuddy.backend.travelBuddy.dao.PostcodeDao;
import com.travelBuddy.backend.travelBuddy.entity.Postcode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostcodeServiceImpl implements PostcodeService{

    @Autowired
    private PostcodeDao postcodeDao;

    @Transactional
    public List<Postcode> findAll() {
        return postcodeDao.findAll();
    }
}
