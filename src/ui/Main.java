package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.*;
import thread.*;

public class Main extends Application {

	private HoldingMasterClass theHolding;
	private MainControllerGUI theMainControllerGUI;

	private ThreadOne t1;
	private ThreadTwo t2;
	private ThreadThree t3;

	public Main() {
		theHolding = new HoldingMasterClass(HoldingMasterClass.NAME, "21232", null, null, 12000000, null, null, null);
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
		primaryStage.setTitle("SEROS GROUP - MANAGER APP V.1");
		primaryStage.show();

	}
}
