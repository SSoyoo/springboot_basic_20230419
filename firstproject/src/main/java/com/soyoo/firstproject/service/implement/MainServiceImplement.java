package com.soyoo.firstproject.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soyoo.firstproject.provider.JwtTokenProvider;
import com.soyoo.firstproject.service.MainService;

@Service
public class MainServiceImplement implements MainService{

    private JwtTokenProvider jwtTokenProvider;
    @Autowired
    public MainServiceImplement(JwtTokenProvider jwtTokenProvider){
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public String hello() {
        return "Hello";
    }

    @Override
    public String getJwt(String data) {
        
        String jwt = jwtTokenProvider.create(data);
        return jwt;
    }

    
    
}
