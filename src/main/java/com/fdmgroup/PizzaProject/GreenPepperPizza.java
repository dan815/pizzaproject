package com.fdmgroup.PizzaProject;

public class GreenPepperPizza extends PizzaDecorator{
	double greenPepperCost;
	double totalPrice;
	public GreenPepperPizza(Pizza myPizza) {
		super.myPizza = myPizza;
		greenPepperCost = 0.70;
		totalPrice=0;
	}
	

	public String getDescription() {
		return super.myPizza.getDescription()+" + Green Pepper";
	}

	public double getPrice() {
		totalPrice = greenPepperCost + super.myPizza.getPrice();
		return totalPrice;
	}
	
}
