package OOPS;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ArrayListLinkList
{
	public static void main(String[] args)
	{
		
		// ArrayList of Integers numerically
		 ArrayList<Integer> myNumbers = new ArrayList<Integer>();
		 myNumbers.add(55);
		 myNumbers.add(1);
		 myNumbers.add(29);
		 myNumbers.add(44);
		 myNumbers.add(4); 
		 myNumbers.add(22);
		  
		 Collections.sort(myNumbers, Collections.reverseOrder()); // Sort cars 
		 // Collections.sort(myNumbers); // Sort integer array in ASE order 
		  for(int X :myNumbers)
		  {
		    System.out.println(X);
		  }
				
		/*	// ArrayList of String data 
		 ArrayList<String> mycar = new ArrayList<String>(); 
		 mycar.add("PORSCHE");
		 mycar.add("BMW");
		 mycar.add("AUDI");
		 mycar.add("ISUZU"); 
		 mycar.add("CITRON");
		 mycar.add(0,"Mazda");   // Set on 0 index position
		 System.out.println(mycar); // [Mazda, PORSCHE, BMW, AUDI, ISUZU, CITRON]
		 System.out.println("===================================================");
		 
		 Collections.sort(mycar);  // Sort mycar object in alphabets order wise 
	     for(String i : mycar) 
	     {
		      System.out.println(i);
		 }
	  */
	}
}
