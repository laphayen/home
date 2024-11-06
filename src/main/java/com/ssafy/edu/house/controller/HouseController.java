package com.ssafy.edu.house.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.ssafy.edu.house.model.HouseDealsDto;
import com.ssafy.edu.house.model.HouseInfosDto;
import com.ssafy.edu.house.model.service.HouseService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/house")
public class HouseController {
	@Autowired
	private HouseService service;

	@PostMapping("/searchAptDeals")
	public void getDeals(@RequestParam("province") String sido, @RequestParam("city") String gugun,
			@RequestParam("dong") String dong, @RequestParam("year") String year, @RequestParam("month") String month,
			HttpServletResponse response) throws Exception {
		System.out.println(sido + " " + gugun);
		String sgg_cd = dong.substring(0, 5);
		String umd_cd = dong.substring(5, 10);
		List<HouseInfosDto> infoList = service.getHouseInfos(sgg_cd, umd_cd);

		for (HouseInfosDto d : infoList) {
			System.out.println(d.toString());
		}

		List<HouseDealsDto> houseList = service.getHouseDeals(infoList, year, month);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		String json = new Gson().toJson(houseList);
		response.getWriter().write(json);
	}
}
