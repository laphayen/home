package com.ssafy.edu.business.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.edu.business.model.BusinessDto;
import com.ssafy.edu.business.model.repository.BusinessMapper;

@Service
public class BusinessServiceImpl implements BusinessService {

	@Autowired
	private BusinessMapper mapper;

	@Override
	public int addBusiness(BusinessDto dto) {
		// TODO Auto-generated method stub
		return mapper.addBusiness(dto);
	}

	@Override
	public int removeBusiness(int id) {
		// TODO Auto-generated method stub
		return mapper.removeBusiness(id);
	}

	@Override
	public List<BusinessDto> getLocalBusinesses(String dongCode) {
		// TODO Auto-generated method stub
		return mapper.getLocalBusinesses(dongCode);
	}

	@Override
	public List<BusinessDto> getLocalBusinessesByIndustrySpecificName(int dongCode, String industySpecificName) {
		// TODO Auto-generated method stub
		return mapper.getLocalBusinessesByIndustrySpecificName(dongCode, industySpecificName);
	}

	@Override
	public List<String> getIndustrySpecificNameByDongCode(int dongCode) {
		// TODO Auto-generated method stub
		return mapper.getIndustrySpecificNameByDongCode(dongCode);
	}

	@Override
	public String getDongcodeByDongName(String dongName) {
		// TODO Auto-generated method stub
		return mapper.getDongcodeByDongName(dongName);
	}

}
