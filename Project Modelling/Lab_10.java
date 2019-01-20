package Lab10;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Lab_10 {

	//formats values to two decimal places
	private static DecimalFormat fdp = new DecimalFormat("#.##");

	public static void main(String args[]) {
		System.out.println("===============Exercise 1 ============= \n");

		double r = Cannon.GetMaxRange(40.0,1575.0);
		System.out.println("The horizontal range is " + r + " metres");
		ArrayList<Double> xt = Cannon.GetX();
		ArrayList<Double> yt = Cannon.GetY();
		System.out.println("number of x axis points: " +xt.size());
		System.out.println("number of y axis points: " +yt.size());

		try
		{
			// Create file 
			FileWriter streamdata = new FileWriter("xyvalues.txt");
			BufferedWriter output = new BufferedWriter(streamdata);
			//Values of x and y
			for(int i=0; i< xt.size(); i++)
			{
				output.write("(" + xt.get(i) + ", " + yt.get(i)+ ")");
				output.newLine();
				//System.out.println("xt: " + xt.get(i));
			}
			output.close();
		}
		catch (Exception e){

			System.err.println("Error: " + e.getMessage());
		}

		System.out.println("===============Exercise 2============= \n");

		System.out.println("Set Random Point: ");
		CannonSolution randomPoint = new CannonSolution();
		randomPoint.print();
		System.out.println();

		System.out.println("------------Maximum Range of K12---------------");
		
			maxRangeK12(500);
	

		System.out.println();
		System.out.println("----------Minumum Range of K12----------");
		minRangeK12(1000);

		System.out.println("----------Range Value 65,000----------");
		getTargetRange(500,65000);

		System.out.println("----------Range Value 75,000----------");
		getTargetRange(500,75000);

		System.out.println("----------Range Value 95,000----------");
		getTargetRange(500,95000);
		
		System.out.println("The most time efficient with best results in 3000 iterations");




	}
	private static void maxRangeK12(int iter) 
	{
		CannonSolution currentCS = new CannonSolution(); // provides random velocity and angle 
		//range before and after change 
		double rangeBeforeChange = 0; 
		double rangeAfterChange = 0;

		for(int i= 1; i<=iter; i++) 
		{
			rangeBeforeChange = Cannon.GetMaxRange(currentCS.getAngle(), currentCS.getVelocity()); // calculates range with random values

			CannonSolution oldCS = new CannonSolution(currentCS.getAngle(),currentCS.getVelocity()); // stores currentcs into oldcs
			currentCS.smallChange();                                                          //makes a small change to currentcs
			CannonSolution newCS = new CannonSolution(currentCS.getAngle(),currentCS.getVelocity());  //newcs made after small change

			rangeAfterChange = Cannon.GetMaxRange(newCS.getAngle(), newCS.getVelocity()); // calculates ranges after change

			System.out.println(i+")" + "Current Range = " + fdp.format(rangeBeforeChange));

			if(rangeAfterChange < rangeBeforeChange) 
			{
				currentCS.setAngle(oldCS.getAngle());
				currentCS.setVelocity(oldCS.getVelocity());
			}
		}
		getResults(currentCS,false,0);
	}


	private static void minRangeK12(int iter) 
	{
		CannonSolution currentCS = new CannonSolution(); // provides random velocity and angle 
		//range before and after change 
		double rangeBeforeChange = 0; 
		double rangeAfterChange = 0;

		for(int i= 1; i<=iter; i++) 
		{
			rangeBeforeChange = Cannon.GetMaxRange(currentCS.getAngle(), currentCS.getVelocity()); // calculates range with random values

			CannonSolution oldCS = new CannonSolution(currentCS.getAngle(),currentCS.getVelocity()); // stores currentcs into oldcs
			currentCS.smallChange();                                                          //makes a small change to currentcs
			CannonSolution newCS = new CannonSolution(currentCS.getAngle(),currentCS.getVelocity());  //newcs made after small change

			rangeAfterChange = Cannon.GetMaxRange(newCS.getAngle(), newCS.getVelocity()); // calculates ranges after change

			System.out.println(i+")" + "Current Range = " + fdp.format(rangeBeforeChange));

			if(rangeAfterChange > rangeBeforeChange) 
			{
				currentCS.setAngle(oldCS.getAngle());
				currentCS.setVelocity(oldCS.getVelocity());
			}
		}
		getResults(currentCS,false,0);

	}


	private static void getTargetRange(int iter,int targetRange) 
	{
		CannonSolution currentCS = new CannonSolution(); //initial random solution
		double rangeBeforeChange = 0;
		double rangeAfterChange = 0;

		// Difference between actual target and target set
		double diffBeforeChange = 0;
		double diffAfterChange = 0;

		for(int i= 1; i<=iter; i++) 
		{
			rangeBeforeChange = Cannon.GetMaxRange(currentCS.getAngle(), currentCS.getVelocity());
			diffBeforeChange = CannonSolution.getCannonRangeDiff(rangeBeforeChange, targetRange);

			System.out.println(i+")" + "Current Range = " + fdp.format(rangeBeforeChange));

			CannonSolution oldCS = new CannonSolution(currentCS.getAngle(),currentCS.getVelocity());
			currentCS.smallChange();
			CannonSolution newCS = new CannonSolution(currentCS.getAngle(),currentCS.getVelocity());

			rangeAfterChange = Cannon.GetMaxRange(newCS.getAngle(), newCS.getVelocity());
			diffAfterChange = CannonSolution.getCannonRangeDiff(rangeAfterChange, targetRange);

			if(diffBeforeChange < diffAfterChange) 
			{
				currentCS.setAngle(oldCS.getAngle());
				currentCS.setVelocity(oldCS.getVelocity());
			}

		}

		getResults(currentCS,true,targetRange);
	}


	private static void getResults(CannonSolution cs, boolean Diff,int targetRange) {
		double finalRange = Cannon.GetMaxRange(cs.getAngle(), cs.getVelocity());
		double finalAngle = cs.getAngle();
		double finalMuzzleV = cs.getVelocity();
		double finalDiff = CannonSolution.getCannonRangeDiff(finalRange, targetRange);

		//FINAL VALUES
		System.out.println();
		System.out.println("Final Values: ");
		System.out.println("Range = " + fdp.format(finalRange));
		if(Diff) {
			System.out.println("Difference between Actual & require Target = " + fdp.format(finalDiff));

		}
		System.out.println("Angle = " + fdp.format(finalAngle));
		System.out.println("Velocity = " + fdp.format(finalMuzzleV));
		System.out.println();

	}



}
