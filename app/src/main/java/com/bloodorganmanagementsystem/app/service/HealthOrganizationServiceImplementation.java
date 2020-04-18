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

---

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
    public HealthOrganizationServiceImplementation(IndividualRepository indRepos, HealthOrganizationRepository orgRepos) {
        this.indRepos = indRepos;
        this.orgRepos = orgRepos;
    }

    @Override
    public Optional<HealthOrganization> findById(String findId) {
        // check if this is correct 
        final Optional<UsHealthOrganizationer> result = HealthOrganizationRepository.findById(findId).blockOptional();
        Assert.isTrue(result.isPresent(), "Cannot find "); // assert check if not find and throw an error  


        return result;
    }

    @Override
    public boolean Register(HealthOrganization healthOrganization throws AppException {
       // 1-check if email is unique
       List<HealthOrganization> dbHealthOrganizationList=HealthOrganizationRepository.findByEmail(HealthOrganization.getEmail());
       if(!dbHealthOrganizationList.isEmpty()){
           throw new AppException("Email Id Already Exists");
       }
    // 2- check name , password , city , country  is not empty 

       int minimumHeight=25;
       int minimumWeight=45;
       int minimumPasswordLength=8;
    
       if(HealthOrganization.getorgNmae().isBlank() || HealthOrganization.getMemeberDetails().getAddress().isBlank() ||HealthOrganization.getMemeberDetails().getCity().isBlank()|| HealthOrganization.getMemeberDetails().getCity().isBlank()||
       HealthOrganization.getMemeberDetails().getPhoneNumber().isBlank()|| HealthOrganization.getMemeberDetails().getPassword().length()<minimumPasswordLength){
        throw new AppException("No fields must be Left Incomplete");
       }
       
       //3- save individual to repository
      try{ 
        HealthOrganization  ho= HealthOrganizationRepository.save(HealthOrganization);
        }
      catch(Exception e){
        System.out.println(e.getMessage());
      }
        return true;
    }

    @Override
    public boolean Login(String email, String password) throws AppException {

        // we need check if it is valid
        return false;
    }

    public List<Individual> viewAllDonor( )
    {
            // return list of all individual if they donate

            return null;
    } 

    public List<Individual> viewAllDonorbyTypr( String donation_type )
    {

        return null;
    }
    
