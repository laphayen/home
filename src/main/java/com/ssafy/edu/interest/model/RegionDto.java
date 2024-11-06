package com.ssafy.edu.interest.model;

public class RegionDto {
	private String sido;
	private String gugun;

	private String dong;
	private String year;
	private String month;

	public RegionDto(String sido, String gugun, String dong, String year, String month) {
		super();
		this.sido = sido;
		this.gugun = gugun;
		this.dong = dong;
		this.year = year;
		this.month = month;
	}

	@Override
	public String toString() {
		return "RegionDto [sido=" + sido + ", gugun=" + gugun + ", dong=" + dong + ", year=" + year + ", month=" + month
				+ "]";
	}

	public String getSido() {
		return sido;
	}

	public void setSido(String sido) {
		this.sido = sido;
	}

	public String getGugun() {
		return gugun;
	}

	public void setGugun(String gugun) {
		this.gugun = gugun;
	}

	public String getDong() {
		return dong;
	}

	public void setDong(String dong) {
		this.dong = dong;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

}
