package com.ssafy.edu.house.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.edu.house.model.HouseDealsDto;
import com.ssafy.edu.house.model.HouseInfosDto;
import com.ssafy.edu.house.model.repository.HouseMapper;
import com.ssafy.edu.interest.model.RegionDto;

@Service
public class HouseServiceImpl implements HouseService {
	@Autowired
	private HouseMapper mapper;

	@Override
	public List<HouseDealsDto> getHouseDeals(List<HouseInfosDto> infoList, String year, String month) throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("infoList", infoList);
		map.put("year", Integer.parseInt(year));
		map.put("month", Integer.parseInt(month));
		return mapper.getHouseDeals(map);
	}

	@Override
	public List<HouseInfosDto> getHouseInfos(String sgg_cd, String umd_cd) throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sgg_cd", sgg_cd);
		map.put("umd_cd", umd_cd);
		return mapper.getHouseInfos(map);
	}
}