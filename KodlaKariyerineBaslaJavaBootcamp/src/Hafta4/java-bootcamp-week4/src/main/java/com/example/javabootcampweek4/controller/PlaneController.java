package com.example.javabootcampweek4.controller;

import com.example.javabootcampweek4.requestDTO.PlaneSaveRequestDTO;
import com.example.javabootcampweek4.service.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/plane")
public class PlaneController {

    @Autowired
    PlaneService planeService;

    @PostMapping("/saveTHYPlane")
    public ResponseEntity<Long> saveTHYPlane(@RequestBody PlaneSaveRequestDTO planeSaveRequestDTO) throws Exception {
        Long planeId = planeService.saveTHY(planeSaveRequestDTO);
        return new ResponseEntity<>(planeId, HttpStatus.OK );
    }
    @PostMapping("/savePegasusPlane")
    public ResponseEntity<Long> savePegasusPlane(@RequestBody PlaneSaveRequestDTO planeSaveRequestDTO){
        Long planeId = planeService.savePegasus(planeSaveRequestDTO);
        return new ResponseEntity<>(planeId, HttpStatus.OK );
    }
    @PostMapping("/saveOnurAirPlane")
    public ResponseEntity<Long> saveOnurAirPlane(@RequestBody PlaneSaveRequestDTO planeSaveRequestDTO){
        Long planeId = planeService.saveOnurAir(planeSaveRequestDTO);
        return new ResponseEntity<>(planeId, HttpStatus.OK );
    }
}
