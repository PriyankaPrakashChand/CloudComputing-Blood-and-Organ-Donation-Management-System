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
	@OneToMany(mappedBy="donationEntity")
	private List<CompletedDonationLog> completedDonationLogs;

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

	public List<CompletedDonationLog> getCompletedDonationLogs() {
		return this.completedDonationLogs;
	}

	public void setCompletedDonationLogs(List<CompletedDonationLog> completedDonationLogs) {
		this.completedDonationLogs = completedDonationLogs;
	}

	public CompletedDonationLog addCompletedDonationLog(CompletedDonationLog completedDonationLog) {
		getCompletedDonationLogs().add(completedDonationLog);
		completedDonationLog.setDonationEntity(this);

		return completedDonationLog;
	}

	public CompletedDonationLog removeCompletedDonationLog(CompletedDonationLog completedDonationLog) {
		getCompletedDonationLogs().remove(completedDonationLog);
		completedDonationLog.setDonationEntity(null);

		return completedDonationLog;
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