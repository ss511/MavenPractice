package com.ss511.maven.MavenPractice.dataStructures.bst;

import java.util.Scanner;

public class BSTImplementation {

	public static void main(String[] args) {
		BSTUtils bstUtils = new BSTUtils();
		BST root = null;
		int choice;
		int data = 0;
		do{
			System.out.println("\nEnter Choice:"
					+ "\n1-Insert Data"
					+ "\n2-Search Data"
					+ "\n3-Delete Data"
					+ "\n4-Minimum Value Element"
					+ "\n5-Check Binary Tree is BST"
					+ "\n6-Lowest Common Ancestor in BST"
					+ "\n7-InOrder Successor"
					+ "\n8-InOrder Traversal"
					+ "\n9-Exit"
					+ "\n10-BST Iterator");
			Scanner in = new Scanner(System.in);
			choice = in.nextInt();
			switch(choice){
			case 1: 
				/*System.out.println("Enter data to be inserted::");
				data = in.nextInt();
				root = bstUtils.insertData(root, data);*/
				
				root = bstUtils.insertData(root, 50);
				root = bstUtils.insertData(root, 30);
				root = bstUtils.insertData(root, 20);
				root = bstUtils.insertData(root, 40);
				root = bstUtils.insertData(root, 80);
				root = bstUtils.insertData(root, 60);
				root = bstUtils.insertData(root, 70);
				root = bstUtils.insertData(root, 90);
				break;
			case 2:
				System.out.println("Enter data to be searched::");
				data = in.nextInt();
				bstUtils.searchData(root, data);
				break;
			case 3:
				System.out.println("Enter data to be deleted::");
				data = in.nextInt();
				root = bstUtils.deleteData(root, data);
				break;
			case 4:
				bstUtils.minElement(root);
				break;
			case 5:
				boolean isBST = bstUtils.isTreeBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
				System.out.println("Is Binary Tree BST:::"+isBST);
				break;
			case 6:
				BST node = bstUtils.lowestCommonAncestor(root, 70, 90);
				System.out.println("Lowest Common Ancestor is:: "+node.getData());
				break;
			case 7:
				
				break;
			case 8:
				bstUtils.inOrder(root);
				break;
			case 9:
				break;
			case 10:
				bstUtils.bstIterator(root);
				break;
			default:
				System.out.println("Please enter correct choice::");
				break;
			}
		}while(choice != 9);


	}

}

class BSTUtils{
	public BST insertData(BST root, int data){
		if(root == null){
			root = new BST();
			root.setData(data);
			root.setLeft(null);
			root.setRight(null);
			return root;
		}
		BST node = root;
		if(node.getData()>data){
			node.setLeft(insertData(node.getLeft(), data));
		}
		else{
			node.setRight(insertData(node.getRight(), data));
		}
		return root;
	}
	
	public void searchData(BST root, int data){
		if(root == null){
			System.out.println("Data not found!!!");
			return;
		}
		if(data == root.getData()){
			System.out.println("Data is present in the tree");
		}
		else if(data < root.getData()){
			searchData(root.getLeft(), data);
		}
		else{
			searchData(root.getRight(), data);
		}
	}
	public BST deleteData(BST root, int data){
		if(root == null){
			return root;
		}
		BST node = root;
		if(data < node.getData()){
			node.setLeft(deleteData(node.getLeft(), data));
		}
		else if(data > node.getData()){
			node.setRight(deleteData(root.getRight(), data));
		}
		else{
			if(node.getLeft() == null){
				return node.getRight(); 
			}
			else if(node.getRight() == null){
				return node.getLeft();
			}
			
			node.setData(minElement(node.getRight()));
			node.setRight(deleteData(node.getRight(), node.getData()));
		}
		return root;
	}
	
	public void inOrder(BST root){
		if(root == null){
			return;
		}
		inOrder(root.getLeft());
		System.out.print(root.getData()+" ");
		inOrder(root.getRight());
	}
	
	public int minElement(BST root){
		while(root.getLeft()!=null){
			root = root.getLeft();
		}
		System.out.println("Minimum Element in the tree is::"+root.getData());
		return root.getData();
	}
	
	public boolean isTreeBST(BST root, int min, int max){
		if(root == null){
			return true;
		}
		if((root.getData() < min) || (root.getData() > max))
			return false;
		return (isTreeBST(root.getLeft(), min, root.getData()) &&  isTreeBST(root.getRight(), root.getData(), max));
		
	}
	
	public BST lowestCommonAncestor(BST root, int a, int b){
		if(root == null){
			return null;
		}
		BST node = root;
		if(node.getData() < a && node.getData() < b){
			return lowestCommonAncestor(node.getRight(), a, b);
		}
		if(node.getData() > a && node.getData() > b){
			return lowestCommonAncestor(node.getLeft(), a, b);
		}
		return node;
	}
	
	public void bstIterator(BST root) {
		BSTIterator iterator = new BSTIterator(root);
		
		while (iterator.hasNext()) {
			System.out.println(iterator.next().getData());
		}
	}
}

class BST{
	private int data;
	private BST left;
	private BST right;
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public BST getLeft() {
		return left;
	}
	public void setLeft(BST left) {
		this.left = left;
	}
	public BST getRight() {
		return right;
	}
	public void setRight(BST right) {
		this.right = right;
	}
}