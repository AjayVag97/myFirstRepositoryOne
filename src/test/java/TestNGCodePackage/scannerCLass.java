package TestNGCodePackage;

import java.util.Scanner;

public class scannerCLass 
{
		// TODO Auto-generated method stub
		public static void main(String[] args) 
		{
			  //Create scanner Object and pass string in it  
			Scanner scn = new Scanner(System.in);  
			
	        System.out.print("Enter your name: ");  
	        String name = scn.nextLine();
	        
	        System.out.println("My name is: " + name);             
	        scn.close();        
	        
	        }  
	}  