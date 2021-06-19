package application.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;


public class MainOutputController {
	
	private static PizzaList pizzas = new PizzaList();

	@FXML
	private TextArea Output;
	
	@FXML
	private Button ClearOrder;
	
	@FXML
	private Button Back;
	
	public MainOutputController()
	{
	}
	
	public void add(Pizza pizza)
	{
		pizzas.add(pizza);
	}
	
	
	@FXML
	public void initialize()
	{
		if(pizzas.list.isEmpty())
		Output.appendText("");
		else
		Output.appendText(pizzas.toString());
	}
	
	public void clearOrder()
	{
		pizzas = new PizzaList();
		Output.setText("");
	}
	
	public void closeWindow()
	{
		Stage stage = (Stage) Back.getScene().getWindow();
	    stage.close();
	}
	
}
