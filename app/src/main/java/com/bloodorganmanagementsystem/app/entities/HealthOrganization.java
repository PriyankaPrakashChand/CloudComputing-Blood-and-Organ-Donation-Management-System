package com.bloodorganmanagementsystem.app.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the HEALTH_ORGANIZATION database table.
 * 
 */
@Entity
@Table(name="HEALTH_ORGANIZATION")
public class HealthOrganization implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="HEALTH_ORG_ID")
	private String healthOrgId;

	@Column(name="LISENCE_KEY")
	private String lisenceKey;

	@Column(name="ORG_NAME")
	private String orgName;

	//bi-directional one-to-one association to Member
	@OneToOne
	@JoinColumn(name="HEALTH_ORG_ID")
	private Member member;

	//bi-directional many-to-many association to HealthOrganization
	@ManyToMany
	@JoinTable(
		name="MAP_ORG_PARTNER"
		, joinColumns={
			@JoinColumn(name="HEALTH_ORG_ID1")
			}
		, inverseJoinColumns={
			@JoinColumn(name="HEALTH_ORG_ID2")
			}
		)
	private List<HealthOrganization> healthOrganizations1;

	//bi-directional many-to-many association to HealthOrganization
	@ManyToMany(mappedBy="healthOrganizations1")
	private List<HealthOrganization> healthOrganizations2;

	public HealthOrganization() {
	}

	public String getHealthOrgId() {
		return this.healthOrgId;
	}

	public void setHealthOrgId(String healthOrgId) {
		this.healthOrgId = healthOrgId;
	}

	public String getLisenceKey() {
		return this.lisenceKey;
	}

	public void setLisenceKey(String lisenceKey) {
		this.lisenceKey = lisenceKey;
	}

	public String getOrgName() {
		return this.orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public Member getMember() {
		return this.member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public List<HealthOrganization> getHealthOrganizations1() {
		return this.healthOrganizations1;
	}

	public void setHealthOrganizations1(List<HealthOrganization> healthOrganizations1) {
		this.healthOrganizations1 = healthOrganizations1;
	}

	public List<HealthOrganization> getHealthOrganizations2() {
		return this.healthOrganizations2;
	}

	public void setHealthOrganizations2(List<HealthOrganization> healthOrganizations2) {
		this.healthOrganizations2 = healthOrganizations2;
	}

}