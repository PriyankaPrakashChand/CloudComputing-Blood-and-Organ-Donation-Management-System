package com.bloodorganmanagementsystem.app.service;

import java.util.List;
import java.util.Optional;

import com.bloodorganmanagementsystem.app.dto.Donations;
import com.bloodorganmanagementsystem.app.dto.IndividualDetails;
import com.bloodorganmanagementsystem.app.dto.Profile;
import com.bloodorganmanagementsystem.app.entities.Individual;
import com.bloodorganmanagementsystem.app.entities.Test;

import org.springframework.stereotype.Service;

@Service
public interface IndividualService {

    public Optional<Individual> findById(String findId);

    public Optional<Test> addTest(Integer testId, Integer TestValue);

    public boolean Register(IndividualDetails details);

    public boolean ModifyProfile(String individualId, Profile profile);

    public boolean Donate(String individualId, String licenseKey);

    public boolean AcceptDonationRequest(String individualId, Integer donationEntityId);

    public  List<Donations> viewDonations(String individualId);

    public Profile viewProfile(String individualId);

}