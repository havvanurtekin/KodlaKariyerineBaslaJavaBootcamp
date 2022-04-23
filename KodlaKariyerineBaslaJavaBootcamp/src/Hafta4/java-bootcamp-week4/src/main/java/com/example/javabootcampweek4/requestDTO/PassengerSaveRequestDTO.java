package com.example.javabootcampweek4.requestDTO;

import lombok.Data;

@Data
public class PassengerSaveRequestDTO {

    private int age;

    private int suitcaseWeight;

    private int seatNo;

    private boolean isBusiness;

    private String gender;


}
