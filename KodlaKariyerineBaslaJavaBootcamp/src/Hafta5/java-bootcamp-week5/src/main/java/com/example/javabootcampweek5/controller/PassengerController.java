package com.example.javabootcampweek5.controller;

import com.example.javabootcampweek4.requestDTO.PassengerSaveRequestDTO;
import com.example.javabootcampweek4.responseDTO.PassengerResponseDTO;
import com.example.javabootcampweek4.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//passenger controller
@RestController
@RequestMapping("/passenger")
public class PassengerController {
    //autowired passenger service
    @Autowired
    PassengerService passengerService;

    //thy uçağına yolcu post eden fonksiyon - parametre passenger id
    @PostMapping("/saveTHYPassenger")
    public ResponseEntity<Integer> saveTHYPassenger(@RequestBody PassengerSaveRequestDTO passengerSaveRequestDTO) {
        //passengerService tarafından dto dan çekilen ve kaydedilen yolcunun id'si
        Integer passengerId = passengerService.savePassenger(passengerSaveRequestDTO);
        //başarılı olursa http 200 dönecek
      return new ResponseEntity<>(passengerId, HttpStatus.OK);
    }
    //pegasus uçağına yolcu post eden fonksiyon - parametre passenger id
    @PostMapping("/savePegasusPassenger")
    public ResponseEntity<Integer> savePegasusPassenger(@RequestBody PassengerSaveRequestDTO passengerSaveRequestDTO) {
        //passengerService tarafından dto dan çekilen ve kaydedilen yolcunun id'si
        Integer passengerId = passengerService.savePassenger(passengerSaveRequestDTO);
        //başarılı olursa http 200 dönecek
        return new ResponseEntity<>(passengerId, HttpStatus.OK);
    }
    //onur air uçağına yolcu post eden fonksiyon - parametre passenger id
    @PostMapping("/saveOnurAirPassenger")
    public ResponseEntity<Integer> saveOnurAirPassenger(@RequestBody PassengerSaveRequestDTO passengerSaveRequestDTO) {
        //passengerService tarafından dto dan çekilen ve kaydedilen yolcunun id'si
        Integer passengerId = passengerService.savePassenger(passengerSaveRequestDTO);
        //başarılı olursa http 200 dönecek
        return new ResponseEntity<>(passengerId, HttpStatus.OK);
    }
    //idsi bilinen uçağın tüm yolcularının bilgilerini döndüren fonksiyon
    @GetMapping("/findAllPassengersByPlaneId")
    public ResponseEntity<List<PassengerResponseDTO>> findAllPassengersByPlaneId(@RequestParam Integer planeId){
        //passenger service tarafından id ile çekilen bilgiler bir dto objesine aktarılır
        List<PassengerResponseDTO> passengerResponseDTOS = passengerService.findAllPassengersByPlaneId(planeId);
        ///başarılı olursa http 200 dönecek
        return new ResponseEntity<>(passengerResponseDTOS, HttpStatus.OK);
    }

    //uçaktan id si bilinen yolcuyı silen fonksiyon
    @DeleteMapping("/deletePassengerById")
    public ResponseEntity<Boolean> deletePassengerById(@RequestParam Integer passengerId){
        //silme işlemi onaylanırsa true döndürecek
        boolean delete = passengerService.deletePassengerById(passengerId);
        ///başarılı olursa http 200 dönecek
        return new ResponseEntity<>(delete, HttpStatus.OK);
    }
}
