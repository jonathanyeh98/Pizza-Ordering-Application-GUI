package application.view;

import java.util.ArrayList;

public abstract class Pizza {
	//Constants
	protected final static String SMALL = "Small(10\")";
	protected final static String MEDIUM = "Medium(14\")";
	protected final static String LARGE = "Large(12\")";

    protected String style;
    protected String size;
    protected ArrayList<String> toppings;
    
    public Pizza(String style, String size, ArrayList<String> toppings) throws IllegalArgumentException {
    	if(toppings.size() > 6)
    	{
    		throw new IllegalArgumentException("Cannot have more than 6 toppings");
    	}
    	else if(toppings.size() <= 0)
    	{
    		throw new IllegalArgumentException("Needs at least 1 topping");
    	}
    	else
    	{
    		this.style = style;
    		this.size = size;
    		this.toppings = toppings;
    	}
    }
    
    public Pizza(String style, String size) {
    	this.style = style;
    	this.size = size;
    	this.toppings = new ArrayList<String>();
    }
    
    public abstract int pizzaPrice();
    
    public String toString() { 
        String result;
        
        result = "Price: $" + this.pizzaPrice() + "\n\t- " + size + "\t" + style + " pizza\t[";
        
        for(int i = 0; i < toppings.size(); i++)
        {
        	result += toppings.get(i);
        	if(i != toppings.size() - 1)
        	{
        		result += ", ";
        	}
        }
        
        result += "]";
        
        return result;
    }
}