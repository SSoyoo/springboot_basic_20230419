package com.soyoo.firstproject.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    
    public String upload(MultipartFile file);

}
