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

    public HPI() {
    } // empty constructor.

    public HPI(String newHistory) {

        historyOfPresentIllness.ensureCapacity(historyOfPresentIllness.size() + 1);
        historyOfPresentIllness.add(newHistory);
    }

    public void setHPI(String newHistory) {
        historyOfPresentIllness.ensureCapacity(historyOfPresentIllness.size() + 1);
        historyOfPresentIllness.add(newHistory);
    }

    public ArrayList<String> getHPI() {

        return historyOfPresentIllness;
    }

     /*
     * This class will handle the HPI, to add a new line of history, you would call setHPI, on a per string
     * basis. You can call setHPI using just a normal string. However an ArrayList<String> will be returned
     * when you call the getHPI method.*/

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
