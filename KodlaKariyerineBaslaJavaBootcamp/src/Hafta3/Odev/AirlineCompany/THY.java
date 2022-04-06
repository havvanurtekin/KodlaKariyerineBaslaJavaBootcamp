/**
 * 
 */
package Hafta3.Odev.AirlineCompany;

import java.util.ArrayList;
import java.util.List;

import Hafta3.Odev.IAbroadFoodChoise;
import Hafta3.Odev.Passenger.Passenger;

/**
 * @author SAYIN BACI
 *
 */
public class THY extends Plane implements IAbroadFoodChoise{

	//instances
	double ticketFare = 170;
	boolean isCurrentPassengerBusiness;
    List <Passenger>passengersT = new ArrayList<Passenger>();
    
    //bilet alma
	@Override
	public double takeTicket(int personCount) {
		// TODO Auto-generated method stub
		 double totalTicketFare = 0;
		 double fare = super.takeTicket(personCount);
		 if(fare != 0) {
			 for(int i = 0; i < personCount; i++) {
				 
	            	Passenger passenger = super.newPassenger();
	            	ticketFare = ticketFare(ticketFare, passenger);
	            	totalTicketFare += ticketFare;
	            	System.out.println("Passenger id: "+passenger.getId());
	        		passengers.add(passenger);
	       			passengerCount += 1;
			 }
		 }
		 
		return totalTicketFare;	
				
	}
	//kiþisel bilet ücreti 
	public double ticketFare(double fare, Passenger passenger) {
		if(passenger.getAge()>18 && passenger.getAge()<25) {
			fare -= fare * (30 / 100);
    	}else if(passenger.getType().equals("B")) {
    		fare += 150;
    	}else if(passenger.getSuitcaseWeight()<4) {
    		fare -= fare * (4 / 100);
    	}
		return fare;
	}
	

    //yemek seçeneði
	@Override
    public void foodChoise(Passenger passenger) {
        if(isCurrentPassengerBusiness) {
        	System.out.println("THY business yolcularýna yemek ikramýnda bulunur.");
        }else {
        	System.out.println("THY economy yolcularýna içecek ikramýnda bulunur.");
        }
    }

}