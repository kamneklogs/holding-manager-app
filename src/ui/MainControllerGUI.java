package ui;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Optional;

import customExceptions.BranchOfficeAlreadyExistException;
import customExceptions.BranchOfficeNotFoundException;
import customExceptions.ContractNotFoundException;
import customExceptions.EmployeeNotFoundException;
import customExceptions.WithoutCurrentCompanyException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Accordion;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import model.*;
import thread.ThreadOne;

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
	private Label timeLabel;

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

	@FXML
	private TextField descriptionNewContract;

	@FXML
	private SplitMenuButton typeNewContract;

	@FXML
	private DatePicker startDateNewContract;

	@FXML
	private DatePicker finishtDateNewContract;

	@FXML
	private TextField idNewContract;

	@FXML
	private TextField valueNewContract;

	@FXML
	private TextField amountNewContract;

	@FXML
	private TextField clauseNewContract;

	private ArrayList<String> clauses;

	@FXML
	private TextField idRemoveEmployee;

	@FXML
	private Label nameRemoveEmployee;

	@FXML
	private Label idContractRemoveEmployee;

	@FXML
	private Button removeEmployeeButton;

	private LocalDateTime locaDate = LocalDateTime.now();

	/**
	 * @param theHolding
	 * @throws IOException
	 */
	public MainControllerGUI(Holding theHolding) throws IOException {
		this.theHolding = theHolding;

	}

	public void initialize() {

		new ThreadOne(this).start();

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
				mainAccordion.setExpandedPane(administrationTitledPane);
				addCompanyRadioButton.setSelected(true);
			} else if (result.get() == buttonTypeTwo) {
				changeCompanyWindow();
				mainAccordion.setExpandedPane(administrationTitledPane);
				changeCompanyRadioButton.setSelected(true);
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

			theHolding.findContract(idContractNewEmpTF.getText())
					.setEmployee(theHolding.findEmployee(idNewEmpTF.getText()));

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
				mainAccordion.setExpandedPane(administrationTitledPane);
				addCompanyRadioButton.setSelected(true);
			} else if (result.get() == buttonTypeTwo) {
				changeCompanyWindow();
				mainAccordion.setExpandedPane(administrationTitledPane);
				changeCompanyRadioButton.setSelected(true);
			}

		}

	}

	@FXML
	void searchEmployeeToRemove(ActionEvent event) {
		try {

			if (idRemoveEmployee.getText() != "") {

				if (theHolding.findEmployee(idRemoveEmployee.getText()) != null) {

					removeEmployeeButton.setDisable(false);

				} else {
					throw new EmployeeNotFoundException(idRemoveEmployee.getText());
				}

			} else {
				throw new Exception();
			}

		} catch (EmployeeNotFoundException e) {

			Alert alert = new Alert(AlertType.WARNING);

			alert.setTitle("Advertencia");
			alert.setHeaderText("Empleado no encontrado");
			alert.setContentText(e.getMessage());

			alert.showAndWait();

		} catch (Exception e) {
			Alert alert = new Alert(AlertType.ERROR);

			alert.setTitle("Error");
			alert.setHeaderText("Parametros incompletos");
			alert.setContentText("Verifique todos los parametros.");
		}
	}

	@FXML
	void removeEmployee(ActionEvent event) throws ContractNotFoundException, EmployeeNotFoundException {

		theHolding.removeContract(theHolding.findEmployee(idRemoveEmployee.getText()).getMyContract().getId());
		theHolding.removeEmployee(idRemoveEmployee.getText());

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
				mainAccordion.setExpandedPane(administrationTitledPane);
				addCompanyRadioButton.setSelected(true);
			} else if (result.get() == buttonTypeTwo) {
				changeCompanyWindow();
				mainAccordion.setExpandedPane(administrationTitledPane);
				changeCompanyRadioButton.setSelected(true);
			}

		}
	}

	@FXML
	void aprendizajeTypeContract(ActionEvent event) {
		typeNewContract.setText(Contract.TYPES[4]);
	}

	@FXML
	void obraOLaborTypeContract(ActionEvent event) {
		typeNewContract.setText(Contract.TYPES[2]);
	}

	@FXML
	void ocasionalTypeContract(ActionEvent event) {
		typeNewContract.setText(Contract.TYPES[5]);
	}

	@FXML
	void prestacionSTypeContract(ActionEvent event) {
		typeNewContract.setText(Contract.TYPES[3]);
	}

	@FXML
	void terminoFijoTypeContract(ActionEvent event) {
		typeNewContract.setText(Contract.TYPES[1]);
	}

	@FXML
	void terminoIndefinidoTypeContract(ActionEvent event) {
		typeNewContract.setText(Contract.TYPES[0]);
	}

	@FXML
	void saveClauseNewContract(ActionEvent event) {
		if (clauses == null) {
			clauses = new ArrayList<String>();
		}

		clauses.add(clauseNewContract.getText());
		clauseNewContract.setText("");

	}

	@FXML
	void saveNewContract(ActionEvent event) {

		try {

			if (descriptionNewContract.getText() == "")
				throw new Exception();

			if (typeNewContract.getText() == "Seleccionar")
				throw new Exception();

			if (startDateNewContract.getEditor().getText() == "")
				throw new Exception();

			if (finishtDateNewContract.getEditor().getText() == "")
				throw new Exception();

			if (idNewContract.getText() == "")
				throw new Exception();

			if (finishtDateNewContract.getValue().isAfter(startDateNewContract.getValue())) {

				if (typeNewContract.getText() == Contract.TYPES[0])
					theHolding.getCurrentCompany().addContract(new DefinedTermContract(idNewContract.getText(),
							descriptionNewContract.getText(), clauses, Double.parseDouble(amountNewContract.getText()),
							startDateNewContract.getValue(), finishtDateNewContract.getValue(), LocalDate.now()));

				if (typeNewContract.getText() == Contract.TYPES[1])
					theHolding.getCurrentCompany().addContract(new UndefinedTermContract(idNewContract.getText(),
							descriptionNewContract.getText(), clauses, Double.parseDouble(amountNewContract.getText()),
							startDateNewContract.getValue(), LocalDate.now()));

				if (typeNewContract.getText() == Contract.TYPES[2])
					theHolding.getCurrentCompany().addContract(new LaborContract(idNewContract.getText(),
							descriptionNewContract.getText(), clauses, Double.parseDouble(amountNewContract.getText()),
							startDateNewContract.getValue(), finishtDateNewContract.getValue(), LocalDate.now()));

				if (typeNewContract.getText() == Contract.TYPES[3])
					theHolding.getCurrentCompany().addContract(new ServiceContract(idNewContract.getText(),
							descriptionNewContract.getText(), clauses, Double.parseDouble(amountNewContract.getText()),
							startDateNewContract.getValue(), finishtDateNewContract.getValue(), LocalDate.now()));

				if (typeNewContract.getText() == Contract.TYPES[4])
					theHolding.getCurrentCompany().addContract(new LearningContract(idNewContract.getText(),
							descriptionNewContract.getText(), clauses, Double.parseDouble(amountNewContract.getText()),
							startDateNewContract.getValue(), finishtDateNewContract.getValue(), LocalDate.now()));

				if (typeNewContract.getText() == Contract.TYPES[5])
					theHolding.getCurrentCompany().addContract(new OcassionalWorkContract(idNewContract.getText(),
							descriptionNewContract.getText(), clauses, Double.parseDouble(amountNewContract.getText()),
							startDateNewContract.getValue(), finishtDateNewContract.getValue(), LocalDate.now()));

				Alert alert = new Alert(AlertType.CONFIRMATION);

				alert.setTitle("Confirmacion");
				alert.setHeaderText("Contrato guardado.");
				alert.setContentText("El contrato con ID: " + idNewContract.getText()
						+ " fue agregado exitosamente a la base de datos");

				alert.showAndWait();

			} else {

				Alert alert = new Alert(AlertType.ERROR);

				alert.setTitle("Error");
				alert.setHeaderText("Fechas erroneas");
				alert.setContentText("La fecha de finalizacion esta antes de la de inicio, por favor verificar");

				alert.showAndWait();

			}

		} catch (Exception e) {

			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Parametros incompletos");
			alert.setContentText("Revise que todos los parametros de registro esten completos");

			alert.showAndWait();

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
	private TextField idContractToRemove;

	@FXML
	private Button removeContractButton;

	@FXML
	private Label infoContractToRemove;

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
				mainAccordion.setExpandedPane(administrationTitledPane);
				addCompanyRadioButton.setSelected(true);
			} else if (result.get() == buttonTypeTwo) {
				changeCompanyWindow();
				mainAccordion.setExpandedPane(administrationTitledPane);
				changeCompanyRadioButton.setSelected(true);
			}

		}
	}

	@FXML
	void searchContractToRemove(ActionEvent event) {

		try {

			if (idContractToRemove.getText() != "") {
				if (theHolding.getCurrentCompany().findContract(idContractToRemove.getText()) != null) {
					infoContractToRemove.setText("Contrato Encontrado!\n\nID: "
							+ theHolding.getCurrentCompany().findContract(idContractToRemove.getText()).getId()
							+ "\bDescripcion: " + theHolding.getCurrentCompany()
									.findContract(idContractToRemove.getText()).getDescription());

					infoContractToRemove.setVisible(true);

					removeContractButton.setDisable(false);

				} else {
					throw new ContractNotFoundException(idContractToRemove.getText());
				}
			}

		} catch (ContractNotFoundException e) {
			infoContractToRemove.setVisible(true);
		} catch (Exception e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Advertencia");
			alert.setHeaderText("Parametros faltantes");
			alert.setContentText("Revise el ID del contrato a eliminar.");

			alert.showAndWait();
		}

	}

	@FXML
	void removeContract(ActionEvent event) throws ContractNotFoundException, IOException {
		theHolding.getCurrentCompany().removeContract(idContractToRemove.getText());

		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmacion");
		alert.setHeaderText("Eliminacion realizada");
		alert.setContentText("Contrato eliminado exitosamente.");

		alert.showAndWait();

		removeContractWindow(event);
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
				mainAccordion.setExpandedPane(administrationTitledPane);
				addCompanyRadioButton.setSelected(true);
			} else if (result.get() == buttonTypeTwo) {
				changeCompanyWindow();
				mainAccordion.setExpandedPane(administrationTitledPane);
				changeCompanyRadioButton.setSelected(true);
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

			} else {

				boolean b;
				if (newBranchOfficeMainType.isSelected()) {
					b = true;
				} else if (newBranchOfficeSimpleType.isSelected()) {
					b = false;
				} else {

					throw new Exception();
				}

				theHolding.getCurrentCompany()
						.addBranchOffice(new BranchOffice(newBranchOfficeCity.getText(),
								newBranchOfficeAddress.getText(), newBranchOfficeId.getText(), b,
								theHolding.getCurrentCompany().findEmployee(newBranchOfficeEmployee.getText())));

				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Confirmacion");
				alert.setHeaderText("Proceso realizado");
				alert.setContentText("La seede con ID " + newBranchOfficeId.getText()
						+ "fue añadida exitosamente a la base de datos");

				alert.showAndWait();

				addBranchOfficeWindow(event);
			}

		} catch (BranchOfficeAlreadyExistException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText(e.getMessage());
			alert.setContentText("El ID ingresado ya esta registrado con otra sede.");

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
				mainAccordion.setExpandedPane(administrationTitledPane);
				addCompanyRadioButton.setSelected(true);
			} else if (result.get() == buttonTypeTwo) {
				changeCompanyWindow();
				mainAccordion.setExpandedPane(administrationTitledPane);
				changeCompanyRadioButton.setSelected(true);
			}

		}
	}

	@FXML
	private TextField idBranchOfficeToRemove;

	@FXML
	private Button removeBranchOfficeButton;

	@FXML
	private Label infoBranchOfficeToRemove;

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
				mainAccordion.setExpandedPane(administrationTitledPane);
				addCompanyRadioButton.setSelected(true);
			} else if (result.get() == buttonTypeTwo) {
				changeCompanyWindow();
				mainAccordion.setExpandedPane(administrationTitledPane);
				changeCompanyRadioButton.setSelected(true);
			}

		}
	}

	@FXML
	void searchBranchOfficeToRemove(ActionEvent event) {
		try {
			if (idBranchOfficeToRemove.getText() != "") {
				if (theHolding.getCurrentCompany().findBranchOffice(idBranchOfficeToRemove.getText()) != null) {

					infoBranchOfficeToRemove.setText("Sede encontrada!\n\nID: "
							+ theHolding.getCurrentCompany().findBranchOffice(idBranchOfficeToRemove.getText()).getId()
							+ "\nCiudad: " + theHolding.getCurrentCompany()
									.findBranchOffice(idBranchOfficeToRemove.getText()).getCity());
					removeBranchOfficeButton.setDisable(true);

				} else {
					throw new BranchOfficeNotFoundException(idBranchOfficeToRemove.getText());
				}
			} else {
				throw new Exception();
			}
		} catch (BranchOfficeNotFoundException e) {

			infoBranchOfficeToRemove.setVisible(true);

		} catch (Exception e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Advertencia");
			alert.setHeaderText("Advertencia");
			alert.setContentText("Parametros incompletos, revise e intente nuevamene");

			alert.showAndWait();
		}
	}

	@FXML
	void removeBranchOffice(ActionEvent event) throws BranchOfficeNotFoundException, IOException {
		theHolding.getCurrentCompany().removeBranchOffice(idBranchOfficeToRemove.getText());
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmacion");
		alert.setHeaderText("Proceso exitoso");
		alert.setContentText("La oficiona con ID " + idBranchOfficeToRemove.getText() + " fue eliminada exitosamente.");

		alert.showAndWait();

		removeBranchOfficeWindow(event);
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
				mainAccordion.setExpandedPane(administrationTitledPane);
				addCompanyRadioButton.setSelected(true);
			} else if (result.get() == buttonTypeTwo) {
				changeCompanyWindow();
				mainAccordion.setExpandedPane(administrationTitledPane);
				changeCompanyRadioButton.setSelected(true);
			}

		}
	}

	@FXML
	void reportEmployeesWindow(ActionEvent event) throws IOException {
		try {
			ccObject();
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("reportEmployee.fxml"));

			fxmlLoader.setController(this);
			Parent reportEmployee = fxmlLoader.load();

			mainPane.getChildren().clear();
			mainPane.getChildren().add(reportEmployee);
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
				mainAccordion.setExpandedPane(administrationTitledPane);
				addCompanyRadioButton.setSelected(true);
			} else if (result.get() == buttonTypeTwo) {
				changeCompanyWindow();
				mainAccordion.setExpandedPane(administrationTitledPane);
				changeCompanyRadioButton.setSelected(true);
			}
		}
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
				mainAccordion.setExpandedPane(administrationTitledPane);
				addCompanyRadioButton.setSelected(true);
			} else if (result.get() == buttonTypeTwo) {
				changeCompanyWindow();
				mainAccordion.setExpandedPane(administrationTitledPane);
				changeCompanyRadioButton.setSelected(true);
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
				mainAccordion.setExpandedPane(administrationTitledPane);
				addCompanyRadioButton.setSelected(true);
			} else if (result.get() == buttonTypeTwo) {
				changeCompanyWindow();
				mainAccordion.setExpandedPane(administrationTitledPane);
				changeCompanyRadioButton.setSelected(true);
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
			initializeChart();
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
				mainAccordion.setExpandedPane(administrationTitledPane);
				addCompanyRadioButton.setSelected(true);
			} else if (result.get() == buttonTypeTwo) {
				changeCompanyWindow();
				mainAccordion.setExpandedPane(administrationTitledPane);
				changeCompanyRadioButton.setSelected(true);
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
			try {
				Company newCompany = null;

				String name = newCompanyName.getText();
				String nit = newCompanyNIT.getText();
				double income = Double.parseDouble(newCompanyIncome.getText());
				double outcome = Double.parseDouble(newCompanyOutcome.getText());
				double tax = Double.parseDouble(newCompanyTaxe.getText());
				double value = Double.parseDouble(newCompanyValue.getText());

				if (income < 0) {
					throw new NumberFormatException();
				}
				if (outcome < 0) {
					throw new NumberFormatException();
				}
				if (tax < 0 || tax > 50) {
					throw new NumberFormatException();
				}
				if (value < 0) {
					throw new NumberFormatException();
				}

				if (alimentosTypeRadioButton.isSelected()) {
					newCompany = new FoodCompany(name, nit, income, outcome, tax, value);
				} else if (tecnologiaTypeRadioButton.isSelected()) {
					newCompany = new TechnologyCompany(name, nit, income, outcome, tax, value);
				} else {
					newCompany = new EducationCompany(name, nit, income, outcome, tax, value);
				}

				theHolding.addCompany(newCompany);

				if (newCompany instanceof FoodCompany) {
					theHolding.setTotalFCompanies(theHolding.getTotalFCompanies() + 1);
				} else if (newCompany instanceof TechnologyCompany) {
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
			} catch (NumberFormatException e) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText("Formato erroneo");
				alert.setContentText(
						"Verifique el valor ingresado en los campos de ingreso, egresos y avaluo.\nEl valor m�ximo de impuestos es de 50%.\nSolo introduzca valores numericos, ning�n simbolo adicional.");
				alert.showAndWait();
			}

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

	public void updateTimeLabel() {

		locaDate = LocalDateTime.now();

		timeLabel.setText(Integer.toString(locaDate.getYear()) + "/" + Integer.toString(locaDate.getMonthValue()) + "/"
				+ Integer.toString(locaDate.getDayOfMonth()) + "   " + Integer.toString(locaDate.getHour()) + ":"
				+ Integer.toString(locaDate.getMinute()) + ":" + Integer.toString(locaDate.getSecond()));

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

	// OFFICES REPORT

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

	@FXML
	void generateOfficesReport(ActionEvent event) {
		if (!officeCsvCheckBox.isSelected() && !officeTxtCheckBox.isSelected() && !officeScreenCheckBox.isSelected()) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setContentText("No se ha seleccionado formato de salida, por favor seleccione al menos uno!");
			alert.showAndWait();
		} else {
			ArrayList<BranchOffice> offices = theHolding.getCurrentCompanyOffices();
			ObservableList<BranchOffice> observableOffices = FXCollections.observableArrayList(offices);

			if (!offices.isEmpty()) {
				theHolding.generateBranchOfficesReport(officeCsvCheckBox.isSelected(), officeTxtCheckBox.isSelected());
				if (officeScreenCheckBox.isSelected()) {
					officesTableView.setItems(observableOffices);

					officeIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
					officeTypeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
					officeCityColumn.setCellValueFactory(new PropertyValueFactory<>("city"));
					officeAddressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
				}
			} else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Advertencia");
				alert.setContentText("No se han agregado oficinas a la empresa actual!");
				alert.showAndWait();
			}
		}
	}

	// EMPLOYEE REPORT

	@FXML
	private RadioButton employeesParticularToggleButton;

	@FXML
	private ToggleGroup employeesToggleGroup;

	@FXML
	private RadioButton employeesGeneralToggleButton;

	@FXML
	private TextField employeeIdTextField;

	@FXML
	private CheckBox employeesCsvCheckBox;

	@FXML
	private CheckBox employeesTxtCheckBox;

	@FXML
	private CheckBox employeesScreenCheckBox;

	@FXML
	private TableView<Employee> employeesTableView;

	@FXML
	private TableColumn<Employee, String> employeeNameColumn;

	@FXML
	private TableColumn<Employee, String> employeeIdColumn;

	@FXML
	private TableColumn<Employee, String> employeePhoneColumn;

	@FXML
	private TableColumn<Employee, Double> employeeSalaryColumn;

	@FXML
	private TableColumn<Employee, String> employeeTitleColumn;

	@FXML
	void employeesGenerateReport(ActionEvent event) {
		if (!employeesCsvCheckBox.isSelected() && !employeesTxtCheckBox.isSelected()
				&& !employeesScreenCheckBox.isSelected()) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setContentText("No se ha seleccionado formato de salida, por favor seleccione al menos uno!");
			alert.showAndWait();
		} else if (!employeesParticularToggleButton.isSelected() && !employeesGeneralToggleButton.isSelected()) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setContentText(
					"No se ha seleccionado un tipo de reporte particular o general, por favor seleccione uno!");
			alert.showAndWait();
		} else {
			ArrayList<Employee> employees = theHolding.getCurrentCompanyEmployees();
			ObservableList<Employee> observableEmployees = FXCollections.observableArrayList(employees);

			if (!employees.isEmpty()) {
				if (employeesParticularToggleButton.isSelected()) {
					String id = employeeIdTextField.getText();
					if (!id.isEmpty()) {
						String report = theHolding.generateEmployeeReportDetailed(employeesScreenCheckBox.isSelected(),
								employeesCsvCheckBox.isSelected(), employeesScreenCheckBox.isSelected(), id);
						if (report != null && employeesScreenCheckBox.isSelected()) {
							Alert alert = new Alert(AlertType.INFORMATION);
							alert.setTitle("Empleado");
							alert.setContentText(report);
							alert.showAndWait();
						} else {
							Alert alert = new Alert(AlertType.ERROR);
							alert.setTitle("Error");
							alert.setContentText("No se ha encontrado el empleado con id: " + id + " !");
							alert.showAndWait();
						}
					} else {
						Alert alert = new Alert(AlertType.ERROR);
						alert.setTitle("Error");
						alert.setContentText(
								"No se ha escrito la id del empleado, por favor escribala en el recuadro!");
						alert.showAndWait();
					}
				} else {
					theHolding.generateEmployeeReportGeneral(employeesCsvCheckBox.isSelected(),
							employeesScreenCheckBox.isSelected());
					if (employeesScreenCheckBox.isSelected()) {
						employeesTableView.setItems(observableEmployees);

						employeeNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
						employeeIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
						employeePhoneColumn.setCellValueFactory(new PropertyValueFactory<>("numberPhone"));
						employeeSalaryColumn.setCellValueFactory(new PropertyValueFactory<>("salary"));
						employeeTitleColumn.setCellValueFactory(new PropertyValueFactory<>("jobTitle"));
					}
				}
			} else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Advertencia");
				alert.setContentText("No se han agregado empleados!");
				alert.showAndWait();
			}
		}
	}

	@FXML
	void employeesUpdateSearchButton(ActionEvent event) {
		if (employeesParticularToggleButton.isSelected()) {
			employeeIdTextField.setDisable(false);
		} else {
			employeeIdTextField.setDisable(true);
		}
	}

	// CONTRACTS REPORT

	@FXML
	private RadioButton contractsParticularToggleButton;

	@FXML
	private ToggleGroup contractsToggleGroup;

	@FXML
	private RadioButton contractsGeneralToggleButton;

	@FXML
	private TextField contractsIdTextField;

	@FXML
	private CheckBox contractsCsvCheckBox;

	@FXML
	private CheckBox contractsTxtCheckBox;

	@FXML
	private CheckBox contractsScreenCheckBox;

	@FXML
	private TableView<Contract> contractsTableView;

	@FXML
	private TableColumn<Contract, String> contractNameColumn;

	@FXML
	private TableColumn<Contract, String> contractIdColumn;

	@FXML
	private TableColumn<Contract, LocalDate> contractStartDateColumn;

	@FXML
	private TableColumn<Contract, LocalDate> contractEndDateColumn;

	@FXML
	void contractsGenerateReport(ActionEvent event) {
		if (!contractsCsvCheckBox.isSelected() && !contractsTxtCheckBox.isSelected()
				&& !contractsScreenCheckBox.isSelected()) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setContentText("No se ha seleccionado formato de salida, por favor seleccione al menos uno!");
			alert.showAndWait();
		} else if (!contractsParticularToggleButton.isSelected() && !contractsGeneralToggleButton.isSelected()) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setContentText(
					"No se ha seleccionado un tipo de reporte particular o general, por favor seleccione uno!");
			alert.showAndWait();
		} else {
			ArrayList<Contract> contracts = theHolding.getCurrentCompanyContracts();
			ObservableList<Contract> observableContracts = FXCollections.observableArrayList(contracts);

			if (!contracts.isEmpty()) {
				if (contractsParticularToggleButton.isSelected()) {
					String id = contractsIdTextField.getText();
					if (!id.isEmpty()) {
						String report = theHolding.generateContractReportDetailed(contractsScreenCheckBox.isSelected(),
								contractsCsvCheckBox.isSelected(), contractsScreenCheckBox.isSelected(), id);
						if (report != null && contractsScreenCheckBox.isSelected()) {
							Alert alert = new Alert(AlertType.INFORMATION);
							alert.setTitle("Contract");
							alert.setContentText(report);
							alert.showAndWait();
						} else {
							Alert alert = new Alert(AlertType.ERROR);
							alert.setTitle("Error");
							alert.setContentText("No se ha encontrado el contrato con id: " + id + " !");
							alert.showAndWait();
						}
					} else {
						Alert alert = new Alert(AlertType.ERROR);
						alert.setTitle("Error");
						alert.setContentText(
								"No se ha escrito la id del contrato, por favor escribala en el recuadro!");
						alert.showAndWait();
					}
				} else {
					theHolding.generateContractReportGeneral(contractsCsvCheckBox.isSelected(),
							contractsScreenCheckBox.isSelected());
					if (contractsScreenCheckBox.isSelected()) {
						contractsTableView.setItems(observableContracts);

						contractNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
						contractIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
						contractStartDateColumn.setCellValueFactory(new PropertyValueFactory<>("startDate"));
						contractEndDateColumn.setCellValueFactory(new PropertyValueFactory<>("finishDate"));
					}
				}
			} else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Advertencia");
				alert.setContentText("No se han agregado contratos!");
				alert.showAndWait();
			}
		}
	}

	@FXML
	void contractsUpdateIdField(ActionEvent event) {
		if (contractsParticularToggleButton.isSelected()) {
			contractsIdTextField.setDisable(false);
		} else {
			contractsIdTextField.setDisable(true);
		}
	}

	// ECONOMICAL REPORT

	@FXML
	private CheckBox economicalCsvCheckBox;

	@FXML
	private CheckBox economicalTxtCheckBox;

	@FXML
	private CheckBox economicalScreenCheckBox;

	@FXML
	private Label economicalReportContent;

	@FXML
	void economicalGenerateReport(ActionEvent event) {
		if (!economicalCsvCheckBox.isSelected() && !economicalTxtCheckBox.isSelected()
				&& !economicalScreenCheckBox.isSelected()) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setContentText("No se ha seleccionado formato de salida, por favor seleccione al menos uno!");
			alert.showAndWait();
		} else {
			String report = theHolding.generateEconomicReport(economicalCsvCheckBox.isSelected(),
					economicalTxtCheckBox.isSelected());
			if (economicalScreenCheckBox.isSelected()) {
				economicalReportContent.setText(report);
			}
		}
	}

	// ECONOMICAL INFORMATION UPDATE AND CHARTS

	@FXML
	private TextField incomeUpdateTextField;

	@FXML
	private TextField outcomeUpdateTextField;

	@FXML
	private BorderPane chartsBorderPane;

	@FXML
	void modifyIncome(ActionEvent event) {
		try {
			double newIncome = Double.parseDouble(incomeUpdateTextField.getText());

			if (newIncome < 0) {
				throw new NumberFormatException();
			}

			theHolding.getCurrentCompany().setIncome(newIncome);
			initializeChart();
		} catch (NumberFormatException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setContentText(
					"Los ingresos deben ser un numero que no incluye el simbolo de dinero, ademas debe ser positivo o 0, verifique su valor!");
			alert.showAndWait();
		}
	}

	@FXML
	void modifyOutcome(ActionEvent event) {
		try {
			double newOutcome = Double.parseDouble(outcomeUpdateTextField.getText());

			if (newOutcome < 0) {
				throw new NumberFormatException();
			}

			theHolding.getCurrentCompany().setOutcome(newOutcome);

			initializeChart();
		} catch (NumberFormatException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setContentText(
					"Los egresos deben ser un numero que no incluye el simbolo de dinero, ademas debe ser positivo o 0, verifique su valor!");
			alert.showAndWait();
		}
	}

	@SuppressWarnings("unchecked")
	public void initializeChart() {
		final CategoryAxis xAxis = new CategoryAxis();
		final NumberAxis yAxis = new NumberAxis();
		final BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
		xAxis.setLabel("Informaci�n Economica");
		yAxis.setLabel("Valor ($)");

		XYChart.Series<String, Number> incomeSeries = new XYChart.Series<>();
		incomeSeries.getData()
				.add(new XYChart.Data<String, Number>("Ingresos", theHolding.getCurrentCompany().getIncome()));

		XYChart.Series<String, Number> outcomeSeries = new XYChart.Series<>();
		outcomeSeries.getData()
				.add(new XYChart.Data<String, Number>("Egresos", theHolding.getCurrentCompany().getOutcome()));

		barChart.getData().addAll(incomeSeries, outcomeSeries);
		barChart.setTitle("Informacion Economica Basica");

		chartsBorderPane.setCenter(barChart);
	}

	// SELL COMPANY

	@FXML
	private TextField sellCompanyNitTextField;

	@FXML
	private TextField sellValueTextField;

	@FXML
	void sellCompany(ActionEvent event) {
		String nit = sellCompanyNitTextField.getText();
		String valueStr = sellValueTextField.getText();

		if (!nit.isEmpty() || !valueStr.isEmpty()) {
			try {
				double value = Double.parseDouble(valueStr);
				if (value < 0) {
					throw new NumberFormatException();
				}

				Company companyToSell = theHolding.searchCompany(nit);
				if (companyToSell != null) {
					if (companyToSell == theHolding.getCurrentCompany()) {
						theHolding.setCurrentCompany(null);
						infoCurrentCompanyLabel.setText("");
					}
					theHolding.sellCompany(nit, value);
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Informaci�n");
					alert.setHeaderText("Compa��a vendida exitosamente!");
					alert.setContentText("La compa�ia con nit " + nit + " ha sido vendida por $" + value
							+ " y el nuevo valor del Seros es $" + theHolding.getValue());
					alert.showAndWait();
				} else {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Error");
					alert.setHeaderText("Compa��a no encontrada!");
					alert.setContentText("La compa�ia con nit " + nit + " no ha sido encontrada");
					alert.showAndWait();
				}
			} catch (NumberFormatException e) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText("Formato");
				alert.setContentText(
						"Verifique que el valor introducido en el campo de valor de venta es un numero positivo.\nNo agregue ningun simbolo adicional.");
				alert.showAndWait();
			}
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Campos vacios");
			alert.setContentText("Verifique que todos los campos este llenos!");
			alert.showAndWait();

		}

	}

	// MAIN WINDOW FIX
	@FXML
	private ToggleGroup mainToggleGroup;

	@FXML
	private TitledPane administrationTitledPane;

	@FXML
	private RadioButton addCompanyRadioButton;

	@FXML
	private RadioButton changeCompanyRadioButton;

	@FXML
	private Accordion mainAccordion;
}
