package OOPS;

public class PublicStaticMethodCalling 
{

	static void myStaticMethod()
	{
		System.out.println("Calling static method without create object");
	}	
	
	public void myPublicMethod()
	{
		System.out.println("Calling Public Method create Object of class");
	}	

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		myStaticMethod();
		
		PublicStaticMethodCalling myObject= new PublicStaticMethodCalling();
		myObject.myPublicMethod();
	}
}

