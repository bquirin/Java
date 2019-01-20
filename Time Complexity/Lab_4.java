package Lab4;
import java.util.Arrays;
public class Lab_4 {


	public static void main(String[] args) {

		//initialise all variables and arrays

		long Start, Finish, Duration; 
		long Begin, End, LengthOfTime; 
		//double [] array = {300,100,300,400,500,100,100}; 
		double [] RandomArray = new double[10000]; 

		//fill array with random numbers

		for(int index = 0; index< RandomArray.length; index++)
		{
			RandomArray[index] =(int)(Math.random()*100);
		}

		//--------------Exercises---------------
		
		System.out.println("-----Exercise 1-----");
		System.out.println("1) The first algorithm uses two loops whereas the second uses one loop. As a result PrefixAverages 2 runs faster than.\n ");

		//Prints created Random Array 
		//PrintArray(RandomArray);
		
		//Measure time taken for algorithm 1 to be completed
		Start = System.nanoTime();  
		Arrays.toString(PrefixAverages1(RandomArray));
		Finish = System.nanoTime();
		Duration = Finish - Start; 

		//Measure time taken for algorithm 2 to be completed
		Begin = System.nanoTime(); 
		Arrays.toString(PrefixAverages2(RandomArray));
		End = System.nanoTime(); 
		LengthOfTime = End - Begin; 

		System.out.println("Prefix averages 1 took " + Duration + " nanoseconds");
		System.out.println("Prefix averages 2 took " + LengthOfTime + " nanoseconds\n");
		System.out.println("2) Prefix averages 1 :T(n) = 6n^2 +4n +2; O(n) = n^2 because of nested loop ");
		System.out.println("   Prefix averages 2: T(n) = 7n + 3; O(n) = n because of one loop");
		System.out.println("   Therefore the most effecient algorithm is Prefix averages 2 \n");

		System.out.println("-----Exercise 2-----");
		System.out.println("Prefix averages 2 completes the task in less than half the time of prefix averages 1 refer to excel spreadsheet. ");


	}


	private static double[] PrefixAverages1(double[] x)
	{
		int arraysize= x.length; 
		double[] array = new double[arraysize]; 
		for (int count=0; count<arraysize; count++)
		{
			double s = x[0]; 
			for(int j=1; j<=count; j++)
			{
				if(j<=count)
				{
					s= s+x[j]; 
				}
			}
			array[count]=s/(count+1);
		}
		return array;
	}

	private static double[] PrefixAverages2 (double[] x)
	{
		int arraysize= x.length; 
		double[] array = new double[arraysize]; 
		double total=0; 

		for(int count=0; count<arraysize; count++)
		{
			total = total +x[count];	
			array[count]= total/(count+1);
		}
		return array;
	}
	

	public static void PrintArray(double[] array) 
	{ 
		int arraysize = array.length;
		System.out.println("----------");

		for(int i = 0; i< arraysize; i++)
		{
			System.out.print("| "+ i + " | "); 
			System.out.println(array[i] + " |");
			System.out.println("----------");
		}
	}
}
