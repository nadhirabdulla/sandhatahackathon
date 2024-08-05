package com.javatechie.crud.example.service;

import com.javatechie.crud.example.entity.Application;
import com.javatechie.crud.example.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationService {
    @Autowired
    private ApplicationRepository repository;

    public Application saveApplication(Application application) {
        return repository.save(application);
    }

    public List<Application> saveApplications(List<Application> applications) {
        return repository.saveAll(applications);
    }

    public List<Application> getApplications() {
        return repository.findAll();
    }

    public Application getApplicationById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Application getApplicationByName(String name) {
        return repository.findByName(name);
    }

    public String deleteApplication(int id) {
        repository.deleteById(id);
        return "application removed !! " + id;
    }

    public Application updateApplication(Application application) {
        Application existingApplication = repository.findById(application.getId()).orElse(null);
        existingApplication.setName(application.getName());
        existingApplication.setQuantity(application.getQuantity());
        existingApplication.setPrice(application.getPrice());
        return repository.save(existingApplication);
    }
    
    public String getApplicationStatus(@PathVariable int id) {
    	Optional<Application> optionalApplication = repository.findById(id);
    	 if (optionalApplication.isPresent()) {
             Application application = optionalApplication.get();
             return application.getStatus();
         } else {
             return "Status not found";
    }


    }
}
