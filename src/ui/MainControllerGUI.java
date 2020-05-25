package ui;

import java.io.IOException;
import java.util.Optional;

import customExceptions.ContractNotFoundException;
import customExceptions.WithoutCurrentCompanyException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import model.*;

public class MainControllerGUI {

	private Holding theHolding;

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
	private TextField workingHNewEmpTF;

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

	@FXML
	private TextField newCompanyName;

	@FXML
	private TextField newCompanyNIT;

	@FXML
	private RadioButton alimentosTypeRadioButton;

	@FXML
	private RadioButton tecnologiaTypeRadioButton;

	@FXML
	private RadioButton educacionTypeRadioButton;

	@FXML
	private ToggleGroup newCompanyTypeToggleGroup;

	@FXML
	private TextField searchParameterCompany;

	@FXML
	private RadioButton aeRadioButton;

	@FXML
	private RadioButton ceaRadioButton;

	@FXML
	private Label totalFCompanies;

	@FXML
	private Label totalTCompanies;

	@FXML
	private Label totalECompanies;

	@FXML
	private Label totalCompanies;

	@FXML
	private TextField newCompanyIncome;

	@FXML
	private TextField newCompanyOutcome;

	@FXML
	private TextField newCompanyTaxe;

	@FXML
	private TextField newCompanyValue;

	@FXML
	private Pane infoCurrentCompanyPane;

	@FXML
	private Label infoCurrentCompanyLabel;

	@FXML
	private ToggleGroup typeBranchOfficeToggleGruop;

	@FXML
	private TextField newBranchOfficeCity;

	@FXML
	private TextField newBranchOfficeAddress;

	@FXML
	private TextField newBranchOfficeId;

	@FXML
	private RadioButton newBranchOfficeMainType;

	@FXML
	private RadioButton newBranchOfficeSimpleType;

	@FXML
	private TextField newBranchOfficeEmployee;

	/**
	 * @param theHolding
	 * @throws IOException
	 */
	public MainControllerGUI(Holding theHolding) throws IOException {
		this.theHolding = theHolding;

	}

	public void ccObject() throws WithoutCurrentCompanyException {
		if (theHolding.getCurrentCompany() == null) {
			throw new WithoutCurrentCompanyException();
		}
	}

