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

    @Transactional
    public List<CovidCase> findCovidCaseByLatAndLon(String lat, String lon) {
        return covidCaseDao.findCovidCaseByLatAndLon(lat, lon);
    }

    @Transactional
    @Override
    public String findCityOfCovidCaseByLatAndLon(String lat, String lon) {
        return covidCaseDao.findCityOfCovidCaseByLatAndLon(lat, lon);
    }

    @Transactional
    @Override
    public int findTotalCovidCaseByLatAndLon(String lat, String lon) {
        return covidCaseDao.findTotalCovidCaseByLatAndLon(lat, lon);
    }

    @Transactional
    public List<CovidCase> findCovidCaseByLatAndLonRange(String lat, String lon) {
        return covidCaseDao.findCovidByLatLngRange1(lat, lon);
    }
}
    
