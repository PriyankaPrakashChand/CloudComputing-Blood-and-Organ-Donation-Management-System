package com.bloodorganmanagementsystem.app.controller;

import com.bloodorganmanagementsystem.app.entities.Individual;
import com.bloodorganmanagementsystem.app.service.IndividualService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/Individual")
public class IndividualController {
	
	private final IndividualService individualService;

	public IndividualController(IndividualService individualService){
		this.individualService = individualService;
	}
	
	@RequestMapping()
	public String getIndividual(String individualId) {
		Individual individual = individualService.findById("I0001").get();
	
		return individual.getFirstName();
	}
	
	
}
