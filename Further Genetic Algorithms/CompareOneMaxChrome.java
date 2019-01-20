package Lab12;

//Compare Scales Chromosomes - used to sort an ArrayList of ScalesChrome
public class CompareOneMaxChrome implements java.util.Comparator<OneMaxChrome>
{
	public int compare(OneMaxChrome a, OneMaxChrome b) 
	{
		if (a.OneMaxGetFitness() < b.OneMaxGetFitness()) return(1);
		if (a.OneMaxGetFitness() > b.OneMaxGetFitness()) return(-1);
		return(0);
		//problem converted from a minimisation problem to a maximisation problem
	}
}
