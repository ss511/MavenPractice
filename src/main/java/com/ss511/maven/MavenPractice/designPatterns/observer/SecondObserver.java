package com.ss511.maven.MavenPractice.designPatterns.observer;

public class SecondObserver implements IObserver {

	private String newText;
	
	@Override
	public void update(String text) {
		newText = text;
	}
	
	@Override
	public String getNewText() {
		return newText;
	}

}
