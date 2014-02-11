package com.getnpk.algo.uf;

import java.util.Arrays;

public class QuickFindUF {

	private int[] list;
	
	/*Initialize list with ids.*/
	public QuickFindUF(int n){
		list = new int[n];
		for (int i = 0; i < n ; i++)
			list[i] = i;
	}
	
	public boolean isConnected(int a, int b){
		return (list[a] == list[b]);
	}
	
	/*
	 * Quadratic time.
	 * */
	public void union(int a, int b){
		int aid = list[a];
		int bid = list[b];
		//Replace all occurance of aid in array with bid.
		for (int i = 0; i < list.length ; i++){
			if (list[i] == aid)
				list[i] = bid;
		}
	}

	@Override
	public String toString() {
		return "QuickFindUF [list=" + Arrays.toString(list) + "]";
	}
	
	
}
