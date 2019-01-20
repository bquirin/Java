package Lab8;
import java.util.*;
import java.io.*;

//Some useful code that we will probably reuse in later laboratories...
public class CS2004 
{
	//Shared random object
	static private Random rand;
	//Create a uniformly distributed random INTEGER between num1 and num2 inclusive
	static public int UI(int num1,int num2)
	{
		int a = Math.min(num1,num2);
		int b = Math.max(num1,num2);
		if (rand == null) 
		{
			rand = new Random();
			rand.setSeed(System.nanoTime());
		}
		int d = b - a + 1;
		int x = rand.nextInt(d) + a;
		return(x);
	}
	//Create a uniformly distributed random DOUBLE number between num1 and num2 inclusive
	static public double UR(double number1,double number2)
	{
		if (rand == null) 
		{
			rand = new Random();
			rand.setSeed(System.nanoTime());
		}
		return((number2-number1)*rand.nextDouble()+number1);
	}
	//This method reads in a text file and parses all of the numbers in it
	//This code is not very good and can be improved!
	//But it should work!!!
	//It takes in as input a string filename and returns an array list of Doubles
	static public ArrayList<Double> ReadNumberFile(String filename)
	{
		ArrayList<Double> result = new ArrayList<Double>();
		Reader read;
		try
		{
			read = new BufferedReader(new FileReader(filename));
			StreamTokenizer stok = new StreamTokenizer(read);
			stok.parseNumbers();
			stok.nextToken();
			while (stok.ttype != StreamTokenizer.TT_EOF) 
			{
				if (stok.ttype == StreamTokenizer.TT_NUMBER)
				{
					result.add(stok.nval);
				}
				stok.nextToken();
			}
		}
		catch(Exception E)
		{
			System.out.println("+++ReadFile: "+E.getMessage());
		}
	    return(result);
	}
}