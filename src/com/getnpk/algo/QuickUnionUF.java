package com.getnpk.algo;

public class QuickUnionUF {

	private int[] list;
	
	private int[] size;
	/*
	 * Initialize list with ids which form the root.
	 * */
	public QuickUnionUF(int n){
		list = new int[n];
		for (int i = 0; i < n ; i++)
			list[i] = i;
		
		size = new int[n];
		for (int i = 0; i < n; i++)
			list[i] = 1;
	}
	
	/*
	 * Traverse up till root element.
	 * Could be slow if long skinny tree.
	 * */
	private int root(int a){
		while (a != list[a]){
			//making the tree flat, path compression.
			list[a] = list[list[a]];
			
			a = list[a];
		}
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
	
	/*
	 * Add smaller tree under root of bigger tree.
	 * */
	public void weightedUnion(int a, int b){
		int ra = root(a);
		int rb = root(b);
		
		if( ra == rb) return;
		
		if (size[ra] < size[rb]){
			list[ra] = rb;
			size[rb] += size[ra];
		}else{
			list[rb] = ra;
			size[ra] += size[rb];
		}
	}
}
