package OOPS;

public class MethodCalling 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		System.out.println("Testing ");
							
		MethodCalling.myPublicMethod(); // Calling 2nd method 
		
		mystaticMethod();		// Calling 1st method 
	}
	
	static void mystaticMethod()
	{
		System.out.println("THIS IS STATIC METHOD calling 1st method ");
	}
	
	public static void myPublicMethod()
	{
		System.out.println("THIS IS PUBLIC STATIC METHOD calling 2nd method");
	}

	
	
}
