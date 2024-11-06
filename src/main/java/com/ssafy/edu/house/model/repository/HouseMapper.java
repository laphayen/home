package com.ssafy.edu.house.model.repository;

import java.util.List;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.edu.house.model.HouseDealsDto;
import com.ssafy.edu.house.model.HouseInfosDto;
import com.ssafy.edu.interest.model.RegionDto;

@Mapper
public interface HouseMapper {

	List<HouseInfosDto> getHouseInfos(Map<String, Object> map) throws Exception;

	List<HouseDealsDto> getHouseDeals(Map<String, Object> map);
}