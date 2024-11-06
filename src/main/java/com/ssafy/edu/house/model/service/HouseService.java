package com.ssafy.edu.house.model.service;

import java.util.List;

import com.ssafy.edu.house.model.HouseDealsDto;
import com.ssafy.edu.house.model.HouseInfosDto;

public interface HouseService {
	public List<HouseDealsDto> getHouseDeals(List<HouseInfosDto> infoList, String year, String month) throws Exception;

	public List<HouseInfosDto> getHouseInfos(String sgg_cd, String umd_cd) throws Exception;
}
