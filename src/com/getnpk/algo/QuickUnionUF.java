package com.getnpk.algo;

public class QuickUnionUF {

	private int[] list;
	
	/*
	 * Initialize list with ids which form the root.
	 * */
	public QuickUnionUF(int n){
		list = new int[n];
		for (int i = 0; i < n ; i++)
			list[i] = i;
	}
	
	/*
	 * Traverse up till root element.
	 * Could be slow if long skinny tree.
	 * */
	private int root(int a){
		while (a != list[a])
			a = list[a];
		return a;
	}
	
	public boolean isConnected(int a, int b){
		return (root(a) == root(b));
	}
	
	public void union(int a , int b){
		int ra = root(a);
		int rb = root(b);
		//change root of a to that of b.
		list[ra] = rb;
	}
}
