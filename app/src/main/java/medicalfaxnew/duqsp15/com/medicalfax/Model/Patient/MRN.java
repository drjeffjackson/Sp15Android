package medicalfaxnew.duqsp15.com.medicalfax.Model.Patient;

/**
 * Created by Coder Barbie
 */
public class MRN {

    /**
     * Integer value for the medical record number.
     */
    private int mrn = 0;

    /**
     * Nullary constructor
     */
    public MRN() {
    }

    /**
     * This is the setter for the medical record number
     *
     * @param newMrn - the int to set the mrn to
     */
    public void setMrn(int newMrn) {

        mrn = newMrn;
    }

    /**
     * This is the getter for the medical record number
     *
     * @return
     */
    public int getMrn() {

        return mrn;
    }

    /*
  Verifies that the medical record number field is present
  @return Boolean
   */
    public Boolean verifyMRN() {
        if (mrn != 0) {
            return false;
        }
        return true;
    }

}
