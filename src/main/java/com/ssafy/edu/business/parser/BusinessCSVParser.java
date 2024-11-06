package com.ssafy.edu.business.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;

import com.ssafy.edu.business.model.BusinessDto;
import com.ssafy.edu.business.model.repository.BusinessMapper;

public class BusinessCSVParser {

	@Autowired
	private BusinessMapper mapper;

	public BusinessCSVParser() {
		new BusinessCSVParser().loadData();
	}

	public void loadData() {
		String path = "/home/src/main/java/com/ssafy/edu/business/parser/csvData/";

		List<File> files = new ArrayList<>();

		// 데이터가 너무 많아서 대전 데이터만 입력
//        files.add(new File(path + "소상공인시장진흥공단_상가(상권)정보_강원_202406.csv"));
//        files.add(new File(path + "소상공인시장진흥공단_상가(상권)정보_경기_202406.csv"));
//        files.add(new File(path + "소상공인시장진흥공단_상가(상권)정보_경남_202406.csv"));
//        files.add(new File(path + "소상공인시장진흥공단_상가(상권)정보_경북_202406.csv"));
//        files.add(new File(path + "소상공인시장진흥공단_상가(상권)정보_광주_202406.csv"));
//        files.add(new File(path + "소상공인시장진흥공단_상가(상권)정보_대구_202406.csv"));
//        files.add(new File(path + "소상공인시장진흥공단_상가(상권)정보_대전_202406.csv"));
//        files.add(new File(path + "소상공인시장진흥공단_상가(상권)정보_부산_202406.csv"));
		files.add(new File(path + "소상공인시장진흥공단_상가(상권)정보_서울_202406.csv"));
//        files.add(new File(path + "소상공인시장진흥공단_상가(상권)정보_세종_202406.csv"));
//        files.add(new File(path + "소상공인시장진흥공단_상가(상권)정보_울산_202406.csv"));
//        files.add(new File(path + "소상공인시장진흥공단_상가(상권)정보_인천_202406.csv"));
//        files.add(new File(path + "소상공인시장진흥공단_상가(상권)정보_전남_202406.csv"));
//        files.add(new File(path + "소상공인시장진흥공단_상가(상권)정보_전북_202406.csv"));
//        files.add(new File(path + "소상공인시장진흥공단_상가(상권)정보_제주_202406.csv"));
//        files.add(new File(path + "소상공인시장진흥공단_상가(상권)정보_충남_202406.csv"));
//        files.add(new File(path + "소상공인시장진흥공단_상가(상권)정보_충북_202406.csv"));

		for (File file : files) {
			BusinessDto cur = null;
			try (BufferedReader is = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"))) {
				String input = is.readLine();
				while ((input = is.readLine()) != null) {
					List<String> line = parseCSV(input);

					cur = new BusinessDto();

					cur.setName(line.get(1));
					cur.setIndustryName(line.get(4));
					cur.setIndustrySpecificName(line.get(8));
					cur.setSidoCode(Integer.parseInt(line.get(11)));
					cur.setGunguCode(Integer.parseInt(line.get(13)));
					cur.setDongCode(Integer.parseInt(line.get(15)));
					cur.setAddress(line.get(24));

					if (mapper.addBusiness(cur) == 0)
						System.err.println("데이터 입력 실패");
				}
			} catch (Exception e) {
				System.err.println(cur);
				e.printStackTrace();
			}
		}

	}

	public static ArrayList<String> parseCSV(String input) {
		ArrayList<String> result = new ArrayList<>();
		Pattern pattern = Pattern.compile("\"([^\"]*)\"|(?<=,)(?=,)|([^,]+)");
		Matcher matcher = pattern.matcher(input);
		while (matcher.find()) {
			if (matcher.group(1) != null) {
				// 큰따옴표 안에 있는 값 처리
				result.add(matcher.group(1));
			} else if (matcher.group(2) != null) {
				// 큰따옴표 밖에 있는 값 처리
				result.add(matcher.group(2));
			} else {
				// 쉼표가 연속으로 나오는 경우 빈 문자열로 처리
				result.add("");
			}
		}
		return result;
	}
}
