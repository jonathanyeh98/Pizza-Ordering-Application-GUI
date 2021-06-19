package application.view;

import java.util.ArrayList;

public class JUnitTestCases {

	private final static String SMALL = "Small(10\")";
	private final static String MEDIUM = "Medium(14\")";
	private final static String LARGE = "Large(12\")";

	
	
	public static void main(String[] args)
	{
		ArrayList<String> style1 = new ArrayList<String>();
		ArrayList<String> style2 = new ArrayList<String>();
		ArrayList<String> style3 = new ArrayList<String>();
		ArrayList<String> style4 = new ArrayList<String>();
		ArrayList<String> style5 = new ArrayList<String>();
		ArrayList<String> fail1 = new ArrayList<String>();
		ArrayList<String> fail2 = new ArrayList<String>();
		
		style1.add("Cheese");
		
		style2.addAll(style1);
		style2.add("Bacon");
		style2.add("Pepperoni");
		

		style3.addAll(style2);
		style3.add("Sausage");
		style3.add("Ham");
		style3.add("Black Olives");
		
		style4.add("Black Olives");
		style4.add("Cheese");
		
		style5.addAll(style2);
		style5.add("Sausage");
		
		fail2.addAll(style3);
		fail2.add("Grass");
		
		BuildYourOwn byo1 = new BuildYourOwn(SMALL,style1);
		BuildYourOwn byo2 = new BuildYourOwn(MEDIUM,style1);
		BuildYourOwn byo3 = new BuildYourOwn(LARGE,style1);
		
		BuildYourOwn byo4 = new BuildYourOwn(SMALL,style2);
		BuildYourOwn byo5 = new BuildYourOwn(MEDIUM,style2);
		BuildYourOwn byo6 = new BuildYourOwn(LARGE,style2);
		
		BuildYourOwn byo7 = new BuildYourOwn(SMALL,style3);
		BuildYourOwn byo8 = new BuildYourOwn(MEDIUM,style3);
		BuildYourOwn byo9 = new BuildYourOwn(LARGE,style3);
		
		BuildYourOwn byo10 = new BuildYourOwn(SMALL,style4);
		BuildYourOwn byo11 = new BuildYourOwn(MEDIUM,style4);
		BuildYourOwn byo12 = new BuildYourOwn(LARGE,style4);
		
		BuildYourOwn byo13 = new BuildYourOwn(SMALL,style5);
		BuildYourOwn byo14 = new BuildYourOwn(MEDIUM,style5);
		BuildYourOwn byo15 = new BuildYourOwn(LARGE,style5);
		
		System.out.println(byo1);
		System.out.println(byo2);
		System.out.println(byo3);
		System.out.println(byo4);
		System.out.println(byo5);
		System.out.println(byo6);
		System.out.println(byo7);
		System.out.println(byo8);
		System.out.println(byo9);
		System.out.println(byo10);
		System.out.println(byo11);
		System.out.println(byo12);
		System.out.println(byo13);
		System.out.println(byo14);
		System.out.println(byo15);
		System.out.println();
		
		try 
		{
			BuildYourOwn noToppings = new BuildYourOwn(SMALL,fail1);
		}
		catch(IllegalArgumentException e)
		{
			System.out.println("Attempt to add pizza with no toppings has failed");
		}
		
		System.out.println();
		
		try 
		{
			BuildYourOwn tooManyToppings = new BuildYourOwn(SMALL,fail2);
		}
		catch(IllegalArgumentException e)
		{
			System.out.println("Attempt to add pizza with 7 toppings has failed");
		}
	}
}
