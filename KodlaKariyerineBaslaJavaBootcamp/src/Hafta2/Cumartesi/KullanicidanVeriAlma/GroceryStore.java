/**
 * 
 */
package Hafta2.Cumartesi.KullanicidanVeriAlma;

import java.util.Scanner;

/**
 * @author Havva Nur TEKÝN
 * Manav dükkaný açmak isteyen bir adam hal'den bir miktar elma, bir miktar armut, bir miktar kiraz alacaktýr.
 * Mallar dükkana gelmiþtir.
 * Kullanýcý bu mallarý ayrý odalarda saklayacaktýr.
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
			System.out.println("Satýþ yapýldý!");
			
		}else {//If there is not enough fruit, there will be no sale and a warning will be given.
			System.out.println("Depoda yeterli meyve yok!");
		
		}
		//current amount of fruits in warehouse
		CurrentWarehouse(fruit);
		
	}
	
	//curent warehouse function
	public static void CurrentWarehouse(Fruit fruit) {
		System.out.println("Oda "+fruit.getRoomNo()+" güncel "+fruit.getName()+ " miktarý: "+fruit.getAmount()+" kg" );
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//get fruit quantities and room number from user
		Scanner sc = new Scanner(System.in);
		System.out.println("Almak istediðiniz elma miktarýný girin: ");
		double amountApple = sc.nextDouble();
		System.out.println("Almak istediðiniz armut miktarýný girin: ");
		double amountPear = sc.nextDouble();
		System.out.println("Almak istediðiniz kiraz miktarýný girin: ");
		double amountCherry = sc.nextDouble();
		System.out.println("Elmalarý saklayacaðýnýz oda numarasýný girin: ");
		int noApple = sc.nextInt();
		System.out.println("Armutlarý saklayacaðýnýz oda numarasýný girin: ");
		int noPear = sc.nextInt();
		System.out.println("Kirazlarý saklayacaðýnýz oda numarasýný girin: ");
		int noCherry = sc.nextInt();
		//fruit objects
		Fruit apple = new GroceryStore() .new Fruit("elma", amountApple, noApple);
		Fruit cherry = new GroceryStore() .new Fruit("kiraz", amountCherry, noCherry);
		Fruit pear = new GroceryStore() .new Fruit("armut", amountPear, noPear);
		/**
		 * Her bir odadaki elma, armut ve kirazýn kg cinsinden deðerini bulalým.
		 */
		CurrentWarehouse(apple);
		CurrentWarehouse(cherry);
		CurrentWarehouse(pear);
		/**
         * Manav'dan online alýþveriþ yapýlýyor. Müþteri Ve 1 kg elma, 2 kg armut almak istedi.
         * Mallarý alsýn. depo guncellensin.
         */
		System.out.println("Manav'dan online alýþveriþ yapýlýyor. Müþteri Ve 1 kg elma, 2 kg armut almak istedi.\r\n"
				+ " Mallarý alsýn. depo guncellensin.");
		FruitSales(apple, 1.0);
		FruitSales(cherry, 2.0);
		
		/**
         * Online satýþta müþteri depoda kalan maldan fazla bir miktarda mal almak istedi.
         * Bunu kullanýcýya bildir.
         */
		System.out.println("Online satýþta müþteri depoda kalan maldan fazla bir miktarda mal almak istedi.\r\n"
				+ "Bunu kullanýcýya bildir.");
		FruitSales(pear, amountPear+1);
		

	}

}
