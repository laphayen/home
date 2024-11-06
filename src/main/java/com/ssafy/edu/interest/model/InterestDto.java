package com.ssafy.edu.interest.model;

public class InterestDto {
	private String interestId;
	private String interestSidoName;
	private String interestGugunName;
	private String interestDongName;

	public InterestDto() {
	}

	public InterestDto(String interestId, String interestSidoName, String interestGugunName, String interestDongName) {
		this.interestId = interestId;
		this.interestSidoName = interestSidoName;
		this.interestGugunName = interestGugunName;
		this.interestDongName = interestDongName;
	}

	public String getInterestId() {
		return interestId;
	}

	public void setInterestId(String interestId) {
		this.interestId = interestId;
	}

	public String getInterestSidoName() {
		return interestSidoName;
	}

	public void setInterestSidoName(String interestSidoName) {
		this.interestSidoName = interestSidoName;
	}

	public String getInterestGugunName() {
		return interestGugunName;
	}

	public void setInterestGugunName(String interestGugunName) {
		this.interestGugunName = interestGugunName;
	}

	public String getInterestDongName() {
		return interestDongName;
	}

	public void setInterestDongName(String interestDongName) {
		this.interestDongName = interestDongName;
	}

	@Override
	public String toString() {
		return "InterestDto [interestId=" + interestId + ", interestSidoName=" + interestSidoName
				+ ", interestGugunName=" + interestGugunName + ", interestDongName=" + interestDongName + "]";
	}

}
