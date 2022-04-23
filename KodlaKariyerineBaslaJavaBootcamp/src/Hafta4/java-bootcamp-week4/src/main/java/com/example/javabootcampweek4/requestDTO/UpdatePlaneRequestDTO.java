package com.example.javabootcampweek4.requestDTO;


import lombok.Data;

import java.time.LocalDate;

@Data
public class UpdatePlaneRequestDTO {

    int planeId;

    LocalDate flightDate;
}
