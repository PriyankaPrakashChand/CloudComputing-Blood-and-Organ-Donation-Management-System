package com.bloodorganmanagementsystem.app.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DONATION_ENTITY database table.
 * 
 */
@Entity
@Table(name="DONATION_ENTITY")
public class DonationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="DONATION_ENTITY_ID")
	private long donationEntityId;
	
	@Column(name="STATE_ID")
	private java.math.BigDecimal stateId;

	//bi-directional many-to-one association to CompletedDonationLog
	
	private CompletedDonationLog completedDonationLog;

	//bi-directional many-to-one association to EntityType
	@ManyToOne
	@JoinColumn(name="ENTITY_TYPE_ID")
	private EntityType entityType;

	//bi-directional many-to-one association to Member
	@ManyToOne
	@JoinColumn(name="MEMBER_ID")
	private Member member;

	public DonationEntity() {
	}

	public long getDonationEntityId() {
		return this.donationEntityId;
	}

	public void setDonationEntityId(long donationEntityId) {
		this.donationEntityId = donationEntityId;
	}

	public java.math.BigDecimal getStateId() {
		return this.stateId;
	}

	public void setStateId(java.math.BigDecimal stateId) {
		this.stateId = stateId;
	}

	public CompletedDonationLog getCompletedDonationLog() {
		return this.completedDonationLog;
	}

	public void setCompletedDonationLog(CompletedDonationLog completedDonationLog) {
		this.completedDonationLog = completedDonationLog;
	}

	

	public EntityType getEntityType() {
		return this.entityType;
	}

	public void setEntityType(EntityType entityType) {
		this.entityType = entityType;
	}

	public Member getMember() {
		return this.member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

}