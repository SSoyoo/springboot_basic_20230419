package com.soyoo.firstproject.service.implement;

import org.springframework.stereotype.Service;

import com.soyoo.firstproject.service.RestApiService;

@Service
public class RestApiServiceImplement implements RestApiService {

    public String getMethod(){

        return "Return to Service Layer";
    }
    
}
