package com.ss511.maven.MavenPractice.designPatterns.observer;

import java.util.LinkedList;
import java.util.List;

public class Subject{

	private List<IObserver> observerList = new LinkedList<>();
	
	public void register(IObserver observer) {
		if(!observerList.contains(observer)) {
			observerList.add(observer);
		}
	}
	
	public void deregister(IObserver observer) {
		if(observerList.contains(observer)) {
			observerList.remove(observer);
		}
	}
	
	public void update(String text) {
		for (IObserver observer: observerList) {
			observer.update(text);
		}
	}
}
