package com.example.javabootcampweek6.entity;

import com.example.javabootcampweek6.IAbroadFoodChoise;

import javax.persistence.Entity;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

//pegasus uçağının entity classı
@Entity
public class Pegasus extends Plane implements IAbroadFoodChoise {
    //bilet ücreti

    //yolcu listesi
    List<Passenger> passengersP = new ArrayList<Passenger>();

    //yemek se�ene�i
    @Override
    public void foodChoise(Passenger passenger) {
        System.out.println("Pegasus et �r�nleri ikram�nda bulunur.");
    }
}
