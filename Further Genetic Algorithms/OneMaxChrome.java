package Lab12;

import java.util.ArrayList;

public class OneMaxChrome 
{
	//The number of times the fitness function is evaluated
	private static int fc = 0;
	//This is used to store the fitness in
	private double fitness = -1;
	//The representation - a binary array
	private ArrayList<Integer> represent = new ArrayList<Integer>();

	//Reset the fitness count back to zero
	public static void ClearFC()
	{
		fc = 0;
	}

	//Get the number of times the fitness function has been called
	public static int GetFC()
	{
		return(fc);
	}


	//Create a Chromosome based on string 's'
	public OneMaxChrome(String s)
	{
		boolean ok = true;
		int n = s.length();
		for(int i=0;i<n;++i)
		{
			char si = s.charAt(i);
			if (si != '0' && si != '1') 
			{
				ok = false;
			}
			else
			{
				represent.add((si == '1')?1:0);
			}
		}
		if (!ok)
		{
			RandomBinary(n);
		}
	}

	//Create a Chromosome based on array 'r'
	public OneMaxChrome(ArrayList<Integer> r)
	{
		for(int i=0;i<r.size();++i)
		{
			if (r.get(i) < 2) represent.add(r.get(i));
		}
	}

	//Create a random binary Chromosome of length 'n' genes/bits
	public OneMaxChrome(int n) 
	{
		RandomBinary(n);
	}

	//Return the representation (as a pointer) for the Chromosome
	public ArrayList<Integer> GetRep()
	{
		return(represent);
	}

	//Copy and return the representation
	public ArrayList<Integer> CopyRep()
	{
		ArrayList<Integer> cr = new ArrayList<Integer>();
		for(int i=0;i<represent.size();++i) cr.add(represent.get(i));
		return(cr);
	}

	//Create a random binary Chromosome of length 'n' genes/bits
	private void RandomBinary(int n)
	{
		represent.clear();
		for(int i=0;i<n;++i)
		{
			Integer y = CS2004_12.UI(0,1);
			represent.add(y);
		}
	}

	//Compute the Scales fitness function
	public double OneMaxGetFitness()
	{
//---------------------------------------------------------------------------------------------------
		//added code 
		if (fitness != -1) return(fitness);

		double result = 0;
		int c = represent.size();
		for (int i =0; i<c; i++) {
			int d = represent.get(i);
			if (d == 1) {
				result++;
			}
		}
		fitness = result;
		++fc;
		return fitness;
//-----------------------------------------------------------------------------------------------------
	}

	//Display the fitness and representation
	public void print()
	{
		System.out.print(OneMaxGetFitness());
		System.out.print(" ");
		System.out.print(represent);
	}

	//Display the fitness and representation followed by a new line
	public void println()
	{
		print();
		System.out.println();
	}
}
