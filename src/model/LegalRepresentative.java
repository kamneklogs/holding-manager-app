package model;

@SuppressWarnings("serial")
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
            double salary, int workingHours, String[] jobTitles, Contract myContract) {
        super(name, id, residenceAddress, numberPhone, jobTitle, salary, workingHours, myContract);
        this.jobTitles = jobTitles;
    }

    /**
     * @return the jobTitles
     */
    public String[] getJobTitles() {
        return jobTitles;
    }
}