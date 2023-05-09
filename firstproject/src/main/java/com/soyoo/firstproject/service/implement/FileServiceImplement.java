package com.soyoo.firstproject.service.implement;

import java.io.File;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.soyoo.firstproject.service.FileService;

@Service
public class FileServiceImplement implements FileService{

    @Value("${file.path}") private String FILE_PATH;
    @Value("${file.url}") private String FILE_URL;

    @Override
    public String upload(MultipartFile file) {

        if(file.isEmpty()) return null;

        //1. 파일명가져오기
        String originalFileName = file.getOriginalFilename();

        //2. 확장자 가져오기
        int extensionIndex = originalFileName.lastIndexOf(".");
        String extension = originalFileName.substring(extensionIndex); // /. 뒤로 확장자 가져옴

        //3. 파일의 새로운 이름 지정 
        String uuid = UUID.randomUUID().toString();
        String saveName = uuid + extension;

        //4. 파일 경로 지정
        String savaPath = FILE_PATH + saveName;

        try {
            //파일 저장
            file.transferTo(new File(savaPath));

        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }

        //클라이언트가 해당 파일에 접근하기 위한url 
        String fileUrl = FILE_URL + saveName;
        return fileUrl;




        
    }
    
}
