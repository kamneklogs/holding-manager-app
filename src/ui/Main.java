package ui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.*;
import thread.*;

public class Main extends Application {

	private Holding theHolding;
	private MainControllerGUI theMainControllerGUI;

	private ThreadOne t1;
	private ThreadTwo t2;
	private ThreadThree t3;

	public Main() throws IOException {
	
		theHolding = new Holding(Holding.NAME, 12000000);
		theMainControllerGUI = new MainControllerGUI(theHolding);

	}

	public static void main(String[] args) {

		launch(args);
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("mainWindow.fxml"));

		fxmlLoader.setController(theMainControllerGUI);

		Parent root = fxmlLoader.load();

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("SEROS GROUP - MANAGER APP  v 1.1");
		primaryStage.show();

	}
}
