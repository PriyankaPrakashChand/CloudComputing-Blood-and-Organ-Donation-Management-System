package com.bloodorganmanagementsystem.app.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the BLOOD_TYPE database table.
 * 
 */
@Entity
@Table(name="BLOOD_TYPE")
public class BloodType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="BLOOD_TYPE_ID")
	private long bloodTypeId;

	@Column(name="BLOOD_TYPE_NAME")
	private String bloodTypeName;

	//bi-directional many-to-one association to Blood
	@OneToMany(mappedBy="bloodType")
	private List<Blood> bloods;

	public BloodType() {
	}

	public long getBloodTypeId() {
		return this.bloodTypeId;
	}

	public void setBloodTypeId(long bloodTypeId) {
		this.bloodTypeId = bloodTypeId;
	}

	public String getBloodTypeName() {
		return this.bloodTypeName;
	}

	public void setBloodTypeName(String bloodTypeName) {
		this.bloodTypeName = bloodTypeName;
	}

	public List<Blood> getBloods() {
		return this.bloods;
	}

	public void setBloods(List<Blood> bloods) {
		this.bloods = bloods;
	}

	public Blood addBlood(Blood blood) {
		getBloods().add(blood);
		blood.setBloodType(this);

		return blood;
	}

	public Blood removeBlood(Blood blood) {
		getBloods().remove(blood);
		blood.setBloodType(null);

		return blood;
	}

}