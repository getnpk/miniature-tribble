package com.getnpk.algorithms.arrays;

public class ArrayStructures {

	private int[] theArray = new int[50];
	private int arraySize = 10;
	
	public void generateRandomArray(){
		for (int i=0; i<arraySize; i++){
			// get a random number between 10 and 19
			theArray[i] = (int)(Math.random()*10) + 10; 
		}
	}
	
	public void printArray(){
		System.out.println("----------");
		for (int i=0; i< arraySize;i++){
			System.out.print("| " + i +" | ");
			System.out.println(theArray[i] + " |");
			System.out.println("----------");
		}
	}
	
	public int getValueAtIndex(int index){
		if(index < arraySize)
			return theArray[index];
		else
			return 0;
	}
	
	public boolean doesArrayContainThisValue(int searchValue){
		boolean valueInArray = false;
		
		for (int i=0;i<arraySize;i++){
			if (theArray[i] == searchValue)
				valueInArray = true;
		}
		return valueInArray;
	}
	
	public void deleteIndex(int index){
		if(index < arraySize){
			for (int i =index; i<(arraySize -1);i++){
				theArray[i] = theArray[i+1];
			}
		}
		// since we removed an element by shifting others.
		arraySize--;
	}
	
	public void insertValue(int value){
		if (arraySize < 50){
			theArray[arraySize] = value;
			arraySize++;
		}
	}
	
	public String linearSearch(int value){
		/*Search will include all occurrences of value*/
		boolean valueInArray = false;
		String indexsWithValue = "";
		System.out.print("The value was found in the following: ");
		for (int i=0;i<arraySize;i++){
			if(theArray[i] == value){
				valueInArray = true;
				System.out.print(i + " ");
				indexsWithValue += i + " ";
			}
		}
		
		if (!valueInArray){
			indexsWithValue = "None";
			System.out.println(indexsWithValue);
		}
		
		System.out.println();
		
		return indexsWithValue;
	}
	
	public static void main(String[] args) {
		
		ArrayStructures newArray = new ArrayStructures();
		newArray.generateRandomArray();
		newArray.printArray();
		System.out.println(newArray.getValueAtIndex(3));
		System.out.println(newArray.doesArrayContainThisValue(22));
		newArray.deleteIndex(4);
		newArray.printArray();
		newArray.insertValue(10);
		newArray.printArray();
		newArray.linearSearch(10);
	}

}
