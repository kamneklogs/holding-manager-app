package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class EmployeeReportGeneral extends Report {

    public EmployeeReportGeneral(boolean toCsv, boolean toTxt, Company company) {
		super(toCsv, toTxt, company);		
	}
    
	@Override
	public String generateReport() {
		Employee employee = getCompany().getFirstEmployee();
		if(employee != null){
			String report = "";
			String companyName = getCompany().getName();		
			
			if(isToCsv()) {
				report += "name,id,phone_number,salary,job_title(s)\n";
				report += obtainInfoCSV(employee,"");
				try {
					BufferedWriter bw = new BufferedWriter(new FileWriter("data/Reporte_Empleados_" + companyName + ".csv"));
					bw.write(report);
					bw.close();
				} 
				catch (IOException e) {					
					e.printStackTrace();
				}
			}			
			
			if(isToTxt()) {
				report = "REPORTE GENERAL DE EMPLEADOS PARA LA EMPRESA " + companyName + "\n";
				report += obtainInfo(employee,"");
				try {
					BufferedWriter bw = new BufferedWriter(new FileWriter("data/Reporte_Empleados_" + companyName + ".txt"));
					bw.write(report);
					bw.close();
				} 
				catch (IOException e) {					
					e.printStackTrace();
				}
			}
			return "";
		}
		else {
			return null;
		}
		
	}
	
	private String obtainInfoCSV(Employee employee, String data) {
		if(employee == null) {
			return data;
		}
		else {
			data += employee.getName() + "," + employee.getId() + "," + employee.getNumberPhone() + "," + employee.getSalary()
			+ "," + employee.getJobTitle() + " " + (employee instanceof LegalRepresentative? Arrays.toString(((LegalRepresentative)employee).getJobTitles()):"") + "\n";
			data += obtainInfoCSV(employee.getLeft(),data);
			data += obtainInfoCSV(employee.getRight(),data);	
			return data;
		}		
	}
	
	private String obtainInfo(Employee employee, String data) {
		if(employee == null) {
			return data;
		}
		else {
			data += "Name: " + employee.getName() + "\nId: " + employee.getId() + "\nPhone Number: " + employee.getNumberPhone()
			+ "\nSalary: " + employee.getSalary() + "\nJob title: " + employee.getJobTitle()
			+ (employee instanceof LegalRepresentative? "\nAdditional job titles: " + Arrays.toString(((LegalRepresentative)employee).getJobTitles()):"") + "\n";
			data += obtainInfo(employee.getLeft(),data);
			data += obtainInfo(employee.getRight(),data);	
			return data;
		}
	}
	
}