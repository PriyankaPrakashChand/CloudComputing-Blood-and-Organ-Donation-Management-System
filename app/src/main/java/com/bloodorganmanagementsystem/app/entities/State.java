package com.bloodorganmanagementsystem.app.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "STATE" database table.
 * 
 */
@Entity
@Table(name="STATE")
public class State implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="STATE_ID")
	private long stateId;

	private String name;

	public State() {
	}

	public long getStateId() {
		return this.stateId;
	}

	public void setStateId(long stateId) {
		this.stateId = stateId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}