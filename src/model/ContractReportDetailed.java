package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ContractReportDetailed extends Report {
	private String id;

	public ContractReportDetailed(boolean toCsv, boolean toTxt, Company company, String id) {
		super(toCsv, toTxt, company);
	}

	@Override
	public String generateReport() {
		if (getCompany().findContract(id) != null) {
			String report = "";
			Contract contract = getCompany().findContract(id);

			String type = "";

			if (contract instanceof LaborContract) {
				type = "Labor";
			} else if (contract instanceof UndefinedTermContract) {
				type = "Termino indefinido";
			} else if (contract instanceof LearningContract) {
				type = "Aprendizaje";
			} else if (contract instanceof ServiceContract) {
				type = "Servicio";
			} else if (contract instanceof DefinedTermContract) {
				type = "Termino fijo";
			} else {
				type = "Trabajo ocasional";
			}

			String id = contract.getId();
			String description = contract.getDescription();
			ArrayList<String> clauses = contract.getClauses();
			double amount = contract.getAmount();
			LocalDate startDate = contract.getStartDate();
			LocalDate finishDate = contract.getFinishDate();
			LocalDate radicationDate = contract.getRadicationDate();
			int actualRenewals = contract.getActualRenewals();
			int renewalsLimit = contract.getRenewalsLimit();
			String employeeName = contract.getEmployee().getName();

			if (isToCsv()) {
				report += "empresa,empleado,nombre,id,tipo,descripción,clausulas,cantidad,fecha_inicio,fecha_fin,fecha_radicaciï¿½n,renovaciones_actuales,limite_de_renovaciones\n";
				report += employeeName + "," + id + "," + type + "," + description + "," + clauses.toString() + ",$"
						+ amount + "," + (startDate != null ? startDate.toString() : "N/A") + ","
						+ (finishDate != null ? finishDate.toString() : "N/A") + ","
						+ (radicationDate != null ? radicationDate.toString() : "N/A") + "," + actualRenewals + ","
						+ renewalsLimit;

				try {
					BufferedWriter bw = new BufferedWriter(
							new FileWriter("reports/Reporte_Contrato_" + description + "_" + id + ".csv"));
					bw.write(report);
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				report = "";
			}

			report = "REPORTE DE CONTRATO " + id +  "\n";
			report += "ID: " + id + "\n";
			report += "Tipo: " + type + "\n";
			report += "Descripción: " + description + "\n";
			report += "Clausulas: " + clauses.toString() + "\n";
			report += "Cantidad: $" + amount + "\n";
			report += "Fecha de Inicio: " + (startDate != null ? startDate.toString() : "N/A") + "\n";
			report += "Fecha de terminación: " + (finishDate != null ? finishDate.toString() : "N/A") + "\n";
			report += "Fecha de radicación: " + (radicationDate != null ? radicationDate.toString() : "N/A") + "\n";
			report += "Renovaciones actuales: " + actualRenewals + "\n";
			report += "Limite de renovaciones: " + renewalsLimit + "\n";

			if (isToTxt()) {

				try {
					BufferedWriter bw = new BufferedWriter(
							new FileWriter("reports/Reporte_Contrato_" + description + "_" + id + ".txt"));
					bw.write(report);
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			return report;
		}

		else {
			return null;
		}
	}
}