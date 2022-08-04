package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.entity.Center;
import com.examly.springapp.service.CenterService;

import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
public class CenterController {
 
    @Autowired
    private CenterService serviceCenterService;

    @PostMapping("/admin/addServiceCenter")
    public Center addServiceCenter(@RequestBody Center serviceCenter) {
    	log.trace("A new service center is created" + serviceCenter);
        return this.serviceCenterService.addCenter(serviceCenter);
    }

    // view all Service Center
    @GetMapping("/getServiceCenter")
    public List<Center> viewServiceCenter() {
        return this.serviceCenterService.viewCenter();
    }

    // get service center by id
    @GetMapping("/getServiceCenter/{id}")
    public Center viewServiceCenter(@PathVariable("id") String id) {
        long centerId = Long.parseLong(id);
        return this.serviceCenterService.getCenter(centerId);
    }

    // updating Service Center
    @PutMapping(value = "/admin/editServiceCenter/{id}")
    public Center editCenter(@RequestBody Center serviceCenter,
            @PathVariable("id") Long id) {
        return this.serviceCenterService.editCenter(serviceCenter, id);
    }

    // delete Service Center
    @DeleteMapping("/admin/deleteServiceCenter/{id}")
    public Center deleteServiceCenter(@PathVariable long id) {
        return this.serviceCenterService.deleteCenter(id);
    }
}