/**
 * 
 */
package Hafta3.Odev.AirlineCompany;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import Hafta3.Odev.Passenger.Business;
import Hafta3.Odev.Passenger.Economy;
import Hafta3.Odev.Passenger.Passenger;

/**
 * @author SAYIN BACI
 *
 */

public abstract class Plane {
    int passengerCount;
    int capacity;
    int fare;
    Scanner sc = new Scanner(System.in);
    List <Passenger>passengers = new ArrayList<Passenger>();
   
    public int takeTicket(int personCount){
    	if(!this.isItFull()) {
    		int remainder = remainderCapacity();
    		if(personCount <= remainder) {
    			int count = createPassenger(personCount);
    			if(count < 0) {
    				System.out.println("Biletleriniz alýnamamýþtýr!");
    				return 0;
    			}
    			int ticketFare = personCount * fare;
    	        
    	        System.out.println("Biletleriniz alýnmýþtýr!");
    	        return ticketFare;
    		}else {
    			System.out.println("Yeterli alan yok! Son "+ remainder +" kiþi...");
    			return 0;
    		}
    	}else{
    		System.out.println("Bilet alýmlarý bitmiþtir!");
    		return 0;
    	}
    }
    
    public Date date() {
    	System.out.println("Gün giriniz: ");
    	int day = sc.nextInt();
    	System.out.println("Ay giriniz: ");
    	int month = sc.nextInt();
    	System.out.println("Yýl giriniz: ");
    	int year = sc.nextInt();
    	Calendar calendar = new GregorianCalendar(year, month, day);
        Date date = calendar.getTime();
        return date;
    }
    
    public int createPassenger(int personCount) {
    	int seatNo = 1;
    	Date date = date();
    	
    	for(int i = 0; i < personCount; i++) {	
    		System.out.println(i+". Passenger: ");
    		System.out.println("Yaþýnýz: ");
    		int age = sc.nextInt();
    		System.out.println("Valiz Aðýrlýðý: ");
    		double suitcaseWeight = sc.nextDouble();
    		System.out.println("Cinsiyetiniz(K/E): ");
    		String gender = sc.next();
    		if(!gender.equals("K") && !gender.equals("E")) {
   				System.out.println("Yanlýþ karakter seçimi!");
   				return -1;
   			}	
    		System.out.println("Ekonomi için E, Business için B: ");
    		String flyingType = sc.next();
    		if(flyingType.equals("E") ) {
    			Passenger passenger = new Economy(age, suitcaseWeight, gender, seatNo, date);
    			passengers.add(passenger);
    			passengerCount += 1;
    		}else if(flyingType.equals("B")) {
    			Passenger passenger = new Business(age, suitcaseWeight, gender, seatNo, date);
    			passengers.add(passenger);
    			passengerCount += 1;
    		}else {
    			System.out.println("Yanlýþ karakter seçimi!");
    			return -1;
    		}
    	
    	}
    	return 1;
    }
    
    public boolean isPassengerBusiness(String flyingType) {
    	if(flyingType.equals("B")) {
    		return true;
    	}else if(flyingType.equals("E")) {
    		
    		return false;
    	}else {
    		System.out.println("Yanlýþ karakter seçimi!");
    		return false;
    	}
    }
    
    public void removePassenger(int seatNo) {
    	Iterator<Passenger> iterator = passengers.iterator();
    	
        Date now = new Date();
        
        System.out.println();
    	while(iterator.hasNext()){
    		  
    	      if(iterator.next().getSeatNo()== seatNo) {
    	    	  long time = iterator.next().getDate().getTime() - now.getTime();
    	    	  if(time > 3) {
    	    		  System.out.println("Bileti iptal edemezsiniz!");
    	    	  }else {
    	    		  passengers.remove(iterator.next());
    	    	      passengerCount -= 1;
    	    	      System.out.println("Biletiniz iptal edildi!");
    	    	  }
    	        
    	      }
    	}
    }

    public int remainderCapacity() {
    	int remainder  = this.getCapacity() - this.getPassengerCount();
    	return remainder;
    }
    
    public boolean isItFull() {
    	if(this.getPassengerCount() < this.getCapacity()) {	
    		return false;
    	}else {
    		return true;
    	}
    }

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