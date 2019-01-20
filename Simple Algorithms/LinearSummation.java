package Lab2;

public class LinearSummation {

	public static void main(String[] args) {

		long StartTime, EndTime, ElapsedTime;

		System.out.println("Testing algorithm …");

		// Save the time before the algorithm run
		StartTime=System.nanoTime();

		System.out.println(LinearSum(10));

		// Save the time after the run
		EndTime=System.nanoTime();

		// Calculate the difference
		ElapsedTime= EndTime- StartTime;

		// Print it out
		System.out.println("The algorithm took " + ElapsedTime + " nanoseconds to run.");
	}
	/// when N = 1000, time = 50,000 nanoseconds
	/// when N = 2000, time = 65,000 nanoseconds
	/// when N = 1000, time = 180,000 nanoseconds

	public static int LinearSum(int N)
	{
		if(N <=0)
		{
			System.out.println("invalid");; 
		}
		int sum = 0; 
		for(int count = 1; count<= N; count++) 
		{
			sum += count; 
			
		}
		return sum;

	}

}
