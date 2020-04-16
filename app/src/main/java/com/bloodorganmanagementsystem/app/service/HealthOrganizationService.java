package com.bloodorganmanagementsystem.app.service;
import java.util.List;
import java.util.Optional;

import com.bloodorganmanagementsystem.app.dto.Donation;
import com.bloodorganmanagementsystem.app.dto.IndividualDetails;
import com.bloodorganmanagementsystem.app.dto.Profile;
import com.bloodorganmanagementsystem.app.entities.Individual;
import com.bloodorganmanagementsystem.app.entities.Tests;

import org.springframework.stereotype.Service;

@Service
public interface HealthOrganizationService {
 
 
    public Optional<HealthOrganization> findById(String findId); 

    public boolean Register(HealthOrganization healthOrganization) throws AppException;

    public boolean Login(String email, String password)throws AppException;

    public List<DonationEntityDetails> viewDonationsEntities() ; // display name of donations type 

    public List<Individual> viewAllDonorbyTypr( String donation_type );

    public List<Individual> viewAllDonor( ); // diplay donations


    //register --
    //login--
    // view List of Donors by entity --
    // view all donors created--
    // view all enities donated-- 
    // view all entites received as donation--
    
}