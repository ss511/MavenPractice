package com.ss511.maven.MavenPractice.designPatterns.decorator;

public class CheeseBurstPizza extends PizzaDecorator {

	public CheeseBurstPizza(Pizza pizza) {
		super(pizza);
	}
	
	public String bake() {
		return super.bake() + " with cheese burst";
	}
	
	public int getCost() {
		return super.getCost() + 30;
	}
	
}
