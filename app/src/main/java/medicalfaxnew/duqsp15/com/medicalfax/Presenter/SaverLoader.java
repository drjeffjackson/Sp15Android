package medicalfaxnew.duqsp15.com.medicalfax.Presenter;

import android.app.Activity;
import android.widget.EditText;
import android.widget.Spinner;

import medicalfaxnew.duqsp15.com.medicalfax.MainActivity;
import medicalfaxnew.duqsp15.com.medicalfax.Model.Patient.Allergy;
import medicalfaxnew.duqsp15.com.medicalfax.Model.Patient.CodeStatus;
import medicalfaxnew.duqsp15.com.medicalfax.Model.Patient.Tests;
import medicalfaxnew.duqsp15.com.medicalfax.R;

/**
 * Created on 4/17/15.
 */



public class SaverLoader {

    public Activity ac;

    Presenter mypres;

    boolean dictationFlag;
    boolean agreementFlag;

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

        mypres.modelInterface.patient.codeStatus.setAsString(((Spinner) (mypres.ac.findViewById(R.id.code_status_spinner))).getSelectedItem().toString());

        mypres.modelInterface.patient.chiefComplaint.setMedicalHistory(((EditText) (mypres.ac.findViewById(R.id.Chief_Complaint))).getText().toString());
        mypres.modelInterface.patient.hpi.setHPI(((EditText) (mypres.ac.findViewById(R.id.HPI))).getText().toString());
        mypres.modelInterface.patient.hospitalCourse.setHospitalCourse(((EditText) (mypres.ac.findViewById(R.id.Hospital_Course))).getText().toString());
        mypres.modelInterface.patient.patientName.setName(((EditText) (mypres.ac.findViewById(R.id.Patient_Name))).getText().toString());
        mypres.modelInterface.patient.addConsultantList(((EditText) (mypres.ac.findViewById(R.id.Consultants))).getText().toString());
        mypres.modelInterface.patient.patientDiagnosis.setPrimaryDiagnosis(((EditText) (mypres.ac.findViewById(R.id.Primary))).getText().toString());
        mypres.modelInterface.patient.patientDiagnosis.setSecondaryDiagnosis(((EditText) (mypres.ac.findViewById(R.id.Secondary))).getText().toString());
        mypres.modelInterface.patient.patientDiagnosis.setComplications(((EditText) (mypres.ac.findViewById(R.id.Complications))).getText().toString());

        //for listOfTests
        String testName = ((EditText)(mypres.ac.findViewById(R.id.Finalized))).getText().toString();
        String testStatus = ((EditText)(mypres.ac.findViewById(R.id.Pending))).getText().toString();

        Tests t1 = new Tests(testName, testStatus);
        if (t1.getTestName() != "") { t1.setFinalized(); }
        if (t1.getStatus() != "") { t1.setPending(); }

        mypres.modelInterface.patient.addTestList(t1);

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

