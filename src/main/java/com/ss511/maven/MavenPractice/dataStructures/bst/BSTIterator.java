package com.ss511.maven.MavenPractice.dataStructures.bst;

import java.util.Stack;

public class BSTIterator {

	Stack<BST> it;
	
	public BSTIterator(BST root) {
		it = new Stack<>();
		pushLeft(root);
	}
	
	private void pushLeft(BST node) {
		if (node != null) {
			it.push(node);
			pushLeft(node.getLeft());
		}
	}
	
	public boolean hasNext() {
		return !it.isEmpty();
	}
	
	public BST next() {
		BST current = it.pop();
		pushLeft(current.getRight());
		return current;
	}
}
