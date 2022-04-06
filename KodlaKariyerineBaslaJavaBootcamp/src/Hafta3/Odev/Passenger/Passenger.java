/**
 * 
 */
package Hafta3.Odev.Passenger;

import java.util.Date;

/**
 * @author SAYIN BACI
 *
 */
public abstract class Passenger {

	/**
	 * 
	 */
	int age;
	double suitcaseWeight;
	String gender;
	int seatNo = 0;
	Date date;
	
	
	public Passenger(int age, double suitcaseWeight, String gender, int seatNo, Date date) {
		// TODO Auto-generated constructor stub
		this.age = age;
		this.gender = gender;
		this.suitcaseWeight = suitcaseWeight;
		this.seatNo += seatNo;
		this.date = date;
		
	}
	
	public int getAge() {
		return age;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSuitcaseWeight() {
		return suitcaseWeight;
	}

	public void setSuitcaseWeight(double suitcaseWeight) {
		this.suitcaseWeight = suitcaseWeight;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public int getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}


	

}
