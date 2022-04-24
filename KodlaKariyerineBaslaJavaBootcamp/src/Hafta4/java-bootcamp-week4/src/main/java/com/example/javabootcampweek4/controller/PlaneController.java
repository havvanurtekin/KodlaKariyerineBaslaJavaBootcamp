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
    public ResponseEntity<Integer> saveTHYPlane(@RequestBody PlaneSaveRequestDTO planeSaveRequestDTO) throws Exception {
        Integer planeId = planeService.saveTHY(planeSaveRequestDTO);
        return new ResponseEntity<>(planeId, HttpStatus.OK );
    }
    @PostMapping("/savePegasusPlane")
    public ResponseEntity<Integer> savePegasusPlane(@RequestBody PlaneSaveRequestDTO planeSaveRequestDTO){
        Integer planeId = planeService.savePegasus(planeSaveRequestDTO);
        return new ResponseEntity<>(planeId, HttpStatus.OK );
    }
    @PostMapping("/saveOnurAirPlane")
    public ResponseEntity<Integer> saveOnurAirPlane(@RequestBody PlaneSaveRequestDTO planeSaveRequestDTO){
        Integer planeId = planeService.saveOnurAir(planeSaveRequestDTO);
        return new ResponseEntity<>(planeId, HttpStatus.OK );
    }
}
