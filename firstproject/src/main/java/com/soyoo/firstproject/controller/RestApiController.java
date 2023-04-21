package com.soyoo.firstproject.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.soyoo.firstproject.dto.request.ExamleDto;

class ParamDto {
    String data1;
    String data2;

    public String getData1() {
        return this.data1;
    }

    public String getData2() {
        return this.data2;
    }

    public void setData1(String data1) {
        this.data1 = data1;
    }

    public void setData2(String data2) {
        this.data2 = data2;
    }

}

/*
 * REST API를 위한 controller임을 명시해주는 어노테이션
 * 
 * @Controller + @ResponseBody = @RestController
 * Response 는 html을 제외한 mime type을 반환
 */
@RestController
/*
 * url path 패턴을 지정해서 해당 패턴이면 지정한 클래스로 처리하도록 함
 */
@RequestMapping("api")
public class RestApiController {

    @RequestMapping(method = { RequestMethod.GET }, value = "hello2")

    public String hello2() {
        return "hello2";
    }

    // GET method @GetMapping
    // GET method : 클라이언트가 서버에게 데이터를 받기 위한 요청의 메소드
    // @RequestMapping(method=RequestMethod.GET, value="get-method")랑 동일
    @GetMapping("get-method")
    public String getMethod() {
        return "Response of Get request";
    }

    /*
     * Post Method @PostMapping
     */

    // Post Method : 클라이언트가 서버에 데이터를 작성하기 위한 요청의 method
    // @RequestMapping(method={RequestMethod.POST}, value = "post-method")

    @PostMapping("post-method")
    public String postMethod() {
        return "Response of Post Request";
    }

    /*
     * PATCH Method @PatchMapping
     */

    // PATCH Method : 클라이언트가 서버에 데이터를 일부만 수정하기 위한 요청의 Method
    // @RequestMapping(method={RequestMethod.PATCH}, value = "patch-method")

    @PatchMapping("patch-method")
    public String patchMethod() {
        return "Response of Patch Request";
    }

    /*
     * Delete Method @DeleteMapping
     */

    // Delete Method : 클라이언트가 서버에 데이터를 삭제하기 위한 요청의 Method
    // @RequestMapping(method={RequestMethod.DELETE}, value = "delete-method")

    @DeleteMapping("delete-method")
    public String deleteMethod() {
        return "Response fo Delete Request";
    }

    /*
     * PathVariable()로 GET 과 DELETE method에서 데이터받기
     * 리스소에 지정한 패턴에 맞춰서 요청의 url을 지정한다면 패턴에 맞춰서 데이터를 받아오는 형식
     */

    @GetMapping({ "path-variable/{data1}/{data2}", "path-variable/{data1}" })
    public String pathVariable(
            @PathVariable(value = "data1") String dataA,
            @PathVariable(value = "data2", required = false) String dataB) {

        return dataA + dataB + "데이터를 입력받았습니다.";

    }

    /*
     * @RequstParam로 GET , DELETE 메소드에서 데이터 받기
     * 완전한 path 뒤에 ?name=value....[&...]형식에 맞춰 name에 해당하는 value를 받아오는 형식
     */

    // @GetMapping("request-param")
    // public String requstParam(ParamDto dto)
    // {
    // return dto.data1 + dto.data2 + "데이터를 입력받았습니다";
    // }

    @GetMapping("request-param")
    public String requstParam(
            @RequestParam() String data1,
            @RequestParam() String data2) {
        return data1 + data2 + "데이터를 입력받았습니다";
    }

    // @RequsetBody 로 post, put, patch method에서 데이터받기
    // request Body에 있는 데이터를 받기 위한 어노테이션 

    @PostMapping("request-body")

    public ResponseEntity<ParamDto> requestBody(
        //@RequestBody String data
        @RequestBody ParamDto dto
    ){
        return ResponseEntity.status(408).body(dto);
    }

    @PostMapping("lombok")
    public String lombok(@RequestBody ExamleDto requestBody){
        return requestBody.toString();
    }

}
