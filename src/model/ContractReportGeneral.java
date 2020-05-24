package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ContractReportGeneral extends Report {

	public ContractReportGeneral(boolean toCsv, boolean toTxt, Company company) {
		super(toCsv, toTxt, company);	
	} 	  
	@Override
	public String generateReport() {	
		Contract contract = getCompany().getFirstContract();
		if(contract != null) {
			String companyName = getCompany().getName();
			String report = "";		
			
			if(isToCsv()) {
				report = "nombre,id,fecha_inicio,fecha_fin\n";
				
				while(contract != null) {
					report += contract.getName() + "," + contract.getId() + "," 
					+ (contract.getStartDate() != null? contract.getStartDate().toString() : "N/A") + "," 
					+ (contract.getFinishDate() != null? contract.getFinishDate().toString() : "N/A") + "\n";
					contract = contract.getNextContract();
				}
				
				try {
					BufferedWriter bw = new BufferedWriter(new FileWriter("data/Reporte_Contratos_" +  companyName + ".csv"));
					bw.write(report);
					bw.close();
				} 
				catch (IOException e) {					
					e.printStackTrace();
				}			
			}
						
			if(isToTxt()) {	
				report = "REPORTE GENERAL DE CONTRATOS PARA LA EMPRESA " + companyName + "\n";
				
				while(contract != null) {
					report += "Name: " + contract.getName() + " -- ID: " + contract.getId() 
					+ " -- Fecha de Incio: "
					+ (contract.getStartDate() != null? contract.getStartDate().toString() : "N/A")
					+ " -- Fecha de Terminación: " 
					+ (contract.getFinishDate() != null? contract.getFinishDate().toString() : "N/A") + "\n";
					contract = contract.getNextContract();
				}
				try {
					BufferedWriter bw = new BufferedWriter(new FileWriter("data/Reporte_Contratos_" +  companyName + ".txt"));
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
}