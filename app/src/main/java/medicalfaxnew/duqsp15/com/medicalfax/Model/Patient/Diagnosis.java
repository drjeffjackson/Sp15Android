package medicalfaxnew.duqsp15.com.medicalfax.Model.Patient;

/**
 * Created by Coder Barbie
 */

/**
 * The class diagnosis contains the fields primary and secondary diagnosis with complications
 */
public class Diagnosis {

    /**
     * This is the primary diagnosis made by the physician (required field)
     */
    String primaryDiagnosis;

    /**
     * Optional field for secondary diagnosis
     */
    String secondaryDiagnosis;

    /**
     * Optional field for complications
     */
    String complications;

    /**
     * Nullary constructor for diagnosis
     */
    public Diagnosis() {

    }

    /**
     * Constructor for handling primaryDiagnosis
     *
     * @param primaryDiagnosis - the primary diagnosis for the patient
     */
    public Diagnosis(String primaryDiagnosis) {
        this.primaryDiagnosis = primaryDiagnosis;
    }

    /**
     * Constructor for primary and secondary diagnosis
     *
     * @param primaryDiagnosis
     * @param secondaryDiagnosis
     */
    public Diagnosis(String primaryDiagnosis, String secondaryDiagnosis) {
        this.primaryDiagnosis = primaryDiagnosis;
        this.secondaryDiagnosis = secondaryDiagnosis;
    }

    /**
     * Constructor for all fields
     * @param primaryDiagnosis
     * @param secondaryDiagnosis
     * @param complications
     */
    public Diagnosis(String primaryDiagnosis, String secondaryDiagnosis, String complications) {
        this.primaryDiagnosis =  primaryDiagnosis;
        this.secondaryDiagnosis = secondaryDiagnosis;
        this.complications = complications;
    }

    /**
     * Setter for primary diagnosis
     *
     * @param newPrimaryDiagnosis - what you want to set the primary diagnosis to
     */
    public void setPrimaryDiagnosis(String newPrimaryDiagnosis) {
        primaryDiagnosis = newPrimaryDiagnosis;
    }

    /**
     * Setter for secondary diagnosis
     *
     * @param newSecondaryDiagnosis -  what you want to set the secondary diagnosis to
     */
    public void setSecondaryDiagnosis(String newSecondaryDiagnosis) {
        secondaryDiagnosis = newSecondaryDiagnosis;
    }

    /**
     * Setter for complications
     * @param newComplications - the complication you want to add
     */
    public void setComplications(String newComplications) {
        complications = newComplications;
    }

    /**
     * Getter for primary diagnosis
     * @return primary diagnosis string
     */
    public String getPrimaryDiagnosis() {
        return primaryDiagnosis;
    }

    /**
     * Getter for secondary diagnosis
     * @return secondary diagnosis
     */
    public String getSecondaryDiagnosis() {
        return secondaryDiagnosis;
    }

    /**
     * Getter
     * @return complications
     */
    public String getComplications() {
        return complications;
    }

    /**
     * Verifies that there is a primary diagnosis
     * @return boolean value true if value is not empty
     */
    public Boolean verifyPrimaryDiagnosis() {
        if (primaryDiagnosis.isEmpty()) {
            return false;
        }
        return true;
    }

}
