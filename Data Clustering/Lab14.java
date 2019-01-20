package Lab14;

import java.util.ArrayList;

public class Lab14 {

	public static void main(String[] args) {

		System.out.println("===============Exercise 1================ \n");
		System.out.println("Iter|    kappa    |   squared error");
		ArrayList<Integer> expected  = new ArrayList<Integer>();

		for(int i = 0; i < 25; i++)
		{
			expected.add(1); 
		}
		for(int i = 0; i < 50; i++)
		{
			expected.add(2); 
		}
		for(int i = 0; i < 25; i++)
		{
			expected.add(3); 
		}

		double[][] clusterLab = KMeans.ReadArrayFile("Textfiles\\ClusterLab.txt",",");
		
		KMeans object = new KMeans(clusterLab,3,100);
		ArrayList<Integer> result = object.RunIter(3, 10, expected, true);
		
		//compare results
		double weightKappa = KMeans.GroupingWK(expected, result);
		System.out.println("expected number of values: " + expected.size());
		System.out.println("resulted number of values: " + result.size());
		System.out.println("The weighted Kappa is: " +weightKappa);
		System.out.println("===============Exercise 2================ \n");
		
		System.out.println("Refer to excel spreadsheet");


	
		System.out.println("===============Exercise 3 ================ \n");
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();

			
			for(int i = 1; i <= 50; i++)
			{
				list1.add(0); 
			}
			for(int i = 51; i <= 100; i++)
			{
				list1.add(1); 
			}
			for(int i = 101; i <= 150; i++)
			{
				list1.add(2); 
			}
		

		// download iris text file
		double[][] Iris = KMeans.ReadArrayFile("Textfiles\\Iris.txt","	");
		KMeans irisCluster = new KMeans(Iris,4,150);

		list2 = irisCluster.RunIter(4, 10, list1, true);
		double kappa2 = KMeans.GroupingWK(list1,list2);
		System.out.println("Number of values in list 1: "+ list1.size());
		System.out.println("Number of valies in list 2: "+list2.size());
		System.out.println(list2);
		System.out.println("The weighted Kappa is: " + kappa2);
		System.out.println("This group of values do not agree as much as the clusterlab");
		//KMeans.GroupingWK(b, c1);
	
	}

}


