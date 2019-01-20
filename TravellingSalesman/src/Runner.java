import java.util.ArrayList;
import java.util.Collections;

//@author:Brandon Quirin (1310906)  
//This class was designed for running the TSP Heuristic Algorithms

public class Runner {

	public static void main(String[] args) 
	{
		//reads in the distance array files
		double [][] TSP_48= CS2004.readArrayFile("TSP_Arrays\\TSP_48.txt"," ");
//		double [][] TSP_100= CS2004.readArrayFile("TSP_Arrays\\TSP_100.txt"," ");
//		double [][] TSP_105= CS2004.readArrayFile("TSP_Arrays\\TSP_105.txt"," ");
//		double [][] TSP_442= CS2004.readArrayFile("TSP_Arrays\\TSP_442.txt"," ");

		//Reads in the optimal solution to the problem
		TSP Optimal_48 = new TSP (CS2004.readIntegerFile("TSP_Optimals\\TSP_48_OPT.txt"),TSP_48.length);
//		TSP Optimal_100 = new TSP (CS2004.readIntegerFile("TSP_Optimals\\TSP_48_OPT.txt"),TSP_100.length);
//		TSP Optimal_105= new TSP (CS2004.readIntegerFile("TSP_Optimals\\TSP_48_OPT.txt"),TSP_105.length);
//		TSP Optimal_442= new TSP (CS2004.readIntegerFile("TSP_Optimals\\TSP_48_OPT.txt"),TSP_442.length);
		
		//prints the distance array files
		System.out.println("City Distance Array");
		System.out.println("====================");
		CS2004.printArray(TSP_48);
//		CS2004.printArray(TSP_100);
//		CS2004.printArray(TSP_105);
//		CS2004.printArray(TSP_442);

		//All four heuristic algorithms for solving the travelling salesman problem
		System.out.println("10 Fitness' provided by algorithm:");
		System.out.println("==================================");
		for(int i = 0; i<10;  i++)
		{
			//TSP test =randomHC(TSP_48, 10000,false);
			//TSP test = restartHC(TSP_48, 100000, 3,false);
			//TSP test = stochasticHC(TSP_48,10,140,false);
			TSP test = SA(10000,TSP_48,10000,false);
			
			System.out.println(test.getFitness() + "\n");
		}

		
		//Prints the Optimal Solution
		System.out.println("This is the Optimal solution: ");
		CS2004.printList(Optimal_48.getSolution());
//		CS2004.printList(Optimal_100.getSolution());
//		CS2004.printList(Optimal_105.getSolution());
//		CS2004.printList(Optimal_442.getSolution());
		
		
		//Prints the Optimal Fitness 
		double OptFitness48 = Optimal_48.fitness(TSP_48);
//		double OptFitness100 = Optimal_100.fitness(TSP_100);
//		double OptFitness105= Optimal_105.fitness(TSP_105);
//		double OptFitness442 = Optimal_442.fitness(TSP_442);
		System.out.println("This is the Optimal fitness " + OptFitness48);

		
		//Prints the MST Fitness
		double mstFitness48 = MST.MSTFitness(TSP_48);
//		double mstFitness100 = MST.MSTFitness(TSP_100);
//		double mstFitness105= MST.MSTFitness(TSP_105);
//		double mstFitness442= MST.MSTFitness(TSP_442);
		System.out.println("This is the MST Fitness = " + mstFitness48);

	}


