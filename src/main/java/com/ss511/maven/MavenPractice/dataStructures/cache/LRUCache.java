package com.ss511.maven.MavenPractice.dataStructures.cache;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class LRUCache {

	public static void main(String[] args) {
		LRU lru = new LRU();
		lru.refer(5);
		lru.refer(3);
		lru.refer(2);
		lru.refer(4);
		lru.display();
		lru.refer(10);
		lru.refer(6);
		lru.refer(1);
		lru.refer(2);
		lru.refer(5);
		lru.refer(5);
		lru.refer(11);
		lru.refer(5);
		lru.display();
	}

}

class LRU {
	
	Deque<Integer> q;
	
	Set<Integer> set;
	
	public LRU() {
		q = new LinkedList<>();
		set = new HashSet<>();
	}
	
	public int refer(int val) {
		
		if (set.contains(val)) {
			q.remove(val);
			q.push(val);
		} else {
			if (q.size() >= 5) {
				int last = q.removeLast();
				set.remove(last);
			}
			set.add(val);
			q.push(val);
		}
		
		return val;
	}
	
	public void display() {
		System.out.println("=====================");
		for(Integer val: q) {
			System.out.println(val);
		}
	}
}