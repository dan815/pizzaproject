	package com.fdmgroup.PizzaProject;

public class PizzaFactory {
	public static Pizza createPizza(String pizzaName, Pizza pizzaTemplate) {
		Pizza order = pizzaTemplate;
		String orderName = pizzaName.toLowerCase(); 	 
		switch (orderName) {
		  case "pepperoni":
		    order = new PepperoniPizza(pizzaTemplate);
		    break;
		  case "cheese":
			order = new CheesePizza(pizzaTemplate);
		    break;
		  case "greenpepper":
				order = new GreenPepperPizza(pizzaTemplate);
			    break;
		  case "gourmet":
			order = new ChocolatePizza(new CheesePizza(pizzaTemplate));
			    break;
		  case "chocolate":
			order = new ChocolatePizza(new ChocolatePizza(pizzaTemplate));
			    break;
		  case "mango":
			order = new ChocolatePizza(new MangoPizza(pizzaTemplate));
			    break;
		  case "pineapple":
			order = new ChocolatePizza(new PineapplePizza(pizzaTemplate));
			    break;		    
		  default:
		    System.out.println("Not a valid pizza name");
		}
		return order;
	}
}
