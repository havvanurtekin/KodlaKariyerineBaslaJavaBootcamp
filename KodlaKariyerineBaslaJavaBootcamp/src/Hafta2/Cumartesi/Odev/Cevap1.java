/**
 * 
 */
package Hafta2.Cumartesi.Odev;

/**
 * @author SAYIN BACI
 *
 * 1'den 10 a kadar olan sayılar içerisinde
 * 2 ile tam bölünenleri ekrana yazdır.    
 */
public class Cevap1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("1-10 Aras�nda 2'ye Tam B�l�nen Say�lar");
		for(int i = 1; i <= 10; i++) {
			if(i%2 == 0)
				System.out.println(i);
		}
	}

}
