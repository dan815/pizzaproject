package com.fdmgroup.PizzaProject;

public class PizzaMaker {
public static void main(String[] args) {
	Pizza pizza = new PlainPizza();
	
	System.out.println( "Price: " +pizza.getPrice()+", "+pizza.getDescription());
	pizza = new PepperoniPizza(pizza);
	System.out.println( "Price: " +pizza.getPrice()+", "+pizza.getDescription());
	pizza = new CheesePizza(pizza);
	System.out.println( "Price: " +pizza.getPrice()+", "+pizza.getDescription());

	pizza = new GreenPepperPizza(new CheesePizza(new PlainPizza()));
	
	System.out.println( "Price: " +pizza.getPrice()+", "+pizza.getDescription());
	
	
	
}
}
