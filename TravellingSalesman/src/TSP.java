import java.util.ArrayList;
import java.util.Collections;

//@author:Brandon Quirin (1310906)  
//This class was designed for creating instances of TSP

public class TSP {
	
	//class variables and collections 
	private ArrayList<Integer> route;
	private double fitness;
	
	/**
	 * 1 parameter Constructor TSP -This constructor initialises the arrangement which is stored in the route class arraylist
	 * @param numberOfCities
	 * @return void
	 */
	public TSP(int numberOfCities)
	{
		
		route = randomPerm(numberOfCities);
	}

	
	/**
	 * 2 parameter Constructor TSP- initialises the an object as soon as it is created,if arraylist is occupied it is cloned so you can use a getter to get the tour
	 * @param journey
	 * @param numberOfCities
	 * @return void
	 */
	public TSP(ArrayList<Integer> journey, int numberOfCities) {
		
		if(journey == null) 
		{
			route = randomPerm(numberOfCities);
		}
		else 
		{
			route = (ArrayList<Integer>)journey.clone();
		}
		
		
	}
	
	
	/**
	 * RANDOMPERM- creates a random arrangement of cities e.g 3--> {1,2,3} --> {2,1,3}
	 * @param numberOfcities
	 * @return a random arrangement of cities
	 */
	private ArrayList<Integer>  randomPerm(int numberOfcities)
	{
		ArrayList<Integer> tour = new ArrayList<Integer>();
		for (int i = 0; i < numberOfcities; i++)
		{
			tour.add(i);
		}
		Collections.shuffle(tour);

		return tour;

	}
	
	
	/**
	 * GETSOLUTION- gets the solution created in the secondary constructor
	 * @return class variable
	 */
	public ArrayList<Integer> getSolution() 
	{
		return route;
	}
	
	
	/**
	 * SWAP- makes a small change to the tour
	 */
	public void swap()
	{
		int i = 0; 
		int j = 0;
		while(i == j)
		{
			i = CS2004.UI(0, route.size()-1);
			j = CS2004.UI(0, route.size()-1);
		}

		Collections.swap(route,i, j);
	}
	
	
	/**
	 * FITNESS- calculates the fitness of the tour using the total distance as a measure
	 * @param distance array
	 * @return fitness of route
	 */
	public double fitness(double[][] distance)
	{
		double sum = 0 ; 
		int n = route.size()-1;
		int a,b;
		for(int i=0; i<n; i++)
		{
			a = route.get(i);
			b = route.get(i+1);
			sum = sum + distance[a][b];
		}
		int end = route.get(n); 
		int start = route.get(0);
		sum = sum + distance[end][start];
		
		fitness = sum;
		return sum;
		
	}
	/**
	 * GETFITNESS- gets the saved fitness
	 * @return class variable fitness
	 */
	
	public double getFitness() 
	{
		return fitness;
	}
	
	

}
