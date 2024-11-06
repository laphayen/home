package com.ssafy.edu.dust.model.service;

import java.util.List;

import com.ssafy.edu.dust.model.DustDto;

public interface DustService {
	// Dust 정보를 가져오는 메서드 선언
	List<DustDto> getDustInfoList();
}
