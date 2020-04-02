package com.bloodorganmanagementsystem.app.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TEST database table.
 * 
 */
@Entity
public class Test implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TEST_ID")
	private long testId;

	private Integer antibody;

	private Integer blood;

	private Integer bonemarrow;

	private Integer cancer;

	private Integer chest;

	private Integer colonscopy;

	private Integer country;

	private Integer crossmatch;

	private Integer ct;

	private Integer doppler;

	private Integer echocardiogram;

	private Integer ekg;

	private Integer electrocardiogram;

	private Integer gyencological;

	private Integer hepatitisb;

	private Integer hepatitisc;

	private Integer hiv;

	private Integer hla;

	private Integer htiv;

	private Integer pet;

	private Integer physical;

	private Integer pulmonary;

	private Integer syphilis;

	private Integer urine;

	//bi-directional many-to-one association to EligibilityToDonate
	@OneToMany(mappedBy="test")
	private List<EligibilityToDonate> eligibilityToDonates;

	//bi-directional many-to-one association to Member
	@ManyToOne
	@JoinColumn(name="MEMBER_ID")
	private Member member;

	public Test() {
	}

	public long getTestId() {
		return this.testId;
	}

	public void setTestId(long testId) {
		this.testId = testId;
	}

	public Integer getAntibody() {
		return this.antibody;
	}

	public void setAntibody(Integer antibody) {
		this.antibody = antibody;
	}

	public Integer getBlood() {
		return this.blood;
	}

	public void setBlood(Integer blood) {
		this.blood = blood;
	}

	public Integer getBonemarrow() {
		return this.bonemarrow;
	}

	public void setBonemarrow(Integer bonemarrow) {
		this.bonemarrow = bonemarrow;
	}

	public Integer getCancer() {
		return this.cancer;
	}

	public void setCancer(Integer cancer) {
		this.cancer = cancer;
	}

	public Integer getChest() {
		return this.chest;
	}

	public void setChest(Integer chest) {
		this.chest = chest;
	}

	public Integer getColonscopy() {
		return this.colonscopy;
	}

	public void setColonscopy(Integer colonscopy) {
		this.colonscopy = colonscopy;
	}

	public Integer getCountry() {
		return this.country;
	}

	public void setCountry(Integer country) {
		this.country = country;
	}

	public Integer getCrossmatch() {
		return this.crossmatch;
	}

	public void setCrossmatch(Integer crossmatch) {
		this.crossmatch = crossmatch;
	}

	public Integer getCt() {
		return this.ct;
	}

	public void setCt(Integer ct) {
		this.ct = ct;
	}

	public Integer getDoppler() {
		return this.doppler;
	}

	public void setDoppler(Integer doppler) {
		this.doppler = doppler;
	}

	public Integer getEchocardiogram() {
		return this.echocardiogram;
	}

	public void setEchocardiogram(Integer echocardiogram) {
		this.echocardiogram = echocardiogram;
	}

	public Integer getEkg() {
		return this.ekg;
	}

	public void setEkg(Integer ekg) {
		this.ekg = ekg;
	}

	public Integer getElectrocardiogram() {
		return this.electrocardiogram;
	}

	public void setElectrocardiogram(Integer electrocardiogram) {
		this.electrocardiogram = electrocardiogram;
	}

	public Integer getGyencological() {
		return this.gyencological;
	}

	public void setGyencological(Integer gyencological) {
		this.gyencological = gyencological;
	}

	public Integer getHepatitisb() {
		return this.hepatitisb;
	}

	public void setHepatitisb(Integer hepatitisb) {
		this.hepatitisb = hepatitisb;
	}

	public Integer getHepatitisc() {
		return this.hepatitisc;
	}

	public void setHepatitisc(Integer hepatitisc) {
		this.hepatitisc = hepatitisc;
	}

	public Integer getHiv() {
		return this.hiv;
	}

	public void setHiv(Integer hiv) {
		this.hiv = hiv;
	}

	public Integer getHla() {
		return this.hla;
	}

	public void setHla(Integer hla) {
		this.hla = hla;
	}

	public Integer getHtiv() {
		return this.htiv;
	}

	public void setHtiv(Integer htiv) {
		this.htiv = htiv;
	}

	public Integer getPet() {
		return this.pet;
	}

	public void setPet(Integer pet) {
		this.pet = pet;
	}

	public Integer getPhysical() {
		return this.physical;
	}

	public void setPhysical(Integer physical) {
		this.physical = physical;
	}

	public Integer getPulmonary() {
		return this.pulmonary;
	}

	public void setPulmonary(Integer pulmonary) {
		this.pulmonary = pulmonary;
	}

	public Integer getSyphilis() {
		return this.syphilis;
	}

	public void setSyphilis(Integer syphilis) {
		this.syphilis = syphilis;
	}

	public Integer getUrine() {
		return this.urine;
	}

	public void setUrine(Integer urine) {
		this.urine = urine;
	}

	public List<EligibilityToDonate> getEligibilityToDonates() {
		return this.eligibilityToDonates;
	}

	public void setEligibilityToDonates(List<EligibilityToDonate> eligibilityToDonates) {
		this.eligibilityToDonates = eligibilityToDonates;
	}

	public EligibilityToDonate addEligibilityToDonate(EligibilityToDonate eligibilityToDonate) {
		getEligibilityToDonates().add(eligibilityToDonate);
		eligibilityToDonate.setTest(this);

		return eligibilityToDonate;
	}

	public EligibilityToDonate removeEligibilityToDonate(EligibilityToDonate eligibilityToDonate) {
		getEligibilityToDonates().remove(eligibilityToDonate);
		eligibilityToDonate.setTest(null);

		return eligibilityToDonate;
	}

	public Member getMember() {
		return this.member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

}