package com.bloodorganmanagementsystem.app.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the BLOOD database table.
 * 
 */
@Entity
public class Blood implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="BLOOD_ID")
	private long bloodId;

	@Column(name="BLOOD_UNITS")
	private BigDecimal bloodUnits;

	//bi-directional many-to-one association to BloodType
	@ManyToOne
	@JoinColumn(name="BLOOD_TYPE_ID")
	private BloodType bloodType;

	//bi-directional many-to-one association to Member
	@JoinColumn(name="MEMBER_ID", referencedColumnName="MEMBER_ID")
	private Member member;

	public Blood() {
	}

	public long getBloodId() {
		return this.bloodId;
	}

	public void setBloodId(long bloodId) {
		this.bloodId = bloodId;
	}

	public BigDecimal getBloodUnits() {
		return this.bloodUnits;
	}

	public void setBloodUnits(BigDecimal bloodUnits) {
		this.bloodUnits = bloodUnits;
	}

	public BloodType getBloodType() {
		return this.bloodType;
	}

	public void setBloodType(BloodType bloodType) {
		this.bloodType = bloodType;
	}

	public Member getMember() {
		return this.member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

}