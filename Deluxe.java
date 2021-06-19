package application.view;

public class Deluxe extends Pizza {	
	private int PRICE_DELUXE_SMALL = 14;
	private int PRICE_DELUXE_MEDIUM = 16;
	private int PRICE_DELUXE_LARGE = 18;
	

	public Deluxe(String size)
	{
		super("Deluxe", size);
		toppings.add("Sausage");
		toppings.add("Pepperoni");
		toppings.add("Green Pepper");
		toppings.add("Onion");
		toppings.add("Mushroom");
	}

	
	public int pizzaPrice() {
		switch(size) {
		// 3 cases
			case (SMALL):
				return PRICE_DELUXE_SMALL;
			case (MEDIUM):
				return PRICE_DELUXE_MEDIUM;
			case (LARGE):
				return PRICE_DELUXE_LARGE;
			default :
				return -1;
		}
	}
	
	public static void main(String[] args)
	{
		Deluxe deluxe1 = new Deluxe(SMALL);
		Deluxe deluxe2 = new Deluxe(MEDIUM);
		Deluxe deluxe3 = new Deluxe(LARGE);
		
		System.out.println(deluxe1);
		System.out.println(deluxe2);
		System.out.println(deluxe3);
	}

}
