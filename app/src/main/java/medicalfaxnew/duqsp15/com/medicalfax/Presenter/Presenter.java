package medicalfaxnew.duqsp15.com.medicalfax.Presenter;

import medicalfaxnew.duqsp15.com.medicalfax.Model.ModelInterface;
import medicalfaxnew.duqsp15.com.medicalfax.MainActivity;
import medicalfaxnew.duqsp15.com.medicalfax.Presenter.Interfaces.PresenterInterface;
import medicalfaxnew.duqsp15.com.medicalfax.R;


import android.content.Context;
import android.app.Activity;
import java.util.ArrayList;
import android.widget.EditText;

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
     * Use to get an array of text boxes (as EditText objects) of the required fields that are not filled
     * @return An array of EditText text boxes that are empty required fields
     */
    public EditText[] getRequiredFields(){
       ArrayList<String> physicianFields, patientFields;

       // get the ArrayLists from Model of all required fields not filled
       physicianFields = ModelInterface.physician.verify(); //verifies physician info
       patientFields = ModelInterface.patient.verify(); // verifies patient info
       ArrayList<EditText> requiredFields = new ArrayList<EditText>();
       EditText[] requiredFieldsArray;
       EditText textField;

  // send this info to the View
        if (patientFields.contains("set allergy in list") || patientFields.contains("set medicine item in list")) {
            textField = (EditText) ac.findViewById(R.id.Home_Medications);
            requiredFields.add(textField);
        }

        if (patientFields.contains("set chief complaint")) {
            textField = (EditText) ac.findViewById(R.id.Chief_Complaint);
            requiredFields.add(textField);
        }

  // date section may not be complete
        if (patientFields.contains("set day")|| patientFields.contains("set month") || patientFields.contains("set year")) {
            textField = (EditText) ac.findViewById(R.id.Admission_Date);
            requiredFields.add(textField);
        }

        if (patientFields.contains("set patient primary diagnosis")) {
            textField = (EditText) ac.findViewById(R.id.Primary);
            requiredFields.add(textField);
        }

        if (patientFields.contains("set history of present illness")) {
            textField = (EditText) ac.findViewById(R.id.Complications);
            requiredFields.add(textField);
        }

        if (patientFields.contains("set patient medical history")) {
            textField = (EditText) ac.findViewById(R.id.Past_Medical_History);
            requiredFields.add(textField);
        }

        if (patientFields.contains("set medicine course in list")) {
            textField = (EditText) ac.findViewById(R.id.Current_Course);
            requiredFields.add(textField);
        }

        if (patientFields.contains("set medicine completed course in list")) {
            textField = (EditText) ac.findViewById(R.id.Completed_Course);
            requiredFields.add(textField);
        }

        if (patientFields.contains("set medical record num")) {
            textField = (EditText) ac.findViewById(R.id.MRN);
            requiredFields.add(textField);
        }

        if (patientFields.contains("set name of attending")) {
            textField = (EditText) ac.findViewById(R.id.Attending_Physician_Name);
            requiredFields.add(textField);
        }

        if (patientFields.contains("set name of pcp")) {
            textField = (EditText) ac.findViewById(R.id.PCP);
            requiredFields.add(textField);
        }

        if (patientFields.contains("set test name ")) {
            textField = (EditText) ac.findViewById(R.id.Finalized);
            requiredFields.add(textField);
        }

        if (patientFields.contains("set test status")) {
            textField = (EditText) ac.findViewById(R.id.Pending);
            requiredFields.add(textField);
        }

        if (physicianFields.contains("setPatientName")) {
            textField = (EditText) ac.findViewById(R.id.Patient_Name);
            requiredFields.add(textField);
        }

        if (physicianFields.contains("setDepartment")) {
            textField = (EditText) ac.findViewById(R.id.Department);
            requiredFields.add(textField);
        }
        if (physicianFields.contains("setHomeHospital")) {
            textField = (EditText) ac.findViewById(R.id.Home_Hospital);
            requiredFields.add(textField);
        }
        if (physicianFields.contains("setNPI")) {
            textField = (EditText) ac.findViewById(R.id.NPI_Number);
            requiredFields.add(textField);
        }
        if (physicianFields.contains("setEmail")) {
            textField = (EditText) ac.findViewById(R.id.Email_Address);
            requiredFields.add(textField);
        }

       requiredFieldsArray = requiredFields.toArray(new EditText[requiredFields.size()]);
        return requiredFieldsArray;
    }

}
