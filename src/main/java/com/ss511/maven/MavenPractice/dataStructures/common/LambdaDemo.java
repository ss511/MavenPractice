package com.ss511.maven.MavenPractice.dataStructures.common;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

class Student {
	int marks;
	String names;
	
	public Student(int marks, String names) {
		this.marks = marks;
		this.names = names;
	}
	
	public String getNames() {
		return this.names;
	}
}
public class LambdaDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> numbers = new LinkedList<>();
		for (int i = 0; i < 10; i++) {
			numbers.add(i);
		}
		
		List<Integer> newList = numbers.stream()
			.filter(num -> num%2 == 0)
			.map(num -> num*num)
			.collect(Collectors.toList());
		
		for (Integer num: newList) {
			System.out.println(num);
		}
		
		List<Student> students = new LinkedList<>();
		students.add(new Student(40, "Ram"));
		students.add(new Student(30, "Shyam"));
		students.add(new Student(50, "Mohan"));
		students.add(new Student(40, "Max"));
		students.add(new Student(70, "Jack"));
		students.add(new Student(80, "Nick"));
		students.add(new Student(30, "Smith"));
		students.add(new Student(70, "Andrew"));
		students.add(new Student(40, "Ben"));
		
		students.sort((a,b) -> {
			if (a.marks != b.marks) {
				return b.marks - a.marks;
			} else {
				return a.names.compareTo(b.names);
			}
		});
		
		for (Student st: students) {
			System.out.println(st.names + " - " + st.marks);
		}
		
		List<String> pass = students.stream()
								.filter(a -> a.marks > 40)
								.map(Student::getNames)
								.collect(Collectors.toList());
		
		System.out.println("==========Pass Students==========");
		for (String st: pass) {
			System.out.println(st);
		}
	}

}
