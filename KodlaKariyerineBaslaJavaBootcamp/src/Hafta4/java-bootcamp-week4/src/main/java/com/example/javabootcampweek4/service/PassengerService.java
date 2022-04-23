package com.example.javabootcampweek4.service;

import com.example.javabootcampweek4.entity.Passenger;
import com.example.javabootcampweek4.repository.PassengerRepository;
import com.example.javabootcampweek4.requestDTO.PassengerSaveRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassengerService {
    @Autowired
    PassengerRepository passengerRepository;

    public Long savePassenger(PassengerSaveRequestDTO passengerSaveRequestDTO){
        int ageRequestDTO = passengerSaveRequestDTO.getAge();
        String genderRequestDTO = passengerSaveRequestDTO.getGender();
        double suitcaseWeightRequestDTO = passengerSaveRequestDTO.getSuitcaseWeight();
        int seatNoRequestDTO = passengerSaveRequestDTO.getSeatNo();
        boolean isBusinessRequestDTO = passengerSaveRequestDTO.isBusiness();

        Passenger passenger = new Passenger();

        passenger.setAge(ageRequestDTO);
        passenger.setGender(genderRequestDTO);
        passenger.setBusiness(isBusinessRequestDTO);
        passenger.setSuitcaseWeight(suitcaseWeightRequestDTO);
        passenger.setSeatNo(seatNoRequestDTO);

        passenger = passengerRepository.save(passenger);
        return passenger.getPassengerId();
    }
}
