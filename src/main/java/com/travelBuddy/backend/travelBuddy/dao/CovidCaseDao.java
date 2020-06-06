package com.travelBuddy.backend.travelBuddy.dao;
import com.travelBuddy.backend.travelBuddy.entity.CovidCase;


import java.util.List;

public interface CovidCaseDao {
    
    List<CovidCase> findAndGroupCovidCases(); 

    List<CovidCase> findCovidCasesByCaseType(String caseType);
}