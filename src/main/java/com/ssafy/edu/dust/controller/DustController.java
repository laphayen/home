package com.ssafy.edu.dust.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.ssafy.edu.dust.model.DustDto;
import com.ssafy.edu.dust.model.service.DustService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/dustinfo")
public class DustController {
	@Autowired
	private DustService dustService;

	@GetMapping("/dustList")
	public ModelAndView dustList(ModelAndView mav, HttpServletResponse response) throws IOException {
		List<DustDto> dustList = dustService.getDustInfoList();

		mav.addObject("dustList", dustList);
		mav.setViewName("/views/dustinfo");
		//모델앤뷰 리턴 부분
		
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		String json = new Gson().toJson(dustList);
		response.getWriter().write(json);//JSON 

		return mav;
	}

}
