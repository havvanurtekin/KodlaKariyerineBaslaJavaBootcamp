/**
 * 
 */
package Hafta2.Cumartesi.Odev;
import java.util.Stack;
/**
 * @author SAYIN BACI
 *
 * Ödev:
 * Bu listedeki isimleri ekrana şu şekilde yazdır.
 * 1. Murat
 * 2. Ahmet
 * 3. Mehmet
 */
public class Cevap2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack s = new Stack();
		s.add("Murat");
		s.add("Ahmet");
		s.add("Mehmet");
		
		int i = 0,counter = 1;
		
		while(!s.isEmpty()) {
			System.out.println(counter+". "+s.remove(i));
			counter++;
		}
	}

}
