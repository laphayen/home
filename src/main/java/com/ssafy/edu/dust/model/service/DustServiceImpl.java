package com.ssafy.edu.dust.model.service;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.edu.dust.model.DustDto;
import com.ssafy.edu.dust.model.repository.DustMapper;

@Service
public class DustServiceImpl implements DustService {
	@Autowired
	private DustMapper mapper;

	@Override
	public List<DustDto> getDustInfoList() {
		// TODO Auto-generated method stub
		try {
			return mapper.getDustInfoList();
		} catch (SQLException e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}
}