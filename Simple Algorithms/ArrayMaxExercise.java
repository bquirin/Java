package Lab2;

public class ArrayMaxExercise {

	public static double ArrayMax (double[] array)
	{
		double CurrentMax = array[0];
		for(int i = 1; i<array.length; i++)
		{
			if (array[i] > CurrentMax)
			{
				CurrentMax = array[i];
			}
		}
		return CurrentMax; 

	}

	public static double ArrayMin(double[] array) 
	{
		double CurrentMin = array[0]; 
		for(int i = 1; i<array.length; i++)
		{
			if (array[i] < CurrentMin)
			{
				CurrentMin = array[i];
			}
		}
		return CurrentMin;
	}




	public static void main (String[] args)
	{
		double [] numbers = {30,25,31,20,50,100,200,150};
		System.out.println(ArrayMax(numbers));
		System.out.println(ArrayMin(numbers)); 

	}
}
