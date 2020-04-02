package com.bloodorganmanagementsystem.app.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the MEMBER database table.
 * 
 */
@Entity
public class Member implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MEMBER_ID")
	private String memberId;

	private String address;

	private String city;

	private String country;

	private String email;

	@Column(name="MEMBER_TYPE")
	private Character memberType;

	private String password;

	@Column(name="PHONE_NUMBER")
	private String phoneNumber;

	//bi-directional many-to-one association to Blood
	@OneToMany(mappedBy="member")
	private List<Blood> bloods;

	//bi-directional many-to-one association to CompletedDonationLog
	@OneToMany(mappedBy="member")
	private List<CompletedDonationLog> completedDonationLogs;

	//bi-directional many-to-one association to DonationEntity
	@OneToMany(mappedBy="member")
	private List<DonationEntity> donationEntities;

	//bi-directional one-to-one association to HealthOrganization
	@OneToOne(mappedBy="member")
	private HealthOrganization healthOrganization;

	//bi-directional one-to-one association to Individual
	@OneToOne(mappedBy="member")
	private Individual individual;

	//bi-directional many-to-one association to Activityid
	@ManyToOne
	@JoinColumn(name="ACTIVITY_ID")
	private Activityid activityid;

	//bi-directional many-to-one association to Test
	@OneToMany(mappedBy="member")
	private List<Test> tests;

	public Member() {
	}

	public String getMemberId() {
		return this.memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Character getMemberType() {
		return this.memberType;
	}

	public void setMemberType(Character memberType) {
		this.memberType = memberType;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<Blood> getBloods() {
		return this.bloods;
	}

	public void setBloods(List<Blood> bloods) {
		this.bloods = bloods;
	}

	public Blood addBlood(Blood blood) {
		getBloods().add(blood);
		blood.setMember(this);

		return blood;
	}

	public Blood removeBlood(Blood blood) {
		getBloods().remove(blood);
		blood.setMember(null);

		return blood;
	}

	public List<CompletedDonationLog> getCompletedDonationLogs() {
		return this.completedDonationLogs;
	}

	public void setCompletedDonationLogs(List<CompletedDonationLog> completedDonationLogs) {
		this.completedDonationLogs = completedDonationLogs;
	}

	public CompletedDonationLog addCompletedDonationLog(CompletedDonationLog completedDonationLog) {
		getCompletedDonationLogs().add(completedDonationLog);
		completedDonationLog.setMember(this);

		return completedDonationLog;
	}

	public CompletedDonationLog removeCompletedDonationLog(CompletedDonationLog completedDonationLog) {
		getCompletedDonationLogs().remove(completedDonationLog);
		completedDonationLog.setMember(null);

		return completedDonationLog;
	}

	public List<DonationEntity> getDonationEntities() {
		return this.donationEntities;
	}

	public void setDonationEntities(List<DonationEntity> donationEntities) {
		this.donationEntities = donationEntities;
	}

	public DonationEntity addDonationEntity(DonationEntity donationEntity) {
		getDonationEntities().add(donationEntity);
		donationEntity.setMember(this);

		return donationEntity;
	}

	public DonationEntity removeDonationEntity(DonationEntity donationEntity) {
		getDonationEntities().remove(donationEntity);
		donationEntity.setMember(null);

		return donationEntity;
	}

	public HealthOrganization getHealthOrganization() {
		return this.healthOrganization;
	}

	public void setHealthOrganization(HealthOrganization healthOrganization) {
		this.healthOrganization = healthOrganization;
	}

	public Individual getIndividual() {
		return this.individual;
	}

	public void setIndividual(Individual individual) {
		this.individual = individual;
	}

	public Activityid getActivityid() {
		return this.activityid;
	}

	public void setActivityid(Activityid activityid) {
		this.activityid = activityid;
	}

	public List<Test> getTests() {
		return this.tests;
	}

	public void setTests(List<Test> tests) {
		this.tests = tests;
	}

	public Test addTest(Test test) {
		getTests().add(test);
		test.setMember(this);

		return test;
	}

	public Test removeTest(Test test) {
		getTests().remove(test);
		test.setMember(null);

		return test;
	}

}