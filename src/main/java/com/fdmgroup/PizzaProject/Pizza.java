package com.fdmgroup.PizzaProject;

import java.io.Serializable;
/**
 * 
 * @author bubba's master
 * 
 * This the base pizza interface that the PlainPizza class and PizzaDecorator implement.
 * This interface extends Serializable, thus allowing the serialization of all the pizza objects.
 * 
 *
 */
public interface Pizza extends Serializable{
	String info = null;
/**
 * Returns a String which represents the toppings that have been added
 * to the pizza
 * @return
 */
	public String getDescription();
/**
 * Returns a double for the price of the order of pizza.
 * @return
 */
	public double getPrice();
	
}
