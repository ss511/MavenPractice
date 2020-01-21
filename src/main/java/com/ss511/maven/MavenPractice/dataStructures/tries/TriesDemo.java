package com.ss511.maven.MavenPractice.dataStructures.tries;

import java.util.HashMap;
import java.util.Map;

public class TriesDemo {

	public static void main(String[] args) {
		TrieOps trieOps = new TrieOps();
		trieOps.insert("Program");
		trieOps.insert("Programmer");
		
		System.out.println(trieOps.search("Prog"));
		System.out.println(trieOps.search("Program"));
		System.out.println(trieOps.search("Prog1"));
		System.out.println(trieOps.search("Programmer"));
	}

}

class Trie {
	Map<Character, Trie> children = new HashMap<>();
	boolean isEOW;
	String content;
	
	public Trie(Map<Character, Trie> children, boolean isEow) {
		this.children = children;
		this.isEOW = isEow;
	}
}

class TrieOps {
	
	private Trie root;
	public TrieOps() {
		Map<Character, Trie> children = new HashMap<>();
		root = new Trie(children, false);

	}
	
	public void insert(String text) {
		int n = text.length();
		Trie current = root;
		for (int i = 0; i < n; i++) {
			if (root.children.containsKey(text.charAt(i))) {
				current = root.children.get(text.charAt(i));
				current.isEOW = current.isEOW || false;
			} else {
				Trie newNode = new Trie(new HashMap<Character,Trie>(), false);
				current.isEOW = false;
				current.content = text.substring(0, i+1);
				current.children.put(text.charAt(i), newNode);
				current = newNode;
			}
		}
		current.isEOW = true;
	}
	
	public boolean search(String text) {
		int n = text.length();
		Trie current = root;
		for (int i = 0; i < n; i++) {
			if (current.children.containsKey(text.charAt(i))) {
				current = current.children.get(text.charAt(i));
			} else {
				return false;
			}
		}
		return true;
	}
}
