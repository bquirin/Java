package Lab9;

import java.util.ArrayList;
import java.util.Random;
import Lab9.CS2004_9;

public class ScalesSolution9
{
	public String scalesolution; 
	public String tempscalesolution;
	//Creates a new scales solution based on a string parameter
	//The string parameter is checked to see if it contains all zeros and ones
	//Otherwise the random binary string generator is used (n = length of parameter)
	//=================================================EXERCISE 1==========================================================

	public void SmallChange()
	{
		/*
		 * This creates method creates a random number between 0 to n-1 
		 * Then swaps a 0 with a 1 or vice versa depending on the position of p
		 */
		Random rand = new Random();
		int n = scalesolution.length();
		int p = Math.abs(rand.nextInt() % n);

		//System.out.println("p = " + p);

		StringBuilder swap = new StringBuilder(scalesolution);
		if (scalesolution.charAt(p) == '0'){
			swap.setCharAt(p, '1');
		}
		else if (scalesolution.charAt(p) == '1'){
			swap.setCharAt(p, '0');	    	
		}	
		System.out.println(swap);
		tempscalesolution = swap.toString();
	}
	//=================================================EXERCISE 2==========================================================

	public String GetSol()
	{
		return(scalesolution);
	}


	public ScalesSolution9(String s)
	{
		boolean ok = true;
		int stringlength = s.length();
		for(int i=0;i<stringlength;++i)
		{
			char single = s.charAt(i);
			if (single != '0' && single != '1')
				ok = false;
		}
		if (ok)
		{
			scalesolution = s;
		}
		else
		{
			scalesolution = RandomBinaryString(stringlength);
		}
	}
	//Create a random binary string of just ones and zeros of length n
	private static String RandomBinaryString(int stringlength)
	{
		String s = new String();

		for(int i = 0; i < stringlength; i++){
			int x = CS2004_9.UI(0,1);
			if(x == 0){
				s = s + '0';
			}
			else if(x == 1){
				s = s + '1';
			}
		}

		return(s);
	}

	public ScalesSolution9(int n) 
	{
		scalesolution = RandomBinaryString(n);	
	}
	//This is the fitness function for the Scales problem
	//This function returns -1 if the number of weights is less than
	//the size of the current solution

	//EXERCISE 3
	public double ScalesFitness(String s,ArrayList<Double> weights)
	{
		int n = s.length();
		double lhs = 0.0, rhs = 0.0;
		if (n < weights.size()) 
		{
			return(-1);
		}
		for(int i = 0; i < n; i++){
			if(s.charAt(i) == '0'){
				lhs += weights.get(i);
			}
			else{
				rhs += weights.get(i);
			}
		}		
		//Code goes here
		//Check each element of scasol for a 0 (lhs) and 1 (rhs) add the weight wi
		//to variables lhs and rhs as appropriate
		return(Math.abs(lhs-rhs));
	}

	public void print()
	{
		System.out.print(scalesolution);
	}
	//Display the string with a new line
	public void println()
	{
		print();
		System.out.println();
	}
}
