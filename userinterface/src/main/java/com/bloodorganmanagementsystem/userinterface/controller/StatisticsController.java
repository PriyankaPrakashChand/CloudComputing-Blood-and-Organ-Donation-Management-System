package com.bloodorganmanagementsystem.userinterface.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bloodorganmanagementsystem.userinterface.models.EntityStatistic;
@RestController
@RequestMapping("/Stats")
public class StatisticsController {
	
	@Autowired
   RestTemplate restTemplate;

//	@RequestMapping("/{entityName}")
//    public Integer getTotalDonationCount(@PathVariable String entityName){
//        return 50;
//    }
	
    
	@RequestMapping("{entityName}")
    public EntityStatistic viewEntityStats(@PathVariable String entityName){
		String ContainerName = "http://localhost:8081/Stats/Entity/foo";
		return restTemplate.getForObject(ContainerName, EntityStatistic.class);
      }
	
}
