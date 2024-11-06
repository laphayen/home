package com.ssafy.edu.interest.model.service;

import java.util.List;

import com.ssafy.edu.interest.model.InterestDto;

public interface InterestService {
	void addInterest(InterestDto interest) throws Exception;

	List<InterestDto> listInterest() throws Exception;

	void deleteInterest(String interestId) throws Exception;

	String getLastInterestId() throws Exception;

}
