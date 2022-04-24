package com.example.javabootcampweek4.controller;

import com.example.javabootcampweek4.requestDTO.PassengerSaveRequestDTO;
import com.example.javabootcampweek4.responseDTO.PassengerResponseDTO;
import com.example.javabootcampweek4.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passenger")
public class PassengerController {
    @Autowired
    PassengerService passengerService;

    @PostMapping("/saveTHYPassenger")
    public ResponseEntity<Integer> saveTHYPassenger(@RequestBody PassengerSaveRequestDTO passengerSaveRequestDTO) {
        Integer passengerId = passengerService.savePassenger(passengerSaveRequestDTO);

      return new ResponseEntity<>(passengerId, HttpStatus.OK);
    }

    @PostMapping("/savePegasusPassenger")
    public ResponseEntity<Integer> savePegasusPassenger(@RequestBody PassengerSaveRequestDTO passengerSaveRequestDTO) {
        Integer passengerId = passengerService.savePassenger(passengerSaveRequestDTO);
       return new ResponseEntity<>(passengerId, HttpStatus.OK);
    }

    @PostMapping("/saveOnurAirPassenger")
    public ResponseEntity<Integer> saveOnurAirPassenger(@RequestBody PassengerSaveRequestDTO passengerSaveRequestDTO) {
        Integer passengerId = passengerService.savePassenger(passengerSaveRequestDTO);
        return new ResponseEntity<>(passengerId, HttpStatus.OK);
    }

    @GetMapping("/findAllPassengersByPlaneId")
    public ResponseEntity<List<PassengerResponseDTO>> findAllPassengersByPlaneId(@RequestParam Integer planeId){
        List<PassengerResponseDTO> passengerResponseDTOS = passengerService.findAllPassengersByPlaneId(planeId);
        return new ResponseEntity<>(passengerResponseDTOS, HttpStatus.OK);
    }

    @DeleteMapping("/deletePassengerById")
    public ResponseEntity<Boolean> deletePassengerById(@RequestParam Integer passengerId){
        boolean delete = passengerService.deletePassengerById(passengerId);
        return new ResponseEntity<>(delete, HttpStatus.OK);
    }
}
