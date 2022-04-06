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
        System.out.println("Ho�geldiniz");
//        TicketService ticketService = new TicketService(thy);
//        TicketService ticketServicePegasus = new TicketService(pegasus);
        TicketService ticketService = new TicketService();
        while (true){
            System.out.println("THY ile u�u� yapmak istiyorsan�z T'ye Pegasus ile u�mak istiyoraan�z P tu�una bas�n�z.");
            System.out.println("��k�� yapmak i�in ��k�� butonun bas�n�z.");
            String next = scanner.next();
            if(next.equalsIgnoreCase("T")){
                ticketService.takeTicketForPassenger(thy,2);
                ticketService.cancelTicketForPassenger(thy, 2);
            }else if(next.equalsIgnoreCase("P")){
                System.out.println("Business bilet i�in l�tfen Yes butonuna bas�n�z");
                String nextBusiness = scanner.next();
                Pegasus pegasus1 = (Pegasus) pegasus;
                pegasus1.foodChoise();
                if(nextBusiness.equalsIgnoreCase("Yes")){
                    pegasus1.setIsbusiness(true);
                }else {
                    pegasus1.setIsbusiness(false);
                }
                ticketService.takeTicketForPassenger(pegasus, 3);
            } else if(next.equalsIgnoreCase("��k��")){
                return;
            }
        }
        
    }

}