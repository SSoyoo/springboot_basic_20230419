package com.soyoo.firstproject.dto.request;


import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class ExamleDto {
    @NotBlank
    private String parameter1;
    private String parameter2;
    private String parameter3;
}
