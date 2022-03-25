/**
 * 
 */
package Hafta2.Cumartesi.Odev;
import java.util.Stack;
/**
 * @author  Havva Nur TEK�N
 *
 * Ödev:
 * Bu listedeki isimleri ekrana şu şekilde yazdır.
 * 1. Murat
 * 2. Ahmet
 * 3. Mehmet
 */
public class NameList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//assign the names to the nameList stack
		Stack nameList = new Stack();
		nameList.add("Murat");
		nameList.add("Ahmet");
		nameList.add("Mehmet");
		
		int i = 0;//list index
		int counter = 1;//name counter
		//loop until the list is empty
		while(!nameList.isEmpty()) {
			//print the name removed from the list
			System.out.println(counter+". "+nameList.remove(i));
			counter++;//counter plus 1
		}
	}

}
