package com.ss511.maven.MavenPractice.designPatterns.decorator;

public class VegToppingsPizza extends PizzaDecorator {

	public VegToppingsPizza(Pizza pizza) {
		super(pizza);
	}
	
	public String bake() {
		return super.bake() + " with veg toppings";
	}
	
	public int getCost() {
		return super.getCost() + 80;
	}
	
}
