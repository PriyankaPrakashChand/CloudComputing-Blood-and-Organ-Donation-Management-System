package com.bloodorganmanagementsystem.app.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import com.bloodorganmanagementsystem.app.dto.Donation;
import com.bloodorganmanagementsystem.app.dto.IndividualDetails;
import com.bloodorganmanagementsystem.app.dto.Profile;
import com.bloodorganmanagementsystem.app.entities.DonationEntityDetails;
import com.bloodorganmanagementsystem.app.entities.HealthOrganization;
import com.bloodorganmanagementsystem.app.entities.Individual;
import com.bloodorganmanagementsystem.app.repository.HealthOrganizationRepository;
import com.bloodorganmanagementsystem.app.repository.IndividualRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

@Service
@Data
public class HealthOrganizationServiceImplementation implements HealthOrganizationService {

    IndividualRepository indRepos;
    HealthOrganizationRepository orgRepos;

    /**
     * Public Constructor
     * 
     * @param indRepos
     * @param orgRepos
     */
    @Autowired
    public HealthOrganizationServiceImplementation(IndividualRepository indRepos,
            HealthOrganizationRepository orgRepos) {
        this.indRepos = indRepos;
        this.orgRepos = orgRepos;
    }

    @Override
    public Optional<HealthOrganization> findById(String findId) {
        // TODO Auto-generated method stub
        //  check if this is correct
        Optional<HealthOrganization> dbHealthOrganization = orgRepos.findById(findId);
        
        
        return dbHealthOrganization;
        
    }

    @Override
    public boolean Register(HealthOrganization healthOrganization) throws AppException {
        // TODO Auto-generated method stub

        // 1-check if email is unique
        List<HealthOrganization> dbHealthOrganizationList = orgRepos.findByEmail(healthOrganization.getEmail());
                
        if (!dbHealthOrganizationList.isEmpty()) {
            throw new AppException("Email Id Already Exists");
        }
        // 2- check name , password , city , country is not empty

        int minimumHeight = 25;
        int minimumWeight = 45;
        int minimumPasswordLength = 8;

        if (healthOrganization.getOrgName().isBlank() || healthOrganization.getMemberDetails().getAddress().isBlank()
                || healthOrganization.getMemberDetails().getCity().isBlank()
                || healthOrganization.getMemberDetails().getCity().isBlank()
                || healthOrganization.getMemberDetails().getPhoneNumber().isBlank()
                || healthOrganization.getMemberDetails().getPassword().length() < minimumPasswordLength) {
            throw new AppException("No fields must be Left Incomplete");
        }

        // 3- save individual to repository
        try {
            healthOrganization  = orgRepos.save(healthOrganization);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
        
    }

    @Override
    public boolean Login(String email, String password) throws AppException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<DonationEntityDetails> viewDonationsEntities() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Individual> viewAllDonorbyTypr(String donation_type) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Individual> viewAllDonor() {
        // TODO Auto-generated method stub
        return null;
    }


 

  
}
