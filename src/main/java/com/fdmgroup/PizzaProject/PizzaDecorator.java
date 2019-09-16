package com.fdmgroup.PizzaProject;
/**
 * 
 * @author Daniel Natta
 * 
 * This is a Pizza Decorator class, it holds a Pizza object with in it's fields.
 * It has many subclasses such as CheesePizza, PepperoniPizza, GreenPepperPizza, & etc.
 * These subclasses all implement this abstract PizzaDecorator methods, and are responsible
 * for adding different toppings to the pizza following the 'Decorator Design Pattern'.  
 *
 */
public abstract class PizzaDecorator implements Pizza{
	Pizza myPizza;
	public void getInfo() {
		
	}

}
