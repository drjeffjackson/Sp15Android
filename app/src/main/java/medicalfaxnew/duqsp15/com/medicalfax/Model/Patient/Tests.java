package medicalfaxnew.duqsp15.com.medicalfax.Model.Patient;

/**
 * Created by Coder Barbie
 */
public class Tests {

    /**
     * The name of the test
     */
    private String testName;

    /**
     * Test status can be finalized or pending
     */
    private String testStatus;


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
        testStatus = "FINALIZED";
    }

    /**
     * Setter for Status - Pending
     */
    public void setPending() {
        testStatus = "PENDING";
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
        return testStatus;
    }

    /*
  Verifies that the test name is present
  @return Boolean
   */
    public Boolean verifyTestName() {
        if (testName.isEmpty()) {
            return false;
        }
        return true;
    }

    /*
  Verifies that the test status field is present
  @return Boolean
   */
    public Boolean verifyTestStatus() {
        if (testStatus.isEmpty()) {
            return false;
        }
        return true;
    }

}
