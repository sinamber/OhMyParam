package com.mljr.demo.bean;

public class Master extends BaseEntity {
	private String name;
	private Integer gender;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

}
