/**
 * 
 */
package Hafta2.Cumartesi.Odev;

/**
 * @author SAYIN BACI
 *
 * 1'den 10 a kadar olan sayÄ±lar iÃ§erisinde
 * 2 ile tam bÃ¶lÃ¼nenleri ekrana yazdÄ±r.    
 */
public class Cevap1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("1-10 Arasında 2'ye Tam Bölünen Sayılar");
		for(int i = 1; i <= 10; i++) {
			if(i%2 == 0)
				System.out.println(i);
		}
	}

}
