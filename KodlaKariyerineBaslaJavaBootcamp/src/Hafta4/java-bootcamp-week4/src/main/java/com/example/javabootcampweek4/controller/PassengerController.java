package com.example.javabootcampweek4.controller;

import com.example.javabootcampweek4.requestDTO.PassengerSaveRequestDTO;
import com.example.javabootcampweek4.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/passenger")
public class PassengerController {
    @Autowired
    PassengerService passengerService;

    @PostMapping("/saveTHYPassenger")
    public ResponseEntity<Long> saveTHYPassenger(@RequestBody PassengerSaveRequestDTO passengerSaveRequestDTO) {
      Long passengerId = passengerService.savePassenger(passengerSaveRequestDTO);
      return new ResponseEntity<>(passengerId, HttpStatus.OK);
    }

    @PostMapping("/savePegasusPassenger")
    public ResponseEntity<Long> savePegasusPassenger(@RequestBody PassengerSaveRequestDTO passengerSaveRequestDTO) {
       Long passengerId = passengerService.savePassenger(passengerSaveRequestDTO);
       return new ResponseEntity<>(passengerId, HttpStatus.OK);
    }

    @PostMapping("/saveOnurAirPassenger")
    public ResponseEntity<Long> saveOnurAirPassenger(@RequestBody PassengerSaveRequestDTO passengerSaveRequestDTO) {
        Long passengerId = passengerService.savePassenger(passengerSaveRequestDTO);
        return new ResponseEntity<>(passengerId, HttpStatus.OK);
    }
}
