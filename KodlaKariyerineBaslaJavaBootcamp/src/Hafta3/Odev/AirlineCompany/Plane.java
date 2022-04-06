/**
 * 
 */
package Hafta3.Odev.AirlineCompany;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import Hafta3.Odev.Passenger.Passenger;

/**
 * @author SAYIN BACI
 *
 */

public abstract class Plane {
	//instances
    int passengerCount;
    int capacity;
    int fare;
    Scanner sc = new Scanner(System.in);
    List <Passenger>passengers = new ArrayList<Passenger>();
  
    //uçakta kalan kapasiteyi hesaplama
    public int remainderCapacity(int personCount) {
    	int remainder  = this.getCapacity() - this.getPassengerCount();
    	if(!this.isItFull()) {
			if(personCount <= remainder) {
				
				System.out.println("Yeterli alan var!");
			    return 1;
			}else {
				System.out.println("Yeterli alan yok! Son "+ remainder +" kiþi...");
				return -1;
			}
    	}else {
    		System.out.println("Bilet Alýmý Kapanmýþtýr!");
    		return -1;
    	}
    
    }
    
    //uçak dolu mu boþ mu
    public boolean isItFull() {
    	if(this.getPassengerCount() < this.getCapacity()) {	
    		return false;
    	}else {
    		return true;
    	}
    }
   
    //bilet alma
    public double takeTicket(int personCount){
    	int result = remainderCapacity(personCount);
    	if(result > 0)
    		
    		return fare;
    	else
    		return 0;
    	
    }
    
    //bilet alýnan tarihi kullanýcýdan alma
    public LocalDate date() {
    	System.out.println("Gün giriniz: ");
    	int day = sc.nextInt();
    	System.out.println("Ay giriniz: ");
    	int month = sc.nextInt();
    	System.out.println("Yýl giriniz: ");
    	int year = sc.nextInt();
    	LocalDate date = LocalDate.of(year, month, day); // 1988-07-16
       
       
        return date;
    }
    
 
    //yeni passenger oluþturma
    public Passenger newPassenger() {
    	LocalDate date = date();
		System.out.println("Yaþýnýz: ");
		int age = sc.nextInt();
		System.out.println("Valiz Aðýrlýðý: ");
		double suitcaseWeight = sc.nextDouble();
		System.out.println("Cinsiyetiniz(K/E): ");
		String gender = sc.next();	
		System.out.println("Ekonomi için E, Business için B: ");
		String flyingType = sc.next();	
		Passenger passenger = new Passenger(age, suitcaseWeight, gender, date, flyingType);
		return passenger;
    }
       
    //bilet alýnan günden iptal edilen güne kadar olan günü hesaplama
	public int lastDayCalculation(LocalDate past) {
    	
    	LocalDate now = LocalDate.now();
    	Period diff = Period.between(past, now);
    	 
        System.out.print( "Tarih Farký ");
   
        System.out.printf("%d yýl, %d ay"  + " ve %d gün ", diff.getYears(), diff.getMonths(), diff.getDays());
        if(diff.getMonths() != 0 || diff.getYears() != 0 || diff.getDays() > 3) {
        	System.out.println("Bilet iptal edemezsiniz!");
        	return -1;
        }else {
        	System.out.println("Bilet iptal ediliyor...");
        	return 1;
        }
    
    }
    //yolcu silme
    public void removePassenger(int id) {
    	Iterator<Passenger> iterator = passengers.iterator();
     	while(iterator.hasNext()){
    		System.out.println("s");
    		Passenger p = iterator.next();
    		  LocalDate past = p.getDate();
    		  System.out.println("ss");
    	      if(p.getId() == id) {
    	    	  
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

    //getters and setters
	public int getPassengerCount() {
        return passengerCount;
    }

    public void setPassengerCount(int passengerCount) {
        this.passengerCount = passengerCount;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getFare() {
        return fare;
    }

    public void setFare(int fare) {
        this.fare = fare;
    }
}