package com.fdmgroup.PizzaProject;

public class ChocolatePizza extends PizzaDecorator implements Pizza {
	double ChocolateCost;
	double totalPrice;
	public ChocolatePizza(Pizza myPizza) {
		super.myPizza = myPizza;
		ChocolateCost = 10.50;
		totalPrice=0;
	}
	

	public String getDescription() {
		return super.myPizza.getDescription()+" + Swiss Chocolate";
	}

	public double getPrice() {
		totalPrice = ChocolateCost + super.myPizza.getPrice();
		return totalPrice;
	}
	
}
