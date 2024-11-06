package com.ssafy.edu.house.model;

import java.math.BigDecimal;

public class HouseDealsDto {
	private String aptNm;
	private String floor;
	private BigDecimal excluUseAr;
	private String dongName;
	private String dealAmount;

	// Getters and setters
	public String getAptNm() {
		return aptNm;
	}

	public void setAptNm(String aptNm) {
		this.aptNm = aptNm;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public BigDecimal getExcluUseAr() {
		return excluUseAr;
	}

	public void setExcluUseAr(BigDecimal excluUseAr) {
		this.excluUseAr = excluUseAr;
	}

	public String getDongName() {
		return dongName;
	}

	public void setDongName(String dongName) {
		this.dongName = dongName;
	}

	public String getDealAmount() {
		return dealAmount;
	}

	public void setDealAmount(String dealAmount) {
		this.dealAmount = dealAmount;
	}

	@Override
	public String toString() {
		return "HouseDealsDto [aptNm=" + aptNm + ", floor=" + floor + ", excluUseAr=" + excluUseAr + ", dongName="
				+ dongName + ", dealAmount=" + dealAmount + "]";
	}

}