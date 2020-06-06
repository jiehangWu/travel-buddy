package com.travelBuddy.backend.travelBuddy.controller;

import com.travelBuddy.backend.travelBuddy.entity.CovidCase;
import com.travelBuddy.backend.travelBuddy.entity.Postcode;
import com.travelBuddy.backend.travelBuddy.service.CovidCaseService;
import com.travelBuddy.backend.travelBuddy.service.PostcodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class ApplicationController {
    private PostcodeService postcodeService;
    private CovidCaseService covidCaseService;

    @Autowired
    public void setPostcodeService(PostcodeService postcodeService) {
        this.postcodeService = postcodeService;
    }

    @Autowired
    public void setCovidCaseService(CovidCaseService covidCaseService) {
        this.covidCaseService = covidCaseService;
    }

    @RequestMapping(value = "/postcodelist", method = RequestMethod.GET)
    @ResponseBody
    public List<Postcode> getAllPostcode() {
        return postcodeService.findAll();
    }

    @RequestMapping(value = "/covidcaselist", method = RequestMethod.GET)
    @ResponseBody
    public List<CovidCase> getAllCovidCaseAndCount() {
        return covidCaseService.findAndGroupCovidCases();
    }

    @RequestMapping(value = "/covidcaselist/casetype", method = RequestMethod.GET)
    @ResponseBody
    public List<CovidCase> getCovidCaseByCase(@RequestParam("casetype") String caseType) {
        return covidCaseService.findCovidCasesByCaseType(caseType);
    }
}
