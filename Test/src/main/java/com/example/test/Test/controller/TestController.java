package com.example.test.Test.controller;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @ApiResponse(description = "this api is testing api")
    @GetMapping
    public String getTest(){
        return "Test Successfull...";
    }

}
