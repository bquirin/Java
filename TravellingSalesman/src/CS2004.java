import java.util.*;
import java.io.*;

//@author:Brandon Quirin (1310906)  
//This class was designed for essential methods to be used in the runner class

public class CS2004 
{
	//Shared random object
	static private Random rand;

	/**
	 * UI =Create a uniformly distributed random INTEGER between num1 and num2 inclusive
	 * @param num1- lower value in interval
	 * @param num2- upper value in interval
	 * @return random integer between num1 and num2
	 */
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
	
	/**
	 * UR - Create a uniformly distributed random DOUBLE number between num1 and num2 inclusive
	 * @param number1
	 * @param number2
	 * @return random integer between num1 and num2
	 */
	static public double UR(double number1,double number2)
	{
		if (rand == null) 
		{
			rand = new Random();
			rand.setSeed(System.nanoTime());
		}
		return((number2-number1)*rand.nextDouble()+number1);
	}
	
	/**
	 * PRINTARRAY-Print a 2D double array to the console Window
	 * @param array
	 * @return void 
	 */
	static public void printArray(double array[][])
	{
		for(int i=0;i<array.length;++i)
		{
			for(int j=0;j<array[i].length;++j)
			{
				System.out.print(array[i][j]);
				System.out.print(", ");
			}
			System.out.println();
		}
		System.out.println();

	}
	
	/**
	 * PRINTLIST-Print an integer arraylist to the console Window
	 * @param array
	 * @return void 
	 */
	static public void printList(ArrayList<Integer> array)
	{
		for(int i=0;i<array.size();++i)
		{
			System.out.print(array.get(i));
			System.out.print(", ");
		}
		System.out.println();

	}
	
	
	/**
	 * READ ARRAY FILE- This method reads in a 2D array from a text file and parses all of the numbers in it('sep' is the separator between columns)
	 * @param filename
	 * @param sep
	 * @return read in double array
	 */
	static public double[][] readArrayFile(String filename,String sep)
	{
		double res[][] = null;
		try
		{
			BufferedReader input = null;
			input = new BufferedReader(new FileReader(filename));
			String line = null;
			int ncol = 0;
			int nrow = 0;

			while ((line = input.readLine()) != null) 
			{
				++nrow;
				String[] columns = line.split(sep);
				ncol = Math.max(ncol,columns.length);
			}
			res = new double[nrow][ncol];
			input = new BufferedReader(new FileReader(filename));
			int i=0,j=0;
			while ((line = input.readLine()) != null) 
			{

				String[] columns = line.split(sep);
				for(j=0;j<columns.length;++j)
				{
					res[i][j] = Double.parseDouble(columns[j]);
				}
				++i;
			}
		}
		catch(Exception E)
		{
			System.out.println("+++ReadArrayFile: "+E.getMessage());
		}
		return(res);
	}
	
	
	/**
	 * READ INTEGER FILE -This method reads in a text file of integers and parses all of the numbers in it('sep' is the separator between columns)
	 * @param filename
	 * @return array list of Integers
	 */
	static public ArrayList<Integer> readIntegerFile(String filename)
	{
		ArrayList<Integer> res = new ArrayList<Integer>();
		Reader r;
		try
		{
			r = new BufferedReader(new FileReader(filename));
			StreamTokenizer stok = new StreamTokenizer(r);
			stok.parseNumbers();
			stok.nextToken();
			while (stok.ttype != StreamTokenizer.TT_EOF) 
			{
				if (stok.ttype == StreamTokenizer.TT_NUMBER)
				{
					res.add((int)(stok.nval));
				}
				stok.nextToken();
			}
		}
		catch(Exception E)
		{
			System.out.println("+++ReadIntegerFile: "+E.getMessage());
		}
		return(res);
	}
	
	
}