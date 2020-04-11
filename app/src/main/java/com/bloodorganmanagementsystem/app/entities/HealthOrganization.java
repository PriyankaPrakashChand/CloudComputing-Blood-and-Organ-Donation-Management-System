package com.bloodorganmanagementsystem.app.entities;

import java.util.List;

import com.microsoft.azure.spring.data.cosmosdb.core.mapping.Document;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

enum OrganganizationInterest{
	RECEIVE,DONATE,BOTH
}
enum EntityPreference {
	BLOOD,BONE_MARROW,EYES,HEART,KIDNEY,LIVER
}
@Document(collection="HEALTH_ORGANIZATION_COLLECTION")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HealthOrganization  {
	

	@Id // registeration 
	private String id;
	private String lisenceKey;
	private String orgName;
	private MemberDetail memberDetails;
	private OrganganizationInterest organizationInterest;
	// expansion activities
	private List<String> requestedPartnerIds; // ids to whom partner request is sent
	private List<String> partnerOrganzationIds; // accepted requests
	private List<String> receivedPartnerRequestIds;// requests received waiting for acceptance
	
	//profile Related
	private List<Blood> bloods;
	private List<EntityPreference> entityPreferences;
// Details to be filed while Entity has been donated
private List<DonationEntityDetails>donationEntityDetails;
// details to be filed while and entity has been received
private List<ReceivedEntityDetails> ReceivedEntityDetails;

}