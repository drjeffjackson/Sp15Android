package medicalfaxnew.duqsp15.com.medicalfax.Presenter;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.widget.EditText;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import medicalfaxnew.duqsp15.com.medicalfax.MainActivity;
import medicalfaxnew.duqsp15.com.medicalfax.Model.ModelInterface;
import medicalfaxnew.duqsp15.com.medicalfax.Presenter.Interfaces.PresenterInterface;
import medicalfaxnew.duqsp15.com.medicalfax.R;

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
    public Context con;
    private SaverLoader SL;
    /**
     * HTML String
     */
    private String htmlResult;
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
        con=context;
        htmlResult = "";
        SL = new SaverLoader(this);
        saveData();
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

    public String assembleHTML()
    {
        HTMLTable patientTable = new HTMLTable();
        for(int i=0; i<7; i++)
        {
            patientTable.add(new HTMLTableRow());
        }
        patientTable.get(0).add("Name");
        patientTable.get(0).add(modelInterface.patient.patientName.getName());

        patientTable.get(1).add("MRN#");
        patientTable.get(1).add(modelInterface.patient.medRecNum.getMrn());

        patientTable.get(2).add ("DOB");
        patientTable.get(2).add(modelInterface.patient.dateOfBirth.getDay()+"/"+modelInterface.patient.dateOfBirth.getMonth()+"/"+modelInterface.patient.dateOfBirth.getYear());

        patientTable.get(3).add ("Date of Admittance");
        patientTable.get(3).add(modelInterface.patient.admDate.getDay()+"/"+modelInterface.patient.admDate.getMonth()+"/"+modelInterface.patient.admDate.getYear());

        patientTable.get(4).add ("Code Status");
        patientTable.get(4).add(modelInterface.patient.codeStatus.getCodeStatus());

        patientTable.get(5).add ("Attending Name");
        patientTable.get(5).add(modelInterface.patient.attendingName.getName());

        patientTable.get(6).add ("PCP Name");
        patientTable.get(6).add(modelInterface.patient.pcpName.getName());


        HTMLTable physicianTable = new HTMLTable();
        for(int i=0; i<4; i++){
            physicianTable.add(new HTMLTableRow());
        }

        physicianTable.get(0).add("Name");
        physicianTable.get(0).add(modelInterface.physician.name.getName());

        physicianTable.get(1).add(modelInterface.physician.hospital.getHomeHospital());
        physicianTable.get(1).add(modelInterface.physician.hospital.getDepartment()+"-"+modelInterface.physician.hospital.getTitle());

        physicianTable.get(2).add("NPI#");
        physicianTable.get(2).add(modelInterface.physician.npi.getNPI());

        physicianTable.get(3).add(modelInterface.physician.contact.getEmail());
        physicianTable.get(3).add(modelInterface.physician.contact.getPhone());

        String str = null;
        str+="<!DOCTYPE html>";
        str+="<html>";
        str+=new HTMLHeader("Patient").toString();
        str+=patientTable.toString();
        str+=new HTMLHeader("Physician").toString();
        str+=physicianTable.toString();
        str+=new HTMLHeader("Chief Complaint").toString();
        str+=new HTMLParagraph(modelInterface.patient.chiefComplaint.getChiefComplaint());
        str+=new HTMLHeader("HPI").toString();
        str+=new HTMLParagraph(modelInterface.patient.hpi.getHPI());
        str+=new HTMLHeader("Hospital Course");
        str+=new HTMLParagraph(modelInterface.patient.hospitalCourse.getHospitalCourse());
        str+=new HTMLHeader("Relevant Medical History");
        str+=new HTMLParagraph(modelInterface.patient.medHistory.getMedicalHistory());
        str+=new HTMLHeader("Patient Diagnosis");
        str+=new HTMLParagraph(modelInterface.patient.patientDiagnosis.getPrimaryDiagnosis());
        str+=new HTMLParagraph(modelInterface.patient.patientDiagnosis.getSecondaryDiagnosis());
        str+=new HTMLParagraph(modelInterface.patient.patientDiagnosis.getComplications());
        str+="</html>";
        htmlResult = str;
        return str;
    }

    public File GenerateHTML()
    {
        FileWriter fw = null;
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), "htmlCode.html");

            try {
                fw = new FileWriter(file);
                fw.append(htmlResult);
                fw.flush();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        return file;
    }

    public void saveData() {
        SL.saveData();
    }

    public void updateDatabase() {
        modelInterface.patient.update();
        modelInterface.physician.update();
    }

    public EditText[] getRequiredFields(){
        ArrayList<String> physicianFields, patientFields;

        // get the ArrayLists from Model of all required fields not filled
        physicianFields = modelInterface.physician.verify(); //verifies physician info
        patientFields = modelInterface.patient.verify(); // verifies patient info
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

    public void sendEmail(){
        saveData();
        /* Recipient and CC's can be pre-filled by passing String[] containing them, otherwise pass null */
        modelInterface.email.sendEmail(null,null ,"Patient Information is in the attached Document.", Uri.fromFile(GenerateHTML()));
    }

}
