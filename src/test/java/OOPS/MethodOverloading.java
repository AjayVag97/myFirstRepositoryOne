package OOPS;

public class MethodOverloading 
{
	
	// Method Overloading = Same METHOD with differnet data type and parameter 
		static int plusMethodInt(int x, int y)
		{
			  return x + y;
			  //System.out.println(x+y);
		}

		static double plusMethodDouble(double x, double y) 
		{
			  return x + y;
		}

		public static void main(String[] args)
		{
			  int myNum1 = plusMethodInt(800, 500);
			  System.out.println("Integer Total : " + myNum1);
			  
			  double myNum2 = plusMethodDouble(4.3, 6.26);
			  System.out.println("Double Total : " + myNum2);
		}

}


