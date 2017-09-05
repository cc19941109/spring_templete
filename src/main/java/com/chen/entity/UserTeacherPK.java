package com.chen.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UserTeacherPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "user_id")
	private long userId;
	
	@Column(name = "teacher_id")
	private long teacherId;

	public UserTeacherPK() {

	}

	public UserTeacherPK(long user_id, long teacher_id) {
		super();
		this.userId = user_id;
		this.teacherId = teacher_id;
	}

	public long getUser_id() {
		return userId;
	}

	public void setUser_id(long user_id) {
		this.userId = user_id;
	}

	public long getTeacher_id() {
		return teacherId;
	}

	public void setTeacher_id(long teacher_id) {
		this.teacherId = teacher_id;
	}

	@Override
	public String toString() {
		return "UserTeacherPK [user_id=" + userId + ", teacher_id=" + teacherId + "]";
	}

}
