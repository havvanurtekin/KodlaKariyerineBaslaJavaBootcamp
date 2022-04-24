package com.example.javabootcampweek4.requestDTO;

import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDate;

@Data
public class PassengerSaveRequestDTO {

    private int age;

    private int suitcaseWeight;

    private int seatNo;

    private boolean isBusiness;

    private LocalDate flightDate;

    private LocalDate ticketPurchaseDate;

    private String gender;


}
