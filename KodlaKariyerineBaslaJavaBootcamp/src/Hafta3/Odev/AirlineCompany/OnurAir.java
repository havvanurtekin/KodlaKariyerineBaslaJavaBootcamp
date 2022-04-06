/**
 * 
 */
package Hafta3.Odev.AirlineCompany;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Hafta3.Odev.IAbroadFoodChoise;
import Hafta3.Odev.Passenger.Passenger;

/**
 * @author SAYIN BACI
 *
 */
public class OnurAir extends Plane implements IAbroadFoodChoise{

	/**
	 * 
	 */
	//instances
	double ticketFare = 150;
	boolean isCurrentPassengerBusiness;
    List <Passenger>passengersO = new ArrayList<Passenger>();
    
	public OnurAir() {
		// TODO Auto-generated constructor stub
	}
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
	        		passengersO.add(passenger);
	       			passengerCount += 1;
			 }
		 }
		 
		return totalTicketFare;		
	}
	
	//kiþisel bilet ücreti
	public double ticketFare(double fare, Passenger passenger) {
    	
		if(passenger.getSuitcaseWeight()>25) {
    		fare += fare * (50 / 100);
    	}else if(passenger.getType().equals("B")) {
    		fare += 200;
    	}
    	return fare;
    }
	
	//yemek seçeneði
	@Override
	public void foodChoise(Passenger passenger) {
		// TODO Auto-generated method stub
		if(passenger.getGender().equals("K"))
			System.out.println("Çikolata hediyesi");
		else
			System.out.println("yemek seçenði yok");
		
	}
	
	

}
