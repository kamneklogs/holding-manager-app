package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EconomicReport extends Report {

    public EconomicReport(boolean toScreen, boolean toCsv, boolean toTxt, Company company) {
    	super(toScreen, toCsv,toTxt,company);           
    }    

	@Override
	public String generateReport() {
		String report = "";
		Company currentCompany = getCompany();		
		String name = currentCompany.getName();
		String nit = currentCompany.getNit();
		
		double income = currentCompany.getIncome();
		double outcome = currentCompany.getOutcome();
		double value = currentCompany.getValue();
		double taxes = currentCompany.getTaxes();
		
		if(isToCsv()) {			 
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter("data/Reporte_Economico_" + name + ".csv"));
				bw.write("nombre,nit,ingresos,egresos,valor,impuestos");
				bw.newLine();
				bw.write(name + "," + nit + ",$" + income + ",$" + outcome + ",$" + value + "," + taxes + "%");				
				bw.close();				
			} catch (IOException e) {				
				e.printStackTrace();				
			}			
		}
		
		report = "REPORTE ECONOMICO PARA LA EMPRESA " + name + " CON NIT:" + nit + "\n";
		report += "Ingresos: $" + income + "\n Egresos: $" + outcome
				+ "\nValor: $" + value + "\nImpuestos: " + taxes + "%";
		
		if(isToTxt()) {
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter("data/Reporte_Economico_" + name + ".txt"));
				bw.write(report);							
				bw.close();				
			} catch (IOException e) {				
				e.printStackTrace();				
			}
		}
		
		
		
		if(isToScreen()) {			
			return report;			
		}	
		
		return null;
	}
}