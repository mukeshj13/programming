package com.m.ds.adt.test;

import com.m.ds.adt.stack.Stack;

public class Test {

	public static void main(String[] args) {

		Stack<Integer> stack = new Stack();

		stack.push(1);
		stack.printStack();
		stack.push(11);
		stack.printStack();
		stack.push(123);
		stack.printStack();
		stack.push(143);
		stack.printStack();
		stack.push(21);
		stack.printStack();
		stack.push(54);
		stack.printStack();
		stack.pop();
		stack.printStack();
		stack.push(18);
		stack.printStack();
		stack.push(98);
		stack.push(8);

		stack.push(18);
		stack.printStack();
		stack.push(98);
		stack.push(8);

		stack.push(18);
		stack.printStack();
		stack.push(98);
		stack.push(8);

		stack.pop();
		stack.printStack();

		stack.printStack();
	}

}
