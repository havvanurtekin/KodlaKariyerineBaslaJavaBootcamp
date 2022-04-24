package com.example.javabootcampweek4.entity;

import com.example.javabootcampweek4.IAbroadFoodChoise;

import javax.persistence.Entity;
import java.time.LocalDate;
import java.time.Period;

//thy uçağının entity classı
@Entity
public class THY extends Plane implements IAbroadFoodChoise {
    //belirlenen bilet ücreti
    double ticketFare = 170;

    //uçakta kalan yer sayısını hesaplayan fonksiyon
    @Override
    public int remainderCapacity(int personCount) {
        //kalan yolcu sayısı
        int remainder  = super.getCapacity() - super.getPassengerCount();
        //doluluğu kontrol eden fonksiyon
        if(!this.isItFull()) {
            //eğer kalan yolcu sayısı talep edilen yolcu sayısından büyükse
            if(personCount <= remainder) {

                System.out.println("Yeterli alan var!");
                return 1;
            }else {//değilse
                System.out.println("Yeterli alan yok! Son "+ remainder +" ki�i...");
                return -1;
            }
        }else {//uçak full doluysa
            System.out.println("Bilet Alımı Kapanmıştır!");
            return -1;
        }
    }

    //uçak dolu mu
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
        int result = this.remainderCapacity(personCount);
        if(result >= 0)
            return personCount * super.getFare();
        else
            return 0;
    }
    //bilet alımı üzerinden kaç gün geçtiğini hesaplayan fonksiyon
    @Override
    public int lastDayCalculation(LocalDate ticketPurchaseDate) {
        LocalDate now = LocalDate.now();//şimdi
        Period diff = Period.between(ticketPurchaseDate, now);//şimdi ile geçmiş farkı

        System.out.print( "Tarih Fark� ");

        System.out.printf("%d y�l, %d ay"  + " ve %d g�n ", diff.getYears(), diff.getMonths(), diff.getDays());
        //fark 3 günden büyükse
        if(diff.getMonths() != 0 || diff.getYears() != 0 || diff.getDays() > 3) {
            System.out.println("Bilet iptal edemezsiniz!");
            return -1;
        }else {//değilse
            System.out.println("Bilet iptal ediliyor...");
            return 1;
        }
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
