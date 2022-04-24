package com.example.javabootcampweek4.service;

import com.example.javabootcampweek4.entity.Passenger;
import com.example.javabootcampweek4.entity.Plane;
import com.example.javabootcampweek4.repository.PassengerRepository;
import com.example.javabootcampweek4.repository.PlaneRepository;
import com.example.javabootcampweek4.requestDTO.PassengerSaveRequestDTO;
import com.example.javabootcampweek4.responseDTO.PassengerResponseDTO;
import org.h2.mvstore.Page;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PassengerService {
    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    PlaneRepository planeRepository;

    public Integer savePassenger(PassengerSaveRequestDTO passengerSaveRequestDTO){
        int ageRequestDTO = passengerSaveRequestDTO.getAge();
        String genderRequestDTO = passengerSaveRequestDTO.getGender();
        double suitcaseWeightRequestDTO = passengerSaveRequestDTO.getSuitcaseWeight();
        int seatNoRequestDTO = passengerSaveRequestDTO.getSeatNo();
        boolean isBusinessRequestDTO = passengerSaveRequestDTO.isBusiness();
        LocalDate flightDateRequestDTO= passengerSaveRequestDTO.getFlightDate();
        LocalDate ticketPurchaseDateRequestDTO = passengerSaveRequestDTO.getTicketPurchaseDate();

        Passenger passenger = new Passenger();

        passenger.setAge(ageRequestDTO);
        passenger.setGender(genderRequestDTO);
        passenger.setBusiness(isBusinessRequestDTO);
        passenger.setSuitcaseWeight(suitcaseWeightRequestDTO);
        passenger.setSeatNo(seatNoRequestDTO);
        passenger.setFlightDate(flightDateRequestDTO);
        passenger.setTicketPurchaseDate(ticketPurchaseDateRequestDTO);

        passenger = passengerRepository.save(passenger);
        return passenger.getPassengerId();
    }

    public List<PassengerResponseDTO> findAllPassengersByPlaneId(Integer planeId) {
        Plane plane = planeRepository.findById(planeId).get();
        List<Passenger> allPassengers = passengerRepository.findAllByPlane(plane);
        List<PassengerResponseDTO> passengerResponseDTOS = new ArrayList<>();
        ModelMapper mapper = new ModelMapper();
        for(Passenger passenger : allPassengers){
            PassengerResponseDTO passengerResponseDTO = mapper.map(passenger, PassengerResponseDTO.class);
            passengerResponseDTOS.add(passengerResponseDTO);
        }
        return passengerResponseDTOS;
    }

    public boolean deletePassengerById(Integer passengerId) {
        Passenger passenger = passengerRepository.findById(passengerId).get();
        passengerRepository.delete(passenger);
        return true;
    }
}
