package com.ssafy.edu.business.model.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.edu.business.model.BusinessDto;

@Mapper
public interface BusinessMapper {
	public int addBusiness(BusinessDto dto);

	public int removeBusiness(int id);

	public List<BusinessDto> getLocalBusinesses(String dongCode);

	public List<BusinessDto> getLocalBusinessesByIndustrySpecificName(int dongCode, String industySpecificName);

	public List<String> getIndustrySpecificNameByDongCode(int dongCode);

	public String getDongcodeByDongName(String dongName);

}
