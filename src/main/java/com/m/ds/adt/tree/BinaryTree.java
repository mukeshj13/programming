package com.m.ds.adt.tree;

import com.m.ds.adt.stack.Queue;

/**
 * 
 * @author mukesh.kumar
 *
 */
public class BinaryTree {

	private Node root;

	public BinaryTree(Object data) {

		this.root = new Node(data);
	}

	public void insert(Object data) throws Exception {

		if (isEmpty()) {

			this.root = new Node(data);
			return;
		}
		Queue<Node> traversal = new Queue<Node>();
		traversal.enqueue(this.root);

		while (!traversal.isEmpty()) {
			Node temp = traversal.dequeu();

			if (temp.getLeft() == null) {

				temp.left = new Node(data);
				break;
			} else {

				traversal.enqueue(temp.left);
			}
			if (temp.getRight() == null) {
				temp.right = new Node(data);
				break;
			} else {

				traversal.enqueue(temp.right);
			}
		}
	}

	/*
	 * Removes the element and adds the right most element at the bottom of the tree
	 * at the empty place
	 */
	public Node delete(Object data) throws Exception {

		// find the element

		Node temp = getNode(data);
		Node rightMost = getDeepestRightMostNode();
		temp.data = rightMost.data;

		freeNode(rightMost);

		return root;

	}

	private void freeNode(Node node) throws Exception {

		if (this.root.data == node.data) {
			this.root = null;
			return;
		}
		Queue<Node> traversal = new Queue<Node>();
		traversal.enqueue(this.root);
		Object data = node.data;
		while (!traversal.isEmpty()) {
			Node temp = traversal.dequeu();

			if (temp.left != null) {

				if (temp.left.data == data) {
					temp.left = null;
				} else {
					traversal.enqueue(temp.left);
				}
			}
			if (temp.right != null) {

				if (temp.right.data == data) {
					temp.right = null;
				} else {
					traversal.enqueue(temp.right);
				}
			}

		}
	}

	private Node getDeepestRightMostNode() throws Exception {
		Queue<Node> traversal = new Queue<Node>();
		traversal.enqueue(this.root);

		Node deepestRightMostNode = null;
		while (!traversal.isEmpty()) {
			Node temp = traversal.dequeu();

			if (temp.left != null) {

				traversal.enqueue(temp.left);
			}
			if (temp.right != null) {

				traversal.enqueue(temp.right);

			}

			deepestRightMostNode = temp;

		}
		return deepestRightMostNode;
	}

	private Node getNode(Object data) throws Exception {

		Queue<Node> traversal = new Queue<Node>();
		traversal.enqueue(this.root);
		Node key = null;
		while (!traversal.isEmpty()) {

			Node temp = traversal.dequeu();

			if (temp.getData().equals(data)) {

				key = temp;
				break;
			}

			if (temp.left != null && temp.left.data.equals(data)) {

				key = temp.left;
				break;
			} else {
				traversal.enqueue(temp.left);
			}
			if (temp.right != null && temp.right.data.equals(data)) {

				key = temp.right;
				break;
			} else {
				traversal.enqueue(temp.right);
			}
		}
		return key;
	}

	private boolean isEmpty() {
		return this.root == null;
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	class Node {

		private Object data;

		private Node left, right;

		public Node(Object data) {

			this.data = data;
		}

		public Object getData() {
			return data;
		}

		public void setData(Object data) {
			this.data = data;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}

	}
}
