package com.getnpk.algo.queue;

import com.getnpk.algo.stack.Node;

public class Queue {

	private Node first, last;
	
	public Queue(){
	}
	
	public boolean isEmpty(){
		return first == null;
	}
	
	public void enQueue(String item){
		Node newNode = new Node(item);
		
		if (first == null){
			first = newNode;
			last = newNode;
			newNode.setNext(null);
		}else{
			newNode.setNext(last);
			last = newNode;
		}
	}
	
	public String deQueue(){
		if (!isEmpty()){
			String item = last.getItem();
			last = last.getNext();
			return item;
		}else {
			return " Empty Queue! ";
		}
	}
}
