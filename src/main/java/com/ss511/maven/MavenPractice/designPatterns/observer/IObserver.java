package com.ss511.maven.MavenPractice.designPatterns.observer;

public interface IObserver {

	public void update(String text);
	
	public String getNewText();
}
