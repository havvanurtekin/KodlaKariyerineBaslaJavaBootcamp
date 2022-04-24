package com.example.javabootcampweek6.responseDTO;

import lombok.Data;

import java.time.LocalDate;

//passenger cevap için oluşturulan ön dto
@Data
public class PassengerResponseDTO {
    int age;

    String gender;

    boolean isBusiness;

    int suitcaseWeight;

    int seatNo;

    LocalDate flightDate;

    LocalDate ticketPurchaseDate;
}
