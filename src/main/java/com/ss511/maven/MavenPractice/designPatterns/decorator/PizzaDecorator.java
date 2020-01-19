package com.ss511.maven.MavenPractice.designPatterns.decorator;

public class PizzaDecorator implements Pizza{

	private Pizza pizza;
	public PizzaDecorator(Pizza pizza) {
		this.pizza = pizza;
	}
	
	public String bake() {
		// TODO Auto-generated method stub
		return pizza.bake();
	}

	public int getCost() {
		// TODO Auto-generated method stub
		return pizza.getCost();
	}

}
