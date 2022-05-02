package com.greatlearning.BinarySearchTree.service;

public class BinarySearchTree {

	public Node root;

	public int counter;

	public BinarySearchTree() {
		root = null;
		counter = 0;
	}

	// insert a node
	public void add(int value) {

		Node new_node = new Node(value);

		if (new_node != null) {
			if (root == null) {
				// Add first Node
				root = new_node;
			} else {
				Node find = root;

				while (find != null) {
					if (find.data >= value) {
						if (find.left == null) {
							find.left = new_node;
							break;
						} else {
							// left sub-tree
							find = find.left;
						}
					} else {
						if (find.right == null) {
							find.right = new_node;
							break;
						} else {
							// right sub-tree
							find = find.right;
						}
					}
				}
			}
		}
	}

	int counter_nodes(Node head) {
		if (head != null) {

			return counter_nodes(head.left) + counter_nodes(head.right) + 1;

		}
		return 0;
	}

	public void get_elements(Node head, int[] auxiliary) {
		if (head != null) {

			get_elements(head.left, auxiliary);
			auxiliary[this.counter] += head.data;
			this.counter++;
			get_elements(head.right, auxiliary);
		}
	}

	public void pair_sum(int sum) {
		if (root != null) {

			int size = counter_nodes(root);

			int[] aux = new int[size];

			int i = 0, index = 0;

			boolean status = false;

			this.counter = 0;

			get_elements(root, aux);

			size--;
			// Check given sum pair exist or not
			while (index < size) {
				if (aux[index] + aux[size] == sum) {
					status = true;
					break;
				} else if (aux[index] + aux[size] > sum) {
					size--;
				} else {
					index++;
				}
			}
			if (status == false) {
				System.out.print("Nodes are not found");
			} else {

				System.out.print("Nodes are present");

				while (index <= size) {

					i = index + 1;

					while (i <= size) {

						if (aux[index] + aux[i] == sum) {
							System.out.print("  (" + aux[index] + "," + aux[i] + ")");
						}
						i++;
					}

					index++;
				}
			}
		}

	}

}
