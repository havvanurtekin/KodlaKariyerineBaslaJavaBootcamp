package com.example.javabootcampweek6.entity;

import com.example.javabootcampweek6.IAbroadFoodChoise;

import javax.persistence.Entity;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

//onur air uçağının entity classı
@Entity
public class OnurAir extends Plane implements IAbroadFoodChoise {
    //belirlenen bilet ücreti
    double ticketFare = 150;

    @Override
    public void setPassengers(Passenger passenger) {
        this.passengers.add(passenger);
    }

    //yolcu listesi
    List<Passenger> passengers = new ArrayList<Passenger>();




    //yemek se�ene�i
    @Override
    public void foodChoise(Passenger passenger) {
        // TODO Auto-generated method stub
        //cinsiyete göre
        if(passenger.getGender().equals("K"))
            System.out.println("�ikolata hediyesi");
        else
            System.out.println("yemek se�en�i yok");

    }




}


