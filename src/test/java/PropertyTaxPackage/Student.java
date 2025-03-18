package PropertyTaxPackage;

public class Student
{
	//data member (also instance variable)
	int id;
	int id1=10;;
    //data member (also instance variable)
    String name;
    String name1="ALEXA";
 
    public static void main(String args[])
    {
        // creating an object of Student
       /* Student s1 = new Student();
        System.out.println(s1.id);
        System.out.println(s1.id1);
        System.out.println(s1.name);
        System.out.println(s1.name1);   
        */ 
    	    	 
      //Try block to check for exceptions
        try
        {
            Class cls = Class.forName("Student");
            // Creating object of main class
            // using instance method
            Student obj = (Student)cls.newInstance();
            // Print and display
            System.out.println(obj.name);
        }        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (InstantiationException e) 
        {
 
            e.printStackTrace();
        }
        catch (IllegalAccessException e) 
        {
 
            e.printStackTrace();
        }
    }
}