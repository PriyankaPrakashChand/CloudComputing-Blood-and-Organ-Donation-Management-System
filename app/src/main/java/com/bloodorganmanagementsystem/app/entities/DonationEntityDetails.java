package com.bloodorganmanagementsystem.app.entities;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

enum dState {
	AVAILABLE_TO_DONATE, HAS_BEEN_DONATED
}

enum ReceiverType {
	INDIVIDUAL, ORGANIZATION
}
enum EntityName { // or type 
	BLOOD,BONE_MARROW,EYES,HEART,KIDNEY,LIVER
}

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DonationEntityDetails {

	private EntityName entityName;
	private dState state;
	private String receiverId; // HealthOrganization ID always- only organizations can receive
	private Date dateOfDonation;
	private ReceiverType receiverType; // whether it is an organization or an individual

}