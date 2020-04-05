package com.bloodorganmanagementsystem.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Stats")
public class TestController {

	@RequestMapping()
    public Integer getTotalDonationCount( String entityName){
        return 50;
    }
}
