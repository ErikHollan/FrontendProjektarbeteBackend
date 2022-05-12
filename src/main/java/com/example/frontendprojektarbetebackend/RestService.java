package com.example.frontendprojektarbetebackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RestService {


    private final RestTemplate restTemplate;

    public RestService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public String getPostsPlainJSON() {
        String url = "http://localhost:8080/items/all";
        return this.restTemplate.getForObject(url, String.class);
    }

    public Post[] getPostsAsObject() {
        String url = "http://localhost:8080/items/all";
        return this.restTemplate.getForObject(url, Post[].class);
    }

    @RequestMapping("/hej")
    public String getall() {
        return getPostsPlainJSON();
    }

}

