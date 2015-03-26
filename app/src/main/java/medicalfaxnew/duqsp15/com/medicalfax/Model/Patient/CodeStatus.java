package medicalfaxnew.duqsp15.com.medicalfax.Model.Patient;

/**
 * Created by Coder Barbie
 */

/**
 * This is a temporary class until we talk to the view/presenter team
 */
public class CodeStatus {

    /**
     * String for the code status which can be: Full, Limited, or DNR/DNI
     */
    private String codeStatus;

    /**
     * Nullary constructor
     */
    public CodeStatus() {

    }

    /**
     * Setter for code status - Case: Full
     */
    public void setAsFull() {

        codeStatus = "Full";
    }

    /**
     * Setter for code status - Case: Limited
     */
    public void setAsLimited() {

        codeStatus = "Limited";
    }

    /**
     * Setter for code status - Case: DNR/DNI
     */
    public void setAsDNRDNI() {

        codeStatus = "DNR/DNI";
    }

    /**
     * Getter for code status
     *
     * @return codeStatus
     */
    public String getCodeStatus() {

        return codeStatus;
    }

    /*
    Verifies that the code status is present
    @return Boolean
     */
    public Boolean verifyCodeStatus() {
        if (codeStatus.isEmpty()) {
            return false;
        }
        return true;
    }

}
