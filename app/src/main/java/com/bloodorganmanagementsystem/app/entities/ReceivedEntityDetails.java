package com.bloodorganmanagementsystem.app.entities;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

enum rState {
	WAITING_TO_BE_RECEIVED, HAS_BEEN_RECEIVED
}

enum DonorType {
	INDIVIDUAL, ORGANIZATION
}

@Data
@AllArgsConstructor
@NoArgsConstructor
public class  ReceivedEntityDetails  {

	private EntityName entityName;
    private String DonorId;
    private rState stateOfEntity;
	private Date dateOfReceivingDonation;
	private ReceiverType DonorType; // whether it is an organization or an individual
}