package com.ssafy.edu.interest.model.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.edu.interest.model.InterestDto;

@Mapper
public interface InterestMapper {
	void addInterest(InterestDto interest) throws Exception;

	List<InterestDto> listInterest() throws Exception;

	void deleteInterest(String interestId) throws Exception;

	String getLastInterestId() throws Exception;
}
