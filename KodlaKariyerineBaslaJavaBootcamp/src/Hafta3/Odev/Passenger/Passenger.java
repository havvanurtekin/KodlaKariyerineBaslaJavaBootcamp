/**
 * 
 */
package Hafta3.Odev.Passenger;

import java.time.LocalDate;


/**
 * @author SAYIN BACI
 *
 */
public class Passenger {

	/**
	 * 
	 */
	//instances
	int age;
	double suitcaseWeight;
	String gender;
	int seatNo;
	LocalDate date;
	int id;
	String type;
	
	
	//constructor method
	public Passenger(int age, double suitcaseWeight, String gender, LocalDate date, String type) {
		// TODO Auto-generated constructor stub
		this.age = age;
		if(gender.equals("K") || gender.equals("E"))
			this.gender = gender;
		this.suitcaseWeight = suitcaseWeight;
		this.seatNo += 1;
		this.date = date;
		this.id += 1;
		if(type.equals("E") || type.equals("B"))
			this.type = type;
		
	}
	//getters and setter
	public String getType() {
		return type;
	}

	public void setType(String type) {
		if(type.equals("E") || type.equals("B"))
			this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
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
		if(gender.equals("K") || gender.equals("E"))
			this.gender = gender;
	}
	
	public int getSeatNo() {
		return seatNo;
	}

	


	

}
