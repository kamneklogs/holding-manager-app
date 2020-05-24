package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class EmployeeReportDetailed extends Report {
	
	private String id;

	public EmployeeReportDetailed(boolean toScreen, boolean toCsv, boolean toTxt, Company company, String id) {
		super(toScreen, toCsv, toTxt, company);		
	}
    
	@Override
	public String generateReport() {
		Employee employee = getCompany().findEmployee(id);
		if(employee != null) {
			String report = "";
			String companyName = getCompany().getName();
			
			String name = employee.getName();
			String id = employee.getId();
			String address = employee.getResidenceAddress();
			String phoneNumber = employee.getNumberPhone();
			double salary = employee.getSalary();
			String jobTitle = employee.getJobTitle();
			double[] workingHours = employee.getWorkingHours();
			ArrayList<String> socialBenefits = employee.getSocialBenefits();
			
			if(isToCsv()) {
				report += "nombre,id,dirección_residencia,numero_telefono,salario,titulo,horas_trabajo(L-D),beneficios_sociales";
				report += name + "," + id + "," + address + "," + phoneNumber + "," + salary + "," + jobTitle
						+ "," + Arrays.toString(workingHours) + "," + socialBenefits.toString();
				
				try {
					BufferedWriter bw = new BufferedWriter(new FileWriter("data/Reporte_Empleado_" + name + "_" + id + "_" +  companyName + ".csv"));
					bw.write(report);
					bw.close();
				} 
				catch (IOException e) {					
					e.printStackTrace();
				}				
			}
			
			report = "REPORTE DE EMPLEADO " + name + " CON ID: " + id + " PARA LA EMPRESA " + companyName + "\n";
			report += "Nombre: " + name + "\n";
			report += "ID: " + id + "\n";
			report += "Dirección de Residencia: " + address + "\n";
			report += "Numero de telefono: " + phoneNumber + "\n";
			report += "Salario: $" + salary + "\n";
			report += "Titulo de Trabajo: " + jobTitle + "\n";
			report += "Horas de Trabajo (L-D)" + Arrays.toString(workingHours) + "\n";
			report += "Beneficios sociales: " + socialBenefits.toString() + "\n";
			
			
			if(isToTxt()) {
				try {
					BufferedWriter bw = new BufferedWriter(new FileWriter("data/Reporte_Empleado_" + name + "_" + id + "_" +  companyName + ".txt"));
					bw.write(report);
					bw.close();
				} 
				catch (IOException e) {					
					e.printStackTrace();
				}
			}
			
			if(isToScreen()) {
				return report;
			}
			
			return null;
		}
		else {
			return "El empleado no ha sido encontrado!";
		}
		
	}
}