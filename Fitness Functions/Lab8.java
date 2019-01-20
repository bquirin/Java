package Lab8;

import java.util.ArrayList;

public class Lab8 {

	public static void main(String[] args) {
		//This code is all about balancing weights on the LHS and RHS 
		//0 = LHS 
		//1 = RHS 
		//A random binary string is generated as a solution
		//and has its fitness tested by out fitness function 
		//Exercise 2=============================================================================
		System.out.println("==========Exercise 2==========\n");
		System.out.print("First set of numbers: ");
		for(int i=0;i<10;++i)
		{
			int x = CS2004.UI(3, 12);
			System.out.print(x + ","); 
		}
		System.out.println();

		System.out.print("Second set of Numbers: ");
		for(int i=0;i<10;++i)
		{
			int x = CS2004.UI(7, 10);
			System.out.print(x + ","); 
		}
		System.out.println();

		System.out.print("-ve 1 to +ve 1 one set of numbers: ");

		for(int i=0;i<10;++i)
		{
			int x = CS2004.UI(-1, 1);
			System.out.print(x + ",");
		}
		System.out.println();
		System.out.println();

		//Exercise 3=============================================================================================================
		System.out.println("==========Exercise 3==========\n");
		System.out.print("This creates a solution for a scales problem of 5 weights: ");
		ScalesSolution stest = new ScalesSolution("10101");		
		stest.println();
		System.out.print("This creates a random soltion for a 6 weight scales problem: ");
		stest = new ScalesSolution("10101x");
		stest.println();
		System.out.println();


		ArrayList<Double> testarray = new ArrayList<Double>();
		for(double i=1 ; i<=4; i++)
		{
			testarray.add(i);
			if(i == 4)
			{
				testarray.add(10.0);
			}
		}
		System.out.println("----------Testing fitness of Random Solutions---------- \n");
		for(int i = 0; i<3; i++)
		{
			ScalesSolution s = new ScalesSolution("xxxxx");
			System.out.print("Random solution: ");
			s.println();
			s.print();
			System.out.println(" has a fitness of "+s.ScalesFitness(testarray) +"\n");
		}

		//Creates random string of 0's and 1's when x is in the string
		//This code produces a different pattern of values each time
		// 0 = weight on the left, 1 = weight on the right
		//This has the best fitness: ScalesSolution s = new ScalesSolution("00001");
		//The smaller the number the better the fitness


		//Exercise 4===========================================================================================
		System.out.println("==========Exercise 4==========\n");

		ArrayList<Double> thousandprimes = CS2004.ReadNumberFile("Textfiles\\1000 Primes.txt");
		System.out.println("These numbers have been read from a text file:");
		showArray(thousandprimes);
		System.out.println("\n");
		ArrayList<Double> primesample = new ArrayList<Double>();

		for(int i=0 ; i<8; i++)
		{
			primesample.add(thousandprimes.get(i));
		}
		System.out.println("This is a sample of 8 primes from the 1000 primes arraylist:");
		System.out.println(primesample);

		System.out.println();
		ScalesSolution binarystring = new ScalesSolution("xxxxxxxx");
		System.out.print("One solution to this problem is: ");
		binarystring.println();
		binarystring.print();
		System.out.println(" has a fitness of "+binarystring.ScalesFitness(primesample) + "\n");

		System.out.println("The average fitness for the first 10 prime weights is "+MAverageFitness(10));
		System.out.println("The average fitness for the first 100 prime weights is " + MAverageFitness(100));
		System.out.println("The average fitness for the first 250 prime weights is "+MAverageFitness(250));
		System.out.println("The average fitness for the first 150 prime weights is "+MAverageFitness(500));
		System.out.println("The average fitness for the first 1000 prime weights is "+MAverageFitness(1000));
		System.out.println("Generating Random Solutions only work for a small amount of weights like 10");
	}

	public static void showArray(ArrayList<Double> arr) {
		for (int i = 0; i < arr.size(); i++) {
			System.out.print(arr.get(i) + " ");
		}
	}

	public static int MAverageFitness(int n )
	{
		int sum = 0, averagefitness = 0; 
		ArrayList<Double> thousandprimes = CS2004.ReadNumberFile("Textfiles\\1000 Primes.txt");
		ArrayList<Double> primesample = new ArrayList<Double>(); 
		for(int i=0 ; i<n; i++)
		{
			primesample.add(thousandprimes.get(i));
		}
		for(int i = 0; i<100; i++){
			ScalesSolution binarystring = new ScalesSolution(n);
			sum += binarystring.ScalesFitness(primesample);
		}
		averagefitness = sum / 100; 
		return averagefitness; 



	}

}
