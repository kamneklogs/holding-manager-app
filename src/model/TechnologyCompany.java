package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TechnologyCompany extends Company implements TechnologyTaxRelief {

	public static final int TYPE_ID = 1;
	public static final double TECHNOLOGY_TAX_RELIEF = 0.3;
	
    /**
     * 
     * @param name
     * @param nit
     * @param income
     * @param outcome
     * @param taxes
     * @param value
     */
	public TechnologyCompany (String name, String nit, double income, double outcome, double taxes, double value) {
		super(name, nit, income, outcome, taxes, value);
		substractTaxes();
		new File("data/companies/" + nit + "").mkdir();				
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("data/companies/" + nit +"/attributes.txt"));
			bw.write(name + "\n" + nit + "\n" + income + "\n" + outcome + "\n" + taxes + "\n" + value + "\n" + TYPE_ID);
			bw.close();
		} catch (IOException e) {
			//SHOULD NOT GET IN HERE
		}
	}
    
    @Override
    public void substractTaxes() {
    	setTaxes(getTaxes()*(1-TECHNOLOGY_TAX_RELIEF));		
    }
    
    public void updateSave() throws IOException {	
		super.updateSave();
		BufferedWriter bw = new BufferedWriter(new FileWriter("data/companies/" + getNit() +"/attributes.txt"));
		bw.write(getName() + "\n" + getNit() + "\n" + getIncome() + "\n" + getOutcome() + "\n" + getTaxes() + "\n" + getValue() + "\n" + TYPE_ID);
		bw.close();
	}

}