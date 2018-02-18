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
import com.csquare.framework.search.SearchCriteria;
import com.csquare.ref.model.RefCity;
import com.csquare.ref.service.IRefCityService;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class RefCityController extends RestExceptionHandler {

    @Autowired
    IRefCityService irefcityService;

    @RequestMapping(value = "/getAllRefCites/{offset}/{limit}", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<RefCity> getRefAllCites(@PathVariable Integer offset, @PathVariable Integer limit) {

        List<RefCity> cities = irefcityService.getAllRefCites(offset, limit);
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

    @RequestMapping(value = "/searchRefCity/{offset}/{limit}/{allMatch}", method = RequestMethod.POST, headers = "Accept=application/json")
    public List<RefCity> searchRefCity(@RequestBody List<SearchCriteria> criterias, @PathVariable Integer offset, @PathVariable Integer limit,
        @PathVariable Boolean allMatch) {

        List<RefCity> refList = irefcityService.searchRefCity(criterias, offset, limit, allMatch);
        return refList;
    }
}
