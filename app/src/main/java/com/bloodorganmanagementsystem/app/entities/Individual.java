package com.bloodorganmanagementsystem.app.entities;

import com.bloodorganmanagementsystem.app.entities.Blood.BloodType;
import com.microsoft.azure.spring.data.cosmosdb.core.mapping.Document;
import com.microsoft.azure.spring.data.cosmosdb.core.mapping.PartitionKey;

import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Generated;

@Document(collection = "INDIVIDUAL_COLLECTION")
@Data
@Component
public class Individual {
	public enum DonationPreference {
		NULL,BLOOD, BONE_MARROW, EYES, HEART, KIDNEY, LIVER
	}
	public enum Gender{
		NULL, MALE, FEMALE
	}

	// public enum BloodType {
	// NULL, A_POSITIVE, A_NEGATIVE, B_NEGATIVE, B_POSITIVE, O_POSITIVE, O_NEGATIVE,
	// AB_POSITIVE, AB_NEGATIVE
	// }

	@Id  
	String id;
	@PartitionKey
	private String email; // unique
	private String password;
	private String appliedLicenseKey;
	private MemberDetail memeberDetails;
	private Date birthday;
	private String firstName;
	private String lastName;
	private Gender gender;
	private Integer heightCm;
	private Integer weightKg;
	private Blood bloodDetails;
	private List<Tests> testDetails;
	private List<DonationPreference> donationPreference;

	// Details to be filed while Entity has been donated
	private List<DonationEntityDetails> donationEntityDetails;

	/**
	 * NoArgsConstructor
	 */
	public Individual() {
		this.id=UUID.randomUUID().toString();
		this.password=new String(""); //F:should I keep it like this?
		this.email=UUID.randomUUID().toString();
		this.memeberDetails = new MemberDetail("", "", "", "", "");
		this.bloodDetails = new Blood(BloodType.NULL);
		this.appliedLicenseKey = this.lastName = this.firstName = "";
		this.birthday = new Date(0);
		List<DonationPreference> dP = new ArrayList<DonationPreference>();
		dP.add(DonationPreference.NULL);
		this.donationPreference=dP;
		this.gender=Gender.NULL;
		this.heightCm=-1;
		this.weightKg=-1;
		List<Tests> testList = new ArrayList<Tests>();
		this.testDetails=testList;
		DonationEntityDetails dE = new DonationEntityDetails();
		List<DonationEntityDetails> dEs = new ArrayList<DonationEntityDetails>();
		this.donationEntityDetails=dEs;
	}
	
	public void addTest(Tests test) {
		testDetails.add(test);
	}
	public void removeTest(Tests test) {
		testDetails.remove(test);
	}

}