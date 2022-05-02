package com.greatlearning.BinarySearchTree.main;

import com.greatlearning.BinarySearchTree.service.BinarySearchTree;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree obj = new BinarySearchTree();

		obj.add(40);
		obj.add(20);
		obj.add(10);
		obj.add(30);
		obj.add(60);
		obj.add(50);
		obj.add(70);

		obj.pair_sum(130);
	}
}
