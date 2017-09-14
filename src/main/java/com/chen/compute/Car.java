package com.chen.compute;

import java.util.List;
import java.util.Map;

import com.chen.entity.UserEntity;

public class Car {

	private String name;

	private int size;

	private List<String> names;
	private Map<String, Integer> owners;

	private UserEntity userEntity;

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public List<String> getNames() {
		return names;
	}

	public void setNames(List<String> names) {
		this.names = names;
	}

	public Map<String, Integer> getOwners() {
		return owners;
	}

	public void setOwners(Map<String, Integer> owners) {
		this.owners = owners;
	}

}
