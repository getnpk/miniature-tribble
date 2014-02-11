package com.getnpk.algo.stack;

public class Stack {

	private Node top;

	public boolean isEmpty() {
		return top == null;
	}

	public void push(String item) {
		if (isEmpty()){
			Node newNode = new Node(item);
			top = newNode;
			newNode.setNext(null);
		}else{
			Node newNode = new Node(item);
			newNode.setNext(top);
			top = newNode;
		}
	}

	public String pop() {
		String item = "empty";
		if (!isEmpty()) {
			item = top.getItem();
			top = top.getNext();
		}
		return item;
	}
	
	public void display(){
		if (isEmpty()){
			System.out.print(" empty stack! ");
			return;
		}
			
		Node temp = top;
		System.out.print(temp.getItem() + " ");
		while (temp.getNext() != null){
			temp = temp.getNext();
			System.out.print(temp.getItem() + " ");
		}
	}
}
