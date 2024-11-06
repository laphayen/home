package com.ssafy.edu.interest.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.edu.interest.model.InterestDto;
import com.ssafy.edu.interest.model.repository.InterestMapper;

@Service
public class InterestServiceImpl implements InterestService {

	@Autowired
	private InterestMapper mapper;

	@Override
	public void addInterest(InterestDto interest) throws Exception {
		// TODO Auto-generated method stub
		mapper.addInterest(interest);
	}

	@Override
	public List<InterestDto> listInterest() throws Exception {
		// TODO Auto-generated method stub
		return mapper.listInterest();
	}

	@Override
	public void deleteInterest(String interestId) throws Exception {
		// TODO Auto-generated method stub
		mapper.deleteInterest(interestId);
	}

	@Override
	public String getLastInterestId() throws Exception {
		// TODO Auto-generated method stub
		return mapper.getLastInterestId();
	}

}
