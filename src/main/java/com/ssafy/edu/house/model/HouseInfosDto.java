package com.ssafy.edu.house.model;

public class HouseInfosDto {
	private String apt_seq;
	private String sgg_cd;
	private String umd_cd;
	private String dong_name;
	private String jibun;
	private String road_nm_sgg_cd;
	private String road_nm;
	private String road_nmroad_nm_bonbun;
	private String road_nm_bubun;
	private String apt_nm;
	private String build_year;
	private String latitude;
	private String longitude;

	public HouseInfosDto(String apt_seq, String sgg_cd, String umd_cd, String umd_nm, String jibun,
			String road_nm_sgg_cd, String road_nm, String road_nmroad_nm_bonbun, String road_nm_bubun, String apt_nm,
			String build_year, String latitude, String longitude) {
		super();
		this.apt_seq = apt_seq;
		this.sgg_cd = sgg_cd;
		this.umd_cd = umd_cd;
		this.dong_name = dong_name;
		this.jibun = jibun;
		this.road_nm_sgg_cd = road_nm_sgg_cd;
		this.road_nm = road_nm;
		this.road_nmroad_nm_bonbun = road_nmroad_nm_bonbun;
		this.road_nm_bubun = road_nm_bubun;
		this.apt_nm = apt_nm;
		this.build_year = build_year;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getApt_seq() {
		return apt_seq;
	}

	public void setApt_seq(String apt_seq) {
		this.apt_seq = apt_seq;
	}

	public String getSgg_cd() {
		return sgg_cd;
	}

	public void setSgg_cd(String sgg_cd) {
		this.sgg_cd = sgg_cd;
	}

	public String getUmd_cd() {
		return umd_cd;
	}

	public void setUmd_cd(String umd_cd) {
		this.umd_cd = umd_cd;
	}

	public String getJibun() {
		return jibun;
	}

	public void setJibun(String jibun) {
		this.jibun = jibun;
	}

	public String getRoad_nm_sgg_cd() {
		return road_nm_sgg_cd;
	}

	public void setRoad_nm_sgg_cd(String road_nm_sgg_cd) {
		this.road_nm_sgg_cd = road_nm_sgg_cd;
	}

	public String getRoad_nm() {
		return road_nm;
	}

	public void setRoad_nm(String road_nm) {
		this.road_nm = road_nm;
	}

	public String getRoad_nmroad_nm_bonbun() {
		return road_nmroad_nm_bonbun;
	}

	public void setRoad_nmroad_nm_bonbun(String road_nmroad_nm_bonbun) {
		this.road_nmroad_nm_bonbun = road_nmroad_nm_bonbun;
	}

	public String getRoad_nm_bubun() {
		return road_nm_bubun;
	}

	public void setRoad_nm_bubun(String road_nm_bubun) {
		this.road_nm_bubun = road_nm_bubun;
	}

	public String getApt_nm() {
		return apt_nm;
	}

	public void setApt_nm(String apt_nm) {
		this.apt_nm = apt_nm;
	}

	public String getBuild_year() {
		return build_year;
	}

	public void setBuild_year(String build_year) {
		this.build_year = build_year;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getDong_name() {
		return dong_name;
	}

	public void setDong_name(String dong_name) {
		this.dong_name = dong_name;
	}

	@Override
	public String toString() {
		return "HouseInfosDto [apt_seq=" + apt_seq + ", sgg_cd=" + sgg_cd + ", umd_cd=" + umd_cd + ", dong_name="
				+ dong_name + ", jibun=" + jibun + ", road_nm_sgg_cd=" + road_nm_sgg_cd + ", road_nm=" + road_nm
				+ ", road_nmroad_nm_bonbun=" + road_nmroad_nm_bonbun + ", road_nm_bubun=" + road_nm_bubun + ", apt_nm="
				+ apt_nm + ", build_year=" + build_year + ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}
}