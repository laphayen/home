package com.ssafy.edu.dust.model;

public class DustDto {
	private int id; // 고유 ID
	private String gugunName; // 구 이름
	private String msradmcode; // 측정소 행정코드
	private String msrdate; // 측정 날짜 및 시간
	private int pm10; // 미세먼지 농도
	private String grade; // 통합대기환경지수 등급

	// 기본 생성자
	public DustDto() {
	}

	// 모든 필드를 포함하는 생성자
	public DustDto(int id, String gugunName, String msradmcode, String msrdate, int pm10, String grade) {
		this.id = id;
		this.gugunName = gugunName;
		this.msradmcode = msradmcode;
		this.msrdate = msrdate;
		this.pm10 = pm10;
		this.grade = grade;
	}

	// Getter 및 Setter 메소드
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGugunName() {
		return gugunName;
	}

	public void setGugunName(String gugunName) {
		this.gugunName = gugunName;
	}

	public String getMsradmcode() {
		return msradmcode;
	}

	public void setMsradmcode(String msradmcode) {
		this.msradmcode = msradmcode;
	}

	public String getMsrdate() {
		return msrdate;
	}

	public void setMsrdate(String msrdate) {
		this.msrdate = msrdate;
	}

	public int getPm10() {
		return pm10;
	}

	public void setPm10(int pm10) {
		this.pm10 = pm10;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "DustDto [id=" + id + ", gugunName=" + gugunName + ", msradmcode=" + msradmcode + ", msrdate=" + msrdate
				+ ", pm10=" + pm10 + ", grade=" + grade + "]";
	}
}
