package Lab11;

import java.util.ArrayList;

public class Lab11 
{
	public static void main(String args[])
	{

		System.out.println("===========Exercise 1============== \n");

		System.out.println("Genetic Algorithms are much faster and more efficient than hill climbing");
		System.out.println("GA is more resistant to being stuck at local extremum at the cost of failing to find a max or min if it doesnt have enough iterations");
		System.out.println("GA is helpful for finding a good starting point"); 

		System.out.println("===========Exercise 2============== \n");
		System.out.println("===========Optimising the Simple Genetic Algorithm============== \n");

	
		//read in primes
		ArrayList<Double> weights = CS2004_11.ReadNumberFile("Textfiles\\1000 Primes.txt");
		ScalesChrome.SetWeights(weights);
		int popsize = 100;
		double mutateRate = 0.001;
		double crossRate = 0.70;

		//Run 10 repeats
		System.out.println("Gen| NoFCalls| Average Fit| Best Fit| \n");
		for(int i=1;i<11;++i)
		{
			System.out.println("Run " + i );
			//Reset the fitness count
			ScalesChrome.ClearFC();
			SimpleGeneticAlgorithm geneticAlg = new SimpleGeneticAlgorithm(popsize,10,1000,mutateRate,crossRate);
			//Run the GA for 10,000 function calls
			double f = geneticAlg.RunSGA(10000,true).GetFitness();

			//Run the GA for specified number of generations
			//double ff = geneticAlg.RunSGA(true).GetFitness();
			System.out.println();
			System.out.println("The best fitness is: " +f + "\n");
			System.out.println("---------------------------------------");
			System.out.println();
		}

		System.out.println("==========Implementing Uniform Crossover============");
		ArrayList<Double> test = new ArrayList<Double>();
		test.add(1.0);
		test.add(2.0);
		test.add(3.0);
		test.add(4.0);
		test.add(10.0);
		ScalesChrome.SetWeights(test);
		SimpleGeneticAlgorithm ga2 = new SimpleGeneticAlgorithm(popsize,10,5,mutateRate,crossRate);
		double g = ga2.RunSGA(true).GetFitness();
		System.out.println("The best fitness is: " + g +"\n");

		System.out.println("Change the code in simple genetic algorithm class to implement uniform crossover");

	}
}

