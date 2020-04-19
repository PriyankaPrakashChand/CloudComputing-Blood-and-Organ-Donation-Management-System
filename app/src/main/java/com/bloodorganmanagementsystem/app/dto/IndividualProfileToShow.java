package com.bloodorganmanagementsystem.app.dto;

import com.bloodorganmanagementsystem.app.entities.Blood;
import com.bloodorganmanagementsystem.app.entities.Tests;
import com.bloodorganmanagementsystem.app.entities.Individual.DonationPreference;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Profile {
   
    char gender;
    Date dateOfBirth;
    Integer height;
    Integer weight;
    Blood blood;
    List<DonationPreference> donationPreferences;
    List<Tests>tests;
    
    
	
    
}