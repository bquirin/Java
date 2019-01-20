package Lab9;

import java.util.ArrayList;

import Lab8.CS2004;

public class Lab9 {

	public static void main(String args[])
	{
		System.out.println("================Exercise 1=============== \n");
		ScalesSolution9 s = new ScalesSolution9("11001");
		System.out.print("Before Change: ");
		s.println();
		System.out.print("After Change:  ");
		s.SmallChange(); 
		System.out.println();

		System.out.println("================Exercise 2=============== \n");


		ScalesSolution9 s1 = new ScalesSolution9(10);
		System.out.print("Without Get Method: ");
		s1.println();
		ScalesSolution9 s2 = new ScalesSolution9(s1.GetSol());
		System.out.print("Using Get Method:   ");
		s2.println(); 
		System.out.println();
		System.out.println("----------Random Mutation Hill Climbing---------- \n");

		ArrayList<Double> weights = new ArrayList<Double>();
		weights.add(1.0);
		weights.add(2.0);
		weights.add(3.0);
		weights.add(4.0);
		weights.add(10.0);    
		System.out.println("This is a small scales problem to be solved:");
		System.out.println(weights + "\n");
		System.out.println("Using RMHC algorithm: \n");
		RMHC(weights, 5,3); 

		System.out.println();
		System.out.println( );
		System.out.println("================Exercise 3=============== \n");
		System.out.println("Run algorithm for 1000 iterations: \n");
		//runExperiment(1000);
		System.out.println();
		System.out.println("After 10 runs of 1000 iterations my average fitness was: 87,452.6");
		//runExperiment(10000);
		System.out.println("Running 10,000 iterations takes roughly 10 times longer than 1,000");
		System.out.println("This is running the algorithm for 5 minutes");
		experimentForTime(3000000);
		//Or run while true (infinite loop)


	}

	public static ScalesSolution9 RMHC(ArrayList<Double> weights,int n,int iter)
	{
		ScalesSolution9 initialsol = new ScalesSolution9(n);	//creates random binary string to solve scales problem				
		ScalesSolution9 oldsol = new ScalesSolution9(initialsol.GetSol()); // copies initial solution an saves it into old solution 

		System.out.print("Current Solution: "); 
		initialsol.println(); // prints initial random solution

		double currentFitness = initialsol.ScalesFitness(initialsol.GetSol(),weights); // checking the fitness of the initial solution
		System.out.print("Current Fittness: ");
		System.out.println(currentFitness); //prints current fitness

		System.out.println();

		for(int i = 1; i <= iter; i++){    											//for loop that iterates for a certain amounts of iterations
			System.out.println("Iteration " + i );                                 // prints what iteration its on
			System.out.println("Current Solution: " + initialsol.GetSol());
			System.out.println("Current Fittness: " + initialsol.ScalesFitness(initialsol.GetSol(),weights));

			System.out.print("New Solution: ");
			oldsol.SmallChange();													//make a small change to the current solution 

			System.out.print("New Fittness: ");
			double oldFitness = oldsol.ScalesFitness(oldsol.tempscalesolution,weights);		//evaluate the fitness to another variable
			System.out.println(oldFitness);

			System.out.println();

			if (oldFitness < initialsol.ScalesFitness(initialsol.GetSol(),weights)){				//if the new fitness is worse than the old
				initialsol.scalesolution = oldsol.tempscalesolution;										//copy oldsol back to being our current solution using temporary scales solution
			}
			else{																	//else do nothing
			}
		}
		System.out.println("The best solution is: " + initialsol.GetSol());
		System.out.println("The best fitness is: " + initialsol.ScalesFitness(initialsol.GetSol(),weights));
		return(initialsol);
	}

	//Time Measurement


	public static void runExperiment(int iter){
		long start;
		long end;
		long duration;	    
		//save the time before the algorithm run
		start=System.nanoTime();

		ArrayList<Double> primes = CS2004_9.ReadNumberFile("Textfiles\\1000 Primes.txt");			//1000Primes.txt
		RMHC(primes, 1000, iter);

		//save the time after the run
		end=System.nanoTime();
		//calculate the difference
		duration=end-start;
		System.out.println("The algorithm took " + duration + " nanoseconds to run.");
	}


	public static void experimentForTime(double milli){

		ArrayList<Double> primes = CS2004_9.ReadNumberFile("Textfiles\\1000 Primes.txt");			//1000Primes.txt

		double startTime = System.currentTimeMillis();

		while (System.currentTimeMillis() - startTime < milli)
		{
			RMHC(primes, 1000, 10000);
		}
	}














}
