package com.travelBuddy.backend.travelBuddy.service;

import com.travelBuddy.backend.travelBuddy.entity.Postcode;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostcodeService {
    List<Postcode> findAll();
}
