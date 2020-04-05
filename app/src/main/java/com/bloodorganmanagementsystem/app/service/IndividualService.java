package com.bloodorganmanagementsystem.app.service;

import java.util.Optional;

import com.bloodorganmanagementsystem.app.entities.Individual;

import org.springframework.stereotype.Service;

@Service
public interface IndividualService {

    public Optional<Individual> findById(String findId);

}