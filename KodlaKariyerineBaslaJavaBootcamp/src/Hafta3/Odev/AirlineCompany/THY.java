/**
 * 
 */
package Hafta3.Odev.AirlineCompany;

import Hafta3.Odev.IAbroadFoodChoise;

/**
 * @author SAYIN BACI
 *
 */
public class THY extends Plane implements IAbroadFoodChoise{

	boolean isCurrentPassengerBusiness;
    private final int businessAddFare = 500;
  
    
	@Override
	public int takeTicket(int personCount) {
		// TODO Auto-generated method stub
		 int takeTicket = super.takeTicket(personCount);
	     if(isCurrentPassengerBusiness){
	         takeTicket = takeTicket + businessAddFare;
	     }
	   
	     return takeTicket;
				
	}

	public boolean getIsbusiness() {
        return isCurrentPassengerBusiness;
    }

    public void setIsbusiness(boolean isbusiness) {
        this.isCurrentPassengerBusiness = isbusiness;
    }
    
    @Override
    public void foodChoise() {
        if(isCurrentPassengerBusiness) {
        	System.out.println("THY business yolcularýna yemek ikramýnda bulunur.");
        }else {
        	System.out.println("THY economy yolcularýna içecek ikramýnda bulunur.");
        }
    }

}