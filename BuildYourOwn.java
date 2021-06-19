package application.view;

import java.util.ArrayList;

public class BuildYourOwn extends Pizza{
	private int PRICE_HAWAIIAN_SMALL = 5;
	private int PRICE_HAWAIIAN_MEDIUM = 7;
	private int PRICE_HAWAIIAN_LARGE = 9;
	private int PRICE_INDIVIDUAL_TOPPING = 2;
	

	public BuildYourOwn(String size, ArrayList<String> toppings)
	{
		super("BYO style", size, toppings);
	}

	
	public int pizzaPrice() {
		switch(size) {
		// 3 cases
			case (SMALL):
				return PRICE_HAWAIIAN_SMALL + (toppings.size() * PRICE_INDIVIDUAL_TOPPING);
			case (MEDIUM):
				return PRICE_HAWAIIAN_MEDIUM + (toppings.size() * PRICE_INDIVIDUAL_TOPPING);
			case (LARGE):
				return PRICE_HAWAIIAN_LARGE + (toppings.size() * PRICE_INDIVIDUAL_TOPPING);
			default :
				return -1;
		}
	}
	
	public static void main(String[] args)
	{
		ArrayList<String> style1 = new ArrayList<String>();
		ArrayList<String> style2 = new ArrayList<String>();
		ArrayList<String> style3 = new ArrayList<String>();
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
		
		System.out.println(byo1);
		System.out.println(byo2);
		System.out.println(byo3);
		System.out.println(byo4);
		System.out.println(byo5);
		System.out.println(byo6);
		System.out.println(byo7);
		System.out.println(byo8);
		System.out.println(byo9);
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
