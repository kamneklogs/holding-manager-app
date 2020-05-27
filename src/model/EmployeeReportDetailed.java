package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class EmployeeReportDetailed extends Report {
	
	private String id;

	public EmployeeReportDetailed(boolean toCsv, boolean toTxt, Company company, String id) {
		super(toCsv, toTxt, company);		
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
			double weeklyHours = employee.getWorkingHoursPerWeek();		
			
			if(isToCsv()) {
				report += "nombre,id,dirección_residencia,numero_telefono,salario,titulo(s)_trabajo,horas_trabajo_semana";
				report += name + "," + id + "," + address + "," + phoneNumber + "," + salary + "," + jobTitle
						+ (employee instanceof LegalRepresentative? Arrays.toString(((LegalRepresentative)employee).getJobTitles()):"") + "," + weeklyHours;
				
				try {
					BufferedWriter bw = new BufferedWriter(new FileWriter("reports/Reporte_Empleado_" + name + "_" + id + "_" +  companyName + ".csv"));
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
			report += "Titulo de Trabajo: " + jobTitle + (employee instanceof LegalRepresentative? Arrays.toString(((LegalRepresentative)employee).getJobTitles()):"") + "\n";
			report += "Horas de Trabajo (L-D)" + weeklyHours + "\n";
			
			if(isToTxt()) {				
				try {
					BufferedWriter bw = new BufferedWriter(new FileWriter("reports/Reporte_Empleado_" + name + "_" + id + "_" +  companyName + ".txt"));
					bw.write(report);
					bw.close();
				} 
				catch (IOException e) {					
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