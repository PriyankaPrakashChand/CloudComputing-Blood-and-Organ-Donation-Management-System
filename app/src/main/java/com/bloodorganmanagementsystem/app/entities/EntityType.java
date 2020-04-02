package com.bloodorganmanagementsystem.app.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ENTITY_TYPE database table.
 * 
 */
@Entity
@Table(name="ENTITY_TYPE")
public class EntityType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ENTITY_TYPE_ID")
	private long entityTypeId;

	@Column(name="ENTITY_TYPE_NAME")
	private String entityTypeName;

	//bi-directional many-to-one association to DonationEntity
	@OneToMany(mappedBy="entityType")
	private List<DonationEntity> donationEntities;

	public EntityType() {
	}

	public long getEntityTypeId() {
		return this.entityTypeId;
	}

	public void setEntityTypeId(long entityTypeId) {
		this.entityTypeId = entityTypeId;
	}

	public String getEntityTypeName() {
		return this.entityTypeName;
	}

	public void setEntityTypeName(String entityTypeName) {
		this.entityTypeName = entityTypeName;
	}

	public List<DonationEntity> getDonationEntities() {
		return this.donationEntities;
	}

	public void setDonationEntities(List<DonationEntity> donationEntities) {
		this.donationEntities = donationEntities;
	}

	public DonationEntity addDonationEntity(DonationEntity donationEntity) {
		getDonationEntities().add(donationEntity);
		donationEntity.setEntityType(this);

		return donationEntity;
	}

	public DonationEntity removeDonationEntity(DonationEntity donationEntity) {
		getDonationEntities().remove(donationEntity);
		donationEntity.setEntityType(null);

		return donationEntity;
	}

}