package com.ss511.maven.MavenPractice.designPatterns.decorator;

public class PizzaDecoratorDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Pizza pizza = new BasePizza();
		System.out.println(pizza.getCost());
		System.out.println(pizza.bake());
		
		pizza = new ChickenPizza(new BasePizza());
		
		System.out.println(pizza.bake());
		System.out.println(pizza.getCost());
		
		pizza = new CheeseBurstPizza(new ChickenPizza(new BasePizza()));
		System.out.println(pizza.bake());
		System.out.println(pizza.getCost());
		
		pizza = new VegToppingsPizza(new ChickenPizza(new BasePizza()));
		System.out.println(pizza.bake());
		System.out.println(pizza.getCost());
		
		pizza = new CheeseBurstPizza(new VegToppingsPizza(new ChickenPizza(new BasePizza())));
		System.out.println(pizza.bake());
		System.out.println(pizza.getCost());
	}

}
