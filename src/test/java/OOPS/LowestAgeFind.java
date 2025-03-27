package OOPS;

public class LowestAgeFind 
{
	public static void main(String[] args)
	{
		// An array storing different ages
		int ages[] = {20, 22, 18, 35, 48, 26, 87, 70, 90};

		// Create a 'lowest age' variable and assign the first array element of ages to it
		int lowestAge = ages[0];

		// Loop through the elements of the ages array to find the lowest age
		for (int smallage : ages) 
		{
		  // Check if the current age is smaller than the current 'lowest age'
		  if (lowestAge > smallage) 
		  {
		    // If the smaller age is found, update 'lowest age' with that element
		    lowestAge = smallage;
		  }
		}

		// Output the value of the lowest age
		System.out.println("The lowest age in the array is  = " + lowestAge);

	}

}
