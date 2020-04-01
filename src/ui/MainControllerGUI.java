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

	@FXML
	void searchBranchOffice(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("searchBranchOffice.fxml"));

		fxmlLoader.setController(this);
		Parent searchBranchOffice = fxmlLoader.load();

		mainPane.getChildren().clear();
		mainPane.getChildren().add(searchBranchOffice);
	}

	@FXML
	void removeBranchOffice(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("removeBranchOffice.fxml"));

		fxmlLoader.setController(this);
		Parent removeBranchOffice = fxmlLoader.load();

		mainPane.getChildren().clear();
		mainPane.getChildren().add(removeBranchOffice);
	}

	@FXML
	void branchOfficesReport(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("reportBranchOffice.fxml"));

		fxmlLoader.setController(this);
		Parent reportBranchOffice = fxmlLoader.load();

		mainPane.getChildren().clear();
		mainPane.getChildren().add(reportBranchOffice);
	}

	@FXML
	void reportEmployees(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("reportEmployee.fxml"));

		fxmlLoader.setController(this);
		Parent reportEmployee = fxmlLoader.load();

		mainPane.getChildren().clear();
		mainPane.getChildren().add(reportEmployee);
	}

	@FXML
	void reportContract(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("reportContract.fxml"));

		fxmlLoader.setController(this);
		Parent reportContract = fxmlLoader.load();

		mainPane.getChildren().clear();
		mainPane.getChildren().add(reportContract);
	}

	@FXML
	void reportFinancial(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("financialReport.fxml"));

		fxmlLoader.setController(this);
		Parent financialReport = fxmlLoader.load();

		mainPane.getChildren().clear();
		mainPane.getChildren().add(financialReport);
	}

	@FXML
	void financialOpts(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("financialOpts.fxml"));

		fxmlLoader.setController(this);
		Parent financialOpts = fxmlLoader.load();

		mainPane.getChildren().clear();
		mainPane.getChildren().add(financialOpts);
	}

	@FXML
	void addCompany(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("addCompany.fxml"));

		fxmlLoader.setController(this);
		Parent addCompany = fxmlLoader.load();

		mainPane.getChildren().clear();
		mainPane.getChildren().add(addCompany);
	}

	@FXML
	void removeCompany(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("removeCompany.fxml"));

		fxmlLoader.setController(this);
		Parent removeCompany = fxmlLoader.load();

		mainPane.getChildren().clear();
		mainPane.getChildren().add(removeCompany);
	}

	@FXML
	void sellCompany(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sellCompany.fxml"));

		fxmlLoader.setController(this);
		Parent sellCompany = fxmlLoader.load();

		mainPane.getChildren().clear();
		mainPane.getChildren().add(sellCompany);
	}

}