	@FXML
	void runSearchBrandOffice(ActionEvent event) {
		BranchOffice branchOffice = theHolding.getCurrentCompany().findBranchOffice(idForSearchBranchOffice.getText());
		if (branchOffice != null) {
			addressForSearchBrand.setText(branchOffice.getAddress());
			idForSearchBranchOffice.setText(branchOffice.getId());
		} else {
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
		} catch (WithoutCurrentCompanyException e) {

			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Advertencia");
			alert.setHeaderText("Esta accion requiere una empresa actual.");
			alert.setContentText("Elija una opccion:");

			ButtonType buttonTypeOne = new ButtonType("Agregar nueva empresa");
			ButtonType buttonTypeTwo = new ButtonType("Elegir una empresa existente");

			alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo);

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == buttonTypeOne) {
				addCompanyWindow(event);
			} else if (result.get() == buttonTypeTwo) {
				changeCompanyWindow();
			}

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
		try {

			if (nameNewEmpTF.getText() == "")
				throw new Exception();

			if (idNewEmpTF.getText() == "")
				throw new Exception();

			if (addresNewEmpTF.getText() == "")
				throw new Exception();

			if (phoneNewEmpTF.getText() == "")
				throw new Exception();

			if (jobNewEmpTF.getText() == "")
				throw new Exception();

			if (salaryNewEmpTF.getText() == "")
				throw new Exception();

			if (workingHNewEmpTF.getText() == "")
				throw new Exception();
				
			if (theHolding.findContract(idContractNewEmpTF.getText()) == null)
				throw new ContractNotFoundException(idContractNewEmpTF.getText());
				

			theHolding.addEmployee(new Employee(nameNewEmpTF.getText(), idNewEmpTF.getText(), addresNewEmpTF.getText(),
					phoneNewEmpTF.getText(), jobNewEmpTF.getText(), Double.parseDouble(salaryNewEmpTF.getText()),
					Integer.parseInt(workingHNewEmpTF.getText()),
					theHolding.findContract(idContractNewEmpTF.getText())));

			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmacion");
			alert.setHeaderText("Empleado agregado");
			alert.setContentText(nameNewEmpTF.getText() + " vinculado a " + theHolding.getCurrentCompany().getName()
					+ " exitosamente");

			alert.showAndWait();

		} catch (ContractNotFoundException e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Advertencia");
			alert.setHeaderText("Contrato no encontrado");
			alert.setContentText("Revise el ID del contrato de vinculacion");

			alert.showAndWait();
		} catch (NumberFormatException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Parametros invalidos");
			alert.setContentText("Formato incorrecto en parametros numericos");

			alert.showAndWait();
		} catch (Exception e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Parametros incompletos");
			alert.setContentText("Revise que todos los parametros de registro esten completos");

			alert.showAndWait();
		}

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
		} catch (WithoutCurrentCompanyException e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Advertencia");
			alert.setHeaderText("Esta accion requiere una empresa actual.");
			alert.setContentText("Elija una opccion:");

			ButtonType buttonTypeOne = new ButtonType("Agregar nueva empresa");
			ButtonType buttonTypeTwo = new ButtonType("Elegir una empresa existente");

			alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo);

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == buttonTypeOne) {
				addCompanyWindow(event);
			} else if (result.get() == buttonTypeTwo) {
				changeCompanyWindow();
			}

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
		} catch (WithoutCurrentCompanyException e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Advertencia");
			alert.setHeaderText("Esta accion requiere una empresa actual.");
			alert.setContentText("Elija una opccion:");

			ButtonType buttonTypeOne = new ButtonType("Agregar nueva empresa");
			ButtonType buttonTypeTwo = new ButtonType("Elegir una empresa existente");

			alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo);

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == buttonTypeOne) {
				addCompanyWindow(event);
			} else if (result.get() == buttonTypeTwo) {
				changeCompanyWindow();
			}

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
		} catch (WithoutCurrentCompanyException e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Advertencia");
			alert.setHeaderText("Esta accion requiere una empresa actual.");
			alert.setContentText("Elija una opccion:");

			ButtonType buttonTypeOne = new ButtonType("Agregar nueva empresa");
			ButtonType buttonTypeTwo = new ButtonType("Elegir una empresa existente");

			alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo);

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == buttonTypeOne) {
				addCompanyWindow(event);
			} else if (result.get() == buttonTypeTwo) {
				changeCompanyWindow();
			}

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
		} catch (WithoutCurrentCompanyException e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Advertencia");
			alert.setHeaderText("Esta accion requiere una empresa actual.");
			alert.setContentText("Elija una opccion:");

			ButtonType buttonTypeOne = new ButtonType("Agregar nueva empresa");
			ButtonType buttonTypeTwo = new ButtonType("Elegir una empresa existente");

			alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo);

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == buttonTypeOne) {
				addCompanyWindow(event);
			} else if (result.get() == buttonTypeTwo) {
				changeCompanyWindow();
			}

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
		} catch (WithoutCurrentCompanyException e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Advertencia");
			alert.setHeaderText("Esta accion requiere una empresa actual.");
			alert.setContentText("Elija una opccion:");

			ButtonType buttonTypeOne = new ButtonType("Agregar nueva empresa");
			ButtonType buttonTypeTwo = new ButtonType("Elegir una empresa existente");

			alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo);

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == buttonTypeOne) {
				addCompanyWindow(event);
			} else if (result.get() == buttonTypeTwo) {
				changeCompanyWindow();
			}

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
		} catch (WithoutCurrentCompanyException e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Advertencia");
			alert.setHeaderText("Esta accion requiere una empresa actual.");
			alert.setContentText("Elija una opccion:");

			ButtonType buttonTypeOne = new ButtonType("Agregar nueva empresa");
			ButtonType buttonTypeTwo = new ButtonType("Elegir una empresa existente");

			alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo);

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == buttonTypeOne) {
				addCompanyWindow(event);
			} else if (result.get() == buttonTypeTwo) {
				changeCompanyWindow();
			}

		}
	}

	@FXML
	void saveBranchOfficeButton(ActionEvent event) {
		try {

			if (newBranchOfficeCity.getText() == "") {

				throw new Exception();
			}

			if (newBranchOfficeAddress.getText() == "") {

				throw new Exception();
			}

			if (newBranchOfficeId.getText() == "") {

				throw new Exception();
			}

			if (theHolding.getCurrentCompany().findEmployee(newBranchOfficeEmployee.getText()) == null) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Advertencia");
				alert.setHeaderText("Empleado no encontrado");
				alert.setContentText("Revise el ID del empleado.");

				alert.showAndWait();
			}

			boolean b;
			if (newBranchOfficeMainType.isSelected()) {
				b = true;
			} else if (newBranchOfficeSimpleType.isSelected()) {
				b = false;
			} else {
				throw new Exception();
			}

			theHolding.getCurrentCompany()
					.addBranchOffice(new BranchOffice(newBranchOfficeCity.getText(), newBranchOfficeAddress.getText(),
							newBranchOfficeId.getText(), b,
							theHolding.getCurrentCompany().findEmployee(newBranchOfficeEmployee.getText())));

		} catch (Exception e) {

			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Parametros incompletos");
			alert.setContentText("Revise que todos los parametros de registro esten completos");

			alert.showAndWait();
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
		} catch (WithoutCurrentCompanyException e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Advertencia");
			alert.setHeaderText("Esta accion requiere una empresa actual.");
			alert.setContentText("Elija una opccion:");

			ButtonType buttonTypeOne = new ButtonType("Agregar nueva empresa");
			ButtonType buttonTypeTwo = new ButtonType("Elegir una empresa existente");

			alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo);

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == buttonTypeOne) {
				addCompanyWindow(event);
			} else if (result.get() == buttonTypeTwo) {
				changeCompanyWindow();
			}

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
		} catch (WithoutCurrentCompanyException e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Advertencia");
			alert.setHeaderText("Esta accion requiere una empresa actual.");
			alert.setContentText("Elija una opccion:");

			ButtonType buttonTypeOne = new ButtonType("Agregar nueva empresa");
			ButtonType buttonTypeTwo = new ButtonType("Elegir una empresa existente");

			alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo);

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == buttonTypeOne) {
				addCompanyWindow(event);
			} else if (result.get() == buttonTypeTwo) {
				changeCompanyWindow();
			}

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
		} catch (WithoutCurrentCompanyException e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Advertencia");
			alert.setHeaderText("Esta accion requiere una empresa actual.");
			alert.setContentText("Elija una opccion:");

			ButtonType buttonTypeOne = new ButtonType("Agregar nueva empresa");
			ButtonType buttonTypeTwo = new ButtonType("Elegir una empresa existente");

			alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo);

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == buttonTypeOne) {
				addCompanyWindow(event);
			} else if (result.get() == buttonTypeTwo) {
				changeCompanyWindow();
			}

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
		} catch (WithoutCurrentCompanyException e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Advertencia");
			alert.setHeaderText("Esta accion requiere una empresa actual.");
			alert.setContentText("Elija una opccion:");

			ButtonType buttonTypeOne = new ButtonType("Agregar nueva empresa");
			ButtonType buttonTypeTwo = new ButtonType("Elegir una empresa existente");

			alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo);

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == buttonTypeOne) {
				addCompanyWindow(event);
			} else if (result.get() == buttonTypeTwo) {
				changeCompanyWindow();
			}

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
		} catch (WithoutCurrentCompanyException e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Advertencia");
			alert.setHeaderText("Esta accion requiere una empresa actual.");
			alert.setContentText("Elija una opccion:");

			ButtonType buttonTypeOne = new ButtonType("Agregar nueva empresa");
			ButtonType buttonTypeTwo = new ButtonType("Elegir una empresa existente");

			alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo);

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == buttonTypeOne) {
				addCompanyWindow(event);
			} else if (result.get() == buttonTypeTwo) {
				changeCompanyWindow();
			}

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
		} catch (WithoutCurrentCompanyException e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Advertencia");
			alert.setHeaderText("Esta accion requiere una empresa actual.");
			alert.setContentText("Elija una opccion:");

			ButtonType buttonTypeOne = new ButtonType("Agregar nueva empresa");
			ButtonType buttonTypeTwo = new ButtonType("Elegir una empresa existente");

			alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo);

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == buttonTypeOne) {
				addCompanyWindow(event);
			} else if (result.get() == buttonTypeTwo) {
				changeCompanyWindow();
			}

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
	void saveNewCompany(ActionEvent event) throws IOException {

		if (newCompanyTypeToggleGroup.getSelectedToggle() != null && newCompanyName.getText() != null
				&& newCompanyName.getText() != "" && newCompanyNIT.getText() != null && newCompanyNIT.getText() != "") {
			Company nC = null;
			if (alimentosTypeRadioButton.isSelected()) {

				nC = new FoodCompany(newCompanyName.getText(), newCompanyNIT.getText(),
						Double.parseDouble(newCompanyIncome.getText()), Double.parseDouble(newCompanyOutcome.getText()),
						Double.parseDouble(newCompanyTaxe.getText()), Double.parseDouble(newCompanyValue.getText()));

			} else if (tecnologiaTypeRadioButton.isSelected()) {

				nC = new TechnologyCompany(newCompanyName.getText(), newCompanyNIT.getText(),
						Double.parseDouble(newCompanyIncome.getText()), Double.parseDouble(newCompanyOutcome.getText()),
						Double.parseDouble(newCompanyTaxe.getText()), Double.parseDouble(newCompanyValue.getText()));

			} else if (educacionTypeRadioButton.isSelected()) {

				nC = new EducationCompany(newCompanyName.getText(), newCompanyNIT.getText(),
						Double.parseDouble(newCompanyIncome.getText()), Double.parseDouble(newCompanyOutcome.getText()),
						Double.parseDouble(newCompanyTaxe.getText()), Double.parseDouble(newCompanyValue.getText()));

			}

			theHolding.addCompany(nC);

			if (nC instanceof FoodCompany) {

				theHolding.setTotalFCompanies(theHolding.getTotalFCompanies() + 1);

			} else if (nC instanceof TechnologyCompany) {

				theHolding.setTotalTCompanies(theHolding.getTotalTCompanies() + 1);

			} else {

				theHolding.setTotalECompanies(theHolding.getTotalECompanies() + 1);

			}

			updateCountCompanies();
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmacion");
			alert.setHeaderText("Compañia agregada exitosamente");
			alert.setContentText("Ahora puede gestionar todos los procesos de esta compañia");

			alert.showAndWait();

			addCompanyWindow(event);

		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Parametros incompletos");
			alert.setContentText("Complete todos los parametros del formulario.");

			alert.showAndWait();
		}

	}

	void updateCountCompanies() {
		totalCompanies.setText(Integer.toString(
				theHolding.getTotalECompanies() + theHolding.getTotalFCompanies() + theHolding.getTotalTCompanies()));

		totalECompanies.setText(Integer.toString(theHolding.getTotalECompanies()));
		totalFCompanies.setText(Integer.toString(theHolding.getTotalFCompanies()));
		totalTCompanies.setText(Integer.toString(theHolding.getTotalTCompanies()));
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
	void searchCompany(ActionEvent event) {
		Company result = theHolding.searchCompany(searchParameterCompany.getText());
		infoFoundCompanyLabel.setVisible(true);
		infoFoundCompanyLabel.setOpacity(1);
		if (result != null) {
			infoFoundCompanyLabel
					.setText("Empresa encontrada!\n\nNombre: " + result.getName() + "\nNit: " + result.getNit());

			changeCompanyButton.setDisable(false);
		}
	}

	@FXML
	void runChangeCurrentCompany(ActionEvent event) {
		Company newCurrentCompany = theHolding.searchCompany(searchParameterCompany.getText());
		theHolding.setCurrentCompany(newCurrentCompany);

		infoCurrentCompanyLabel.setText(
				theHolding.getCurrentCompany().getName() + "\nNit: " + theHolding.getCurrentCompany().getNit());

		infoCurrentCompanyPane.setVisible(true);

		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmacion");
		alert.setHeaderText("Compañia cambiada exitosamente");
		alert.setContentText("Nueva compañia:\n\n     " + theHolding.getCurrentCompany().getName());

		alert.showAndWait();

	}
	
	//OFFICES REPORT

    @FXML
    private CheckBox officeCsvCheckBox;

    @FXML
    private CheckBox officeTxtCheckBox;

    @FXML
    private CheckBox officeScreenCheckBox;

    @FXML
    private TableView<BranchOffice> officesTableView;

    @FXML
    private TableColumn<BranchOffice, String> officeIdColumn;

    @FXML
    private TableColumn<BranchOffice, String> officeTypeColumn;

    @FXML
    private TableColumn<BranchOffice, String> officeCityColumn;

    @FXML
    private TableColumn<BranchOffice, String> officeAddressColumn;
	

}