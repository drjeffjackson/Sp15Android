package medicalfaxnew.duqsp15.com.medicalfax.Presenter;

import android.widget.EditText;
import android.widget.Spinner;

import medicalfaxnew.duqsp15.com.medicalfax.Model.Patient.Allergy;
import medicalfaxnew.duqsp15.com.medicalfax.Model.Patient.Medicine;
import medicalfaxnew.duqsp15.com.medicalfax.Model.Patient.Tests;
import medicalfaxnew.duqsp15.com.medicalfax.R;

/**
 * Created by dansuriano on 4/17/15.
 */
public class SaverLoader {

        Presenter mypres;

        public SaverLoader(Presenter pres) {
            mypres = pres;
        }

        public void saveData() {
        /*
        Setting records for all data pertaining to Patient class
         */

            //Setting the date for Patient's Date of Birth
            String dob = ((EditText)(mypres.ac.findViewById(R.id.DOB))).getText().toString();

            //Setting the date for Patient's Admission Date
            String adm = ((EditText)(mypres.ac.findViewById(R.id.Admission_Date))).getText().toString();

            mypres.modelInterface.patient.patientName.setName(((EditText)(mypres.ac.findViewById(R.id.Patient_Name))).getText().toString());
            mypres.modelInterface.patient.dateOfBirth.setDate(dob);
            mypres.modelInterface.patient.medRecNum.setMrn(((EditText)(mypres.ac.findViewById(R.id.MRN))).getText().toString());
            mypres.modelInterface.patient.admDate.setDate(((EditText)(mypres.ac.findViewById(R.id.DOB))).getText().toString());
            mypres.modelInterface.patient.pcpName.setName(((EditText)(mypres.ac.findViewById(R.id.PCP))).getText().toString());
            mypres.modelInterface.patient.attendingName.setName(((EditText)(mypres.ac.findViewById(R.id.Attending_Physician_Name))).getText().toString());

            mypres.modelInterface.patient.codeStatus.setAsString(((Spinner)(mypres.ac.findViewById(R.id.code_status_spinner))).getSelectedItem().toString());

            mypres.modelInterface.patient.chiefComplaint.setMedicalHistory(((EditText)(mypres.ac.findViewById(R.id.Chief_Complaint))).getText().toString());
            mypres.modelInterface.patient.hpi.setHPI(((EditText)(mypres.ac.findViewById(R.id.HPI))).getText().toString());
            mypres.modelInterface.patient.hospitalCourse.setHospitalCourse(((EditText)(mypres.ac.findViewById(R.id.Hospital_Course))).getText().toString());
            mypres.modelInterface.patient.patientName.setName(((EditText)(mypres.ac.findViewById(R.id.Patient_Name))).getText().toString());
            mypres.modelInterface.patient.addConsultantList(((EditText)(mypres.ac.findViewById(R.id.Consultants))).getText().toString());
            mypres.modelInterface.patient.patientDiagnosis.setPrimaryDiagnosis(((EditText)(mypres.ac.findViewById(R.id.Primary))).getText().toString());
            mypres.modelInterface.patient.patientDiagnosis.setSecondaryDiagnosis(((EditText)(mypres.ac.findViewById(R.id.Secondary))).getText().toString());
            mypres.modelInterface.patient.patientDiagnosis.setComplications(((EditText)(mypres.ac.findViewById(R.id.Complications))).getText().toString());
            mypres.modelInterface.patient.patientName.setName(((EditText)(mypres.ac.findViewById(R.id.Patient_Name))).getText().toString());

            //for listOfTests
            Tests t = new Tests();
            if(((EditText)(mypres.ac.findViewById(R.id.Finalized))).getText().toString()!="") { t.setFinalized(); }
            else if(((EditText)(mypres.ac.findViewById(R.id.Pending))).getText().toString()!="") { t.setPending(); }
            mypres.modelInterface.patient.addTestList(t);

            //Not really sure what the first argument should be, as there is no field for "medicine" to pull data from
            mypres.modelInterface.patient.addPatientMedicationList(new Medicine(((EditText)(mypres.ac.findViewById(R.id.Home_Medications))).getText().toString(),
                    ((EditText)(mypres.ac.findViewById(R.id.Current_Course))).getText().toString(), ((EditText)(mypres.ac.findViewById(R.id.Completed_Course))).getText().toString()));

            mypres.modelInterface.patient.medHistory.setMedicalHistory(((EditText)(mypres.ac.findViewById(R.id.Past_Medical_History))).getText().toString());
            mypres.modelInterface.patient.addAllergiesList(new Allergy(((EditText)(mypres.ac.findViewById(R.id.Home_Medications))).getText().toString()));


        /*
        Setting records for all data pertaining to Physician class
         */

            mypres.modelInterface.physician.name.setName(((EditText)(mypres.ac.findViewById(R.id.Attending_Physician_Name))).getText().toString());
            mypres.modelInterface.physician.hospital.setHomeHospital(((EditText)(mypres.ac.findViewById(R.id.Home_Hospital))).getText().toString());
            mypres.modelInterface.physician.npi.setNPI(((EditText)(mypres.ac.findViewById(R.id.NPI_Number))).getText().toString());
            mypres.modelInterface.physician.contact.setEmail(((EditText)(mypres.ac.findViewById(R.id.Email_Address))).getText().toString());
            mypres.modelInterface.physician.contact.setPhone(((EditText)(mypres.ac.findViewById(R.id.Phone_Number))).getText().toString());

        }

        public void loadData() {

        }


    }
