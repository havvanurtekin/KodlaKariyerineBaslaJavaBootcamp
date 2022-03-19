/**
 * 
 */
package Hafta2.Cumartesi.Odev;
import java.util.HashMap;
import java.util.Random;

/**
 * @author SAYIN BACI
 *
 * 10 kişilik bir sınıf var.
 * Sınıftaki kişilerin numaraları ve cinsiyetlerini biliyorum.
 * bu sınıftaki kızların ve erkeklerin numalarını ayrı ayrı ekrana yazdıran program.
 *
 */
public class Cevap3 {

	/**
	 * @param args
	 */
	public class Students{
		private String gender;
		private int number;
		public Students() {
			
		}
		public Students(String gender, int number) {
			this.gender = gender;
			this.number = number;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public int getNumber() {
			return number;
		}
		public void setNumber(int number) {
			this.number = number;
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cevap3.Students student[] =new Cevap3.Students[10] ;
		
		int n = 10;
		String gender = "fm";
		Random r = new Random();  
        for (int i = 0; i < n; i++) {
  
            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index = r.nextInt(2);
            int number = r.nextInt(300);
            // add Character one by one in end of sb
            String g = String.valueOf(gender.charAt(index));
            student[i] = new Cevap3().new Students(g,number);
           
           
        }
        System.out.println("K�zlar:");
        for (int i = 0; i<n; i++) {
        	if(student[i].getGender().equals("f")) {
        		System.out.println("Gender: " + student[i].getGender() + " Number: " + student[i].getNumber());
        	}	  
        }
        System.out.println("Erkekler:");
        for (int i = 0; i<n; i++) {
        	if(student[i].getGender().equals("m")) {
        		System.out.println("Gender: " + student[i].getGender() + " Number: " + student[i].getNumber());
        }
        }
	}        

}
