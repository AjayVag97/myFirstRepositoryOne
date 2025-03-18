package PropertyTaxPackage;

import java.util.Scanner;

public class ScannerClassExample1 
{

	public static void main(String[] args)
	{
		String s = "Hello, This is JavaTpoint.";  
        //Create scanner Object and pass string in it  
        Scanner scan = new Scanner(s);  
        
        //Check if the scanner has a token  
        System.out.println("Boolean Result: " + scan.hasNext());  
        
        //Print the string  
        System.out.println("String: " +scan.nextLine());  
        scan.close();       
        
        System.out.println("--------Enter Your Details-------- ");  
        
        Scanner in = new Scanner(System.in);  
        System.out.print("Enter your name: ");    
        String name = in.next();   
        System.out.println("My Name is : " + name);           
        
        System.out.print("Enter your age: ");  
        int i = in.nextInt();  
        System.out.println("My Age is: " + i);  
        
        System.out.print("Enter your salary: ");  
        double d = in.nextDouble();  
        System.out.println("Salary: " + d);         
        in.close();           
        }    
}  