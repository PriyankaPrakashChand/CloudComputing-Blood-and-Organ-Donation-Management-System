package com.bloodorganmanagementsystem.app.service;

import java.util.Optional;

import com.bloodorganmanagementsystem.app.entities.Individual;
import com.bloodorganmanagementsystem.app.repository.IndividualRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndividualServiceImplementation implements IndividualService {

    IndividualRepository individualRepository;

    @Autowired
    public IndividualServiceImplementation(IndividualRepository individualRepository) {
        this.individualRepository = individualRepository;
    }

    public Optional<Individual> findById(String findId) {
        return individualRepository.findById(findId);
    }

}