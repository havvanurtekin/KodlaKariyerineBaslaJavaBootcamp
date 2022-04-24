package com.example.javabootcampweek6.service;

import com.example.javabootcampweek6.converter.PlaneConverter;
import com.example.javabootcampweek6.entity.*;
import com.example.javabootcampweek6.repository.PassengerRepository;
import com.example.javabootcampweek6.repository.PlaneRepository;
import com.example.javabootcampweek6.requestDTO.PlaneSaveRequestDTO;
import com.example.javabootcampweek6.responseDTO.PassengerResponseDTO;
import com.example.javabootcampweek6.responseDTO.PlaneResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

//plane service katmanı
@Service
public class PlaneService {
    //autowired repository and converter
    @Autowired
    PlaneRepository planeRepository;

    @Autowired
    PlaneConverter planeConverter;

    @Autowired
    PassengerRepository passengerRepository;
    /** -----------------------------saving methods----------------------------*/
    //thy uçağı kaydedip id'sini döndüren fonksiyon
    public Integer saveTHY(PlaneSaveRequestDTO planeSaveRequestDTO) {
        //dto'dan thy'ye convert et
        THY thyPlane = planeConverter.convertFromPlaneSaveRequestDTOToTHY(planeSaveRequestDTO);
        //kaydet
        thyPlane = planeRepository.save(thyPlane);
        //id'sini döndür
        return thyPlane.getPlaneId();

    }
    //pegasus uçağı kaydedip id'sini döndüren fonksiyon
    public Integer savePegasus(PlaneSaveRequestDTO planeSaveRequestDTO){
        //dto'dan pegasusa convert et
        Pegasus pegasusPlane = planeConverter.convertFromPlaneSaveRequestDTOToPegasus(planeSaveRequestDTO);
        //kaydet
        pegasusPlane = planeRepository.save(pegasusPlane);
        //id'sini döndür
        return pegasusPlane.getPlaneId();
    }
    //onur air uçağı kaydedip id'sini döndüren fonksiyon
    public Integer saveOnurAir(PlaneSaveRequestDTO planeSaveRequestDTO){
        //dto'dan onur aira convert et
        OnurAir onurAirPlane = planeConverter.convertFromPlaneSaveRequestDTOToOnurAir(planeSaveRequestDTO);
       //kaydet
        onurAirPlane = planeRepository.save(onurAirPlane);
        //id'sini döndür
        return onurAirPlane.getPlaneId();
    }
    /** -----------------------------remainder capacity methods----------------------------*/
    //uçakta kalan kapasitede yeterli alan var mı kontrol eder
    public int remainderCapacityOnurAir(PlaneResponseDTO planeResponseDTO) {
        //dto'dan onur aira convert et
        OnurAir onurAirPlane = planeConverter.convertFromPlaneResponseDTOToOnurAir(planeResponseDTO);
        //kalan yolcu sayıs
        int remainder  = onurAirPlane.getCapacity() - onurAirPlane.getPassengerCount();

        return remainder;
    }

