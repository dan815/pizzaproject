package com.fdmgroup.PizzaProject;

import java.util.Scanner;

public class PizzaOrderApp {
	String incompleteOrderFile = "incompleteOrderPizza.ser";
	String completeOrderFile = "completeOrderPizza.ser";
	PizzaOrderController poc;

	public PizzaOrderApp() {
		this.poc = new PizzaOrderController();
	}

	void startOrder() {
		System.out.println("Would you like to order a new pizza? (Y/N)");
		Scanner myScannerObj = new Scanner(System.in);
		String orderReply = myScannerObj.next().toLowerCase();
		if (orderReply.equals("y")) {
			showMenu();
			poc.orderNewPizza();
		}else {
			System.out.println("Cancelling Order!");
		}
		myScannerObj.close();
	}
	
	void showMenu() {
		Topping[] myTops = Topping.values();
		String orderMenu = "Select Option: ";
		for (int i = 0; i < myTops.length; i++) {
			orderMenu += "\n" + (i + 1) + ". Add " + myTops[i];
		}
		System.out.println("Ordering Pizza" + "\n" + orderMenu + "\n7. Save Pizza" + "\n8. Order From Save Point"
				+ "\n9. Reorder Last" + "\n0. End Selection");

	}
	public static void main(String[] args) {
		PizzaOrderApp poa = new PizzaOrderApp();
		poa.startOrder();
	}

}
