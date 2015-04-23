package medicalfaxnew.duqsp15.com.medicalfax.Presenter;

import android.app.Activity;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

import medicalfaxnew.duqsp15.com.medicalfax.Model.Patient.Allergy;
import medicalfaxnew.duqsp15.com.medicalfax.Model.Patient.Medicine;
import medicalfaxnew.duqsp15.com.medicalfax.Model.Patient.Tests;
import medicalfaxnew.duqsp15.com.medicalfax.R;

/**
 * Created on 4/17/15.
 */



public class SaverLoader {

    public Activity ac;

    Presenter mypres;

    public SaverLoader(Presenter pres, Activity act) {
        mypres = pres;
        ac = act;
    }

    public void saveData() {
        /*
        Setting records for all data pertaining to Patient class
         */

        //Setting the date for Patient's Date of Birth
        String dob = ((EditText) (mypres.ac.findViewById(R.id.DOB))).getText().toString();

        //Setting the date for Patient's Admission Date
        String adm = ((EditText) (mypres.ac.findViewById(R.id.Admission_Date))).getText().toString();

        mypres.modelInterface.patient.patientName.setName(((EditText) (mypres.ac.findViewById(R.id.Patient_Name))).getText().toString());
        mypres.modelInterface.patient.dateOfBirth.setDate(dob);
        mypres.modelInterface.patient.medRecNum.setMrn(((EditText) (mypres.ac.findViewById(R.id.MRN))).getText().toString());
        mypres.modelInterface.patient.admDate.setDate(((EditText) (mypres.ac.findViewById(R.id.DOB))).getText().toString());
        mypres.modelInterface.patient.pcpName.setName(((EditText) (mypres.ac.findViewById(R.id.PCP))).getText().toString());
        mypres.modelInterface.patient.attendingName.setName(((EditText) (mypres.ac.findViewById(R.id.Attending_Physician_Name))).getText().toString());

        mypres.modelInterface.patient.codeStatus.setAsString(((Spinner) (mypres.ac.findViewById(R.id.code_status_spinner))).getSelectedItem().toString());

        mypres.modelInterface.patient.chiefComplaint.setMedicalHistory(((EditText) (mypres.ac.findViewById(R.id.Chief_Complaint))).getText().toString());
        mypres.modelInterface.patient.hpi.setHPI(((EditText) (mypres.ac.findViewById(R.id.HPI))).getText().toString());
        mypres.modelInterface.patient.hospitalCourse.setHospitalCourse(((EditText) (mypres.ac.findViewById(R.id.Hospital_Course))).getText().toString());
        mypres.modelInterface.patient.patientName.setName(((EditText) (mypres.ac.findViewById(R.id.Patient_Name))).getText().toString());
        mypres.modelInterface.patient.addConsultantList(((EditText) (mypres.ac.findViewById(R.id.Consultants))).getText().toString());
        mypres.modelInterface.patient.patientDiagnosis.setPrimaryDiagnosis(((EditText) (mypres.ac.findViewById(R.id.Primary))).getText().toString());
        mypres.modelInterface.patient.patientDiagnosis.setSecondaryDiagnosis(((EditText) (mypres.ac.findViewById(R.id.Secondary))).getText().toString());
        mypres.modelInterface.patient.patientDiagnosis.setComplications(((EditText) (mypres.ac.findViewById(R.id.Complications))).getText().toString());
        mypres.modelInterface.patient.patientName.setName(((EditText) (mypres.ac.findViewById(R.id.Patient_Name))).getText().toString());

        //for listOfTests
        Tests t = new Tests();
        if (((EditText) (mypres.ac.findViewById(R.id.Finalized))).getText().toString() != "") {
            t.setFinalized();
        } else if (((EditText) (mypres.ac.findViewById(R.id.Pending))).getText().toString() != "") {
            t.setPending();
        }
        mypres.modelInterface.patient.addTestList(t);

        //Not really sure what the first argument should be, as there is no field for "medicine" to pull data from
        // Deleted the statement containing "current course" and "completed course"

        mypres.modelInterface.patient.medHistory.setMedicalHistory(((EditText) (mypres.ac.findViewById(R.id.Past_Medical_History))).getText().toString());
        mypres.modelInterface.patient.addAllergiesList(new Allergy(((EditText) (mypres.ac.findViewById(R.id.Home_Medications))).getText().toString()));


        /*
        Setting records for all data pertaining to Physician class
         */

        mypres.modelInterface.physician.name.setName(((EditText) (mypres.ac.findViewById(R.id.Attending_Physician_Name))).getText().toString());
        mypres.modelInterface.physician.hospital.setHomeHospital(((EditText) (mypres.ac.findViewById(R.id.Home_Hospital))).getText().toString());
        mypres.modelInterface.physician.npi.setNPI(((EditText) (mypres.ac.findViewById(R.id.NPI_Number))).getText().toString());
        mypres.modelInterface.physician.contact.setEmail(((EditText) (mypres.ac.findViewById(R.id.Email_Address))).getText().toString());
        mypres.modelInterface.physician.contact.setPhone(((EditText) (mypres.ac.findViewById(R.id.Phone_Number))).getText().toString());

    }

    public void loadData() {

    }


    public EditText[] getRequiredFields() {
        ArrayList<String> physicianFields, patientFields;

        // get the ArrayLists from Model of all required fields not filled
        physicianFields = mypres.modelInterface.physician.verify(); //verifies physician info
        patientFields = mypres.modelInterface.patient.verify(); // verifies patient info
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
        if (patientFields.contains("set day") || patientFields.contains("set month") || patientFields.contains("set year")) {
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

        // Deleted "Current Course" statement

        // Deleted "Completed Course" statement

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

        // Deleted "Department" statement

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