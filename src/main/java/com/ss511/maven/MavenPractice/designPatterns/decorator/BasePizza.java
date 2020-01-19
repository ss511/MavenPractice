package com.ss511.maven.MavenPractice.designPatterns.decorator;

public class BasePizza implements Pizza{

	public String bake() {
		return "Base Pizza";
	}

	public int getCost() {
		return 100;
	}

}
