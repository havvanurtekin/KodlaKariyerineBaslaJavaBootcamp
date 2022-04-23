package com.example.javabootcampweek4.entity;

import com.example.javabootcampweek4.IAbroadFoodChoise;

import javax.persistence.Entity;
import java.time.LocalDate;
import java.time.Period;
import java.util.Iterator;

@Entity
public class THY extends Plane implements IAbroadFoodChoise {
    double ticketFare = 170;
    boolean isCurrentPassengerBusiness;
    @Override
    public int remainderCapacity(int personCount) {
        int remainder  = super.getCapacity() - super.getPassengerCount();
        if(!this.isItFull()) {
            if(personCount <= remainder) {

                System.out.println("Yeterli alan var!");
                return 1;
            }else {
                System.out.println("Yeterli alan yok! Son "+ remainder +" ki�i...");
                return -1;
            }
        }else {
            System.out.println("Bilet Alımı Kapanmıştır!");
            return -1;
        }
    }

    @Override
    public boolean isItFull() {
        if(super.getPassengerCount() < super.getCapacity()) {
            return false;
        }else {
            return true;
        }
    }

    @Override
    public double takeTicket(int personCount) {
        int result = this.remainderCapacity(personCount);
        if(result >= 0)
            return personCount * super.getFare();
        else
            return 0;
    }

    @Override
    public int lastDayCalculation(LocalDate ticketPurchaseDate) {
        LocalDate now = LocalDate.now();
        Period diff = Period.between(ticketPurchaseDate, now);

        System.out.print( "Tarih Fark� ");

        System.out.printf("%d y�l, %d ay"  + " ve %d g�n ", diff.getYears(), diff.getMonths(), diff.getDays());
        if(diff.getMonths() != 0 || diff.getYears() != 0 || diff.getDays() > 3) {
            System.out.println("Bilet iptal edemezsiniz!");
            return -1;
        }else {
            System.out.println("Bilet iptal ediliyor...");
            return 1;
        }
    }

    @Override
    public void removePassenger(int passengerId) {
        Iterator<Passenger> iterator = passengers.iterator();
        while(iterator.hasNext()){
            System.out.println("s");
            Passenger p = iterator.next();
            LocalDate past = p.getDate();
            System.out.println("ss");
            if(p.getPassengerId() == passengerId) {

                int t = lastDayCalculation(past);
                if(t < 0)
                    System.out.println("Bileti iptal edemezsiniz!");
                else {
                    passengers.remove(p);
                    passengerCount -= 1;
                    System.out.println("Biletiniz iptal edildi!");
                    break;
                }
            }
        }
    }

    @Override
    public void foodChoise(Passenger passenger) {

        if(isCurrentPassengerBusiness) {
            System.out.println("THY business yolcular�na yemek ikram�nda bulunur.");
        }else {
            System.out.println("THY economy yolcular�na i�ecek ikram�nda bulunur.");
        }
    }
}
