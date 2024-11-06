package com.ssafy.edu.business.controller;

import java.io.BufferedReader;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.edu.business.model.BusinessDto;
import com.ssafy.edu.business.model.service.BusinessService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/business")
@CrossOrigin("*")
public class BusinessController {
	public BusinessController() throws IOException {
		// loadData();
	}

	@Autowired
	private BusinessService businessService;

	@GetMapping("/getList")
	public String getList(HttpServletRequest request) throws IOException {
		StringBuilder stringBuilder = new StringBuilder();
		String line;

		try (BufferedReader reader = request.getReader()) {
			while ((line = reader.readLine()) != null) {
				stringBuilder.append(line);
			}
		}

		String jsonString = stringBuilder.toString();

		String action = null;
		String dongName = null;

		if (jsonString.contains("\"action\"")) {
			action = jsonString.split("\"action\"")[1].split("\"")[1];
		}
		if (jsonString.contains("\"dong\"")) {
			dongName = jsonString.split("\"dong\"")[1].split("\"")[1];
		}

		String dongCode = businessService.getDongcodeByDongName(dongName);
		String gunguCode = dongCode.substring(0, 5);
		System.out.println("군구코드 : " + gunguCode);

		List<BusinessDto> localBusinesses = businessService.getLocalBusinesses(gunguCode);

		request.setAttribute("businessList", localBusinesses);

		// JSP 파일 경로 수정 (webapp/views 경로를 포함)
		return "/views/business.jsp";
	}

	@GetMapping("/loadData")
	public void loadData() throws IOException {
		// 기본 쿼리 스트링
		StringBuilder queryString = new StringBuilder("http://apis.data.go.kr/B553077/api/open/sdsc2/");
		// 서비스 종류
		queryString.append("largeUpjongList");
		// 필수 인자
		queryString.append("?" + URLEncoder.encode("ServiceKey", "UTF-8") + "="
				+ "DPvEhobzPWBOZeUPzkAk%2BrZ5QivehlbFnKUS%2FMZd8Owx%2BNA5PKwRI20j9YzN9qo0M6K3dDzS3deSt%2Fl6zFVjpg%3D%3D");
		// 서비스 타입
		queryString.append("&" + "type" + "=" + "json");
		System.out.println(queryString);

		// 본격적인 URL 준비
		URL url = new URL(queryString.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");

		System.out.println("Response code: " + conn.getResponseCode());

		BufferedReader rd;
		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		// 9. 저장된 데이터를 라인별로 읽어 StringBuilder 객체로 저장.
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line + "\n");
		}
		// 10. 객체 해제.
		System.out.println(sb);
		rd.close();
		conn.disconnect();
	}

//	@GetMapping(value = "/localBusiness")
//	public ModelAndView jsonParser(ModelAndView mav, HttpServletRequest request, HttpServletResponse response)
//			throws IOException {
//		// 데이터 변환
//
//		mav.addObject("businessinfolist", list);
//		mav.setViewName("/views/business");
//		return mav; // List<BusinessDto> 반환
//	}
}
