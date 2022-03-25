/**
 * 
 */
package Hafta2.Cumartesi.Odev;
import java.util.Random;

/**
 * @author  Havva Nur TEK�N
 *
 * 10 kişilik bir sınıf var.
 * Sınıftaki kişilerin numaraları ve cinsiyetlerini biliyorum.
 * bu sınıftaki kızların ve erkeklerin numalarını ayrı ayrı ekrana yazdıran program.
 *
 */
public class Students {

	/**
	 * @param args
	 */
		//parameters
		private String gender;
		private int number;
		//constructor methods
		public Students() {
			
		}
		public Students(String gender, int number) {
			this.gender = gender;
			this.number = number;
		}
		//getters-setters
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
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//paramesters
		Students student[] =new Students[10] ;//student array
		int n = 10;//element number
		String gender = "fm";//gender selector
		Random r = new Random(); //random object
		//
        for (int i = 0; i < n; i++) {
  
            // generate a random number between 0-2
            int index = r.nextInt(2);
            // generate another random num 0-300 for school num 
            int number = r.nextInt(300);
            // gender selection with f(female) or m(male)
            String g = String.valueOf(gender.charAt(index));
            //assign the gender to the relevant element
            student[i] = new Students(g,number);
           
           
        }
        //if gender is female their school nums are printed
        System.out.println("K�zlar:");
        for (int i = 0; i<n; i++) {
        	if(student[i].getGender().equals("f")) {
        		System.out.println("Gender: " + student[i].getGender() + " Number: " + student[i].getNumber());
        	}	  
        }
        //if gender is male their school nums are printed
        System.out.println("Erkekler:");
        for (int i = 0; i<n; i++) {
        	if(student[i].getGender().equals("m")) {
        		System.out.println("Gender: " + student[i].getGender() + " Number: " + student[i].getNumber());
        }
        }
	}        

}
