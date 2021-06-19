package application.view;

import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainViewController {
	
	ObservableList<String> PizzaTypeList = FXCollections.observableArrayList("Build Your Own", "Deluxe", "Hawaiian");
	ObservableList<String> PizzaSizeList = FXCollections.observableArrayList("small", "medium", "large");
	
	
	ObservableList<String> ToppingsChoice = FXCollections.observableArrayList("Beef","Cheese","Chicken","Green Pepper","Ham","Mushroom","Onion","Pepperoni","Pineapple","Sausage");
	ObservableList<String> ToppingsSelected = FXCollections.observableArrayList();

	@FXML
	private ComboBox PizzaType;
	
	@FXML
	private ComboBox PizzaSize;
	
	@FXML
	private ImageView Pizza;

	@FXML
	private ListView<String> Toppings;
	
	@FXML
	private ListView<String> SelectedToppings;
	
	@FXML
	private Button AddTopping;
	
	@FXML
	private Button RemoveTopping;
	
	@FXML
	private Button ClearSelection;
	
	@FXML
	private Button AddOrder;
	
	@FXML
	private Button ShowOrder;
	
	@FXML
	private TextArea AddedOutput;
	
	private MainOutputController finalOrder = new MainOutputController();
	
	@FXML
	private void initialize()
	{
		
		PizzaType.setValue("Build Your Own");
		PizzaType.setItems(PizzaTypeList);
		
		PizzaSize.setValue("medium");
		PizzaSize.setItems(PizzaSizeList);
		
		Toppings.setItems(ToppingsChoice);
		SelectedToppings.setItems(ToppingsSelected);
		
		Image image = new Image("pizza.jpg");
		Pizza.setImage(image);
		
	}
	
	public void addToppings()
	{
		if(ToppingsChoice.isEmpty())
		{
			AddedOutput.appendText("Can't add anymore toppings!");
			AddedOutput.appendText("\n");
		}
		else if(Toppings.getSelectionModel().getSelectedItem() == null)
		{
			AddedOutput.appendText("Must choose toppings to add!");
			AddedOutput.appendText("\n");
		}
		else
		{
		    String selectedItem = Toppings.getSelectionModel().getSelectedItem();
		    ToppingsChoice.remove(selectedItem);
		    ToppingsSelected.add(selectedItem);
		}
	}
	
	public void removeToppings()
	{
		if(ToppingsSelected.isEmpty())
		{
			AddedOutput.appendText("Can't remove anymore toppings!");
			AddedOutput.appendText("\n");
		}
		else if (SelectedToppings.getSelectionModel().getSelectedItem() == null)
		{
			AddedOutput.appendText("Must choose topping to remove!");
			AddedOutput.appendText("\n");
		}
		else
		{
		    String selectedItem = SelectedToppings.getSelectionModel().getSelectedItem();
		    ToppingsSelected.remove(selectedItem);
		    ToppingsChoice.add(selectedItem);
		}
	}
	
	public void clearSelection()
	{
		if (ToppingsSelected.size() == 0)
		{
			AddedOutput.appendText("Must have selected toppings to clear order!");
			AddedOutput.appendText("\n");
		}
		
		for(int i = 0; i < ToppingsSelected.size(); i++)
		{
			ToppingsChoice.addAll(ToppingsSelected);
			ToppingsSelected.removeAll(ToppingsSelected);
		}
	}
	
	public void addOrder()
	{
		
		String sizeOfPizza = "";
		
		if(PizzaSize.getValue().toString() == "small")
			sizeOfPizza = "Small(10\")";
		
		if(PizzaSize.getValue().toString() == "medium")
			sizeOfPizza = "Medium(14\")";
		
		if(PizzaSize.getValue().toString() == "large")
			sizeOfPizza = "Large(12\")";
			
		ArrayList<String> pizzaToppings = new ArrayList<String>();
		
		for(int i = 0; i < ToppingsSelected.size(); i++)
		{
			pizzaToppings.add(ToppingsSelected.get(i));
		}
		
	    String result = "";
		
		for(int j = 0; j < pizzaToppings.size(); j++)
		{
			result += pizzaToppings.get(j).toString() + "\n";
		}
		
		if (PizzaType.getValue().toString() == "Build Your Own")
		{
			if(ToppingsSelected.isEmpty())
			{
				AddedOutput.appendText("Must choose toppings to add to pizza!");
			    AddedOutput.appendText("\n");
			}
			else if (ToppingsSelected.size() > 6)
			{	
				AddedOutput.appendText("Cannot have more than 6 toppings!");
				AddedOutput.appendText("\n");
			}
		    else
			{
			    Pizza toBeAdded = new BuildYourOwn(sizeOfPizza, pizzaToppings);
		        finalOrder.add(toBeAdded);
		    
		        AddedOutput.appendText("BYO pizza added to order!");
		        AddedOutput.appendText("\n");
			}
		
		}
		
		if (PizzaType.getValue().toString() == "Deluxe")
		{
			if(!(ToppingsSelected.isEmpty()))
			{
				AddedOutput.appendText("Cannot add extra toppings to deluxe pizza!");
			    AddedOutput.appendText("\n");	
			}
			
			else
			{
			    Pizza toBeAdded = new Deluxe(sizeOfPizza);
		        finalOrder.add(toBeAdded);
		    
		        AddedOutput.appendText("Deluxe Pizza added to order!");
		        AddedOutput.appendText("\n");
			}
		}
		
		if (PizzaType.getValue().toString() == "Hawaiian")
		{
			if(!(ToppingsSelected.isEmpty()))
			{
				AddedOutput.appendText("Cannot add extra toppings to hawaiian pizza!");
			    AddedOutput.appendText("\n");	
			}
			
			Pizza toBeAdded = new Hawaiian(sizeOfPizza);
		    finalOrder.add(toBeAdded);
		    
		    AddedOutput.appendText("Hawaiian pizze added to order!");
		    AddedOutput.appendText("\n");
		}
		
		
		ToppingsChoice.addAll(ToppingsSelected);
		ToppingsSelected.removeAll(ToppingsSelected);
		
	}
	
	public void showOrder()
	{	
		
		 try {
	            FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("MainOutput.fxml"));
	            Parent root = (Parent) fxmlloader.load();
	            Stage stage = new Stage();
	            stage.initModality(Modality.APPLICATION_MODAL);
	            stage.setTitle("Pizza Order");
	            stage.setScene(new Scene(root, 450, 450));
	            stage.show();
	        }
	        catch (IOException e) {
	            e.printStackTrace();
	        }
		 
		 
	}
}
