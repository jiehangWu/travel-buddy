package com.travelBuddy.backend.travelBuddy.service;

import java.util.List;

import com.travelBuddy.backend.travelBuddy.dao.CovidCaseDao;
import com.travelBuddy.backend.travelBuddy.entity.CovidCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CovidCaseServiceImpl implements CovidCaseService {

    @Autowired
    private CovidCaseDao covidCaseDao;

    @Transactional
    public List<CovidCase> findAndGroupCovidCases() {
        return covidCaseDao.findAndGroupCovidCases();
    }

    @Transactional
    public List<CovidCase> findCovidCasesByCaseType(String caseType) {
        return covidCaseDao.findCovidCasesByCaseType(caseType);
    }
}
    
