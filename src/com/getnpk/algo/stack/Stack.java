package com.getnpk.algo.stack;

import java.util.Iterator;


public class Stack implements Iterable<String>{

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

	@Override
	public Iterator<String> iterator() {
		return new StackIterator();
	}
	
	private class StackIterator implements Iterator<String>{

		private Node current = top;
		
		@Override
		public boolean hasNext() {
			return current.getNext() != null;
		}

		@Override
		public String next() {
			String item = current.getItem();
			current = current.getNext();
			return item;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
		
	}
}
