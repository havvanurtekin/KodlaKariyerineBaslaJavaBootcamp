package com.example.javabootcampweek5.responseDTO;

import lombok.Data;

//plane cevap için oluşturulan ön dto
@Data
public class PlaneResponseDTO {
    private double fare;

    private int capacity;
}
