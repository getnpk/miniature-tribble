package com.getnpk.algo.sort;

public class Sort {

	public static void insertionSort(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = i; j > 0; j--) {
				if (lessThan(a[j], a[j-1]))
					swap(a, j, j-1);
				else
					break;
			}
		}
	}

	public static void selectionSort(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			int min = i;
			for (int j = i + 1; j < a.length; j++) {
				if (lessThan(a[j], a[min]))
					min = j;
			}
			swap(a, i, min);
		}
	}

	public static boolean lessThan(Comparable a, Comparable b) {
		return a.compareTo(b) == -1;
	}

	public static void swap(Comparable[] array, int i, int j) {
		Comparable temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void display(Comparable[] a) {
		for (Comparable c : a)
			System.out.print(c.toString() + " ");
		System.out.println();
	}

	public static void main(String[] args) {

		Comparable[] array = { 7, 1, 2, 4, 6, 3, 5, 2 };
		Comparable[] sarray = { "maverik", "peter", "yo", "fido", "jackson" };
		display(array);
		display(sarray);

		// selectionSort(array);
		insertionSort(array);

		display(array);

	}
}
