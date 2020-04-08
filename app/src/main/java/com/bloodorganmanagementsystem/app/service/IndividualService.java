package com.bloodorganmanagementsystem.app.service;

import java.util.List;
import java.util.Optional;

import com.bloodorganmanagementsystem.app.dto.Donation;
import com.bloodorganmanagementsystem.app.dto.IndividualDetails;
import com.bloodorganmanagementsystem.app.dto.Profile;
import com.bloodorganmanagementsystem.app.entities.Individual;
import com.bloodorganmanagementsystem.app.entities.Test;

import org.springframework.stereotype.Service;

@Service
public interface IndividualService {

    public Optional<Individual> findById(String findId);

    public boolean addTest(String individualId, Integer testId, Integer testValue,String licenseKey) throws AppException;

    public boolean Register(IndividualDetails details) throws AppException;

    public boolean AddProfile(String individualId, Profile profile,String licenseKey) throws AppException;

    public boolean Donate(long donationEntityTypeId, String individualId, String licenceKey) throws AppException;

    public List<Donation> viewDonations(String individualId) throws AppException;

    public Profile viewProfile(String individualId) throws AppException;

}