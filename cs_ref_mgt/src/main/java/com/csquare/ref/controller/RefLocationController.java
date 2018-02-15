package com.csquare.ref.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.csquare.framework.exception.handler.RestExceptionHandler;
import com.csquare.ref.model.RefLocation;
import com.csquare.ref.service.IRefLocationService;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class RefLocationController extends RestExceptionHandler {

    @Autowired
    IRefLocationService ireflocationService;

    @RequestMapping(value = "/addRefLocation", method = RequestMethod.POST, headers = "Accept=application/json")
    public RefLocation addRefLocation(@RequestBody RefLocation reflocation) {

    	reflocation = ireflocationService.addRefLocation(reflocation);
        return reflocation;
    }

    @RequestMapping(value = "/updateRefLocation", method = RequestMethod.POST, headers = "Accept=application/json")
    public RefLocation updateRefLocation(@RequestBody RefLocation reflocation) {

    	reflocation = ireflocationService.updateRefLocation(reflocation);
        return reflocation;
    }
    
    @RequestMapping(value = "/deleteRefLocation", method = RequestMethod.POST, headers = "Accept=application/json")
    public void deleteRefLocation(@RequestBody String reflocationId) {

    	ireflocationService.deleteRefLocation(reflocationId);
    }
    
    @RequestMapping(value = "/getRefLocationById/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public RefLocation getRefLocationById(@PathVariable String id) {

    	RefLocation reflocation = ireflocationService.getRefLocationById(id);
        return reflocation;
    }
    
    @RequestMapping(value = "/getAllRefLocations", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<RefLocation> getAllRefLocations() {

        return ireflocationService.getAllRefLocations();
    }
    
    @RequestMapping(value = "/getAllRefLocationsByCity/{city}", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<RefLocation> getAllRefLocationsByCity(@PathVariable String city) {

        return ireflocationService.getAllRefLocationsByCity(city);
    }
}
