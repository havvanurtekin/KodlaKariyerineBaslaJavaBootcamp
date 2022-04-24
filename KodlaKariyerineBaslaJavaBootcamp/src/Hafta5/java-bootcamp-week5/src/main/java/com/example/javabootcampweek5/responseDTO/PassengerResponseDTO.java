package com.example.javabootcampweek5.responseDTO;

import lombok.Data;

//passenger cevap için oluşturulan ön dto
@Data
public class PassengerResponseDTO {
    int age;

    String gender;

    long passengerId;

    boolean isBusiness;
}
