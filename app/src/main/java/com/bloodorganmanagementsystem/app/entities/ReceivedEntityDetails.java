package com.bloodorganmanagementsystem.app.entities;

import java.util.Date;
import java.util.List;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReceivedEntityDetails {
	public enum rState {
		WAITING_TO_BE_RECEIVED, HAS_BEEN_RECEIVED
	}
	public enum ReceiverType {
		INDIVIDUAL, ORGANIZATION
	}
	public enum EntityName { // or type 
		BLOOD,BONE_MARROW,EYES,HEART,KIDNEY,LIVER
	}
	private EntityName entityName;
	private String DonorId;
	private rState stateOfEntity;
	private Date dateOfReceivingDonation;
	private ReceiverType DonorType; // whether it is an organization or an individual
}