package OOPS;

public class Array 
{

	public static void main(String[] args) 
	{
	
		// A Multidimensional Array 
		//int[][] myNumbers = { {1, 2, 3, 4}, {5, 6, 7} };
		//System.out.println(myNumbers[1][2]);
		// Outputs 7
		
		// A int Array storing different ages
		//int ages[] = {20, 22, 18, 35, 48, 26, 87, 70};
		
		//A String Array storing differnets car name 
		String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
		//cars[0] = "Opel";
		
		System.out.println(cars[3]);
		
		System.out.println(cars.length);
		
		for(int i = 0; i < cars.length; i++) 
		{
			  System.out.println(cars[i]);
		}
		
		for(String i:cars)
		{
			System.out.println("This is your array value " + i);
		}
		

	}
}
