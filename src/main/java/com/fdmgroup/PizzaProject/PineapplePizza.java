package com.fdmgroup.PizzaProject;

public class PineapplePizza extends PizzaDecorator implements Pizza {
		double PineappleCost;
		double totalPrice;
		public PineapplePizza(Pizza myPizza) {
			super.myPizza = myPizza;
			PineappleCost = 101.0;
			totalPrice=0;
		}
		

		public String getDescription() {
			return myPizza.getDescription()+" + Exquiste Pineapple";
		}

		public double getPrice() {
			totalPrice = PineappleCost + myPizza.getPrice();
			return totalPrice;
		}
}
