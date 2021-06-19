package application;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class Main extends Application {
	
	private Stage primaryStage;
	private BorderPane mainLayout;
	
	@Override
	public void start(Stage primaryStage) {
		try 
		{
			this.primaryStage = primaryStage;
			this.primaryStage.setTitle("Project 4: Pizza Store");
			showMainView();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Method to create and show scene created through FXML
	 * @throws IOException
	 */
    private void showMainView() throws IOException
    {
	    FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/MainView.fxml"));
		mainLayout = loader.load();
		Scene scene = new Scene(mainLayout);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
    /**
     * Main function to launch scene
     * @param args
     */
	public static void main(String[] args) {
		launch(args);
	}
}
