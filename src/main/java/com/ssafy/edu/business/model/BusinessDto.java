package com.ssafy.edu.business.model;

public class BusinessDto {
	private int id;
	private String name;
	private String industryName;
	private String industrySpecificName;
	private int sidoCode;
	private int gunguCode;
	private int DongCode;
	private String address;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIndustryName() {
		return industryName;
	}

	public void setIndustryName(String industryName) {
		this.industryName = industryName;
	}

	public String getIndustrySpecificName() {
		return industrySpecificName;
	}

	public void setIndustrySpecificName(String industrySpecificName) {
		this.industrySpecificName = industrySpecificName;
	}

	public int getSidoCode() {
		return sidoCode;
	}

	public void setSidoCode(int sidoCode) {
		this.sidoCode = sidoCode;
	}

	public int getGunguCode() {
		return gunguCode;
	}

	public void setGunguCode(int gunguCode) {
		this.gunguCode = gunguCode;
	}

	public int getDongCode() {
		return DongCode;
	}

	public void setDongCode(int dongCode) {
		DongCode = dongCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "LocalBusinessDTO [id=" + id + ", name=" + name + ", industryName=" + industryName
				+ ", industrySpecificName=" + industrySpecificName + ", sidoCode=" + sidoCode + ", gunguCode="
				+ gunguCode + ", DongCode=" + DongCode + ", address=" + address + "]";
	}
}
