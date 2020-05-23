package model;

import java.util.ArrayList;

public class LegalRepresentative extends Employee {

    private String[] jobTitles;

    /**
     * @param name
     * @param id
     * @param residenceAddress
     * @param numberPhone
     * @param jobTitle
     * @param salary
     * @param workingHours
     * @param socialBenefits
     * @param myContract
     * @param jobTitles
     */
    public LegalRepresentative(String name, String id, String residenceAddress, String numberPhone, String jobTitle,
            double salary, double[] workingHours, ArrayList<String> socialBenefits, Contract myContract,
            String[] jobTitles) {
        super(name, id, residenceAddress, numberPhone, jobTitle, salary, workingHours, socialBenefits, myContract);
        this.jobTitles = jobTitles;
    }

    /**
     * @return the jobTitles
     */
    public String[] getJobTitles() {
        return jobTitles;
    }
}