package com.example.javabootcampweek6.entity;

import com.example.javabootcampweek6.IAbroadFoodChoise;

import javax.persistence.Entity;
import java.time.LocalDate;
import java.time.Period;

//thy uçağının entity classı
@Entity
public class THY extends Plane implements IAbroadFoodChoise {
    //belirlenen bilet ücreti
    double ticketFare = 170;

    public void setPassengers(Passenger passenger) {
        this.passengers.add(passenger);
    }

//yemek seçimi
    @Override
    public void foodChoise(Passenger passenger) {
        //business mı
        if(passenger.isBusiness()) {
            System.out.println("THY business yolcular�na yemek ikram�nda bulunur.");
        }else {//değil mi
            System.out.println("THY economy yolcular�na i�ecek ikram�nda bulunur.");
        }
    }
}
