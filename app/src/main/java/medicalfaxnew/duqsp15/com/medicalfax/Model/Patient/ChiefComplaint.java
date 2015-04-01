package medicalfaxnew.duqsp15.com.medicalfax.Model.Patient;

/**
 * Created by Coder Thanatos on 2/18/15.
 * Code based off, Coder Barbie MedicalHistory.
 */
public class ChiefComplaint {

    String chiefComplaint;

    /**
     * nullary constructor
     */
    public ChiefComplaint() {

    }

    /**
     * Constructor with String
     * @param chiefComplaint
     */
    public ChiefComplaint(String chiefComplaint) {
        this.chiefComplaint = chiefComplaint;
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

    /**
     * Verifies string is not empty
     * @return boolean value
     */
    public Boolean verifyComplaint() {
        if (chiefComplaint.isEmpty()) {
            return false;
        }
        return true;
    }

}
