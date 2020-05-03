package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


import model.HoldingMasterClass;

public class MainControllerGUI {

    private HoldingMasterClass theHolding;

    @FXML
    private ToggleGroup empleadosToggleGroup;

    @FXML
    private ToggleGroup contratosToggleGroup;

    @FXML
    private ToggleGroup sedesToggleGroup;

    @FXML
    private ToggleGroup reportesToggleGroup;

    @FXML
    private ToggleGroup finanzasToggleGroup;

    @FXML
    private ToggleGroup administracionToggleGroup;

    @FXML
    private Font x1;

    @FXML
    private Color x2;

    @FXML
    private Font x3;

    @FXML
    private Color x4;


    @FXML
    private AnchorPane mainPane;

    /**
     * @param theHolding
     */
    public MainControllerGUI(HoldingMasterClass theHolding) {
        this.theHolding = theHolding;
    }

    // @FXML
    // void addEmployee(ActionEvent event)throws IOException {

    //     FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("addEmployee.fxml"));

	// 	fxmlLoader.setController(this);
	// 	Parent addEmployee = fxmlLoader.load();


	// mainPane.getChildren().clear();
	// mainPane.getChildren().add(addEmployee);
    // }

}