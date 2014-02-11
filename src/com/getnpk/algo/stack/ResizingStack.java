package com.getnpk.algo.stack;

public class ResizingStack {

	private String[] stack;
	private int top;
	
	public ResizingStack(){
		stack = new String[1];
		top = 0;
	}
	
	private void resize(int size) {
		String[] temp = new String[size];
		for (int i = 0; i < stack.length; i++)
			temp[i] = stack[i];
		stack = temp;
		
	}

	public void push(String item){
		if (stack.length == top+1)
			resize(stack.length * 2);
		
		stack[top++] = item;
	}
	
	public String pop(){
		
		//reduce to quarter size to avoid trashing.
		if (stack.length == 4 * (top+1))
			resize(stack.length / 4);
		return stack[top--];
	}
}
