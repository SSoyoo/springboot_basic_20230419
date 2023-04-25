package com.soyoo.firstproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Example")
@Table(name = "Example") // 어떤 테이블과 매핑할 것인지를 표시. 작성하지 않으면 클래스명으로 찾아간다. 
public class ExampleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "example_column1" , nullable = false, unique = true)
    private int pk;
    private String exampleColumn2;
    private boolean exampleColumn3;
}
