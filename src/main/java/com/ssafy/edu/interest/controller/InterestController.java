package com.ssafy.edu.interest.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.edu.interest.model.service.InterestService;
import com.google.gson.Gson;
import com.ssafy.edu.interest.model.InterestDto;
import com.ssafy.edu.interest.model.repository.RegionMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller()
@RequestMapping("/interest")
public class InterestController {

	@Autowired
	private InterestService interestService;

	@Autowired
	private RegionMapper regionmapper;

	@PostMapping("/addFavoriteArea")
	public String listFavoriteAreas(@RequestParam("province") String provinceCode,
			@RequestParam("city") String cityCode, @RequestParam("dong") String dongCode, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		try {
			// 요청과 응답의 인코딩 설정
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");

			// 지역 코드를 지역명으로 변환
			String province = regionmapper.getProvinceName(provinceCode);
			String city = regionmapper.getCityName(cityCode);
			String dong = regionmapper.getDongName(dongCode);

			// 마지막 interestId를 가져와서 새로운 ID 생성
			String lastInterestId = interestService.getLastInterestId();
			System.out.println(lastInterestId);
			String interestId = String.valueOf(Integer.parseInt(lastInterestId) + 1);

			// InterestDto 객체 생성
			InterestDto interest = new InterestDto(interestId, province, city, dong);

			// 관심 지역 추가 서비스 호출
			interestService.addInterest(interest);
//			response.setContentType("application/json");
//			response.setCharacterEncoding("UTF-8");
//
//			String json = new Gson().toJson(interest);
//			response.getWriter().write(json);
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().write(
					"<script>alert('오류 발생: " + e.getMessage() + "'); window.location.href=document.referrer;</script>");
		} // 성공 메시지 출력 및 index.jsp로 리다이렉트
		
		return "/index";
	}

	@GetMapping("/listFavoriteAreas")
	public String listFavoriteAreas(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			// 데이터베이스에서 관심 지역 목록을 가져옴
			List<InterestDto> interestList = interestService.listInterest();
			// 관심 지역 목록을 request scope에 설정
			request.setAttribute("interestList", interestList);
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().write(
					"<script>alert('오류 발생: " + e.getMessage() + "'); window.location.href=document.referrer;</script>");
		}
		// 관심 지역 목록을 보여줄 interestinfo.jsp로 포워딩
		return "/views/interestinfo";
	}

	@DeleteMapping("/deleteFavoriteArea")
	public String deleteFavoriteArea(@RequestParam("interestId") String interestId, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		try {
			System.out.println(interestId);
			// 관심 지역 삭제 서비스 호출
			interestService.deleteInterest(interestId);
			// 데이터베이스에서 관심 지역 목록을 가져옴
			List<InterestDto> interestList = interestService.listInterest();
			// 관심 지역 목록을 request scope에 설정
			request.setAttribute("interestList", interestList);
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().write(
					"<script>alert('오류 발생: " + e.getMessage() + "'); window.location.href=document.referrer;</script>");
		}
		return "/views/interestinfo";
	}
}
