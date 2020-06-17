package com.travelBuddy.backend.travelBuddy.controller;

import com.travelBuddy.backend.travelBuddy.entity.CovidCase;
import com.travelBuddy.backend.travelBuddy.entity.Geolocation;
import com.travelBuddy.backend.travelBuddy.entity.MakeComment;
import com.travelBuddy.backend.travelBuddy.entity.Postcode;
import com.travelBuddy.backend.travelBuddy.entity.AppUser;
import com.travelBuddy.backend.travelBuddy.service.AppUserService;
import com.travelBuddy.backend.travelBuddy.service.CovidCaseService;
import com.travelBuddy.backend.travelBuddy.service.MakeCommentService;
import com.travelBuddy.backend.travelBuddy.service.PostcodeService;
import com.travelBuddy.backend.travelBuddy.service.GeolocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.nio.IntBuffer;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/")
public class ApplicationController {
    private PostcodeService postcodeService;
    private CovidCaseService covidCaseService;
    private MakeCommentService makeCommentService;
    private AppUserService appUserService;
    private GeolocationService geolocationService;

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

    @Autowired
    public void setAppUserService(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @Autowired
    public void setGeolocationService(GeolocationService geolocationService) {
        this.geolocationService = geolocationService;
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

    @RequestMapping(path = "/covidcaserangelist/{lat}/{lon}", method = RequestMethod.GET)
    @ResponseBody
    public List<CovidCase> getCovidCaseByLatAndLonRange(@PathVariable String lat, @PathVariable String lon) {
        return covidCaseService.findCovidCaseByLatAndLonRange(lat, lon);
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

    @RequestMapping(value = "/comments", method = RequestMethod.GET)
    @ResponseBody
    public List<MakeComment> getAllComments() {
        return makeCommentService.findAllComments();
    }

    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public void insertComment(@RequestBody MakeComment mc) {
        makeCommentService.insertComment(mc);
    }

    @RequestMapping(value = "/upvote/{id}", method = RequestMethod.PUT)
    public void updateUpvote(@PathVariable int id) {
        makeCommentService.updateUpvote(id);
    }

    @RequestMapping(value = "/downvote/{id}", method = RequestMethod.PUT)
    public void updateDownvote(@PathVariable int id) {
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
    public void deleteCommentById(@PathVariable int id) {
        makeCommentService.deleteCommentById(id);
    }

    @RequestMapping(path = "/users/{id}", method = RequestMethod.GET)
    @ResponseBody
    public AppUser getAppUserById(@PathVariable int id) {
        return appUserService.findAppUserById(id);
    }

    @RequestMapping(value = "/upvote/{id}", method = RequestMethod.GET)
    @ResponseBody
    public int getUpvoteById(@PathVariable int id) {
        return makeCommentService.findUpvoteById(id);
    }

    @RequestMapping(value = "/downvote/{id}", method = RequestMethod.GET)
    @ResponseBody
    public int getDownvoteById(@PathVariable int id) {
        return makeCommentService.findDownvoteById(id);
    }

    @RequestMapping(path = "/locations", method = RequestMethod.GET)
    @ResponseBody
    public List<Geolocation> getAllLocations() {
        return geolocationService.findAllGeolocation();
    }

    @RequestMapping(path = "equipments/{lat}/{lon}", method = RequestMethod.GET)
    @ResponseBody
    public List<String> getEquipmentsByLocation(@PathVariable double lat, @PathVariable double lon) {
        return geolocationService.findEquipmentsByLocation(lat, lon);
    }
}
