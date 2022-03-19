/**
 * 
 */
package Hafta2.Cumartesi.Odev;
import java.util.Scanner;
/**
 * @author SAYIN BACI
 * Sinema bileti satýþý:
 * ücret hesaplama: 18 yaþ altý için %10 indirimli.
 * 18 ve 25 yaþ arasý % 5 indirim.
 * Korku filmi seçilmiþse ekstra % 10 indirim.
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
		System.out.println("Sinema bileti satýþý:");
		System.out.println("Lütfen yaþýnýzý giriniz:");
		int age = sc.nextInt();
		if(age < 18)
			price = generalPrice - (generalPrice*10)/100;
		else if(age >= 18 && age <= 25)
			price = generalPrice - (generalPrice*5)/100;
		else
			price = generalPrice;
		System.out.println("Lütfen film türünü giriniz(korku,komedi vs.):");
		String type = sc.next();
		if(type.equals("korku"))
			price = price - (price*10)/100;
		System.out.println("Bilet ücreti: "+price);
	}

}
