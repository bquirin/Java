package Lab10;

import java.util.Random;

public class CS2004_10 {
	
	//Shared random object
	private static Random rand;
	
	
	//Create a uniformly distributed random integer between alpha and beta inclusive
	public static int UI(int alpha,int beta)
	{
		int a = Math.min(alpha,beta);
		int b = Math.max(alpha,beta);
		if (rand == null) 
		{
			rand = new Random();
			rand.setSeed(System.nanoTime());
		}
		int d = b - a + 1;
		int x = rand.nextInt(d) + a;
		return(x);
	}
	
	
	//Creates a random double between a and b inclusive
	public static double UR(double a,double b)
	{
		if (rand == null) 
		{
			rand = new Random();
			rand.setSeed(System.nanoTime());
		}
		return((b-a)*rand.nextDouble()+a);
	}
}
