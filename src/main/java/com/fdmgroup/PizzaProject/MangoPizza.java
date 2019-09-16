package com.fdmgroup.PizzaProject;

public class MangoPizza extends PizzaDecorator implements Pizza {
		double MangoCost;
		double totalPrice;
		public MangoPizza(Pizza myPizza) {
			super.myPizza = myPizza;
			MangoCost = 2.0;
			totalPrice=0;
		}
		

		public String getDescription() {
			return myPizza.getDescription()+" + Mango";
		}

		public double getPrice() {
			totalPrice = MangoCost + myPizza.getPrice();
			return totalPrice;
		}
}
