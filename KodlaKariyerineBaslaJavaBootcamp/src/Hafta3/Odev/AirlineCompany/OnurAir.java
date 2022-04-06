/**
 * 
 */
package Hafta3.Odev.AirlineCompany;

import Hafta3.Odev.IAbroadFoodChoise;

/**
 * @author SAYIN BACI
 *
 */
public class OnurAir extends Plane implements IAbroadFoodChoise{

	/**
	 * 
	 */
	boolean isCurrentPassengerBusiness;
    private final int businessAddFare = 200;
    
	public OnurAir() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public int takeTicket(int personCount) {
		// TODO Auto-generated method stub
		 int takeTicket = super.takeTicket(personCount);
	     if(isCurrentPassengerBusiness){
	    	 
	         takeTicket = takeTicket + personCount * businessAddFare;
	     }
	   
	     return takeTicket;
				
	}
	@Override
	public void foodChoise() {
		// TODO Auto-generated method stub
		
	}
	
	

}
