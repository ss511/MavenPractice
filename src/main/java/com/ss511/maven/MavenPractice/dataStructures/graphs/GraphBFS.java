package com.ss511.maven.MavenPractice.dataStructures.graphs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class GraphBFS {

	public static void main(String[] args) {
		Graph graph = new Graph();
		graph.bfsDisplay();

	}

}

class Graph {
	private Map<String, List<String>> graph;
	
	public Graph() {
		graph = new HashMap<>();
		String s1 = "Jack";
		String s2 = "Mac";
		String s3 = "John";
		String s4 = "Peter";
		String s5 = "Aron";
		String s6 = "Sam";
		
		graph.put(s1, new LinkedList<String>(Arrays.asList(s2,s4,s5)));
		graph.put(s2, new LinkedList<String>(Arrays.asList(s1,s6)));
		graph.put(s3, new LinkedList<String>(Arrays.asList(s2,s4,s5)));
		graph.put(s4, new LinkedList<String>(Arrays.asList(s6)));
		graph.put(s5, new LinkedList<String>(Arrays.asList(s2,s3)));
		graph.put(s6, new LinkedList<String>(Arrays.asList(s4,s5)));
	}
	
	public void bfsDisplay() {
		Queue<String> q = new LinkedList<>();
		Set<String> set = new HashSet<>();
		
		/*
		 * for(Map.Entry<String, List<String>> entry : graph.entrySet()) {
		 * 
		 * }
		 */
		q.add("Jack");
		set.add("Jack");
		while(!q.isEmpty()) {
			String name = q.poll();
			System.out.print(name + " ");
			List<String> v = graph.get(name);
			for(String s : v) {
				if (!set.contains(s)) {
					q.add(s);
					set.add(s);
				}
			}
		}
	}
}
