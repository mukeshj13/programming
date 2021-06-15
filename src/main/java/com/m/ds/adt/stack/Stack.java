package com.m.ds.adt.stack;

import java.util.Arrays;

/**
 * Stack Implementation
 * 
 * @author mukesh.kumar
 *
 */
public class Stack<T> {

	private Object[] arr;
	private int top;

	public Stack() {
		top = -1;
		arr = new Object[10];
	}

	public Stack(int n) {
		top = -1;
		arr = new Object[n];
	}

	public void push(T data) {

		if (isFull()) {
			grow();
		}
		top++;
		arr[top] = data;
	}

	@SuppressWarnings("unchecked")
	public T pop() {

		if (isEmpty()) {

			return null;
		}
		Object data = arr[top];
		arr[top--] = null;
		return (T) data;
	}

	public boolean isEmpty() {
		return top == -1;
	}

	private void grow() {

		arr = Arrays.copyOf(arr, (int) (arr.length * 1.5));
	}

	public boolean isFull() {

		return top == arr.length - 1;
	}

	public void printStack() {

		for (int i = 0; i <= top; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	@SuppressWarnings("unchecked")
	public T peek() {

		if (!isEmpty()) {
			return (T) arr[top];
		}
		return null;
	}

	public void reverse() {
		if (!isEmpty()) {
			T data = pop();
			reverse();
			insertAtBottom(data);
		}

	}

	private void insertAtBottom(T data) {

		if (isEmpty()) {
			push(data);
		} else {
			T element = pop();
			insertAtBottom(data);
			push(element);

		}

	}
}
