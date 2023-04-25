package com.soyoo.firstproject.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soyoo.firstproject.entity.ExampleEntity;
import com.soyoo.firstproject.repository.ExampleRepository;
import com.soyoo.firstproject.service.RestApiService;

@Service
public class RestApiServiceImplement implements RestApiService {

    private ExampleRepository exampleRepository;

    @Autowired
    public RestApiServiceImplement(ExampleRepository exampleRepository){
        this.exampleRepository = exampleRepository;
    }

    @Override
    public String getMethod(){
        // 데이터 조회
        // //1. jpa Repository 에 있는 findBy 메서드로 Entity 조회 가능
        // ExampleEntity exampleEntity = exampleRepository.findById(1).get();
        ExampleEntity exampleEntity = exampleRepository.findByPk(1);
        return exampleEntity == null? "null" :exampleEntity.toString();
    }

    @Override
    public String postMethod() {
        // 데이터 삽입 
        //1. 엔터티 인스턴스( = 데이터베이스 테이블의 레코드) 생성 
        ExampleEntity exampleEntity = 
            ExampleEntity.builder()
            .exampleColumn2("string1")
            .exampleColumn3(false)
            .build();

        //2. repository 를 거쳐서 Entity 인스턴스 저장
        exampleRepository.save(exampleEntity);
        return null;
    }

    @Override
    public String patchMethod() {
        //데이터 수정
        //1) 아이디로 가져와서 수정 후 저장
        //1. 특정조건으로 Entity조회
        ExampleEntity exampleEntity = exampleRepository.findById(1).get();
        //2.데이터 수정
        exampleEntity.setExampleColumn2("String2");
        //3. 엔터티 인스턴스 저장
        exampleRepository.save(exampleEntity);

        //2) 새 엔터티를 생성하고 
        //1. 엔터티 인스턴스 생성
        ExampleEntity exampleEntity2 = new ExampleEntity(2, "string3로 변경", true);
        //2. 엔터티 인스턴스 저장
        exampleRepository.save(exampleEntity2);
        return null;
    }

    @Override
    public String deleteMethod() {
        //두가지 방법
        //1. JpaRepository에 있는 deleteBy메서드로 Entity삭제
        exampleRepository.deleteById(1);
        //2. 
        return null;
    }

    


    
}
