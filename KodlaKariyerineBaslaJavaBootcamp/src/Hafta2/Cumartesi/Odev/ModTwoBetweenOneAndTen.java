/**
 * 
 */
package Hafta2.Cumartesi.Odev;

/**
 * @author  Havva Nur TEK�N
 *
 * 1'den 10 a kadar olan sayılar içerisinde
 * 2 ile tam bölünenleri ekrana yazdır.    
 */
public class ModTwoBetweenOneAndTen {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("1-10 Aras�nda 2'ye Tam B�l�nen Say�lar");
		//a loop that returns 1 to 10
		for(int i = 1; i <= 10; i++) {
			//print if remainder of division by 2 is 0
			if(i%2 == 0)
				System.out.println(i);
		}
	}

}
