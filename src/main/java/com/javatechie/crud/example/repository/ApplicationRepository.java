package com.javatechie.crud.example.repository;

import com.javatechie.crud.example.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application,Integer> {
    Application findByName(String name);
}

