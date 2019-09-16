package com.fdmgroup.PizzaProject;

public class PlainPizza implements Pizza{
	

	public String getDescription() {
		String description = "Pizza: dough + Tomato Sauce";
		return description;
	}


	public double getPrice() {
		double plainPizzaPrice = 5.0;
		return plainPizzaPrice;
	}
}
