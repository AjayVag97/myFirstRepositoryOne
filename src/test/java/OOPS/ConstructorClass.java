package OOPS;

/*
//Create a class   (WITHOUT PARAMETER)
public class ConstructorClass 
{
	int a; //Create a class attribute

	// Create a class constructor for the above class
	public ConstructorClass()
	{
		a=10;  // Set the initial value for the class attribute x
	}

	public static void main(String[] args) 
	{
		ConstructorClass myobjec = new ConstructorClass(); // Create an object of class (This will call the constructor)
		System.out.println(myobjec.a);  // Print the value of a 
	}
}
*/

//Create a class   (WITH PARAMETER)
public class ConstructorClass 
{
	int myYear;
	String myMonth;
	
	public ConstructorClass(int Year, String Month) 
	{
		myYear = Year;
		myMonth = Month;
	}
	
	public static void main(String[] args)
	{
		ConstructorClass mynewObj = new ConstructorClass(2024,"JULY");
		
		System.out.println(mynewObj.myYear +" "+ mynewObj.myMonth);
	}
}



