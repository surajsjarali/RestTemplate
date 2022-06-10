package com.example.RestTemplate.controller;

import com.example.RestTemplate.model.StudentModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;

@RestController
public class Controller {

    RestTemplate restTemplate = new RestTemplate();

    String url
            = "http://localhost:8888/student/v1/";
    @GetMapping("/get")
    public ResponseEntity get(){


        // Fetch JSON response as String wrapped in ResponseEntity
        ResponseEntity<String> response
                = restTemplate.getForEntity(url+"get", String.class);
        //ResponseEntity<String> response1
         //       = restTemplate.exchange(resourceUrl, HttpMethod.GET,)
        String productsJson = response.getBody();

        System.out.println("result: "+" "+productsJson);
        return response;
    }
    @PostMapping("/post")
    public void postData(@Valid @RequestBody StudentModel student) {
        ResponseEntity<String> response
                = restTemplate.postForEntity(url+"post", student,String.class);

        System.out.println("result: "+" "+response);

    }
}
