package com.getnpk.algo.test;

import com.getnpk.algo.uf.QuickFindUF;

public class UnionFindTest {

	public static void main(String[] args){
		QuickFindUF quf = new QuickFindUF(10);
		System.out.println(quf);
		quf.union(0, 5);
		quf.union(1, 2);
		quf.union(3, 9);
		quf.union(3, 2);
		quf.union(9, 5);
		System.out.println(quf);
	}
}
