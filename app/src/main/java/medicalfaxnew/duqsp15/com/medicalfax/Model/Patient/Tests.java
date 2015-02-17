package medicalfaxnew.duqsp15.com.medicalfax.Model.Patient;

/**
 * Created by claire on 2/16/15.
 */
public class Tests {

    /**
     * The name of the test
     */
    private String testName;

    /**
     * Test status can be finalized or pending
     */
    private String setStatus;


    /**
     * nullary constructor
     */
    public Tests() {

    }

    /**
     * Setter for testName
     *
     * @param newTestName - new name to set testName to
     */
    public void setTestName(String newTestName) {
        testName = newTestName;
    }

    /**
     * Setter for Status - FINALIZED
     */
    public void setFinalized() {
        setStatus = "FINALIZED";
    }

    /**
     * Setter for Status - Pending
     */
    public void setPending() {
        setStatus = "PENDING";
    }

    /**
     * Return the name of the test
     *
     * @return - testName
     */
    public String getTestName() {
        return testName;
    }

    /**
     * Return the test status
     *
     * @return - testStatus
     */
    public String getStatus() {
        return setStatus;
    }

}
