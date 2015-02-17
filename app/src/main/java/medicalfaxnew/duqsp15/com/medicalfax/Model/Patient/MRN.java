package medicalfaxnew.duqsp15.com.medicalfax.Model.Patient;

/**
 * Created by claire on 2/16/15.
 */
public class MRN {

    /**
     * Integer value for the medical record number.
     */
    private int mrn;

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

}
