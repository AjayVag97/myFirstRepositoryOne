package OOPS;

public class swapingValue 
{
	public static void main(String[] args)
	{
	int a=11;
	int b=22;
	
	swapFun(a,b);

	}

	public static void swapFun(int a,int b)
	{
	
		System.out.println("Before Swap  a=" +a+ " b = "+b);
		int c=a;
		a=b;
		b=c;
		System.out.println("Afer Swap  a=" +a+ " b = "+b);
	}
	
	
}
