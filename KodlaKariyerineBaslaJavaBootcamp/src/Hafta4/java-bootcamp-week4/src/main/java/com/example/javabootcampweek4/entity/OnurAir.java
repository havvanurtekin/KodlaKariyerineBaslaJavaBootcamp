package com.example.javabootcampweek4.entity;

import com.example.javabootcampweek4.IAbroadFoodChoise;

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
    //yolcu listesi
    List<Passenger> passengers = new ArrayList<Passenger>();

    //uçakta kalan yer sayısını hesaplayan fonksiyon
    @Override
    public int remainderCapacity(int personCount) {
        //kalan yolcu sayıs
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
//uçağın dolu olup olmadığını kontrol eden fonksiyon
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
       //toplam bilet ücreti
        double totalTicketFare = 0;
        //talep edilen kişi sayısının genel bilet tutarı
        double fare = super.getFare()*personCount;
        //eğer bilet tutarı 0 değilse
        if(fare != 0) {
            //herkes için tek tek bilet fiyatını hesapla
            for(int i = 0; i < personCount; i++) {
                //yolcuyu al
                Passenger passenger = super.getPassenger();
                //biletini hesapla
                ticketFare = ticketFare(ticketFare, passenger);
                //toplama ekle
                totalTicketFare += ticketFare;
                System.out.println("Passenger id: "+passenger.getPassengerId());
                //listeye ekle
                passengers.add(passenger);
                passengerCount += 1;
            }
        }
        //toplamı döndür
        return totalTicketFare;
    }
    //bilet alımı üzerinden kaç gün geçtiğini hesaplayan fonksiyon
    @Override
    public int lastDayCalculation(LocalDate ticketPurchaseDate) {

        LocalDate now = LocalDate.now();//şimdi
        Period diff = Period.between(ticketPurchaseDate, now);//şimdinin geçmişle farkı

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

    //ki�isel bilet �creti
    public double ticketFare(double fare, Passenger passenger) {
        //valiz ağırlığına göre
        if(passenger.getSuitcaseWeight()>25) {
            fare += fare * (50 / 100);
            //business mı
        }else if(passenger.isBusiness()) {
            fare += 200;
        }
        //ücreti dön
        return fare;
    }


}


