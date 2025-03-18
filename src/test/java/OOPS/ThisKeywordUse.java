package OOPS;

public class ThisKeywordUse 
{
	int a;
	int b;
	
	public void setData(int x, int y)
	{
		   this.a=x;
		   this.b=y;
	}
	
	public void showData()
	{
		System.out.println("VALUE OF A = "  +a );
		System.out.println("VALUE OF B = "  +b );
	}
	
	public static void main(String[] args)
	{
		ThisKeywordUse myobj = new ThisKeywordUse();
		myobj.setData(7, 7);
		myobj.showData();
		

	}

}
