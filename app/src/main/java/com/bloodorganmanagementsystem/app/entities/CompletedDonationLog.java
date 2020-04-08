package com.bloodorganmanagementsystem.app.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the COMPLETED_DONATION_LOG database table.
 * 
 */
@Entity
@Table(name="COMPLETED_DONATION_LOG")
public class CompletedDonationLog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CD_ID")
	private long cdId;

	@Temporal(TemporalType.DATE)
	@Column(name="DONATION_DATE")
	private Date donationDate;

	//bi-directional many-to-one association to DonationEntity
	
	@JoinColumn(name="DONATION_ENTITY_ID")
	private DonationEntity donationEntity;

	//bi-directional many-to-one association to Member
	
	@JoinColumn(name="RECEPIENT_ID")
	private Member member;

	public CompletedDonationLog() {
	}

	public long getCdId() {
		return this.cdId;
	}

	public void setCdId(long cdId) {
		this.cdId = cdId;
	}

	public Date getDonationDate() {
		return this.donationDate;
	}

	public void setDonationDate(Date donationDate) {
		this.donationDate = donationDate;
	}

	public DonationEntity getDonationEntity() {
		return this.donationEntity;
	}

	public void setDonationEntity(DonationEntity donationEntity) {
		this.donationEntity = donationEntity;
	}

	public Member getMember() {
		return this.member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

}