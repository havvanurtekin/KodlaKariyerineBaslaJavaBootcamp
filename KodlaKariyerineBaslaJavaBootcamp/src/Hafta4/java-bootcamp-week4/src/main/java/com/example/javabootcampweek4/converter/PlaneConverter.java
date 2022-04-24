package com.example.javabootcampweek4.converter;

import com.example.javabootcampweek4.entity.OnurAir;
import com.example.javabootcampweek4.entity.Passenger;
import com.example.javabootcampweek4.entity.Pegasus;
import com.example.javabootcampweek4.entity.THY;
import com.example.javabootcampweek4.requestDTO.PlaneSaveRequestDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class PlaneConverter {
    public THY convertFromPlaneSaveRequestDTOToTHY(PlaneSaveRequestDTO planeSaveRequestDTO){
        int capacityRequestDTO = planeSaveRequestDTO.getCapacity();
        double fareRequestDTO = planeSaveRequestDTO.getFare();
        LocalDate flightDateRequestDTO = planeSaveRequestDTO.getFlightDate();
        int businessCapacityRequestDTO = planeSaveRequestDTO.getBusinessCapacity();
        LocalDate ticketPurchaseDateRequestDTO = planeSaveRequestDTO.getTicketPurchaseDate();

        THY thyPlane = new THY();

        thyPlane.setCapacity(capacityRequestDTO);
        thyPlane.setFare(fareRequestDTO);
        thyPlane.setFlightDate(flightDateRequestDTO);
        thyPlane.setTicketPurchaseDate(ticketPurchaseDateRequestDTO);
        thyPlane.setBusinessCapacity(businessCapacityRequestDTO);
        return thyPlane;
    }

    public Pegasus convertFromPlaneSaveRequestDTOToPegasus(PlaneSaveRequestDTO planeSaveRequestDTO){
        int capacityRequestDTO = planeSaveRequestDTO.getCapacity();
        double fareRequestDTO = planeSaveRequestDTO.getFare();
        LocalDate flightDateRequestDTO = planeSaveRequestDTO.getFlightDate();
        int businessCapacityRequestDTO = planeSaveRequestDTO.getBusinessCapacity();
        LocalDate ticketPurchaseDateRequestDTO = planeSaveRequestDTO.getTicketPurchaseDate();
        Pegasus pegasusPlane = new Pegasus();

        pegasusPlane.setCapacity(capacityRequestDTO);
        pegasusPlane.setFare(fareRequestDTO);
        pegasusPlane.setFlightDate(flightDateRequestDTO);
        pegasusPlane.setTicketPurchaseDate(ticketPurchaseDateRequestDTO);
        pegasusPlane.setBusinessCapacity(businessCapacityRequestDTO);
        return pegasusPlane;
    }
    public OnurAir convertFromPlaneSaveRequestDTOToOnurAir(PlaneSaveRequestDTO planeSaveRequestDTO){
        int capacityRequestDTO = planeSaveRequestDTO.getCapacity();
        double fareRequestDTO = planeSaveRequestDTO.getFare();
        LocalDate flightDateRequestDTO = planeSaveRequestDTO.getFlightDate();
        int businessCapacityRequestDTO = planeSaveRequestDTO.getBusinessCapacity();
        LocalDate ticketPurchaseDateRequestDTO = planeSaveRequestDTO.getTicketPurchaseDate();

        OnurAir onurAirPlane = new OnurAir();

        onurAirPlane.setCapacity(capacityRequestDTO);
        onurAirPlane.setFare(fareRequestDTO);
        onurAirPlane.setFlightDate(flightDateRequestDTO);
        onurAirPlane.setTicketPurchaseDate(ticketPurchaseDateRequestDTO);
        onurAirPlane.setBusinessCapacity(businessCapacityRequestDTO);
        return onurAirPlane;
    }

}
