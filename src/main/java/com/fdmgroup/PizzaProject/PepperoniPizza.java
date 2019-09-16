package com.fdmgroup.PizzaProject;

public class PepperoniPizza extends PizzaDecorator{
	double pepperoniCost;
	double totalPrice;
	public PepperoniPizza(Pizza myPizza) {
		super.myPizza = myPizza;
		pepperoniCost = 1.0;
		totalPrice=0;
	}
	

	public String getDescription() {
		return myPizza.getDescription()+" + Pepperoni";
	}

	public double getPrice() {
		totalPrice = pepperoniCost + myPizza.getPrice();
		return totalPrice;
	}
}
