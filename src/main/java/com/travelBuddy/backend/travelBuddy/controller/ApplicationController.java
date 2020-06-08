package com.travelBuddy.backend.travelBuddy.controller;

import com.travelBuddy.backend.travelBuddy.entity.CovidCase;
import com.travelBuddy.backend.travelBuddy.entity.MakeComment;
import com.travelBuddy.backend.travelBuddy.entity.Postcode;
import com.travelBuddy.backend.travelBuddy.service.CovidCaseService;
import com.travelBuddy.backend.travelBuddy.service.MakeCommentService;
import com.travelBuddy.backend.travelBuddy.service.PostcodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

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

    @RequestMapping(value = "/covidcaselist/casetype", method = RequestMethod.GET)
    @ResponseBody
    public List<CovidCase> getCovidCaseByCase(@RequestParam(value = "casetype") String caseType) {
        return covidCaseService.findCovidCasesByCaseType(caseType);
    }

    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public void insertComment(@RequestBody MakeComment mc) {
        makeCommentService.insertComment(mc);
    }

    @RequestMapping(value = "/upvote", method = RequestMethod.PUT)
    public void updateUpvote(@RequestBody String id) {
        UUID cid = UUID.fromString(id);
        makeCommentService.updateUpvote(cid);
    }

    @RequestMapping(value = "/downvote", method = RequestMethod.PUT)
    public void updateDownvote(@RequestBody String id) {
        UUID cid = UUID.fromString(id);
        makeCommentService.updateDownvote(cid);
    }

    @RequestMapping(value = "/comment", method = RequestMethod.GET)
    @ResponseBody
    public MakeComment getCommentById(@RequestParam(value = "id") String id) {
        UUID cid = UUID.fromString(id);
        return makeCommentService.findCommentById(cid);
    }
}
