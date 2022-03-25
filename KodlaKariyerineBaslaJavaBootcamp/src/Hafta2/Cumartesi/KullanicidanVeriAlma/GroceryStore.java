/**
 * 
 */
package Hafta2.Cumartesi.KullanicidanVeriAlma;

import java.util.Scanner;

/**
 * @author Havva Nur TEK�N
 * Manav d�kkan� a�mak isteyen bir adam hal'den bir miktar elma, bir miktar armut, bir miktar kiraz alacakt�r.
 * Mallar d�kkana gelmi�tir.
 * Kullan�c� bu mallar� ayr� odalarda saklayacakt�r.
 *
 */
public class GroceryStore {

	//fruit class
	public class Fruit{
		/**
		 * Fields
		 */
		public String name;
		public double amount;
		public int roomNo;
		//constructor method
		public Fruit(String name, double amount, int roomNo) {
			// TODO Auto-generated constructor stub
			this.name = name;
			this.amount = amount;
			this.roomNo = roomNo;
		}
		
		//getters and setters
		public int getRoomNo() {
			return roomNo;
		}


		public void setRoomNo(int roomNo) {
			this.roomNo = roomNo;
		}


		public String getName() {
			return name;
		}


		public void setFruit(String name) {
			this.name = name;
		}


		public double getAmount() {
			return amount;
		}


		public void setAmount(double amount) {
			this.amount = amount;
		}	
	}
	
	//grocery store functions
	
	//online sales function
	public static void FruitSales(Fruit fruit , double amount) {
		//If there is enough fruit in the warehouse, there will be a sale.
		if(amount <= fruit.getAmount()) {
			double newAmount = fruit.getAmount() - amount;
			fruit.setAmount(newAmount);//update fruit amount
			System.out.println("Sat�� yap�ld�!");
			
		}else {//If there is not enough fruit, there will be no sale and a warning will be given.
			System.out.println("Depoda yeterli meyve yok!");
		
		}
		//current amount of fruits in warehouse
		CurrentWarehouse(fruit);
		
	}
	
	//curent warehouse function
	public static void CurrentWarehouse(Fruit fruit) {
		System.out.println("Oda "+fruit.getRoomNo()+" g�ncel "+fruit.getName()+ " miktar�: "+fruit.getAmount()+" kg" );
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//get fruit quantities and room number from user
		Scanner sc = new Scanner(System.in);
		System.out.println("Almak istedi�iniz elma miktar�n� girin: ");
		double amountApple = sc.nextDouble();
		System.out.println("Almak istedi�iniz armut miktar�n� girin: ");
		double amountPear = sc.nextDouble();
		System.out.println("Almak istedi�iniz kiraz miktar�n� girin: ");
		double amountCherry = sc.nextDouble();
		System.out.println("Elmalar� saklayaca��n�z oda numaras�n� girin: ");
		int noApple = sc.nextInt();
		System.out.println("Armutlar� saklayaca��n�z oda numaras�n� girin: ");
		int noPear = sc.nextInt();
		System.out.println("Kirazlar� saklayaca��n�z oda numaras�n� girin: ");
		int noCherry = sc.nextInt();
		//fruit objects
		Fruit apple = new GroceryStore() .new Fruit("elma", amountApple, noApple);
		Fruit cherry = new GroceryStore() .new Fruit("kiraz", amountCherry, noCherry);
		Fruit pear = new GroceryStore() .new Fruit("armut", amountPear, noPear);
		/**
		 * Her bir odadaki elma, armut ve kiraz�n kg cinsinden de�erini bulal�m.
		 */
		CurrentWarehouse(apple);
		CurrentWarehouse(cherry);
		CurrentWarehouse(pear);
		/**
         * Manav'dan online al��veri� yap�l�yor. M��teri Ve 1 kg elma, 2 kg armut almak istedi.
         * Mallar� als�n. depo guncellensin.
         */
		System.out.println("Manav'dan online al��veri� yap�l�yor. M��teri Ve 1 kg elma, 2 kg armut almak istedi.\r\n"
				+ " Mallar� als�n. depo guncellensin.");
		FruitSales(apple, 1.0);
		FruitSales(cherry, 2.0);
		
		/**
         * Online sat��ta m��teri depoda kalan maldan fazla bir miktarda mal almak istedi.
         * Bunu kullan�c�ya bildir.
         */
		System.out.println("Online sat��ta m��teri depoda kalan maldan fazla bir miktarda mal almak istedi.\r\n"
				+ "Bunu kullan�c�ya bildir.");
		FruitSales(pear, amountPear+1);
		

	}

}
