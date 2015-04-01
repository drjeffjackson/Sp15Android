package medicalfaxnew.duqsp15.com.medicalfax.Model.Patient;
/**
 * Created by Coder Barbie
 */
public class MedicalHistory {

    String medicalHistory;

    /**
     * Nullary constructor
     */
    public MedicalHistory() {

    }

    public MedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
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

    /*
   Verifies that the medical history is present
   @return Boolean
    */
    public Boolean verifyMedicalHistory() {
        if (medicalHistory.isEmpty()) {
            return false;
        }
        return true;
    }
}
