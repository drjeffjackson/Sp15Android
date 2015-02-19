package medicalfaxnew.duqsp15.com.medicalfax.Model.Patient;

/**
 * Created by Justin Chilleo on 2/18/15.
 * Code based off, Claire Saunders MedicalHistory.
 */
public class ChiefComplaint {
    String chiefComplaint;

    /**
     * Nullary constructor
     */
    public ChiefComplaint() {

    }

    /**
     * Setter for chief complaint
     *
     * @param newChiefComplaint - String to set as chief complaint
     */
    public void setMedicalHistory(String newChiefComplaint) {
        chiefComplaint = newChiefComplaint;
    }

    /**
     * Getter for Chief Complaint
     *
     * @return - Chief Complaint
     */
    public String getChiefComplaint() {
        return chiefComplaint;
    }

}
