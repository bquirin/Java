package Lab2;

public class GeometricSummation {

	public static double GeoSum(double a, double N)
	{
		double sum = 0; 
		for(int i = 0; i<=N; i++)
		{
			sum = sum + Math.pow(a, i); 
		}
		return sum;
		
	}
	
	public static void main (String[] args)
	{
		long Start, Finish, Duration; 
		
		System.out.println("Testing Algorithm");
		Start = System.nanoTime(); 
		
		System.out.println(GeoSum(2,3));
		
		Finish = System.nanoTime();
		Duration = Finish - Start; 
		
		System.out.println("This algorithm took " + Duration +" Nanoseconds");
		
		
	}
}
