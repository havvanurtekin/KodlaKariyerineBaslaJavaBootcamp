/**
 * 
 */
package Hafta3.Odev;

/**
 * @author SAYIN BACI
 *
 */
import java.util.Scanner;

import Hafta3.Odev.AirlineCompany.Pegasus;
import Hafta3.Odev.AirlineCompany.Plane;
import Hafta3.Odev.AirlineCompany.THY;

public class TicketReservation {

    public static void main(String[] args) {
        Plane thy = new THY();
        thy.setCapacity(100);
        thy.setFare(200);
        thy.setPassengerCount(0);

        Plane pegasus = new Pegasus();
        pegasus.setCapacity(230);
        pegasus.setFare(300);
        pegasus.setPassengerCount(0);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Hoþgeldiniz");
//        TicketService ticketService = new TicketService(thy);
//        TicketService ticketServicePegasus = new TicketService(pegasus);
        TicketService ticketService = new TicketService();
        while (true){
            System.out.println("THY ile uçuþ yapmak istiyorsanýz T'ye Pegasus ile uçmak istiyoraanýz P tuþuna basýnýz.");
            System.out.println("Çýkýþ yapmak için çýkýþ butonun basýnýz.");
            String next = scanner.next();
            if(next.equalsIgnoreCase("T")){
                ticketService.takeTicketForPassenger(thy,2);
                ticketService.cancelTicketForPassenger(thy, 2);
            }else if(next.equalsIgnoreCase("P")){
                System.out.println("Business bilet için lütfen Yes butonuna basýnýz");
                String nextBusiness = scanner.next();
                Pegasus pegasus1 = (Pegasus) pegasus;
                pegasus1.foodChoise();
                if(nextBusiness.equalsIgnoreCase("Yes")){
                    pegasus1.setIsbusiness(true);
                }else {
                    pegasus1.setIsbusiness(false);
                }
                ticketService.takeTicketForPassenger(pegasus, 3);
            } else if(next.equalsIgnoreCase("çýkýþ")){
                return;
            }
        }
        
    }

}