package com.ss511.maven.MavenPractice.designPatterns.decorator;

public class ChickenPizza extends PizzaDecorator {

	public ChickenPizza(Pizza pizza) {
		super(pizza);
	}
	
	public String bake() {
		return super.bake() + " with chicken";
	}
	
	public int getCost() {
		return super.getCost() + 50;
	}
	
}
