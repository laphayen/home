package com.ssafy.edu.hospital.controller;

import com.ssafy.edu.hospital.HospitalDto;
import com.ssafy.edu.hospital.model.service.HospitalService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController // RestController를 사용하여 JSON 반환을 쉽게 처리합니다.
@RequestMapping("/hospital")
public class HospitalController {

    private final HospitalService hospitalService;

    public HospitalController(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }

    @GetMapping("/list")
    public List<HospitalDto> getHospitalList() throws Exception {
        // 병원 리스트를 JSON 형식으로 반환
        return hospitalService.getHospitalList();
    }
}
