package ui;

import java.io.IOException;

import customExceptions.NotFundBrandOfficeException;
import customExceptions.WithoutCurrentCompany;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import model.*;

public class MainControllerGUI {

	private Holding theHolding;

	private Company currentCompany;

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

	@FXML
	private TextField idForSearchBranchOffice;

	@FXML
	private Label addressForSearchBrand;

	@FXML
	private Label idForSearchBrand;

	@FXML
	private AnchorPane detailsPane;

	@FXML
	private Label infoFoundCompanyLabel;

	@FXML
	private Button changeCompanyButton;

	/**
	 * @param theHolding
	 * @throws IOException
	 */
	public MainControllerGUI(Holding theHolding) throws IOException {
		this.theHolding = theHolding;

	}

	public void ccObject() throws WithoutCurrentCompany {
		if (currentCompany == null) {
			throw new WithoutCurrentCompany();
		}
	}

	@FXML
	void runSearchBrandOffice(ActionEvent event) {
		try {
			theHolding.getCurrentCompany().searchBrandOffice(idForSearchBranchOffice.getText());
			addressForSearchBrand.setText(
					theHolding.getCurrentCompany().searchBrandOffice(idForSearchBranchOffice.getText()).getAddress());
			idForSearchBranchOffice.setText(
					theHolding.getCurrentCompany().searchBrandOffice(idForSearchBranchOffice.getText()).getId());

		} catch (NotFundBrandOfficeException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Error.");
			alert.setContentText("Sede inexistente");

			alert.showAndWait();
		}
	}

