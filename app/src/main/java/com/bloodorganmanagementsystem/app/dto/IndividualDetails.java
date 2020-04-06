package com.bloodorganmanagementsystem.app.dto;

import lombok.Data;

@Data
public class IndividualDetails extends MemberDetails {
String firstName;
String lastName;
String licenceKey;
String bloodType;

}