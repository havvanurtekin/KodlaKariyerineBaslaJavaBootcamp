package com.example.javabootcampweek6.converter;

import com.example.javabootcampweek6.entity.OnurAir;
import com.example.javabootcampweek6.entity.Passenger;
import com.example.javabootcampweek6.entity.Pegasus;
import com.example.javabootcampweek6.entity.THY;
import com.example.javabootcampweek6.requestDTO.PlaneSaveRequestDTO;
import com.example.javabootcampweek6.responseDTO.PlaneResponseDTO;
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

    //dto verilerinden thy objesi oluşturan fonksiyon
    public THY convertFromPlaneResponseDTOToTHY(PlaneResponseDTO planeResponseDTO){
        //dto verilerini instance'lara atar
        int capacityResponseDTO = planeResponseDTO.getCapacity();
        double fareResponseDTO = planeResponseDTO.getFare();
        LocalDate flightDateResponseDTO = planeResponseDTO.getFlightDate();
        int businessCapacityResponseDTO = planeResponseDTO.getBusinessCapacity();
        LocalDate ticketPurchaseDateResponseDTO = planeResponseDTO.getTicketPurchaseDate();

        //thy objesi oluştur
        THY thyPlane = new THY();

        //tüm verileri thy objesine ata
        thyPlane.setCapacity(capacityResponseDTO);
        thyPlane.setFare(fareResponseDTO);
        thyPlane.setFlightDate(flightDateResponseDTO);
        thyPlane.setTicketPurchaseDate(ticketPurchaseDateResponseDTO);
        thyPlane.setBusinessCapacity(businessCapacityResponseDTO);

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

    //dto verilerinden pegasus objesi oluşturan fonksiyon
    public Pegasus convertFromPlaneResponseDTOToPegasus(PlaneResponseDTO planeResponseDTO){
        //dto verilerini instance'lara atar
        int capacityResponseDTO = planeResponseDTO.getCapacity();
        double fareResponseDTO = planeResponseDTO.getFare();
        LocalDate flightDateResponseDTO = planeResponseDTO.getFlightDate();
        int businessCapacityResponseDTO = planeResponseDTO.getBusinessCapacity();
        LocalDate ticketPurchaseDateResponseDTO = planeResponseDTO.getTicketPurchaseDate();

        //thy objesi oluştur
        Pegasus pegasusPlane = new Pegasus();

        //tüm verileri thy objesine ata
        pegasusPlane.setCapacity(capacityResponseDTO);
        pegasusPlane.setFare(fareResponseDTO);
        pegasusPlane.setFlightDate(flightDateResponseDTO);
        pegasusPlane.setTicketPurchaseDate(ticketPurchaseDateResponseDTO);
        pegasusPlane.setBusinessCapacity(businessCapacityResponseDTO);

        //thy objesini döndür
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

    //dto verilerinden onur air objesi oluşturan fonksiyon
    public OnurAir convertFromPlaneResponseDTOToOnurAir(PlaneResponseDTO planeResponseDTO){
        //dto verilerini instance'lara atar
        int capacityResponseDTO = planeResponseDTO.getCapacity();
        double fareResponseDTO = planeResponseDTO.getFare();
        LocalDate flightDateResponseDTO = planeResponseDTO.getFlightDate();
        int businessCapacityResponseDTO = planeResponseDTO.getBusinessCapacity();
        LocalDate ticketPurchaseDateResponseDTO = planeResponseDTO.getTicketPurchaseDate();

        //thy objesi oluştur
        OnurAir onurAirPlane = new OnurAir();

        //tüm verileri thy objesine ata
        onurAirPlane.setCapacity(capacityResponseDTO);
        onurAirPlane.setFare(fareResponseDTO);
        onurAirPlane.setFlightDate(flightDateResponseDTO);
        onurAirPlane.setTicketPurchaseDate(ticketPurchaseDateResponseDTO);
        onurAirPlane.setBusinessCapacity(businessCapacityResponseDTO);

        //thy objesini döndür
        return onurAirPlane;
    }

}
