package com.bloodorganmanagementsystem.app.dto;

import com.bloodorganmanagementsystem.app.entities.Blood;
import com.bloodorganmanagementsystem.app.entities.Tests;
import com.bloodorganmanagementsystem.app.entities.Individual.DonationPreference;
import com.bloodorganmanagementsystem.app.entities.Individual.Gender;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class IndividualProfileToShow {
   
	Gender gender;
    Date dateOfBirth, DateOfLastUpdate;
    Integer height;
    Integer weight;
    Blood blood;
    List<DonationPreference> donationPreferences;
    List<Tests>tests;
    
	
    
}