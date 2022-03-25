/**
 * 
 */
package Hafta2.Cumartesi.Odev;
import java.util.Scanner;
/**
 * @author  Havva Nur TEKÝN
 * Sinema bileti satýþý:
 * ücret hesaplama: 18 yaþ altý için %10 indirimli.
 * 18 ve 25 yaþ arasý % 5 indirim.
 * Korku filmi seçilmiþse ekstra % 10 indirim.
 */
public class Cinema {

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Parameters
		final double generalPrice = 35;
		double price = 0;
		//Scanner object
		Scanner sc = new Scanner(System.in);
		System.out.println("Cinema Ticket Sales:");
		System.out.println("Please Enter Your Age:");
		//Age taken from user
		int age = sc.nextInt();
		//Age check is done by if-else
		if(age < 18)
			price = generalPrice - (generalPrice*10)/100;
		else if(age >= 18 && age <= 25)
			price = generalPrice - (generalPrice*5)/100;
		else
			price = generalPrice;
		System.out.println("Please Enter The Movie Type(korku,komedi vs.):");
		//Movie type taken from user
		String type = sc.next();
		//check if the type is horror
		if(type.equals("korku"))
			price = price - (price*10)/100;
		//the calculated price is printed
		System.out.println("Ticket Price: "+price);
	}

}
