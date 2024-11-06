package com.ssafy.edu.dust.model.repository;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.edu.dust.model.DustDto;

@Mapper
public interface DustMapper {
	List<DustDto> getDustInfoList() throws SQLException;
}
