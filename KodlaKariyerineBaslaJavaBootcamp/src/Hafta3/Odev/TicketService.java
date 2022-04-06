/**
 * 
 */
package Hafta3.Odev;

import Hafta3.Odev.AirlineCompany.Plane;

/**
 * @author SAYIN BACI
 *
 */
public class TicketService {


	//bilet al�m�
  public void takeTicketForPassenger(Plane plane, int countPerson){
      double ticketFare = plane.takeTicket(countPerson);
      
      System.out.println("Toplam bilet �creti: "+ticketFare);

  }

  //bilet iptali
  public void cancelTicketForPassenger(Plane plane, int id) {
	  plane.removePassenger(id);
  }

}