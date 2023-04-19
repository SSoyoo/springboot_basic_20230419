package com.soyoo.firstproject.service.implement;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.soyoo.firstproject.service.MainService;

@Service
public class MainServiceImplement implements MainService{

    @Override
    public String helllo() {
        return "Hello";
    }
    
}
