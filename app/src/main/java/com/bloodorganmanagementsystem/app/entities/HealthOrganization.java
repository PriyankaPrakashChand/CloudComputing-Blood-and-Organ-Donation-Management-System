package com.bloodorganmanagementsystem.app.entities;

import java.util.List;

import com.bloodorganmanagementsystem.app.entities.enums.EntityPreference;
import com.bloodorganmanagementsystem.app.entities.enums.OrganizationInterest;
import com.microsoft.azure.spring.data.cosmosdb.core.mapping.Document;
import com.microsoft.azure.spring.data.cosmosdb.core.mapping.PartitionKey;

import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "HEALTH_ORGANIZATION_COLLECTION")
@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class HealthOrganization {

	@Id // registeration
	private String id;
	@PartitionKey
	private String lisenceKey;
	private String orgName;
	private MemberDetail memberDetails;
	private OrganizationInterest organizationInterest;
	// expansion activities
	private List<String> requestedPartnerIds; // ids to whom partner request is sent
	private List<String> partnerOrganzationIds; // accepted requests
	private List<String> receivedPartnerRequestIds;// requests received waiting for acceptance

	// profile Related
	private List<Blood> bloods;
	private List<EntityPreference> entityPreferences;
	// Details to be filed while Entity has been donated
	private List<DonationEntityDetails> donationEntityDetails;
	// details to be filed while and entity has been received
	private List<ReceivedEntityDetails> ReceivedEntityDetails;

}