	/**
	 * RANDOM MUTATION HILL CLIMBING- iterative search method the aims to find the solution with minimal fitness
	 * @param distances
	 * @param iter
	 * @param info
	 * @return best solution
	 */
	private static TSP randomHC(double [][] distances,int iter, boolean info)
	{

		int numberOfCities=distances.length;
		TSP solution1 = new TSP(numberOfCities); 
		double fitness1 =  solution1.fitness(distances); 
		
		if (info ==true)
		{
		System.out.print("First Random Solution: ");  
		CS2004.printList(solution1.getSolution()); 
		System.out.print("First Fittness: ");
		System.out.println(fitness1); //prints current fitness
		System.out.println();
		System.out.println("=========================================================================================================================================================================================");
		}
		
		
		for(int i = 1; i <= iter; i++)
		{
			TSP solution2 = new TSP(solution1.getSolution(),numberOfCities); 
			double fitness2 = solution2.fitness(distances); 
			if (info)
			{
			System.out.println("Iteration " + i );                                 
			System.out.print("Current Solution: ");      
			CS2004.printList(solution2.getSolution());	
			System.out.println("Current Fitness: " + fitness2);
			}
			solution1.swap(); 
			
			TSP solution3 = new TSP(solution1.getSolution(),numberOfCities); 
			double fitness3 = solution3.fitness(distances);	
			if (info)
			{
			System.out.print("New Solution: ");							
			CS2004.printList(solution3.getSolution());	
			System.out.print("\nNew Fitness: ");
			System.out.println(fitness3);
			System.out.println("========================================================================================================================================================================================= \n");
			}
			if (fitness3 > fitness2)
			{				
				solution1 = solution2;	//if the new solutions is greater than the old solution then go back to old solution
			}

		}
		if (info)
		{
			System.out.print("The best RMHC solution is: ");
			CS2004.printList(solution1.getSolution());
			System.out.print("The best RMHC fitness is: ");
			System.out.println(solution1.fitness(distances));
		}

		return(solution1);
	}


	/**
	 * RANDOM RESTART HILL CLIMBING - an effective iterative search method runs RMHC multiple times and record the best solution
	 * because it changes the random starting point for n laps it explores the search space more than other hill climbers 
	 * @param distances
	 * @param iter
	 * @param lap
	 * @param info
	 * @return minimum fitness
	 */
	private static TSP  restartHC(double[][] distances, int iter, int lap, boolean info)
	{
		ArrayList<TSP> solutions = new ArrayList<TSP>();
		for(int i = 1; i<= lap; i++)
		{
			solutions.add(randomHC(distances,iter,info));
		}
		return minFitness(solutions,info); 
	}


	//This method takes in an arraylist of solutions calculates the fitness of those solutions and gives back the best fitness(lowest fitness)
	/**
	 * MINIUMUM FITNESS- 
	 * @param solutions
	 * @param info
	 * @return
	 */
	private static TSP minFitness(ArrayList<TSP> solutions,boolean info)
	{
		ArrayList<Double> fitness = new ArrayList<Double>();
		for(int i = 0; i<solutions.size();i++) 
		{
			fitness.add(solutions.get(i).getFitness());
		}
		int minimumIndex = fitness.indexOf(Collections.min(fitness));
		if(info) {
			System.out.println("All Fitness: " + fitness);
			System.out.print("Minimum Fitness = ");
			System.out.println(fitness.get(minimumIndex));
		}

		return solutions.get(minimumIndex); 
	}

	
	/**
	 * STOCHASTIC HILL CLIMBING - an iterative search method that allows worse fitness to explore the search space more and escape local optima
	 * @param distances
	 * @param iter
	 * @param t
	 * @param info
	 * @return best solution
	 */
	private static TSP stochasticHC(double [][] distances,int iter,int t,boolean info){

		int numberOfCities=distances.length;
		TSP solution1 = new TSP(numberOfCities); 
		double fitness1 =  solution1.fitness(distances); 
		
		if(info) {
			System.out.print("First Random Solution: ");  
			CS2004.printList(solution1.getSolution()); 
			System.out.print("First Fittness: ");
			System.out.println(fitness1); 
			System.out.println();
			System.out.println("=========================================================================================================================================================================================");
		}
		for(int i = 1; i <= iter; i++)
		{
			TSP solution2 = new TSP(solution1.getSolution(),numberOfCities); 
			double fitness2 = solution2.fitness(distances); 
			if (info)
			{
			System.out.println("Iteration " + i );                                 
			System.out.print("Current Solution: ");      
			CS2004.printList(solution2.getSolution());	
			System.out.println("Current Fitness: " + fitness2);
			}
			solution1.swap(); 
			
			TSP solution3 = new TSP(solution1.getSolution(),numberOfCities); 
			double fitness3 = solution3.fitness(distances);	
			if (info ==true)
			{
			System.out.print("New Solution: ");							
			CS2004.printList(solution3.getSolution());	
			System.out.print("\nNew Fitness: ");
			System.out.println(fitness3);
			System.out.println("========================================================================================================================================================================================= \n");
			}
			
			if (CS2004.UR(0,1) > decisionFunc(fitness3,fitness2,t))
			{				
				solution1 = solution2;	
			}
		}
		if(info) {
			System.out.print("The best stochastic solution is: ");
			CS2004.printList(solution1.getSolution());
			System.out.println("The best stochastic hill climbing fitness is: " + solution1.fitness(distances));
		}

		return(solution1);
	}