    public int isThereEnoughSeatOnurAir(int personCount,PlaneResponseDTO planeResponseDTO ){
        int remainder = remainderCapacityOnurAir(planeResponseDTO);
        //doluluğu kontrol eden fonksiyon
        if(!this.isItFull(remainder)) {
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

    //uçakta kalan kapasitede yeterli alan var mı kontrol eder
    public int remainderCapacityPegasus(PlaneResponseDTO planeResponseDTO) {
        //dto'dan onur aira convert et
        Pegasus pegasusPlane = planeConverter.convertFromPlaneResponseDTOToPegasus(planeResponseDTO);
        //kalan yolcu sayıs
        int remainder  = pegasusPlane.getCapacity() - pegasusPlane.getPassengerCount();

        return remainder;
    }

    public int isThereEnoughSeatPegasus(int personCount,PlaneResponseDTO planeResponseDTO ){
        int remainder = remainderCapacityPegasus(planeResponseDTO);
        //doluluğu kontrol eden fonksiyon
        if(!this.isItFull(remainder)) {
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

    //uçakta kalan kapasitede yeterli alan var mı kontrol eder
    public int remainderCapacityTHY(PlaneResponseDTO planeResponseDTO) {
        //dto'dan onur aira convert et
        THY thyPlane = planeConverter.convertFromPlaneResponseDTOToTHY(planeResponseDTO);
        //kalan yolcu sayıs
        int remainder  = thyPlane.getCapacity() - thyPlane.getPassengerCount();

        return remainder;
    }

    public int isThereEnoughSeatTHY(int personCount,PlaneResponseDTO planeResponseDTO ){
        int remainder = remainderCapacityTHY(planeResponseDTO);
        //doluluğu kontrol eden fonksiyon
        if(!this.isItFull(remainder)) {
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


    public boolean isItFull(int remainder) {
        if(remainder > 0) {
            return false;
        }else {
            return true;
        }
    }

    /** -----------------------------food choise methods----------------------------*/

    //yemek seçimi
    public void foodChoiseTHY(int passengerId) {
        //id'den yolcuyu bul
        Passenger passenger = passengerRepository.findById(passengerId).get();
        //business mı
        if(passenger.isBusiness()) {
            System.out.println("THY business yolcular�na yemek ikram�nda bulunur.");
        }else {//değil mi
            System.out.println("THY economy yolcular�na i�ecek ikram�nda bulunur.");
        }
    }

    //yemek se�ene�i
    public void foodChoisePegasus() {
        System.out.println("Pegasus et �r�nleri ikram�nda bulunur.");
    }

    //yemek se�ene�i
    public void foodChoiseOnurAir(int passengerId) {
        Passenger passenger = passengerRepository.findById(passengerId).get();
        //cinsiyete göre
        if(passenger.getGender().equals("K"))
            System.out.println("�ikolata hediyesi");
        else
            System.out.println("yemek se�en�i yok");

    }
    /** -----------------------------take ticket methods----------------------------*/

    //bilet alma
    public double takeTicketOnurAir(int personCount, PlaneResponseDTO planeResponseDTO) {
        double ticketFare = 150;
        //toplam bilet ücreti
        double totalTicketFare = 0;
        OnurAir onurAirPlane = planeConverter.convertFromPlaneResponseDTOToOnurAir(planeResponseDTO);
        //talep edilen kişi sayısının genel bilet tutarı
        double fare = onurAirPlane.getFare()*personCount;
        //eğer bilet tutarı 0 değilse
        if(fare != 0) {
            //herkes için tek tek bilet fiyatını hesapla
            for(int i = 0; i < personCount; i++) {
                //yolcuyu al
                Passenger passenger = onurAirPlane.getPassenger();
                //biletini hesapla
                ticketFare = ticketFareOnurAir(ticketFare, passenger);
                //toplama ekle
                totalTicketFare += ticketFare;
                System.out.println("Passenger id: "+passenger.getPassengerId());
                //listeye ekle
                onurAirPlane.setPassengers(passenger);
                onurAirPlane.setPassengerCount(onurAirPlane.getPassengerCount()+1);
            }
        }
        //toplamı döndür
        return totalTicketFare;
    }

    //ki�isel bilet �creti
    public double ticketFareOnurAir(double fare, Passenger passenger) {
        //valiz ağırlığına göre
        if(passenger.getSuitcaseWeight()>25) {
            fare += fare * (50 / 100);
            //business mı
        }
        if(passenger.isBusiness()) {
            fare += 200;
        }
        //ücreti dön
        return fare;
    }

    //bilet alma metodu
    public double takeTicketPegasus(int personCount, PlaneResponseDTO planeResponseDTO) {
        double ticketFare = 200;
        //toplam bilet ücreti
        double totalTicketFare = 0;
        //talep edilen kişi sayısının genel bilet tutarı
        Pegasus pegasusPlane = planeConverter.convertFromPlaneResponseDTOToPegasus(planeResponseDTO);
        //talep edilen kişi sayısının genel bilet tutarı
        double fare = pegasusPlane.getFare()*personCount;
        //eğer bilet tutarı 0 değilse
        if(fare != 0) {
            //herkes için tek tek bilet fiyatını hesapla
            for(int i = 0; i < personCount; i++) {
                //yolcuyu al
                Passenger passenger = pegasusPlane.getPassenger();
                //biletini hesapla
                ticketFare = ticketFareOnurAir(ticketFare, passenger);
                //toplama ekle
                totalTicketFare += ticketFare;
                System.out.println("Passenger id: "+passenger.getPassengerId());
                //listeye ekle
                pegasusPlane.setPassengers(passenger);
                pegasusPlane.setPassengerCount(pegasusPlane.getPassengerCount()+1);
            }
        }
        //toplamı döndür
        return totalTicketFare;
    }


    //ki�isel bilet �creti belirleme
    public double ticketFarePegasus(double fare, Passenger passenger) {
        //yaşa göre
        if(passenger.getAge()<13) {
            fare = fare * (90 / 100);
            //business mı
        }
        if(passenger.isBusiness()) {
            fare += 130;
        }
        return fare;
    }

    //bilet alma metodu
    public double takeTicketTHY(int personCount, PlaneResponseDTO planeResponseDTO) {
        //talep edilen kişi sayısının genel bilet tutarı
        THY thyPlane = planeConverter.convertFromPlaneResponseDTOToTHY(planeResponseDTO);
        int result = remainderCapacityTHY(planeResponseDTO);
        if(result >= 0)
            return personCount * thyPlane.getFare();
        else
            return 0;
    }
    /** ------------------------------last day calculations methods----------------------------*/

    //bilet alımı üzerinden kaç gün geçtiğini hesaplayan fonksiyon
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

}
