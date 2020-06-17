package com.travelBuddy.backend.travelBuddy.dao;
import com.travelBuddy.backend.travelBuddy.entity.CovidCase;


import java.util.List;

public interface CovidCaseDao {
    
    List<CovidCase> findAndGroupCovidCases(); 

    List<CovidCase> findCovidCasesByCaseType(String caseType);

    List<CovidCase> findCovidCaseByLatAndLon(String lat, String lon);

    String findCityOfCovidCaseByLatAndLon(String lat, String lon);

    int findTotalCovidCaseByLatAndLon(String lat, String lon);

    List<CovidCase> findCovidByLatLngRange(String lat, String lon, String r);
}