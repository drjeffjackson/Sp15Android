package medicalfaxnew.duqsp15.com.medicalfax.Presenter;

import medicalfaxnew.duqsp15.com.medicalfax.Model.ModelInterface;
import medicalfaxnew.duqsp15.com.medicalfax.MainActivity;
import medicalfaxnew.duqsp15.com.medicalfax.Presenter.Interfaces.PresenterInterface;


import android.content.Context;
import android.app.Activity;
import java.util.ArrayList;


/**
 * This class contains the functions pertaining to the Presenter.
 */

public class Presenter implements PresenterInterface
{
    /**
     * The object representing the modelInterface.
     */
    public ModelInterface modelInterface;
    /**
     * Identifies which box was selected for dictation.
     */
    private int requestedBox;
    /**
     * The object representing the MainActivity class.
     */
    public MainActivity ac;
    //Context is required for database in model

    /**
     * This constructor will initialize a new Presenter object with a provided Context and Activity.
     * @param context The object representing the Context.
     * @param act The object representing the Activity.
     */
    public Presenter(Context context, Activity act)
    {
        //Activity for dictation
    	ac=(MainActivity)act;
        modelInterface = new ModelInterface(context, this, act);
        requestedBox = -1;
    }

	// ModelObject
	// ViewObject

    /**
     * Notifies the Model via the ModelInterface to begin dictation.
     * @param boxNum The number id from the textbox where transcribed text is to appear.
     */
	@Override
	public void startTranscription(int boxNum)
    {
        requestedBox = boxNum;
		ModelInterface.dictation.getSpeechInput();
	}

    public void stopRequest() {
        // TODO Auto-generated method stub
        //NOT NEEDED anymore

    }

    /**
     * Retrieves transcribed text from dictation and sends it the appropriate textbox.
     * Also checks for errors in the textbox selection.
     * @param transcribedText ArrayList containing the transcribed text from dictation.
     */
    public void doneListening(ArrayList<String> transcribedText)
    {
        System.err.println("requestedBox = " + requestedBox);
        if(requestedBox !=-1){ //error checking for the View group, if it's -1, no box was selected
            System.err.println("string = " + transcribedText.get(0));
            ac.fillBox(requestedBox, transcribedText.get(0));
            //Called by model with dictation results :)//
        }
        requestedBox = -1; //need to reset value for error checking
    }

    /**
     * Use to get an ArrayList of text box id's (as strings) of the required fields that are not filled
     * @return the ArrayList of missing required field id's
     */
    public ArrayList<String> getEmptyRequiredFields(){
       ArrayList<String> physicianFields, patientFields;

        // get the ArrayLists from Model of all required fields not filled
       physicianFields = ModelInterface.physician.verify(); //verifies physician info
       patientFields = ModelInterface.patient.verify(); // verifies patient info (still incomplete)
       ArrayList<String> requiredFields = new ArrayList <String>();
       // send these ArrayLists to the View

        if (patientFields.contains("set allergy in list")) {
            requiredFields.add("Home_Medications");
        }



        if (patientFields.contains("set chief complaint")) {
            requiredFields.add("Chief_Complaint");
        }


        if (patientFields.contains("set code status")) {
            requiredFields.add("code_status_spinner");
        }


   // date section is not complete
/*if (patientFields.contains("set day")) {
requiredFields.add("Admission_Date"));
}


if (patientFields.contains("set month")) {
requiredFields.add("Admission_Date");
}


if (patientFields.contains("set year")) {
requiredFields.add("Admission_Date");
}
*/

        if (patientFields.contains("set patient primary diagnosis")) {
            requiredFields.add("Primary");
        }

        if (patientFields.contains("set history of present illness")) {
            requiredFields.add("Past_Medical_History");
        }

        if (patientFields.contains("set patient medical history")) {
            requiredFields.add("Past_Medical_History");
        }

        //medicine list is not complete 
/*if (patientFields.contains("set medicine item in list")) {
requiredFields.add("Home_Medications");
}
*/

        if (patientFields.contains("set medicine course in list")) {
            requiredFields.add("Current_Course");
        }

        if (patientFields.contains("set medicine completed course in list")) {
            requiredFields.add("Completed_Course");
        }

        if (patientFields.contains("set medical record num")) {
            requiredFields.add("MRN");
        }

        if (patientFields.contains("set name of attending")) {
            requiredFields.add("Attending_Physician_Name");
        }

        if (patientFields.contains("set name of pcp")) {
            requiredFields.add("PCP");
        }

        if (patientFields.contains("set name of patient")) {
            requiredFields.add("Patient_Name");
        }



/*
if (patientFields.contains("set test name ")) {
requiredFields.add("");
}

if (patientFields.contains("set test status")) {
requiredFields.add("");
}

*/


        if (physicianFields.contains("setPatientName")) {
            requiredFields.add("Patient_Name");
        }

        if (physicianFields.contains("setDepartment")) {
            requiredFields.add("Department");
        }
        if (physicianFields.contains("setHomeHospital")) {
            requiredFields.add("Home_Hospital");
        }
        if (physicianFields.contains("setNPI")) {
            requiredFields.add("NPI_Number");
        }
        if (physicianFields.contains("setEmail")) {
            requiredFields.add("Email_Address");
        }

        return requiredFields;



    }

}
