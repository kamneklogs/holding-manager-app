package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BranchOfficesReport extends Report {
	
	/**
	 * 
	 * @param toCsv
	 * @param toTxt
	 * @param company
	 */
	public BranchOfficesReport(boolean toCsv, boolean toTxt, Company company) {
		super(toCsv, toTxt, company);		
	}

	@Override
	/**
	 * 
	 */
	public String generateReport() {
		if(getCompany().getFirstBranchOffice() != null) {
			String report = "";
			String name = getCompany().getName();
			String nit = getCompany().getNit();
			if(isToCsv()) {
				BranchOffice current = getCompany().getFirstBranchOffice();
				report += "tipo,id,ciudad,dirección\n";								
				
				while(current != null) {
					report += current.getType() + "," + current.getId() + "," + current.getCity() + "," + current.getAddress() + "\n";
					current = current.getNextOffice();
				}
				
				try {
					BufferedWriter bw = new BufferedWriter(new FileWriter("reports/Reporte_Sedes_" + name + ".csv"));
					bw.write(report);
					bw.close();
				} 
				catch (IOException e) {					
					e.printStackTrace();
				}
			}					
			
			if(isToTxt()) {
				BranchOffice current = getCompany().getFirstBranchOffice();
				report = "REPORTE DE SEDES PARA LA EMPRESA " + name + " CON NIT: " + nit + "\n";								
				
				while(current != null) {
					report += "Tipo: " + current.getType() + " -- ID: " + current.getId() + " -- Ciudad: " + current.getCity() + " -- Dirección:" + current.getAddress() + "\n";
					current = current.getNextOffice();
				}
				try {
					BufferedWriter bw = new BufferedWriter(new FileWriter("reports/Reporte_Sedes_" + name + ".txt"));
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
