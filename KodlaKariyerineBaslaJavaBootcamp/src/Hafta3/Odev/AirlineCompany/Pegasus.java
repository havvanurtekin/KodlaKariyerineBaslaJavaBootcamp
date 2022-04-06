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
public class Pegasus extends Plane implements IAbroadFoodChoise{
	double ticketFare = 200;
	//yolcu listesi
	List <Passenger>passengersP = new ArrayList<Passenger>();

    //bilet alma metodu
    @Override
    public double takeTicket(int personCount) {
    	double totalTicketFare = 0;
        double fare = super.takeTicket(personCount);
        if(fare != 0) {
        	for(int i = 0; i < personCount; i++) {
            	
            	Passenger passenger = super.newPassenger();
            	ticketFare = ticketFare(ticketFare, passenger);
            	totalTicketFare += ticketFare;
            	System.out.println("Passenger id: "+passenger.getId());
        		passengersP.add(passenger);
       			passengerCount += 1;
            }
        }
        
        return totalTicketFare;
    }
   
   
    //kiþisel bilet ücreti belirleme
    public double ticketFare(double fare, Passenger passenger) {
    	
    	if(passenger.getAge()<13) {
    		fare = fare * (90 / 100);
    	}else if(passenger.getType().equals("B")) {
    		fare += 130;
    	}
    	return fare;
    }
   //yemek seçeneði
    @Override
    public void foodChoise(Passenger passenger) {
        System.out.println("Pegasus et ürünleri ikramýnda bulunur.");
    }
}