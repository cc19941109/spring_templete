package com.chen.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "teacher_user")
public class TerUserLinkEntity {
	
	@EmbeddedId
	private UserTeacherPK pk;
	
	private String info;

	public UserTeacherPK getPk() {
		return pk;
	}

	public void setPk(UserTeacherPK pk) {
		this.pk = pk;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	
	
	
	
}
