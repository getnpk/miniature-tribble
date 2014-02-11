package com.getnpk.algo.test;

import com.getnpk.algo.stack.Stack;

public class StackTest {

	public static void main(String[] args) {
		Stack s = new Stack();
		s.push("a");
		s.push("b");
		s.pop();
		s.push("c");
		s.display();
		s.pop();
		s.pop();
		s.pop();
		s.display();
		System.out.println("done.");
	}
}
