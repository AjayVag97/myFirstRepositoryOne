package OOPS;

//Java Program to implement
//Java this reference
//Driver Class
public class PersonTHIS 
{
	// Fields Declared
	String name;
	int age;

	// Constructor
	PersonTHIS(String fname, int age)
	{
		this.name = fname;
		this.age = age;
	}

	// Getter for name
	public String get_name() 
	{ 
		return name; 
	}

	// Setter for name
	public void change_name(String CCname)
	{
		this.name = CCname;
	}

	// Method to Print the Details of
	// the person
	public void printDetails()
	{
		System.out.println("Name=: " + name);
		System.out.println("Age=: " + age);
		System.out.println();
	}

	// main function
	public static void main(String[] args)
	{
		// Objects Declared
		PersonTHIS first = new PersonTHIS("AJAY", 18);
		first.printDetails();
		
		PersonTHIS second = new PersonTHIS("VAGHODE", 22);
		second.printDetails();

		first.change_name("ALEXA");
		System.out.println("Name has been changed to: "	+ first.get_name());
	}
}
