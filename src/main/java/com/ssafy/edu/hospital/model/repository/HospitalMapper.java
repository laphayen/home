package com.ssafy.edu.hospital.model.repository;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.ssafy.edu.hospital.HospitalDto;

@Mapper
public interface HospitalMapper {

    List<HospitalDto> getHospitalList() throws Exception;

    HospitalDto getHospitalDetail(String businessNo) throws Exception;
}