	/**
	 * DECISION FUNCTION- formula used to stop the algorithm from being stuck at local optima 1/(1+exp(newfitness-oldfitness)/T
	 * @param newfitness
	 * @param oldfitness
	 * @param T
	 * @return decision value
	 */
	private static double decisionFunc(double newfitness, double oldfitness, int T) {
		double answer = 1.0/(1.0+Math.exp(newfitness -oldfitness)/T);
		return answer; 
	}


	/**
	 * SIMULATED ANNEALING - uses annealing as inspiration this method allows worse solution under certain circumstances to find the best solution
	 * The temperature should reach zero at the end of the algorithm
	 * @param t0  
	 * @param coolRate  
	 * @param distances  
	 * @param iter  
	 * @param info  
	 * @return Best solution
	 */
	private static TSP SA(double t0,double [][] distances,int iter, boolean info) {

		int numberOfCities=distances.length;
		TSP solution1 = new TSP(numberOfCities); 
		double fitness1 =  solution1.fitness(distances); 
	
		if(info) {
			System.out.print("First Random Solution: ");  
			CS2004.printList(solution1.getSolution()); 
			System.out.print("First Fittness: ");
			System.out.println(fitness1); 
			System.out.println();
			System.out.println("=========================================================================================================================================================================================");
		}
		double currentTemp = t0; 
		double coolingRate = coolRate(t0,iter);
		for(int i = 1; i <= iter; i++)
		{
			TSP solution2 = new TSP(solution1.getSolution(),numberOfCities);
			double fitness2 = solution2.fitness(distances);  
			if (info)
			{
			System.out.println("Iteration " + i );                                 
			System.out.print("Current Solution: ");      
			CS2004.printList(solution2.getSolution());	
			System.out.println("Current Fitness: " + fitness2);
			}
			solution1.swap(); 
			
			TSP solution3 = new TSP(solution1.getSolution(),numberOfCities); 
			double fitness3 = solution3.fitness(distances);	
			if (info)
			{
			System.out.print("New Solution: ");							
			CS2004.printList(solution3.getSolution());	
			System.out.print("\nNew Fitness: ");
			System.out.println(fitness3);
			System.out.println("========================================================================================================================================================================================= \n");
			}
			if (fitness3> fitness2)
			{				
				double p = acceptanceFunc(fitness3, fitness2, currentTemp); 
				if(p<CS2004.UR(0,1))
				{
					solution1 = solution2;	
					
				}
				else {
					solution1 = solution3;
				}
			}
			currentTemp = currentTemp*coolingRate;
		}
		if(info) {
			System.out.print("The best solution is: ");
			CS2004.printList(solution1.getSolution());
			System.out.println("The best Simulated annealing fitness is: " + solution1.fitness(distances));
			System.out.print("\nFinal temp = "+ currentTemp);
			System.out.print("\nLamda = "+ coolingRate +"\n");
		}

		return(solution1);
	}



	/**
	 * ACCEPTANCE FUNCTION - function used to stop the algorithm from being stuck at local optima 
	 * @param newfitness
	 * @param oldfitness
	 * @param currentTemp
	 * @return
	 */
	private static double acceptanceFunc(double newfitness, double oldfitness, double currentTemp){
		double changefitness = Math.abs(newfitness - oldfitness); 
		return Math.exp(-changefitness/currentTemp); 
	}

	private static double coolRate(double initialTemp, int i) {
		
		return Math.exp(((Math.log(Math.pow(10, -100)) - Math.log(initialTemp))/i));
		
	}

}




