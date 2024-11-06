package com.ssafy.edu.interest.model.repository;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RegionMapper {

	String getProvinceName(String provinceCode) throws Exception;

	String getCityName(String cityCode) throws Exception;

	String getDongName(String dongCode) throws Exception;
}
