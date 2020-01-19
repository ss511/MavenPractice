package com.ss511.maven.MavenPractice.designPatterns.observer;

public class ObserverDemo {

	public static void main(String[] args) {

		Subject subject = new Subject();
		IObserver first = new FirstObserver();
		IObserver second = new SecondObserver();
		
		subject.register(first);
		subject.register(second);
		
		subject.update("First Text");
		
		System.out.println(first.getNewText());
		System.out.println(second.getNewText());
		
		subject.update("Second Text");
		
		System.out.println(first.getNewText());
		System.out.println(second.getNewText());
		
		subject.deregister(second);
		
		subject.update("Third Text");
		
		System.out.println(first.getNewText());
		System.out.println(second.getNewText());
		
	}

}
