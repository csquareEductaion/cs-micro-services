package com.csquare.ref.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.csquare.framework.exception.handler.RestExceptionHandler;
import com.csquare.ref.model.RefCity;
import com.csquare.ref.service.IRefCityService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class RefCityController extends RestExceptionHandler {

    @Autowired
    IRefCityService irefcityService;

    @RequestMapping(value = "/getAllRefCites", method = RequestMethod.GET, headers = "Accept=application/json")
    public ArrayList<RefCity> getRefAllCites() {

    	ArrayList<RefCity> cities = irefcityService.getAllRefCites();
        return cities;
    }   

    @RequestMapping(value = "/addRefCity", method = RequestMethod.POST, headers = "Accept=application/json")
    public RefCity addRefCity(@RequestBody RefCity refcity) {

    	refcity = irefcityService.addRefCity(refcity);
        return refcity;
    }

    @RequestMapping(value = "/updateRefCity", method = RequestMethod.POST, headers = "Accept=application/json")
    public RefCity updateRefCity(@RequestBody RefCity city) {

    	city = irefcityService.updateRefCity(city);
        return city;
    }
    
    @RequestMapping(value = "/deleteRefCity", method = RequestMethod.POST, headers = "Accept=application/json")
    public void deleteRefCity(@RequestBody String refcityId) {

    	irefcityService.deleteRefCity(refcityId);
    }
    
    @RequestMapping(value = "/getRefCityById/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public RefCity getRefCityById(@PathVariable String id) {

    	RefCity city = irefcityService.getRefCityById(id);
        return city;
    }

}
