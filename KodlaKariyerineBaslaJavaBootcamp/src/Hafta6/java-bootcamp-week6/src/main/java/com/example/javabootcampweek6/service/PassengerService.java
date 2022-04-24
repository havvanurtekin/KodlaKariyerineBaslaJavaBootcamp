package com.example.javabootcampweek6.service;

import com.example.javabootcampweek6.entity.Passenger;
import com.example.javabootcampweek6.entity.Plane;
import com.example.javabootcampweek6.repository.PassengerRepository;
import com.example.javabootcampweek6.repository.PlaneRepository;
import com.example.javabootcampweek6.requestDTO.PassengerSaveRequestDTO;
import com.example.javabootcampweek6.responseDTO.PassengerResponseDTO;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//passenger service katmanı
@Service
public class PassengerService {
    //autowired repositories
    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    PlaneRepository planeRepository;
    //passenger kaydedip id'sini döndüren fonksiyon
    public Integer savePassenger(PassengerSaveRequestDTO passengerSaveRequestDTO){
        //dto verilerini kaydet
        int ageRequestDTO = passengerSaveRequestDTO.getAge();
        String genderRequestDTO = passengerSaveRequestDTO.getGender();
        double suitcaseWeightRequestDTO = passengerSaveRequestDTO.getSuitcaseWeight();
        int seatNoRequestDTO = passengerSaveRequestDTO.getSeatNo();
        boolean isBusinessRequestDTO = passengerSaveRequestDTO.isBusiness();
        LocalDate flightDateRequestDTO= passengerSaveRequestDTO.getFlightDate();
        LocalDate ticketPurchaseDateRequestDTO = passengerSaveRequestDTO.getTicketPurchaseDate();

        //passenger oluştur
        Passenger passenger = new Passenger();

        //dto verilerini passengera aktar
        passenger.setAge(ageRequestDTO);
        passenger.setGender(genderRequestDTO);
        passenger.setBusiness(isBusinessRequestDTO);
        passenger.setSuitcaseWeight(suitcaseWeightRequestDTO);
        passenger.setSeatNo(seatNoRequestDTO);
        passenger.setFlightDate(flightDateRequestDTO);
        passenger.setTicketPurchaseDate(ticketPurchaseDateRequestDTO);

        //passenger'ı kaydet
        passenger = passengerRepository.save(passenger);
        //id'sini döndür
        return passenger.getPassengerId();
    }

    //uçak idsi ile tüm yolcuları bulan fonksiyon
    public List<PassengerResponseDTO> findAllPassengersByPlaneId(Integer planeId) {
        //id'den uçağı bul
        Plane plane = planeRepository.findById(planeId).get();
        //uçaktan yolcu listesini bul
        List<Passenger> allPassengers = passengerRepository.findAllByPlane(plane);
        //dto arraylist oluştur
        List<PassengerResponseDTO> passengerResponseDTOS = new ArrayList<>();
        //modelmapper oluştur
        ModelMapper mapper = new ModelMapper();
        //listedeki yolcuları tek tek dto listesine aktar
        for(Passenger passenger : allPassengers){
            PassengerResponseDTO passengerResponseDTO = mapper.map(passenger, PassengerResponseDTO.class);
            passengerResponseDTOS.add(passengerResponseDTO);
        }
        //dto listesini döndür
        return passengerResponseDTOS;
    }
    //idsi bilinen yolcuyu sil
    public boolean deletePassengerById(Integer passengerId) {
        //id'den yolcuyu bul
        Passenger passenger = passengerRepository.findById(passengerId).get();
        //sil
        passengerRepository.delete(passenger);
        //silinirse true döndür
        return true;
    }
}
