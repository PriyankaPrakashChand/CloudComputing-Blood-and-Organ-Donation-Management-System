package com.bloodorganmanagementsystem.app.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ACTIVITYID database table.
 * 
 */
@Entity
public class Activityid implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ACTIVITY_ID")
	private long activityId;

	private String name;

	//bi-directional many-to-one association to Member
	@OneToMany(mappedBy="activityid")
	private List<Member> members;

	public Activityid() {
	}

	public long getActivityId() {
		return this.activityId;
	}

	public void setActivityId(long activityId) {
		this.activityId = activityId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Member> getMembers() {
		return this.members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}

	public Member addMember(Member member) {
		getMembers().add(member);
		member.setActivityid(this);

		return member;
	}

	public Member removeMember(Member member) {
		getMembers().remove(member);
		member.setActivityid(null);

		return member;
	}

}