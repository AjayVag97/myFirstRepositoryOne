package OOPS;


interface FirstInterface 
{
	public void myMethod(); // interface method
}

interface SecondInterface 
{
	public void myOtherMethod(); // interface method
}

class InterfaceMulti1 implements FirstInterface, SecondInterface 
{
	public void myMethod() 
	{
		System.out.println("Calling MyMethod ");
	}
	public void myOtherMethod() 
	{
		System.out.println("Calling OTHER Method ");
	}
}

class InterfaceMulti 
{
	public static void main(String[] args) 
	{
		InterfaceMulti1 myObj = new InterfaceMulti1();
		myObj.myMethod();
		myObj.myOtherMethod();
	}
}



