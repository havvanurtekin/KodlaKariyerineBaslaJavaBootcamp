package com.example.javabootcampweek5.requestDTO;

import lombok.Data;


import java.time.LocalDate;

//passenger kayıt sorgusu için oluşturulan ön dto
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
