package OOPS;

public class ForLoopBreakContinue 
{

	public static void main(String[] args) 
	{
		
		for(int i=1; i<=10; i++)
		{
			if(i==10)
			{
				break;  //  Break Example 
			}
			System.out.println("BREAK statement condition matched= " +i);
			
		}
		System.out.println();
		//String[] myarr= {"AJAY","VIJAY","JAY"};
	
		for(int j=0; j<10; j++)
		{
			if(j==10)
			{
				continue;
			}
			System.out.println("CONTINUE statement condition matched =" +j);
		}
	}	
}






