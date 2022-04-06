/**
 * 
 */
package Hafta3.Odev;

/**
 * @author SAYIN BACI
 *
 */
import java.util.Scanner;

import Hafta3.Odev.AirlineCompany.OnurAir;
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
        
        Plane onurAir = new OnurAir();
        onurAir.setCapacity(230);
        onurAir.setFare(300);
        onurAir.setPassengerCount(0);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Hoþgeldiniz");

        TicketService ticketService = new TicketService();
        while (true){
        	
            System.out.println("THY ile uçuþ yapmak istiyorsanýz T'ye Pegasus ile uçmak istiyoraanýz P , OnurAir ile uçmak istiyoraanýz O tuþuna basýnýz.");
            System.out.println("Çýkýþ yapmak için çýkýþ yazýnýz.");
            String next = scanner.next();
            if(next.equalsIgnoreCase("T")){
            	System.out.println("Yolcu sayýsýný giriniz.");
            	int count = scanner.nextInt();
                ticketService.takeTicketForPassenger(thy,count);
                System.out.println("Ýptal etmek istediðiniz yolcu id'sini giriniz.");
                int id = scanner.nextInt();
                ticketService.cancelTicketForPassenger(thy, id);
            }else if(next.equalsIgnoreCase("P")){
            	System.out.println("Yolcu sayýsýný giriniz.");
            	int count = scanner.nextInt();
            	ticketService.takeTicketForPassenger(pegasus,count);
            	System.out.println("Ýptal etmek istediðiniz yolcu id'sini giriniz.");
                int id = scanner.nextInt();
                ticketService.cancelTicketForPassenger(pegasus, id);
            }else if(next.equalsIgnoreCase("O")){
            	System.out.println("Yolcu sayýsýný giriniz.");
            	int count = scanner.nextInt();
            	ticketService.takeTicketForPassenger(onurAir,count);
           	    System.out.println("Ýptal etmek istediðiniz yolcu id'sini giriniz.");
                int id = scanner.nextInt();
                ticketService.cancelTicketForPassenger(onurAir, id);
            } else if(next.equalsIgnoreCase("çýkýþ")){
                return;
            }
        }
        
    }

}