package com.m.ds.adt.stack;

/**
 * Queue with unlimited capacity from a stack
 * 
 * @author mukesh.kumar
 *
 */
public class Queue<T> {

	private Stack<T> stack;

	public Queue() {

		this.stack = new Stack<T>();

	}

	public void enqueue(T data) {

		insertAtBottom(data);
	}

	public T dequeu() throws Exception {

		if (!this.stack.isEmpty()) {
			throw new Exception("Queue is empty");
		}
		return this.stack.pop();
	}

	public boolean isEmpty() {

		return this.stack.isEmpty();
	}

	private void insertAtBottom(T data) {

		if (this.stack.isEmpty()) {
			this.stack.push(data);
		} else {
			T element = this.stack.pop();
			insertAtBottom(data);
			this.stack.push(element);
		}
	}

	public void printQueue() {

		this.stack.printStack();
	}

}
