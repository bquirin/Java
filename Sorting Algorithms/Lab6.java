package Lab6;

import java.util.ArrayList;
import java.util.Random;

public class Lab6 {

	public static void main(String[] args) 
	{
		//===============Exercise 1 test methods=======================
		System.out.println("===========Exercise 1=========== \n");
		System.out.println("This is a arraylist of random integers");
		ArrayList <Integer> Randomlist = (RandomArray(10)); 
		ArrayList <Integer> SortA; 
		ArrayList <Integer> SortB; 
		ArrayList <Integer> SortC; 
		ShowArray(Randomlist);
		
		System.out.println("This is sorted by Sort A:");
		SortA = ThreeSorts.SortA(Randomlist);
		ShowArray(SortA);
		
		System.out.println("This is sorted by Sort B:");
		SortB = ThreeSorts.SortB(Randomlist);
		ShowArray(SortB);
		
		System.out.println("This is sorted by Sort C:");
		SortC = ThreeSorts.SortC(Randomlist);
		ShowArray(SortC);
		System.out.println("All three methods Sort the arraylist in descending order \n");
		System.out.println("SortA is bubble sort because it requires alot of swaps");
		System.out.println("SortB is radix sort becaue of the base change");
		System.out.println("SortC is quick sort because it uses a pivot\n ");
		
		//===============Exercise 2 Experimental Analysis=======================

		System.out.println("==========Exercise 2=========== \n");
		ArrayList <Integer> Test = (RandomArray(500000)); 
		long before  = System.nanoTime();
		ShowArray(ThreeSorts.SortC(Test));
		//ThreeSorts.SortA(Test);
		long after = System.nanoTime(); 
		long duration = after -before; 
		System.out.println("Duration of Algorithm: "+ duration +" nanoseconds \n");
		System.out.println("7) Sorting algorithms Ranking from fastest to slowest: ");
		System.out.println("SortC, SortB, SortA");
		System.out.println("Quicksort,RadixSort, BubbleSort\n");
		System.out.println("8) If n is less than 1000 the difference in speed is negligible.");
		System.out.println("When n is large it would be best to use Quicksort or Radix Sort\n");
		System.out.println("9) From the results quick sort can sort any array from the range given \n");
		System.out.println("10) 500000 integers is the largest array it can sort in a reasonable time (less than 20 seconds)");
		
		
		//Experimental Analysis for other 2 sorts
//		long before  = System.nanoTime();
//		ShowArray(ThreeSorts.SortB(Test));
//		long after = System.nanoTime(); 
//		long duration = after -before; 
//		System.out.println("Duration of Algorithm: "+ duration +" nanoseconds");
		
//		long before  = System.nanoTime();
//		ShowArray(ThreeSorts.SortC(Test));
//		long after = System.nanoTime(); 
//		long duration = after -before; 
//		System.out.println("Duration of Algorithm: "+ duration +" nanoseconds");
		



	}

	//===============Exercise 1 methods=======================
	public static ArrayList<Integer> RandomArray(int n) 
	{
		ArrayList<Integer> arraylist = new ArrayList<Integer>(n);
		Random rand = new Random();
		for (int i = 0; i < n; i++) 
		{
			Integer num = Math.abs(rand.nextInt() % 256);
			arraylist.add(num);
		}
		return arraylist;
	}

	public static void ShowArray(ArrayList<Integer> arraylist) 
	{
		int n = arraylist.size();
		for (int i = 0; i < n; i++) 
		{
			int r = arraylist.get(i);
			System.out.print( + r + ", ");
		}
		System.out.println("\n");
	}

}