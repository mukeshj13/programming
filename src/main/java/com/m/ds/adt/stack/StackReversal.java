package com.m.ds.adt.stack;

/**
 * 
 * @author mukesh.kumar
 *
 */
public class StackReversal {

	public static void main(String[] args) {

		Stack<Integer> stack = new Stack<Integer>();

		stack.push(1);
		stack.push(11);
		stack.push(123);
		stack.push(132);
		stack.push(143);
		stack.push(23);
		stack.push(51);
		stack.push(191);
		stack.push(3);
		stack.push(981);
		stack.push(87);
		stack.push(13);
		stack.push(10);
		stack.push(38);
		stack.push(345);
		stack.printStack();

		reverse(stack);
		stack.printStack();
	}

	private static void reverse(Stack<Integer> stack) {
		if (!stack.isEmpty()) {
			Integer data = stack.pop();
			reverse(stack);
			insertAtBottom(data, stack);
		}

	}

	private static void insertAtBottom(Integer data, Stack<Integer> stack) {

		if (stack.isEmpty()) {
			stack.push(data);
		} else {
			Integer element = stack.pop();
			insertAtBottom(data, stack);
			stack.push(element);

		}

	}
}
