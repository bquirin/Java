package Lab8;
import java.util.*;

public class ScalesSolution
{
	public String scalesolution;
	//Creates a new scales solution based on a string parameter
	//The string parameter is checked to see if it contains all zeros and ones
	//Otherwise the random binary string generator is used (n = length of parameter)
	public ScalesSolution(String s)
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
			int x = CS2004.UI(0,1);
			if(x == 0){
				s = s + '0';
			}
			else if(x == 1){
				s = s + '1';
			}
		}

		return(s);
	}

	public ScalesSolution(int n) 
	{
		scalesolution = RandomBinaryString(n);	
	}
	//This is the fitness function for the Scales problem
	//This function returns -1 if the number of weights is less than
	//the size of the current solution

	public double ScalesFitness(ArrayList<Double> weights)
	{
		//Check each element of scales solution for a 0 (lhs) and 1 (rhs) add the weight weights
		//to variables lhs and rhs as appropriate
		if (scalesolution.length() > weights.size()) return(-1);
		double lhs = 0.0,rhs = 0.0;
		int stringlength = scalesolution.length();

		if (stringlength > weights.size()) return(-1);

		for(int i = 0; i < stringlength; i++) {

			char singleScaleSolution = scalesolution.charAt(i);
			if(singleScaleSolution == '0'){
				lhs += weights.get(i);
			}
			else{
				rhs += weights.get(i);
			}
		} 

		return(Math.abs(lhs-rhs));
	}
	//Display the string without a new line
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