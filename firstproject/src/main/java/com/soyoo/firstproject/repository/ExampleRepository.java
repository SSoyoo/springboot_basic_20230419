package com.soyoo.firstproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soyoo.firstproject.entity.exampleEntity;

@Repository
public interface ExampleRepository extends JpaRepository<exampleEntity,Integer> {

    
}
