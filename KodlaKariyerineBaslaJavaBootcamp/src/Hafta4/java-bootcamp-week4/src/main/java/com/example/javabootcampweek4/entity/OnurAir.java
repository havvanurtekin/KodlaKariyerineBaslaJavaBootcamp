package com.example.javabootcampweek4.entity;

import com.example.javabootcampweek4.IAbroadFoodChoise;

import javax.persistence.Entity;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Entity
public class OnurAir extends Plane implements IAbroadFoodChoise {

    double ticketFare = 150;
    List<Passenger> passengers = new ArrayList<Passenger>();

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

    //bilet alma
    @Override
    public double takeTicket(int personCount) {
        // TODO Auto-generated method stub
        double totalTicketFare = 0;
        double fare = super.getFare()*personCount;
        if(fare != 0) {
            for(int i = 0; i < personCount; i++) {

                Passenger passenger = super.getPassenger();
                ticketFare = ticketFare(ticketFare, passenger);
                totalTicketFare += ticketFare;
                System.out.println("Passenger id: "+passenger.getPassengerId());
                passengers.add(passenger);
                passengerCount += 1;
            }
        }

        return totalTicketFare;
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
            LocalDate past = p.getTicketPurchaseDate();
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


    //yemek se�ene�i
    @Override
    public void foodChoise(Passenger passenger) {
        // TODO Auto-generated method stub
        if(passenger.getGender().equals("K"))
            System.out.println("�ikolata hediyesi");
        else
            System.out.println("yemek se�en�i yok");

    }

    //ki�isel bilet �creti
    public double ticketFare(double fare, Passenger passenger) {

        if(passenger.getSuitcaseWeight()>25) {
            fare += fare * (50 / 100);
        }else if(passenger.isBusiness()) {
            fare += 200;
        }
        return fare;
    }


}


