package com.soyoo.firstproject.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.soyoo.firstproject.service.FileService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("file")
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;

    @PostMapping("upload")
    public String upload(

        @RequestParam("file") MultipartFile file

    ){
        return fileService.upload(file);
    }

}
