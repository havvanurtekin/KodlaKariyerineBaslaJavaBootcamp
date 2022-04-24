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
//plane controller
@RestController
@RequestMapping("/plane")
public class PlaneController {

    //autowired plane service
    @Autowired
    PlaneService planeService;

    //thy yolcu uçağı ekleyen fonksiyon
    @PostMapping("/saveTHYPlane")
    public ResponseEntity<Integer> saveTHYPlane(@RequestBody PlaneSaveRequestDTO planeSaveRequestDTO) throws Exception {
        //plane service tarafından dto'dan plane id döner
        Integer planeId = planeService.saveTHY(planeSaveRequestDTO);
        //başarılı olursa 200 dönecek
        return new ResponseEntity<>(planeId, HttpStatus.OK );
    }
    //pegasus yolcu uçağı ekleyen fonksiyon
    @PostMapping("/savePegasusPlane")
    public ResponseEntity<Integer> savePegasusPlane(@RequestBody PlaneSaveRequestDTO planeSaveRequestDTO){
        //plane service tarafından dto'dan plane id döner
        Integer planeId = planeService.savePegasus(planeSaveRequestDTO);
        //başarılı olursa 200 dönecek
        return new ResponseEntity<>(planeId, HttpStatus.OK );
    }
    //onur air yolcu uçağı ekleyen fonksiyon
    @PostMapping("/saveOnurAirPlane")
    public ResponseEntity<Integer> saveOnurAirPlane(@RequestBody PlaneSaveRequestDTO planeSaveRequestDTO){
        //plane service tarafından dto'dan plane id döner
        Integer planeId = planeService.saveOnurAir(planeSaveRequestDTO);
        //başarılı olursa 200 dönecek
        return new ResponseEntity<>(planeId, HttpStatus.OK );
    }
}
