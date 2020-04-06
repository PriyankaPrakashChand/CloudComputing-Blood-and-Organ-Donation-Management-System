package com.bloodorganmanagementsystem.app.dto;

import java.util.Date;

import lombok.Data;

@Data
public class Profile {
   
    char gender;
    Date dateOfBirth;
    Integer height;
    Integer weight;
    Integer bloodType;
    Integer BloodUnits;
    
}