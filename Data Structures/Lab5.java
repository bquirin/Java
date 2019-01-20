package Lab5;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;


public class Lab5 {
	
	public static void main(String[] args)
	{
//========================Exercise 1 Preliminaries======================
		
		System.out.println("==========Exercise 1========== \n");
		Data x = new Data("Fred", 41); 
		x.Print(); 
		System.out.println("");
		// Experimenting with instances of data class 
		Data test = new Data("Johnny", 72); 
		System.out.println("This is an instance of the data class: ");
		test.Print();
		System.out.println();
		
		// creating new instances of the data class
		Data y = new Data("Jo",43); 
		Data z= new Data("Zoe",37);
		Data a = new Data("Harry", 78);  
		
//===================Exercise 2: ArrayList and LinkedLists==================
		
		System.out.println("==========Exercise 2========== \n");
		//creates an arraylist called people
		ArrayList<Data> people = new ArrayList<Data>();
		// adding people to the arraylist
		people.add(x);
		people.add(y); 
		people.add(z);  
		//adds objects to arraylist called people 
		System.out.println("This is printed from an arraylist:");
		PrintCollection(people); 
		//Adds harry to arraylist in position 2 
		people.add(2, a); 
		System.out.println("Now we have added Harry: ");
		PrintCollection(people);   
		System.out.println();
		
		
		LinkedList<Data> group = new LinkedList<Data>();
		group.add(x);
		group.add(y); 
		group.add(z);  
		//adds objects to Linkedlist called people 
		System.out.println("This is printed from a Linked list:");
		PrintCollection(group); 
		group.add(2, a);
		System.out.println("Now we have added Harry again: ");
		PrintCollection(group); 
		System.out.println();
		System.out.println("Arraylists is better for storing and acessing data because it acts likes a list.");
		System.out.println("Linkedlists is better for manipulating data because it acts like a list and a queue \n");
/*They are both list but the main difference is the speed of 
 * certain methods they perform like removing or searching(get)
 * or adding and memory consumption is higher for linkedlists
 */
		
//============Exercise 3: ArrayList Implementation Considerations===============
		System.out.println("==========Exercise 3==========\n");
		//creates an arraylist and adds 3 items
		ArrayList<Data> ArrayA = new ArrayList<Data>(); 
		ArrayA.add(x); 
		ArrayA.add(y); 
		ArrayA.add(z); 
		// creates empty arraylist
		ArrayList<Data> ArrayB = new ArrayList<Data>(); 
		
		System.out.println("This is ArrayListA:");
		PrintCollection(ArrayA); 
		System.out.println();
		ArrayB = ArrayA;
		System.out.println("This is ArrayListB:");
		PrintCollection(ArrayB);  
		System.out.println();
		System.out.println("This is ArrayListB with index 1 deleted from ArrayA:");
		ArrayA.remove(1);
		PrintCollection(ArrayB); 
		System.out.println();
		System.out.println("ArrayB points to ArrayA it does not copy the data which means");
		System.out.println("Anything added/ removed to ArrayA will coincide with ArrayB \n");

		
		ArrayList <Data> ArrayC = new ArrayList<Data>(); 
		ArrayList <Data> ArrayD = new ArrayList<Data>(); 
		ArrayC.add(x); 
		ArrayC.add(y); 
		ArrayC.add(z);  
		
		System.out.println("This is ArrayListC:");
		PrintCollection(ArrayC);
		System.out.println();
		ArrayD = (ArrayList<Data>)ArrayC.clone();
		ArrayC.remove(1); 
		System.out.println("Ths is ArrayC with index 1 deleted:");
		PrintCollection(ArrayC);
		System.out.println();	 
		System.out.println("This is ArrayD which cloned C before removing index 1");
		PrintCollection(ArrayD);
		System.out.println();
		System.out.println("The clone method copies all of the elements from ArrayC to ArrayD. ");
		System.out.println("Additions or deletions will only affect the individual array (and elements) \n");
//============================Exercise 3: Stacks===================================	
		System.out.println("==========Exercise 3 continued: Stacks========== \n");
		Stack<Data> stack = new Stack<Data>(); 
		stack.push(x);
		stack.push(y); 
		stack.push(z); 
// The method pop only removes the object at the top of the stack.
		
		System.out.println("This is a stack: ");
		PrintCollection(stack);  
		
		System.out.println("The poped item list from the stack is: ");
		while(stack.isEmpty() == false)
		{
			stack.pop().Print();
		}
		System.out.println();
		System.out.println("The number of items in the stack is " + stack.size());
		System.out.println("This loop prints what is poped from the stack. Hence, why the stack is empty. \n");
//===========================Exercise 4: Queues====================================
		System.out.println("==========Exercise 4========== \n");
		ArrayBlockingQueue<Data> q = new ArrayBlockingQueue<Data>(10);
		q.add(x);
		q.add(y); 
		q.add(z); 
		System.out.println("This is the queue: ");
		PrintCollection(q);
		
		System.out.println("This poll itemlist from the queue is:");
		while(q.isEmpty() == false)
		{
			q.poll().Print();
		}	
		System.out.println();
		System.out.println("The number of items in the queue is " + q.size()+"\n");
		System.out.println("This loop prints what is polled from the queue(similar to H|T function in PROLOG).");


		for(int i=0;i<20;++i)
		{
			//q.add(new Data("Test:"+String.valueOf(i),i));
			q.offer(new Data("Test:"+String.valueOf(i),i));
		}
		PrintCollection(q);
		System.out.println();
		System.out.println("This loops adds 10 new items to the queue");
		System.out.println("The maximum amount in the queue is 10.");
		System.out.println("Offer is preferred because add throw an exception");
		System.out.println("The queue is defined as 10 elements from the beginning so you cant add 20 but u can offer 20 and it takes 10.");
	} 
	
	public static void PrintCollection(Collection<Data> c)
	{
		for (Iterator<Data> iter = c.iterator(); iter.hasNext();)
		{
			Data x = (Data)iter.next();
			x.Print();
		}
		System.out.println();
	}


}
