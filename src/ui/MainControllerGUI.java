package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
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

	@FXML
	private TextField nameNewEmpTF;

	@FXML
	private TextField idNewEmpTF;

	@FXML
	private TextField addresNewEmpTF;

	@FXML
	private TextField phoneNewEmpTF;

	@FXML
	private TextField salaryNewEmpTF;

	@FXML
	private TextField idContractNewEmpTF;

	@FXML
	private TextField jobNewEmpTF;

	/**
	 * @param theHolding
	 */
	public MainControllerGUI(HoldingMasterClass theHolding) {
		this.theHolding = theHolding;
	}

	@FXML
	void addEmployee(ActionEvent event) throws IOException {

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("addEmployee.fxml"));

		fxmlLoader.setController(this);
		Parent addEmployee = fxmlLoader.load();

		mainPane.getChildren().clear();
		mainPane.getChildren().add(addEmployee);
	}

	@FXML
	void jobEjecutive(ActionEvent event) {
		jobNewEmpTF.setText("Ejecutivo");
	}

	@FXML
	void jobOV(ActionEvent event) {
		jobNewEmpTF.setText("Oficios Varios");
	}

	@FXML
	void jobOfficer(ActionEvent event) {
		jobNewEmpTF.setText("Oficinista");
	}

	@FXML
	void saveNewEmployee(ActionEvent event) {

	}

	@FXML
	void removeEmployee(ActionEvent event) throws IOException {

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("removeEmployee.fxml"));

		fxmlLoader.setController(this);
		Parent removeEmployee = fxmlLoader.load();

		mainPane.getChildren().clear();
		mainPane.getChildren().add(removeEmployee);

	}

	@FXML
	void searchEmployee(ActionEvent event) throws IOException {

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("searchEmployee.fxml"));

		fxmlLoader.setController(this);
		Parent searchEmployee = fxmlLoader.load();

		mainPane.getChildren().clear();
		mainPane.getChildren().add(searchEmployee);
	}

	@FXML
	void addContract(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("addContract.fxml"));

		fxmlLoader.setController(this);
		Parent addContract = fxmlLoader.load();

		mainPane.getChildren().clear();
		mainPane.getChildren().add(addContract);
	}

	@FXML
	void showCredits(ActionEvent event) {

		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Creditos");
		alert.setHeaderText("Desarrolladores:");
		alert.setContentText("JUAN MARTINEZ\n\nCAMILO CORDOBA");

		alert.showAndWait();

	}

	@FXML
	void removeContract(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("removeContract.fxml"));

		fxmlLoader.setController(this);
		Parent removeContract = fxmlLoader.load();

		mainPane.getChildren().clear();
		mainPane.getChildren().add(removeContract);
	}

	@FXML
	void searchContract(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("searchContract.fxml"));

		fxmlLoader.setController(this);
		Parent searchContract = fxmlLoader.load();

		mainPane.getChildren().clear();
		mainPane.getChildren().add(searchContract);
	}

	@FXML
	void addBranchOffice(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("addBranchOffice.fxml"));

		fxmlLoader.setController(this);
		Parent addBranchOffice = fxmlLoader.load();

		mainPane.getChildren().clear();
		mainPane.getChildren().add(addBranchOffice);
	}


}