package com.javatechie.crud.example.controller;

import com.javatechie.crud.example.entity.Application;
import com.javatechie.crud.example.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApplicationController {

    @Autowired
    private ApplicationService service;

    @PostMapping("/addApplication")
    public Application addApplicattion(@RequestBody Application application) {
        return service.saveApplication(application);
    }

    @PostMapping("/addApplications")
    public List<Application> addApplications(@RequestBody List<Application> application) {
        return service.saveApplications(application);
    }

    @GetMapping("/applications")
    public List<Application> findAllApplications() {
        return service.getApplications();
    }

    @GetMapping("/applicationById/{id}")
    public Application findApplicationById(@PathVariable int id) {
        return service.getApplicationById(id);
    }

    @GetMapping("/application{name}")
    public Application findApplicationByName(@PathVariable String name) {
        return service.getApplicationByName(name);
    }

    @PutMapping("/update")
    public Application updateApplication(@RequestBody Application application) {
        return service.updateApplication(application);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteApplication(@PathVariable int id) {
        return service.deleteApplication(id);
    }
    
    @GetMapping("/applicationById/{id}")
    public String trackApplication(@PathVariable int id) {
   	 return service.getApplicationStatus(id);
   	 
    }
}
