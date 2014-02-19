package com.getnpk.algo.sort;

public class Sort {

	private static int[] orgArray;
	private static int[] auxArray;
	
	public static void initiateMergeSort(int[] a){
		orgArray = a;
		auxArray = new int[a.length];
		mergeSort(0, a.length -1);
	}
	
	private static void mergeSort(int low, int high){
		if (low < high){
			int middle = (low + high) / 2;
	
			mergeSort(low, middle);
			mergeSort(middle+1, high);
			
			merge(low, middle, high);
		}
	}
	
	private static void merge(int low, int middle, int high){
		//copy all to auxArray.
		for (int i = 0; i < orgArray.length ; i++)
			auxArray[i] = orgArray[i];
		
		int i = low, j = middle + 1, k = low;
		
		//copy lowest from either to orgArray
		while(i <= middle && j <= high){
			if (auxArray[i] < auxArray[j]){
				orgArray[k] = auxArray[i];
				i++;
			}else{
				orgArray[k] = auxArray[j];
				j++;
			}
			k++;
		}
		
		//copy rest of elements from left side, if exists.
		while(i <= middle){
			orgArray[k] = auxArray[i];
			i++;k++;
		}
		
		//copy rest of elements from right side, if exists.
		while(j <= high){
			orgArray[k] = auxArray[j];
			j++;k++;
		}
	}
	
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
		
		int[] intArray = { 7, 1, 2, 4, 6, 3, 5, 2 };
		initiateMergeSort(intArray);
		for (int i : intArray)
			System.out.print(i + " ");

	}
}
