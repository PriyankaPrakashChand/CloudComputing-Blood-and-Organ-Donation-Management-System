package com.bloodorganmanagementsystem.app.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the INDIVIDUAL database table.
 * 
 */
@Entity
public class Individual implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="INDIVIDUAL_ID")
	private String individualId;

	@Column(name="APPLIED_LICENSE_KEY")
	private String appliedLicenseKey;

	@Temporal(TemporalType.DATE)
	private Date birthday;

	@Column(name="FIRST_NAME")
	private String firstName;

	private Character gender;

	@Column(name="HEIGHT_CM")
	private Integer heightCm;

	@Column(name="LAST_NAME")
	private String lastName;

	@Column(name="WEIGHT_KG")
	private Integer weightKg;

	//bi-directional one-to-one association to Member
	@OneToOne
	@JoinColumn(name="INDIVIDUAL_ID")
	private Member member;

	public Individual() {
	}

	public String getIndividualId() {
		return this.individualId;
	}

	public void setIndividualId(String individualId) {
		this.individualId = individualId;
	}

	public String getAppliedLicenseKey() {
		return this.appliedLicenseKey;
	}

	public void setAppliedLicenseKey(String appliedLicenseKey) {
		this.appliedLicenseKey = appliedLicenseKey;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Character getGender() {
		return this.gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}

	public Integer getHeightCm() {
		return this.heightCm;
	}

	public void setHeightCm(Integer heightCm) {
		this.heightCm = heightCm;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getWeightKg() {
		return this.weightKg;
	}

	public void setWeightKg(Integer weightKg) {
		this.weightKg = weightKg;
	}

	public Member getMember() {
		return this.member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

}