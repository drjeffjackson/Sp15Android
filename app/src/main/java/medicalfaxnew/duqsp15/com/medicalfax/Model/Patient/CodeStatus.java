package medicalfaxnew.duqsp15.com.medicalfax.Model.Patient;

/**
 * Created by Coder Barbie
 */

/**
 * Class for setting the code status using the drop down
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
     * Constructor for setting code status
     * @param codeStatus - Full, Limited, or DNR/DNI
     */
    public  CodeStatus(String codeStatus) {
        this.codeStatus = codeStatus;
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

    /*
    Setter for code statys as passed string
     */
    public void setAsString(String passed)
    {
        codeStatus = passed;
    }

    /**
     * Getter for code status
     *
     * @return codeStatus
     */
    public String getCodeStatus() {

        return codeStatus;
    }

    /**
     * Verifies code status is not empty
     * @return boolean value
     */
    public Boolean verifyCodeStatus() {
        if (codeStatus.isEmpty()) {
            return false;
        }
        return true;
    }

}
