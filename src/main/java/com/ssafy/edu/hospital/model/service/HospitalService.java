package com.ssafy.edu.hospital.model.service;

import java.util.List;

import com.ssafy.edu.hospital.HospitalDto;

public interface HospitalService {

    List<HospitalDto> getHospitalList() throws Exception;

    HospitalDto getHospitalDetail(String businessNo) throws Exception;
}
