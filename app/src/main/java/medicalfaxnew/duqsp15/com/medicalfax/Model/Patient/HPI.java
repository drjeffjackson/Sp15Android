package medicalfaxnew.duqsp15.com.medicalfax.Model.Patient;

import java.util.ArrayList;

/**
 * Created by Coder Barbie on 3/26/15.
 */

/**
 * This class for is the HPI (History of Present illness)
 */
public class HPI {

    ArrayList<String> historyOfPresentIllness;  //array list of strings containing history of present illness.

    /**
     * nullary constructor
     */
    public HPI() {
    }

    /**
     * constructor with arrayList
     * @param historyOfPresentIllness
     */
    public HPI(ArrayList<String> historyOfPresentIllness) {
        this.historyOfPresentIllness = historyOfPresentIllness;
    }


    public void setHPI(ArrayList<String> newHistoryOfPresentIllness) {
        historyOfPresentIllness = newHistoryOfPresentIllness;
    }

    /**
     * Getter for HPI
     * @return hpi arraylist
     */
    public ArrayList<String> getHPI() {

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
