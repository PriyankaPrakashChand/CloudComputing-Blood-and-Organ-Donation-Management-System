package com.bloodorganmanagementsystem.app.dto;

import java.util.Date;

import lombok.Data;

@Data
public class Profile {
    Integer age;
    char gender;
    Date dateOfBirth;
    Integer height;
    Integer weight;

}