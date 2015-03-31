package medicalfaxnew.duqsp15.com.medicalfax.Presenter;

import android.app.Activity;
import android.content.Context;
import android.widget.Spinner;

import java.util.ArrayList;

import medicalfaxnew.duqsp15.com.medicalfax.MainActivity;
import medicalfaxnew.duqsp15.com.medicalfax.Model.ModelInterface;
import medicalfaxnew.duqsp15.com.medicalfax.Model.Patient.Allergy;
import medicalfaxnew.duqsp15.com.medicalfax.Model.Patient.Medicine;
import medicalfaxnew.duqsp15.com.medicalfax.Model.Patient.Tests;
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

    public String assembleHTML()
    {
        HTMLTable patientTable = new HTMLTable();
        for(int i=0; i<7; i++)
        {
            patientTable.add(new HTMLTableRow());
        }
        patientTable.get(0).add("Name");
        patientTable.get(0).add(modelInterface.patient.patientName);

        patientTable.get(1).add("MRN#");
        patientTable.get(1).add(modelInterface.patient.medRecNum);

        patientTable.get(2).add ("DOB");
        patientTable.get(2).add(modelInterface.patient.dateOfBirth);

        patientTable.get(3).add ("Date of Admittance");
        patientTable.get(3).add(modelInterface.patient.admDate);

        patientTable.get(4).add ("Code Status");
        patientTable.get(4).add(modelInterface.patient.codeStatus);

        patientTable.get(5).add ("Attending Name");
        patientTable.get(5).add(modelInterface.patient.attendingName);

        patientTable.get(6).add ("PCP Name");
        patientTable.get(6).add(modelInterface.patient.pcpName);

        HTMLTable physicianTable = new HTMLTable();
        for(int i=0; i<4; i++){
            physicianTable.add(new HTMLTableRow());
        }

        physicianTable.get(0).add("Name");
        physicianTable.get(0).add(modelInterface.physician.name);

        physicianTable.get(1).add(modelInterface.physician.hospital.getHomeHospital());
        physicianTable.get(1).add(modelInterface.physician.hospital.getDepartment());
        physicianTable.get(1).add(modelInterface.physician.hospital.getDepartment());

        physicianTable.get(2).add("NPI#");
        physicianTable.get(2).add(modelInterface.physician.npi);

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
        str+=new HTMLHeader("Relevant Medical History");
        str+=new HTMLParagraph(modelInterface.patient.medHistory.getMedicalHistory());
        str+=new HTMLHeader("Patient Diagnosis");
        str+=new HTMLParagraph(modelInterface.patient.patientDiagnosis.getPrimaryDiagnosis());
        str+=new HTMLParagraph(modelInterface.patient.patientDiagnosis.getSecondaryDiagnosis());
        str+=new HTMLParagraph(modelInterface.patient.patientDiagnosis.getComplications());
        str+="</html>";
        return str;
    }

    public void saveData() {

        //Setting the date for Patient's Date of Birth
        String dob = ac.findViewById(R.id.DOB).toString();
        String[] mdy = dob.split(", ");
        int year = Integer.parseInt(mdy[1]);
        String[] md = mdy[0].split(" ");
        String month = md[0];
        int day = Integer.parseInt(md[1]);

        //Setting the date for Patient's Admission Date
        String adm = ac.findViewById(R.id.Admission_Date).toString();
        String[] admDate = adm.split(", ");
        int year2 = Integer.parseInt(admDate[1]);
        String[] md2 = admDate[0].split(" ");
        String month2 = md2[0];
        int day2 = Integer.parseInt(md2[1]);

        /*
        Setting records for all data pertaining to Patient class
         */

        modelInterface.patient.patientName.setName(ac.findViewById(R.id.Patient_Name).toString());
        modelInterface.patient.dateOfBirth.setDate(month, day, year);
        modelInterface.patient.medRecNum.setMrn(ac.findViewById(R.id.MRN).toString());
        modelInterface.patient.admDate.setDate(month2, day2, year2);
        modelInterface.patient.pcpName.setName(ac.findViewById(R.id.PCP).toString());
        modelInterface.patient.attendingName.setName(ac.findViewById(R.id.Attending_Physician_Name).toString());

        //May need to be revised?
        modelInterface.patient.codeStatus.setAsString(((Spinner)(ac.findViewById(R.id.code_status_spinner))).getSelectedItem().toString());

        modelInterface.patient.chiefComplaint.setMedicalHistory(ac.findViewById(R.id.Chief_Complaint).toString());
        modelInterface.patient.hpi.setHPI(ac.findViewById(R.id.HPI).toString());
        modelInterface.patient.hospitalCourse.setHospitalCourse(ac.findViewById(R.id.Hospital_Course).toString());
        modelInterface.patient.patientName.setName(ac.findViewById(R.id.Patient_Name).toString());
        modelInterface.patient.addConsultantList(ac.findViewById(R.id.Consultants).toString());
        modelInterface.patient.patientDiagnosis.setPrimaryDiagnosis(ac.findViewById(R.id.Primary).toString());
        modelInterface.patient.patientDiagnosis.setSecondaryDiagnosis(ac.findViewById(R.id.Secondary).toString());
        modelInterface.patient.patientDiagnosis.setComplications(ac.findViewById(R.id.Complications).toString());
        modelInterface.patient.patientName.setName(ac.findViewById(R.id.Patient_Name).toString());

        //something for listOfTests
        Tests t = new Tests();
        if(ac.findViewById(R.id.Finalized).toString()!="") { t.setFinalized(); }
        if(ac.findViewById(R.id.Pending).toString()!="") { t.setPending(); }
        modelInterface.patient.addTestList(t);

        //Not really sure what the first argument should be, as there is no field for "medicine" to pull data from
        modelInterface.patient.addPatientMedicationList(new Medicine(ac.findViewById(R.id.Home_Medications).toString(),
                ac.findViewById(R.id.Current_Course).toString(), ac.findViewById(R.id.Completed_Course).toString()));

        modelInterface.patient.medHistory.setMedicalHistory(ac.findViewById(R.id.Past_Medical_History).toString());
        modelInterface.patient.addAllergiesList(new Allergy(ac.findViewById(R.id.Home_Medications).toString()));


        /*
        Setting records for all data pertaining to Physician class
         */

        modelInterface.physician.name.setName(ac.findViewById(R.id.Attending_Physician_Name).toString());
        modelInterface.physician.hospital.setHomeHospital(ac.findViewById(R.id.Home_Hospital).toString());
        modelInterface.physician.npi.setNPI(ac.findViewById(R.id.NPI_Number).toString());
        modelInterface.physician.contact.setEmail(ac.findViewById(R.id.Email_Address).toString());
        modelInterface.physician.contact.setPhone(ac.findViewById(R.id.Phone_Number).toString());

    }


}
