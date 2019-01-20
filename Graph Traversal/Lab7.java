package Lab7;
import java.text.DecimalFormat;
import java.util.Random;

public class Lab7 {
	
	public static void main(String args[]) {
		
		double[][] grapharray = new double[][]{
			{0,1,2},
			{1,0,3},
			{2,3,0}};
		
			double mst[][] = MST.PrimsMST(grapharray);
		
		//Exercise 1---------------------------------------------------
		System.out.println("==========Exercise 1==========");
		System.out.println();
		System.out.println("Undirected Graph");
		PrintArray(grapharray);
		System.out.println("-----------");
		System.out.println("Minimum Spanning Tree: No cycles and minimum weight graph");
		PrintArray(mst);
		System.out.println();
		
		
		
		//Exercise 2 --------------------------------------------------
		System.out.println("==========Exercise 2==========");
		System.out.println();
		System.out.println("Undirected Graph Larger Example");
		double[][] grapharray2 = new double[][]{
			{0,1,2,3,0},
			{1,0,6,0,5},
			{2,6,0,4,1},
			{3,0,4,0,2},
			{0,5,1,2,0}};
		double[][] mst2 = MST.PrimsMST(grapharray2);
		PrintArray(grapharray2);
		System.out.println("-------------");
		System.out.println("Larger Example MST");
		PrintArray(mst2);
		
		//Exercise 3---------------------------------------------------------
		System.out.println();
		System.out.println("==========Exercise 3==========");
		System.out.println();
		
		double[][] RandomGraph = RandomArray(4);
		SymmetricArray(RandomGraph);
		System.out.println("Random Symmetric Graph");
		PrintArray(RandomGraph);
		System.out.println();
		double[][] test = MST.PrimsMST(RandomGraph);
		System.out.println("MST of Random Symmetric Graph ");
		PrintArray(test);
		System.out.println();
		
		System.out.println("----------Experiment----------");
		System.out.println();
		
		for(int i = 100; i <= 500; i+=100) {
			//Did 13 tests because first few results are invalid
			for(int j = 1; j<=10;j++) {
				
				System.out.println("Iteration: " + j);
				algorithmTimeTest(i);
			}
			System.out.println();
		}
		
	}
	
	private static void algorithmTimeTest(int arrayLength) {
		
		double[][] beforeMST = RandomArray(arrayLength);
		DecimalFormat dec = new DecimalFormat("#.##");
		double before = System.nanoTime();
		double[][] afterMST = MST.PrimsMST(beforeMST);
		double after = System.nanoTime();
		double duration= (after - before)/1000000;;
		System.out.println(arrayLength + " nodes took " + dec.format(duration)+ " nanoseconds to run MST");
		
		
	}
	
	
	
	private static double[][] RandomArray(int n) {
		
		double[][] array = new double[n][n]; 
		Random rand = new Random();
		
		for(int i = 0;i < array.length;i++) 
		{
			for(int j = 0; j < array.length;j++) 
			{
				array[i][j] = Math.abs(rand.nextInt() % 101);
				if (array[i][i] != 0 )
				{
					array[i][j] = 0.0;
				}
			}
			
		}
		return array;
	}
	
	
	
	public static double[][] SymmetricArray(double [][] array)
	{
		for(int i = 0;i < array.length;i++)
		{
			for(int j = 0; j < array.length;j++) 
			{
				if(array[i][j] != array[j][i])
				{
					array[i][j] = array[j][i];
				}
			}
		}
		return array;
	}
	
	
	
	private static void PrintArray(double[][] array) {	
		for(int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				System.out.print(array[i][j] + " ");
				//array.length - 1 is to make it go to the next line
				if(j == array.length - 1) {
					System.out.println();
				}
			}
		}
		
		
	}
	


	
}
