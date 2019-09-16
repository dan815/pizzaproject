package com.fdmgroup.PizzaProject;

public class CheesePizza extends PizzaDecorator {
	double CheeseCost;
	double totalPrice;


	public CheesePizza(Pizza myPizza) {
		super.myPizza = myPizza;
		CheeseCost = 0.75;
		this.totalPrice = 0;
	}

	public String getDescription() {
		
		return myPizza.getDescription()+" + Cheese";
	}

	public double getPrice() {
		totalPrice = CheeseCost + myPizza.getPrice();
		return totalPrice;
	}

}