        mypres.modelInterface.physician.setContinuousDictation(mypres.ac.getContinuousDictation());
        //[A method of a model object to set agreement flag](mypres.ac.getAgreement());
    }

    public void loadData() {
         /*
         Loading Patient data from Model Object into text boxes
         */

        CodeStatus cs = new CodeStatus();

        int spinnerID;

        if (cs.getCodeStatus() == "Full") { spinnerID = 0; }

        else if (cs.getCodeStatus() == "Limited") { spinnerID = 1; }

        else { spinnerID = 2; }


        ((EditText)(mypres.ac.findViewById(R.id.Patient_Name))).setText((mypres.modelInterface.patient.patientName.getName()));
        ((EditText)(mypres.ac.findViewById(R.id.DOB))).setText((mypres.modelInterface.patient.dateOfBirth.getDate()));
        ((EditText)(mypres.ac.findViewById(R.id.MRN))).setText((mypres.modelInterface.patient.medRecNum.getMrn()));
        ((EditText)(mypres.ac.findViewById(R.id.Admission_Date))).setText((mypres.modelInterface.patient.admDate.getDate()));
        ((EditText)(mypres.ac.findViewById(R.id.PCP))).setText((mypres.modelInterface.patient.pcpName.getName()));
//        ((EditText)(mypres.ac.findViewById(R.id.Attending_Physician_Name))).setText((mypres.modelInterface.patient.attendingName.getName()));

        ((Spinner)(mypres.ac.findViewById(R.id.code_status_spinner))).setSelection(spinnerID);

        ((EditText)(mypres.ac.findViewById(R.id.Chief_Complaint))).setText((mypres.modelInterface.patient.chiefComplaint.getChiefComplaint()));
        ((EditText)(mypres.ac.findViewById(R.id.HPI))).setText((mypres.modelInterface.patient.hpi.getHPI()));
        ((EditText)(mypres.ac.findViewById(R.id.Hospital_Course))).setText((mypres.modelInterface.patient.hospitalCourse.getHospitalCourse()));

        ((EditText)(mypres.ac.findViewById(R.id.Consultants))).setText(mypres.modelInterface.patient.getConsultantList());

        ((EditText)(mypres.ac.findViewById(R.id.Primary))).setText((mypres.modelInterface.patient.patientDiagnosis.getPrimaryDiagnosis()));
        ((EditText)(mypres.ac.findViewById(R.id.Secondary))).setText((mypres.modelInterface.patient.patientDiagnosis.getSecondaryDiagnosis()));
        ((EditText)(mypres.ac.findViewById(R.id.Complications))).setText((mypres.modelInterface.patient.patientDiagnosis.getComplications()));

        ((EditText)(mypres.ac.findViewById(R.id.Past_Medical_History))).setText((mypres.modelInterface.patient.medHistory.getMedicalHistory()));

        ((EditText)(mypres.ac.findViewById(R.id.Home_Medications))).setText(mypres.modelInterface.patient.getAllergyList());


         /*
         Loading Physician data into Text boxes
         */
        ((EditText)(mypres.ac.findViewById(R.id.Attending_Physician_Name))).setText((mypres.modelInterface.physician.name.getName()));
        ((EditText)(mypres.ac.findViewById(R.id.Home_Hospital))).setText((mypres.modelInterface.physician.hospital.getHomeHospital()));
        ((EditText)(mypres.ac.findViewById(R.id.NPI_Number))).setText((mypres.modelInterface.physician.npi.getNPI()));
        ((EditText)(mypres.ac.findViewById(R.id.Email_Address))).setText((mypres.modelInterface.physician.contact.getEmail()));
        ((EditText)(mypres.ac.findViewById(R.id.Phone_Number))).setText((mypres.modelInterface.physician.contact.getPhone()));

        mypres.ac.setContinuousDictation(mypres.modelInterface.physician.getContinuousDictation());
        //mypres.ac.setAgreement(/*[A method to get the agreement flag from the database through some model object]*/);

    }

    public void reset(int currentTab)
    {
        switch(currentTab)
        {
            case 1:
                ((EditText)(mypres.ac.findViewById(R.id.Patient_Name))).setText("");
                ((EditText)(mypres.ac.findViewById(R.id.DOB))).setText("");
                ((EditText)(mypres.ac.findViewById(R.id.MRN))).setText("");
                ((EditText)(mypres.ac.findViewById(R.id.PCP))).setText("");
                ((Spinner)(mypres.ac.findViewById(R.id.code_status_spinner))).setSelection(0);
                ((EditText)(mypres.ac.findViewById(R.id.Past_Medical_History))).setText("");
                ((EditText)(mypres.ac.findViewById(R.id.Home_Medications))).setText("");
                break;
            case 2:
                ((EditText)(mypres.ac.findViewById(R.id.Attending_Physician_Name))).setText("");
                ((EditText)(mypres.ac.findViewById(R.id.Home_Hospital))).setText("");
                ((EditText)(mypres.ac.findViewById(R.id.Email_Address))).setText("");
                ((EditText)(mypres.ac.findViewById(R.id.Phone_Number))).setText("");
                ((EditText)(mypres.ac.findViewById(R.id.NPI_Number))).setText("");
                break;
            case 3:
                ((EditText)(mypres.ac.findViewById(R.id.Admission_Date))).setText("");
                ((EditText)(mypres.ac.findViewById(R.id.Chief_Complaint))).setText("");
                ((EditText)(mypres.ac.findViewById(R.id.HPI))).setText("");
                ((EditText)(mypres.ac.findViewById(R.id.Hospital_Course))).setText("");
                ((EditText)(mypres.ac.findViewById(R.id.Consultants))).setText("");
                break;
            case 4:
                ((EditText)(mypres.ac.findViewById(R.id.Primary))).setText("");
                ((EditText)(mypres.ac.findViewById(R.id.Secondary))).setText("");
                ((EditText)(mypres.ac.findViewById(R.id.Complications))).setText("");
               break;
            case 5:
                ((EditText)(mypres.ac.findViewById(R.id.Finalized))).setText("");
                ((EditText)(mypres.ac.findViewById(R.id.Pending))).setText("");
                break;
            default: break;
        }
    }
    public boolean testRequiredFields() {

        return  check(R.id.Patient_Name) & check(R.id.DOB) & check(R.id.Admission_Date) &
                check(R.id.Home_Hospital) & check(R.id.Home_Medications) & check(R.id.Primary) &
                check(R.id.Complications) & check(R.id.Past_Medical_History) & check(R.id.MRN) &
                check(R.id.Attending_Physician_Name) & check(R.id.PCP) & check(R.id.Finalized) &
                check(R.id.Pending) & check(R.id.NPI_Number) & check(R.id.Email_Address) & check(R.id.Chief_Complaint) ;
    }
    private boolean check(int id)
    {
        EditText required = (EditText) ac.findViewById(id);
        if (required.getText().toString().isEmpty()) {
            required.setError("Field is required");
            return false;
        }
        else{
            required.setError(null);
        }
        return true;
    }
}