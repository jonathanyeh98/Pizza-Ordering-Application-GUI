package application.view;

public class Hawaiian extends Pizza{
	private int PRICE_HAWAIIAN_SMALL = 8;
	private int PRICE_HAWAIIAN_MEDIUM = 10;
	private int PRICE_HAWAIIAN_LARGE = 12;
	

	public Hawaiian(String size)
	{
		super("Hawaiian", size);
		toppings.add("Ham");
		toppings.add("Pineapple");
	}

	
	public int pizzaPrice() {
		switch(size) {
		// 3 cases
			case (SMALL):
				return PRICE_HAWAIIAN_SMALL;
			case (MEDIUM):
				return PRICE_HAWAIIAN_MEDIUM;
			case (LARGE):
				return PRICE_HAWAIIAN_LARGE;
			default :
				return -1;
		}
	}
	
	public static void main(String[] args)
	{
		Hawaiian hawaiian1 = new Hawaiian(SMALL);
		Hawaiian hawaiian2 = new Hawaiian(MEDIUM);
		Hawaiian hawaiian3 = new Hawaiian(LARGE);
		
		System.out.println(hawaiian1);
		System.out.println(hawaiian2);
		System.out.println(hawaiian3);
	}

}
