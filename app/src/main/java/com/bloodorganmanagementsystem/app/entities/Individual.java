package com.bloodorganmanagementsystem.app.entities;

import com.microsoft.azure.spring.data.cosmosdb.core.mapping.Document;
import com.microsoft.azure.spring.data.cosmosdb.core.mapping.PartitionKey;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

enum DonationPreference {
	BLOOD,BONE_MARROW,EYES,HEART,KIDNEY,LIVER
}

@Document(collection = "INDIVIDUAL_COLLECTION")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Individual  {
	
	@Id  // for registeration
	private String id;
	private String appliedLicenseKey;
	private MemberDetail memeberDetails;
	private Date birthday;
	private String firstName;
	private String lastName;
	// Profile-to add/modivy and view
	@PartitionKey
	private Character gender;
	private Integer heightCm;
	private Integer weightKg;
	private Blood bloodDetails;
	private List<Test> testDetails;  
	private List<DonationPreference> donationPreference;

	// Details to be filed while Entity has been donated
	private List<DonationEntityDetails>donationEntityDetails;
	
}