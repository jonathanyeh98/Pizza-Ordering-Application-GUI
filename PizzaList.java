package application.view;

import java.util.ArrayList;

public class PizzaList {
	private final static String SMALL = "Small(10\")";
	private final static String MEDIUM = "Medium(14\")";
	private final static String LARGE = "Large(12\")";
	
	ArrayList<Pizza> list;
	
	public PizzaList()
	{
		list = new ArrayList<Pizza>();
	}
	
	public void add(Pizza p)
	{
		list.add(p);
	}
	
	public void clear()
	{
		list = new ArrayList<Pizza>();
	}
	
	public String toString()
	{
		String result = "";
		int total = 0;
		for(int i = 0 ; i < list.size(); i++) 
		{
			total += list.get(i).pizzaPrice();
			result += list.get(i).toString() + "\n";
		}
		result += "Total: $" + total;
		return result;
	}
	

	public static void main(String[] args)
	{
		PizzaList testList = new PizzaList();
		
		ArrayList<String> byoToppings = new ArrayList<String>();
		byoToppings.add("Cheese");
		byoToppings.add("Pepperoni");
		byoToppings.add("Sausage");
		
		Hawaiian hawaiian1 = new Hawaiian(SMALL);
		Deluxe deluxe1 = new Deluxe(MEDIUM);
		BuildYourOwn byo1 = new BuildYourOwn(LARGE,byoToppings);
		
		testList.add(hawaiian1);
		testList.add(deluxe1);
		testList.add(byo1);
		
		System.out.println(testList.toString());
		
		
	}
}