	@FXML
	void addEmployeeWindow(ActionEvent event) throws IOException {

		try {
			ccObject();
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("addEmployee.fxml"));

			fxmlLoader.setController(this);
			Parent addEmployee = fxmlLoader.load();

			mainPane.getChildren().clear();
			mainPane.getChildren().add(addEmployee);
		} catch (WithoutCurrentCompany e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText(e.getMessage());
			alert.setContentText("Para elegir una empresa actual dirigase a Administracion>>Cambiar empresa");

			alert.showAndWait();
			changeCompanyWindow();
		}

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
	void removeEmployeeWindow(ActionEvent event) throws IOException {

		try {
			ccObject();
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("removeEmployee.fxml"));

			fxmlLoader.setController(this);
			Parent removeEmployee = fxmlLoader.load();

			mainPane.getChildren().clear();
			mainPane.getChildren().add(removeEmployee);
		} catch (WithoutCurrentCompany e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText(e.getMessage());
			alert.setContentText("A continuacion asigne una emprea.");

			alert.showAndWait();
			changeCompanyWindow();

		}

	}

	@FXML
	void searchEmployeeWindow(ActionEvent event) throws IOException {

		try {
			ccObject();
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("searchEmployee.fxml"));

			fxmlLoader.setController(this);
			Parent searchEmployee = fxmlLoader.load();

			mainPane.getChildren().clear();
			mainPane.getChildren().add(searchEmployee);
		} catch (WithoutCurrentCompany e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText(e.getMessage());
			alert.setContentText("Para elegir una empresa actual dirigase a Administracion>>Cambiar empresa");

			alert.showAndWait();
			changeCompanyWindow();
		}
	}

	@FXML
	void addContractWindow(ActionEvent event) throws IOException {

		try {
			ccObject();
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("addContract.fxml"));

			fxmlLoader.setController(this);
			Parent addContract = fxmlLoader.load();

			mainPane.getChildren().clear();
			mainPane.getChildren().add(addContract);
		} catch (WithoutCurrentCompany e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText(e.getMessage());
			alert.setContentText("Para elegir una empresa actual dirigase a Administracion>>Cambiar empresa");

			alert.showAndWait();
			changeCompanyWindow();
		}
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
	void removeContractWindow(ActionEvent event) throws IOException {

		try {
			ccObject();
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("removeContract.fxml"));
			fxmlLoader.setController(this);
			Parent removeContract = fxmlLoader.load();

			mainPane.getChildren().clear();
			mainPane.getChildren().add(removeContract);
		} catch (WithoutCurrentCompany e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText(e.getMessage());
			alert.setContentText("Para elegir una empresa actual dirigase a Administracion>>Cambiar empresa");

			alert.showAndWait();
			changeCompanyWindow();
		}
	}

	@FXML
	void searchContractWindow(ActionEvent event) throws IOException {

		try {
			ccObject();
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("searchContract.fxml"));

			fxmlLoader.setController(this);
			Parent searchContract = fxmlLoader.load();

			mainPane.getChildren().clear();
			mainPane.getChildren().add(searchContract);
		} catch (WithoutCurrentCompany e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText(e.getMessage());
			alert.setContentText("Para elegir una empresa actual dirigase a Administracion>>Cambiar empresa");

			alert.showAndWait();
			changeCompanyWindow();
		}
	}

	@FXML
	void addBranchOfficeWindow(ActionEvent event) throws IOException {

		try {
			ccObject();
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("addBranchOffice.fxml"));

			fxmlLoader.setController(this);
			Parent addBranchOffice = fxmlLoader.load();

			mainPane.getChildren().clear();
			mainPane.getChildren().add(addBranchOffice);
		} catch (WithoutCurrentCompany e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText(e.getMessage());
			alert.setContentText("Para elegir una empresa actual dirigase a Administracion>>Cambiar empresa");

			alert.showAndWait();
			changeCompanyWindow();
		}
	}

	@FXML
	void searchBranchOfficeWindow(ActionEvent event) throws IOException {

		try {
			ccObject();
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("searchBranchOffice.fxml"));

			fxmlLoader.setController(this);
			Parent searchBranchOffice = fxmlLoader.load();

			mainPane.getChildren().clear();
			mainPane.getChildren().add(searchBranchOffice);
		} catch (WithoutCurrentCompany e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText(e.getMessage());
			alert.setContentText("Para elegir una empresa actual dirigase a Administracion>>Cambiar empresa");

			alert.showAndWait();
			changeCompanyWindow();
		}
	}

	@FXML
	void removeBranchOfficeWindow(ActionEvent event) throws IOException {

		try {
			ccObject();
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("removeBranchOffice.fxml"));

			fxmlLoader.setController(this);
			Parent removeBranchOffice = fxmlLoader.load();

			mainPane.getChildren().clear();
			mainPane.getChildren().add(removeBranchOffice);
		} catch (WithoutCurrentCompany e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText(e.getMessage());
			alert.setContentText("Para elegir una empresa actual dirigase a Administracion>>Cambiar empresa");

			alert.showAndWait();
			changeCompanyWindow();
		}
	}

	@FXML
	void branchOfficesReportWindow(ActionEvent event) throws IOException {

		try {
			ccObject();
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("reportBranchOffice.fxml"));

			fxmlLoader.setController(this);
			Parent reportBranchOffice = fxmlLoader.load();

			mainPane.getChildren().clear();
			mainPane.getChildren().add(reportBranchOffice);
		} catch (WithoutCurrentCompany e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText(e.getMessage());
			alert.setContentText("Para elegir una empresa actual dirigase a Administracion>>Cambiar empresa");

			alert.showAndWait();
			changeCompanyWindow();
		}
	}

	@FXML
	void reportEmployeesWindow(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("reportEmployee.fxml"));

		fxmlLoader.setController(this);
		Parent reportEmployee = fxmlLoader.load();

		mainPane.getChildren().clear();
		mainPane.getChildren().add(reportEmployee);
	}

	@FXML
	void reportContractWindow(ActionEvent event) throws IOException {

		try {
			ccObject();
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("reportContract.fxml"));

			fxmlLoader.setController(this);
			Parent reportContract = fxmlLoader.load();

			mainPane.getChildren().clear();
			mainPane.getChildren().add(reportContract);
		} catch (WithoutCurrentCompany e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText(e.getMessage());
			alert.setContentText("Para elegir una empresa actual dirigase a Administracion>>Cambiar empresa");

			alert.showAndWait();
			changeCompanyWindow();
		}
	}

	@FXML
	void reportFinancialWindow(ActionEvent event) throws IOException {

		try {
			ccObject();
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("financialReport.fxml"));

			fxmlLoader.setController(this);
			Parent financialReport = fxmlLoader.load();

			mainPane.getChildren().clear();
			mainPane.getChildren().add(financialReport);
		} catch (WithoutCurrentCompany e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText(e.getMessage());
			alert.setContentText("Para elegir una empresa actual dirigase a Administracion>>Cambiar empresa");

			alert.showAndWait();
			changeCompanyWindow();
		}
	}

	@FXML
	void financialOptsWindow(ActionEvent event) throws IOException {

		try {
			ccObject();
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("financialOpts.fxml"));

			fxmlLoader.setController(this);
			Parent financialOpts = fxmlLoader.load();

			mainPane.getChildren().clear();
			mainPane.getChildren().add(financialOpts);
		} catch (WithoutCurrentCompany e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText(e.getMessage());
			alert.setContentText("Para elegir una empresa actual dirigase a Administracion>>Cambiar empresa");

			alert.showAndWait();
			changeCompanyWindow();
		}
	}

	@FXML
	void addCompanyWindow(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("addCompany.fxml"));

		fxmlLoader.setController(this);
		Parent addCompany = fxmlLoader.load();

		mainPane.getChildren().clear();
		mainPane.getChildren().add(addCompany);
	}

	@FXML
	void sellCompanyWindow(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sellCompany.fxml"));

		fxmlLoader.setController(this);
		Parent sellCompany = fxmlLoader.load();

		mainPane.getChildren().clear();
		mainPane.getChildren().add(sellCompany);
	}

	@FXML
	void changeCompany(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("changeCurrentCompany.fxml"));

		fxmlLoader.setController(this);
		Parent changeCurrentC = fxmlLoader.load();

		mainPane.getChildren().clear();
		mainPane.getChildren().add(changeCurrentC);
	}

	@FXML
	void changeCompanyWindow() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("changeCurrentCompany.fxml"));

		fxmlLoader.setController(this);
		Parent changeCurrentC = fxmlLoader.load();

		mainPane.getChildren().clear();
		mainPane.getChildren().add(changeCurrentC);
	}

	@FXML
	void runChangeCurrentCompany(ActionEvent event) {

	}

}