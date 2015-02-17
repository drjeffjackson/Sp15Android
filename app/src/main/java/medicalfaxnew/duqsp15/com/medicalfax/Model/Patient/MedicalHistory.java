package medicalfaxnew.duqsp15.com.medicalfax.Model.Patient;

/**
 * Created by claire on 2/17/15.
 */
public class MedicalHistory {

    String medicalHistory;

    /**
     * Nullary constructor
     */
    public MedicalHistory() {

    }

    /**
     * Setter for Medical History
     *
     * @param newMedicalHistory - String to set as medical history
     */
    public void setMedicalHistory(String newMedicalHistory) {
        medicalHistory = newMedicalHistory;
    }

    /**
     * Getter for Medical History
     *
     * @return - medical history
     */
    public String getMedicalHistory() {
        return medicalHistory;
    }
}
