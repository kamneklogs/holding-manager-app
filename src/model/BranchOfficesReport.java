package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BranchOfficesReport extends Report {

	public BranchOfficesReport(boolean toScreen, boolean toCsv, boolean toTxt, Company company) {
		super(toScreen, toCsv, toTxt, company);		
	}

	@Override
	public String generateReport() {
		if(getCompany().getFirstBranchOffice() != null) {
			String report = "";
			String name = getCompany().getName();
			String nit = getCompany().getNit();
			if(isToCsv()) {
				BranchOffice current = getCompany().getFirstBranchOffice();
				report += "tipo,id,ciudad,direcci�n\n";								
				
				while(current != null) {
					report += current.getType() + "," + current.getId() + "," + current.getCity() + "," + current.getAddress() + "\n";
					current = current.getNextOffice();
				}
				
				try {
					BufferedWriter bw = new BufferedWriter(new FileWriter("data/Reporte_Sedes_" + name + ".csv"));
					bw.write(report);
					bw.close();
				} 
				catch (IOException e) {					
					e.printStackTrace();
				}
			}
			
			BranchOffice current = getCompany().getFirstBranchOffice();
			report = "REPORTE DE SEDES PARA LA EMPRESA " + name + " CON NIT: " + nit + "\n";								
			
			while(current != null) {
				report += "Tipo: " + current.getType() + " -- ID: " + current.getId() + " -- Ciudad: " + current.getCity() + " -- Direcci�n:" + current.getAddress() + "\n";
				current = current.getNextOffice();
			}
			
			
			if(isToTxt()) {
				try {
					BufferedWriter bw = new BufferedWriter(new FileWriter("data/Reporte_Sedes_" + name + ".txt"));
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
			return "No hay sedes agregadas!";
		}
	}

}
