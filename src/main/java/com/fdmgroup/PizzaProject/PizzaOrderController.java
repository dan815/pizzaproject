package com.fdmgroup.PizzaProject;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.Scanner;
/**
 * Encapsulates different logics that the user can access through the  UI.
 * Makes use of serialization to save and restore pizza orders from the customer.
 * @author Daniel Natta
 *
 */
public class PizzaOrderController {
	private String incompleteOrderFile;
	private String completeOrderFile;
	private Pizza pizzaTemplate;

	/**
	 * This constructor sets the local path for serialization.
	 * The files completeOrderPizza.ser and incompleteOrderPizza.ser will exist
	 * with in the target folder of the project workspace.
	 */
	public PizzaOrderController() {
		incompleteOrderFile = "incompleteOrderPizza.ser";
		completeOrderFile = "completeOrderPizza.ser";
	}
	
	private static final Logger logger = Logger.getLogger(PizzaOrderController.class);

/**
 * This is the core method for ordering a pizza and calling upon various
 * other options such as adding different toppings, saving the pizza order, ordering
 * from previous save points and creating a log for finished orders. It will cause 
 * a while loop that will constantly prompt for the user's selection until they are finished.
 */
	void orderNewPizza() {
		pizzaTemplate = new PlainPizza();
		Scanner myScannerObj = new Scanner(System.in);
		boolean placeOrder = true;
		
		while (placeOrder == true) {

			int choice = myScannerObj.nextInt();
			if (choice == 0) {
				savePizzaOrder(pizzaTemplate);
				placeOrder = false;
			} else if (choice > 0 && choice < 10) {
				String topping = null;
				switch (choice) {
				case 3:
					topping = "cheese";
					pizzaTemplate = PizzaFactory.createPizza(topping, pizzaTemplate);
					break;
				case 2:
					topping = "pepperoni";
					pizzaTemplate = PizzaFactory.createPizza(topping, pizzaTemplate);
					break;
				case 1:
					topping = "greenpepper";
					pizzaTemplate = PizzaFactory.createPizza(topping, pizzaTemplate);
					break;
				case 4:
					topping = "pineapple";
					pizzaTemplate = PizzaFactory.createPizza(topping, pizzaTemplate);
					break;
				case 6:
					topping = "chocolate";
					pizzaTemplate = PizzaFactory.createPizza(topping, pizzaTemplate);
					break;
				case 7:
					Pizza myPizzaObj = pizzaTemplate;
					createPizzaSavePoint(myPizzaObj);
					// myPizzaObj = null;
					break;
				case 8:
					orderFromSavePoint();
					break;
				case 9:
					reorderLast();
					break;
				}
			} else {
				logger.warn("This topping is currently unavailable, try again later!, Choice: " + choice);
				System.out.println("This topping is currently unavailable, try again later!");
			}
		}
		myScannerObj.close();
		logger.info("Current Order: ");
		//System.out.println("Current Order:");
		logger.info("Cost: " + pizzaTemplate.getPrice() + " " + pizzaTemplate.getDescription());
		//System.out.println("Cost: " + pizzaTemplate.getPrice() + " " + pizzaTemplate.getDescription());
	}
/**
 * This a helper method that contains the logic to serialize the current pizza order, 
 * which will be the Pizza object passed into its parameter.The serialized object and
 * only the object will exist in a file called: incompleteOrderFile.ser
 * @param pizzaTemplate
 */
	void createPizzaSavePoint(Pizza pizzaTemplate) {
		Pizza myPizzaObj = pizzaTemplate;
		try {
			// Saving of object in a file
			FileOutputStream file = new FileOutputStream(incompleteOrderFile);
			ObjectOutputStream out = new ObjectOutputStream(file);

			// serialization of object
			out.writeObject(myPizzaObj);

			out.close();
			file.close();
		
		
		
			logger.info("Object has been serialized from createPizzaSavePoint()");
			logger.info("Pizza = " + pizzaTemplate.getDescription());
			logger.info("Price = " + pizzaTemplate.getPrice());
			//System.out.println("Object has been serialized");
		} catch (IOException ex) {
			logger.warn("IOException is caught");
			//System.out.println("IOException is caught");
		}
	}
/**
 * Saves the finished order after the selection has been ended.
 * It can be recalled with order last option from the menu.
 * @param pizzaTemplate
 */
	void savePizzaOrder(Pizza pizzaTemplate) {
		Pizza myPizzaObj = pizzaTemplate;
		try {
			// Saving of object in a file
			FileOutputStream file = new FileOutputStream(completeOrderFile);
			ObjectOutputStream out = new ObjectOutputStream(file);

			// serialization of object
			out.writeObject(myPizzaObj);

			out.close();
			file.close();
			logger.info("Object has been serialized from savePizzaOrder() ");
			logger.info("Pizza = " + pizzaTemplate.getDescription());
			logger.info("Price = " + pizzaTemplate.getPrice());
			//System.out.println("Object has been serialized");
		} catch (IOException ex) {
			logger.warn("IOException is caught");
			
			//System.out.println("IOException is caught");
		}
	}
/**
 * Another helper method to satisfy the menu option of ordering from save point.
 * It will acquire the Pizza object from incompleteOrderPizza.ser and allow the user to
 * continue their selection from that template.
 */
	void orderFromSavePoint() {
		try {
			// Reading the object from a file
			FileInputStream file = new FileInputStream(incompleteOrderFile);
			ObjectInputStream in = new ObjectInputStream(file);

			// Method for deserialization of object
			pizzaTemplate = (Pizza) in.readObject();

			in.close();
			file.close();
			
			logger.info("Object has been deserialized from orderFromSavePoint() ");
			logger.info("Pizza = " + pizzaTemplate.getDescription());
			logger.info("Price = " + pizzaTemplate.getPrice());
//			System.out.println("Object has been deserialized ");
//			System.out.println("Pizza = " + pizzaTemplate.getDescription());
//			System.out.println("Price = " + pizzaTemplate.getPrice());
		}

		catch (IOException ex) {
			logger.warn("IOException is caught");
			//System.out.println("IOException is caught");
		} catch (ClassNotFoundException ex) {
			logger.warn("ClassNotFoundException is caught");
			//System.out.println("ClassNotFoundException is caught");
		}
	}
/**
 * Allows the user to order the last completed order of pizza. Also allows the
 * user to continue to add toppings with the last order as a base.
 */
	void reorderLast() {
		try {
			// Reading the object from a file
			FileInputStream file = new FileInputStream(completeOrderFile);
			ObjectInputStream in = new ObjectInputStream(file);

			// Method for deserialization of object
			pizzaTemplate = (Pizza) in.readObject();

			in.close();
			file.close();
			logger.info("Object has been deserialized from reorderLast ");
			logger.info("Pizza = " + pizzaTemplate.getDescription());
			logger.info("Price = " + pizzaTemplate.getPrice());
			
//			System.out.println("Object has been deserialized ");
//			System.out.println("Pizza = " + pizzaTemplate.getDescription());
//			System.out.println("Price = " + pizzaTemplate.getPrice());
		}

		catch (IOException ex) {
			logger.warn("IOException is caught");
			//System.out.println("IOException is caught");
		} catch (ClassNotFoundException ex) {
			logger.warn("ClassNotFoundException is caught");
			//System.out.println("ClassNotFoundException is caught");
		}

	}


}
