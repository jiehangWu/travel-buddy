package com.travelBuddy.backend.travelBuddy.controller;

import com.travelBuddy.backend.travelBuddy.entity.CovidCase;
import com.travelBuddy.backend.travelBuddy.entity.MakeComment;
import com.travelBuddy.backend.travelBuddy.entity.Postcode;
import com.travelBuddy.backend.travelBuddy.service.CovidCaseService;
import com.travelBuddy.backend.travelBuddy.service.MakeCommentService;
import com.travelBuddy.backend.travelBuddy.service.PostcodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
    private MakeCommentService makeCommentService;

    @Autowired
    public void setPostcodeService(PostcodeService postcodeService) {
        this.postcodeService = postcodeService;
    }

    @Autowired
    public void setCovidCaseService(CovidCaseService covidCaseService) {
        this.covidCaseService = covidCaseService;
    }

    @Autowired
    public void setMakeCommentService(MakeCommentService makeCommentService) {
        this.makeCommentService = makeCommentService;
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

    @RequestMapping(value = "/covidcaselist/case", method = RequestMethod.GET)
    @ResponseBody
    public List<CovidCase> getCovidCaseByCase(@RequestParam(value = "type") String caseType) {
        return covidCaseService.findCovidCasesByCaseType(caseType);
    }

    @RequestMapping(path = "/covidcaselist/{lat}/{lon}", method = RequestMethod.GET)
    @ResponseBody
    public List<CovidCase> getCovidCaseByLatAndLon(@PathVariable String lat, @PathVariable String lon) {
        return covidCaseService.findCovidCaseByLatAndLon(lat, lon);
    }

    @RequestMapping(path = "/covidcaselist/city/{lat}/{lon}", method = RequestMethod.GET)
    @ResponseBody
    public String getCityOfCovidCaseByLatAndLon(@PathVariable String lat, @PathVariable String lon) {
        return covidCaseService.findCityOfCovidCaseByLatAndLon(lat, lon);
    }

    @RequestMapping(path = "/covidcaselist/total/{lat}/{lon}", method = RequestMethod.GET)
    @ResponseBody
    public int getTotalCovidCaseByLatAndLon(@PathVariable String lat, @PathVariable String lon) {
        return covidCaseService.findTotalCovidCaseByLatAndLon(lat, lon);
    }

    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public void insertComment(@RequestBody MakeComment mc) {
        makeCommentService.insertComment(mc);
    }

    @RequestMapping(value = "/upvote", method = RequestMethod.PUT)
    public void updateUpvote(@RequestParam(value = "id") String cid) {
        Long id = Long.parseLong(cid);
        makeCommentService.updateUpvote(id);
    }

    @RequestMapping(value = "/downvote", method = RequestMethod.PUT)
    public void updateDownvote(@RequestParam(value = "id") String cid) {
        Long id = Long.parseLong(cid);
        makeCommentService.updateDownvote(id);
    }

    @RequestMapping(path = "/comment/{cid}", method = RequestMethod.GET)
    @ResponseBody
    public MakeComment getCommentById(@PathVariable String cid) {
        Long id = Long.parseLong(cid);
        return makeCommentService.findCommentById(id);
    }

    @RequestMapping(path = "/comment/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteCommentById(@PathVariable Long id) {
        makeCommentService.deleteCommentById(id);
    }
}
