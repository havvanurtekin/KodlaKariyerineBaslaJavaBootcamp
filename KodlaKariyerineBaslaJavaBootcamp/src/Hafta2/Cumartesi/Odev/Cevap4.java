/**
 * 
 */
package Hafta2.Cumartesi.Odev;
import java.util.Scanner;
/**
 * @author SAYIN BACI
 * Sinema bileti sat���:
 * �cret hesaplama: 18 ya� alt� i�in %10 indirimli.
 * 18 ve 25 ya� aras� % 5 indirim.
 * Korku filmi se�ilmi�se ekstra % 10 indirim.
 */
public class Cevap4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final double generalPrice = 35;
		double price = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Sinema bileti sat���:");
		System.out.println("L�tfen ya��n�z� giriniz:");
		int age = sc.nextInt();
		if(age < 18)
			price = generalPrice - (generalPrice*10)/100;
		else if(age >= 18 && age <= 25)
			price = generalPrice - (generalPrice*5)/100;
		else
			price = generalPrice;
		System.out.println("L�tfen film t�r�n� giriniz(korku,komedi vs.):");
		String type = sc.next();
		if(type.equals("korku"))
			price = price - (price*10)/100;
		System.out.println("Bilet �creti: "+price);
	}

}
