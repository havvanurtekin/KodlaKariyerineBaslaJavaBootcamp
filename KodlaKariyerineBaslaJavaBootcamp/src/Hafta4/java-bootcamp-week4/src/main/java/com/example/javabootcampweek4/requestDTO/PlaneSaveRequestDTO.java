package com.example.javabootcampweek4.requestDTO;

import com.example.javabootcampweek4.entity.Passenger;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//plane kayıt sorgusu için oluşturulan ön dto
@Data
public class PlaneSaveRequestDTO {
    private double fare;

    private int capacity;

    private LocalDate flightDate;

    private LocalDate ticketPurchaseDate;

    private int passengerCount;

    private int businessCapacity;



}
