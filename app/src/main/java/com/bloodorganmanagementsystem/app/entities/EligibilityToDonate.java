package com.bloodorganmanagementsystem.app.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ELIGIBILITY_TO_DONATE database table.
 * 
 */
@Entity
@Table(name="ELIGIBILITY_TO_DONATE")
public class EligibilityToDonate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private Integer blood;

	@Column(name="BONE_MARROW")
	private Integer boneMarrow;

	private Integer eyes;

	private Integer heart;

	private Integer kidney;

	private Integer liver;

	//bi-directional many-to-one association to Test
	
	@JoinColumn(name="TEST_ID")
	private Test test;

	public EligibilityToDonate() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Integer getBlood() {
		return this.blood;
	}

	public void setBlood(Integer blood) {
		this.blood = blood;
	}

	public Integer getBoneMarrow() {
		return this.boneMarrow;
	}

	public void setBoneMarrow(Integer boneMarrow) {
		this.boneMarrow = boneMarrow;
	}

	public Integer getEyes() {
		return this.eyes;
	}

	public void setEyes(Integer eyes) {
		this.eyes = eyes;
	}

	public Integer getHeart() {
		return this.heart;
	}

	public void setHeart(Integer heart) {
		this.heart = heart;
	}

	public Integer getKidney() {
		return this.kidney;
	}

	public void setKidney(Integer kidney) {
		this.kidney = kidney;
	}

	public Integer getLiver() {
		return this.liver;
	}

	public void setLiver(Integer liver) {
		this.liver = liver;
	}

	public Test getTest() {
		return this.test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

}