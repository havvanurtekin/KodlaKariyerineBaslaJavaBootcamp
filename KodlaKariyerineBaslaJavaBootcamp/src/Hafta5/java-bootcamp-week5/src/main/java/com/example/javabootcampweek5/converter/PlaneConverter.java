package com.example.javabootcampweek5.converter;

import com.example.javabootcampweek4.entity.OnurAir;
import com.example.javabootcampweek4.entity.Passenger;
import com.example.javabootcampweek4.entity.Pegasus;
import com.example.javabootcampweek4.entity.THY;
import com.example.javabootcampweek4.requestDTO.PlaneSaveRequestDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

//bu class dto verileri ile entity objesi oluşturur
@Component
public class PlaneConverter {
    //dto verilerinden thy objesi oluşturan fonksiyon
    public THY convertFromPlaneSaveRequestDTOToTHY(PlaneSaveRequestDTO planeSaveRequestDTO){
       //dto verilerini instance'lara atar
        int capacityRequestDTO = planeSaveRequestDTO.getCapacity();
        double fareRequestDTO = planeSaveRequestDTO.getFare();
        LocalDate flightDateRequestDTO = planeSaveRequestDTO.getFlightDate();
        int businessCapacityRequestDTO = planeSaveRequestDTO.getBusinessCapacity();
        LocalDate ticketPurchaseDateRequestDTO = planeSaveRequestDTO.getTicketPurchaseDate();

        //thy objesi oluştur
        THY thyPlane = new THY();

        //tüm verileri thy objesine ata
        thyPlane.setCapacity(capacityRequestDTO);
        thyPlane.setFare(fareRequestDTO);
        thyPlane.setFlightDate(flightDateRequestDTO);
        thyPlane.setTicketPurchaseDate(ticketPurchaseDateRequestDTO);
        thyPlane.setBusinessCapacity(businessCapacityRequestDTO);

        //thy objesini döndür
        return thyPlane;
    }
    //dto verilerinden pegasus objesi oluşturan fonksiyon
    public Pegasus convertFromPlaneSaveRequestDTOToPegasus(PlaneSaveRequestDTO planeSaveRequestDTO){
        //dto verilerini instance'lara atar
        int capacityRequestDTO = planeSaveRequestDTO.getCapacity();
        double fareRequestDTO = planeSaveRequestDTO.getFare();
        LocalDate flightDateRequestDTO = planeSaveRequestDTO.getFlightDate();
        int businessCapacityRequestDTO = planeSaveRequestDTO.getBusinessCapacity();
        LocalDate ticketPurchaseDateRequestDTO = planeSaveRequestDTO.getTicketPurchaseDate();

        //pegasus objesi oluştur
        Pegasus pegasusPlane = new Pegasus();

        //tüm verileri thy objesine ata
        pegasusPlane.setCapacity(capacityRequestDTO);
        pegasusPlane.setFare(fareRequestDTO);
        pegasusPlane.setFlightDate(flightDateRequestDTO);
        pegasusPlane.setTicketPurchaseDate(ticketPurchaseDateRequestDTO);
        pegasusPlane.setBusinessCapacity(businessCapacityRequestDTO);

        //pegasus objesini döndür
        return pegasusPlane;
    }

    //dto verilerinden onur air objesi oluşturan fonksiyon
    public OnurAir convertFromPlaneSaveRequestDTOToOnurAir(PlaneSaveRequestDTO planeSaveRequestDTO){
        //dto verilerini instance'lara atar
        int capacityRequestDTO = planeSaveRequestDTO.getCapacity();
        double fareRequestDTO = planeSaveRequestDTO.getFare();
        LocalDate flightDateRequestDTO = planeSaveRequestDTO.getFlightDate();
        int businessCapacityRequestDTO = planeSaveRequestDTO.getBusinessCapacity();
        LocalDate ticketPurchaseDateRequestDTO = planeSaveRequestDTO.getTicketPurchaseDate();

        //onur air objesi oluştur
        OnurAir onurAirPlane = new OnurAir();

        //tüm verileri thy objesine ata
        onurAirPlane.setCapacity(capacityRequestDTO);
        onurAirPlane.setFare(fareRequestDTO);
        onurAirPlane.setFlightDate(flightDateRequestDTO);
        onurAirPlane.setTicketPurchaseDate(ticketPurchaseDateRequestDTO);
        onurAirPlane.setBusinessCapacity(businessCapacityRequestDTO);

        //onur air objesini döndür
        return onurAirPlane;
    }

}
