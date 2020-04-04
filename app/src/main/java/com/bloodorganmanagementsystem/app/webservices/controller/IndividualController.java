package com.bloodorganmanagementsystem.app.webservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bloodorganmanagementsystem.app.entities.Individual;
import com.bloodorganmanagementsystem.app.repositories.IndividualRepository;


@RestController
@RequestMapping("/Individual")
public class IndividualController {
	
	@Autowired
	IndividualRepository individualRepository;
	
	@RequestMapping()
	public String getIndividual(String individualId) {
		Individual individual=individualRepository.findById("I0001").get();
	
		return individual.getFirstName();
	}
	
	
}
