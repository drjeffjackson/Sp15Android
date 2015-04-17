package medicalfaxnew.duqsp15.com.medicalfax.Model.Patient;

import java.util.ArrayList;

/** Justin!!!! No one likes arraylists
 * Created by Coder Barbie on 3/26/15.
 */

/**
 * This class for is the HPI (History of Present illness)
 */
public class HPI {

    String historyOfPresentIllness;  //array list of strings containing history of present illness.

    /**
     * nullary constructor
     */
    public HPI() {
    }

    /**
     * constructor with String
     * @param historyOfPresentIllness
     */
    public HPI(String historyOfPresentIllness) {
        this.historyOfPresentIllness = historyOfPresentIllness;
    }


    public void setHPI(String newHistoryOfPresentIllness) {
        historyOfPresentIllness = newHistoryOfPresentIllness;
    }

    /**
     * Getter for HPI
     * @return hpi
     */
    public String getHPI() {

        return historyOfPresentIllness;
    }

    /*
   Verifies that the history of present illness is present, do we need this?
   @return Boolean
    */
    public Boolean verifyHistoryOfPresentIllness() {
        if (historyOfPresentIllness.isEmpty()) {
            return false;
        }
        return true;
    }
}
