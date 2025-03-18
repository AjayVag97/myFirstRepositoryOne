package OOPS;

public class FinalClass 
{
	 final int x = 10;
	 final double PI = 3.14;

	  public static void main(String[] args) 
	  {
	  
		FinalClass myObj = new FinalClass();
	    
		myObj.x = 50; // will generate an error: cannot assign a value to a final variable
	    
		myObj.PI = 25; // will generate an error: cannot assign a value to a final variable
	    
		System.out.println(myObj.x);
	  
	  }
}