package com.ssafy.edu.business.model.service;

import java.util.List;

import com.ssafy.edu.business.model.BusinessDto;

public interface BusinessService {
	public int addBusiness(BusinessDto dto);

	public int removeBusiness(int id);

	public List<BusinessDto> getLocalBusinesses(String dongCode);

	public List<BusinessDto> getLocalBusinessesByIndustrySpecificName(int dongCode, String industySpecificName);

	public List<String> getIndustrySpecificNameByDongCode(int dongCode);

	public String getDongcodeByDongName(String dongName);

}
