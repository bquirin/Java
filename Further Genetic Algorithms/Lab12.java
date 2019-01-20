package Lab12;

import java.util.ArrayList;

public class Lab12 {

	public static void main(String args[]) {

		System.out.println("Gen| NoFCalls| Average Fit| Best Fit| \n");
		
		for(int i=1;i<11;++i)
		{
			//Reset the fitness count
			OneMaxChrome.ClearFC();
			//initialise values
			int popsize = 100;
			int generation = 10;
			int noOfBits = 1000; 
			double mutateR = 0.001;
			double crossR = 0.75;
			
			SimpleGeneticAlgorithm12 ga = new SimpleGeneticAlgorithm12(popsize,generation,noOfBits,mutateR,crossR);
			double f = ga.OneMaxRunSGA(10000,false).OneMaxGetFitness();
			System.out.println( f);
		}		
		
		System.out.println("Uniform Crossover provides a better fitness than one point");
	}	
}



