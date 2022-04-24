package com.example.javabootcampweek6.responseDTO;

import lombok.Data;

import java.time.LocalDate;

//plane cevap için oluşturulan ön dto
@Data
public class PlaneResponseDTO {
    private double fare;

    private int capacity;

    private LocalDate flightDate;

    private LocalDate ticketPurchaseDate;

    private int passengerCount;

    private int businessCapacity;
}
