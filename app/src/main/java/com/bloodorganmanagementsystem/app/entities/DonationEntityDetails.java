package com.bloodorganmanagementsystem.app.entities;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
// @Entity
public class DonationEntityDetails {
	public enum EntityName { // or type
		BLOOD, BONE_MARROW, EYES, HEART, KIDNEY, LIVER
	}

	public enum dState {
		AVAILABLE_TO_DONATE, HAS_BEEN_DONATED
	}

	public enum ReceiverType {
		INDIVIDUAL, ORGANIZATION
	}
	private EntityName entityName;
	private dState state;
	private String receiverId; // HealthOrganization ID always- only organizations can receive
	private Date dateOfDonation;
	private ReceiverType receiverType; // whether it is an organization or an individual

}