package com.ssafy.edu.hospital.model.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ssafy.edu.hospital.HospitalDto;
import com.ssafy.edu.hospital.model.repository.HospitalMapper;

@Service
public class HospitalServiceImpl implements HospitalService {

    private final HospitalMapper hospitalMapper;

    @Autowired
    public HospitalServiceImpl(HospitalMapper hospitalMapper) {
        this.hospitalMapper = hospitalMapper;
    }

    @Override
    public List<HospitalDto> getHospitalList() throws Exception {
        return hospitalMapper.getHospitalList();
    }

    @Override
    public HospitalDto getHospitalDetail(String businessNo) throws Exception {
        return hospitalMapper.getHospitalDetail(businessNo);
    }
}
