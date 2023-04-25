package com.soyoo.firstproject.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soyoo.firstproject.entity.ExampleEntity;

@Repository
public interface ExampleRepository extends JpaRepository<ExampleEntity,Integer> {

    public ExampleEntity findByPk(int pk);
    public List<ExampleEntity>findByExampleColumn3AndExampleCoulmn2(boolean exampleColumn3, boolean exampleColumn2);

    public boolean exexistsByExampleColumn3(boolean exampleColumn3);
    

    
}
