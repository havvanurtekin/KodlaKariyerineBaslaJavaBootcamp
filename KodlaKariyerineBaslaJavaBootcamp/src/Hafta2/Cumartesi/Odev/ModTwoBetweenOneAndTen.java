/**
 * 
 */
package Hafta2.Cumartesi.Odev;

/**
 * @author  Havva Nur TEKİN
 *
 * 1'den 10 a kadar olan sayÄ±lar iÃ§erisinde
 * 2 ile tam bÃ¶lÃ¼nenleri ekrana yazdÄ±r.    
 */
public class ModTwoBetweenOneAndTen {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("1-10 Arasında 2'ye Tam Bölünen Sayılar");
		//a loop that returns 1 to 10
		for(int i = 1; i <= 10; i++) {
			//print if remainder of division by 2 is 0
			if(i%2 == 0)
				System.out.println(i);
		}
	}

}
