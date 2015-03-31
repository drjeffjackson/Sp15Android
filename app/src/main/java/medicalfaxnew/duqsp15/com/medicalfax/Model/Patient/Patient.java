package medicalfaxnew.duqsp15.com.medicalfax.Model.Patient;

import java.util.ArrayList;

import medicalfaxnew.duqsp15.com.medicalfax.Model.Interface.ModelObj;
import medicalfaxnew.duqsp15.com.medicalfax.Model.ModelInterface;

/**
 * Created by Coder Barbie
 */
public class Patient implements ModelObj {

    /**
     * Begin Patient ID
     */

    /**
     * The patient name
     */
    public static final Name patientName = new Name();

    /**
     * Patient date of birth (Month, day, year)
     */
    public static final Date dateOfBirth = new Date();

    /**
     * Patient medical record number
     */
    public static final MRN medRecNum = new MRN();

    /**
     * The date the patient was admitted to the hospital (Month, day, year)
     */
    public static final Date admDate = new Date();

    /**
     * The primary care physician's name/ physician assistant
     */
    public static final Name pcpName = new Name();

    /**
     * The name of the attending physician
     */
    public static final Name attendingName = new Name();

    /**
     * The code status of the patient: Full, Limited, or DNR/DNI
     */
    public static final CodeStatus codeStatus = new CodeStatus();

    /**
     * End Patient ID
     */


    /**
     * Begin Chief Complaint
     */
    public static final ChiefComplaint chiefComplaint = new ChiefComplaint();
    /**
     * End Chief Complaint
     */

    /**
     * Begin History of present illness
     */
    public static final HPI hpi = new HPI();
    /**
     * End History of present illness
     */


    /**
     * Begin Hospital Course
     */
    public static final HospitalCourse hospitalCourse = new HospitalCourse();
    /**
     * End Hospital Course
     */


    /**
     *  Begin Consultants
     */
    private ArrayList<String> consultantList = new ArrayList<>();
    /**
     *  End Consultants
     */


    /**
     * Begin Diagnosis
     */

    /**
     * Diagnosis Object
     */
    public static final Diagnosis patientDiagnosis = new Diagnosis();

    /**
     * End Diagnosis
     */


    /**
     * Begin Test/Procedure Results
     */
    private static final ArrayList<Tests> listOfTests = new ArrayList<>();
    /**
     * End Test/Procedure Results
     */


    /**
     * Begin Antibiotics
     */

    /**
     * List of medications the patient is on
     */
    private ArrayList<Medicine> patientMedicationsList = new ArrayList<>();

    /**
     * End Antibiotics
     */


    /**
     * Begin Past Medical History
     */
    public static final MedicalHistory medHistory = new MedicalHistory();
    /**
     * End Past Medical History
     */


    /**
     * Begin Home Medications/Allergies
     */

    /**
     * List of patient home medications
     */
    private ArrayList<Medicine> patientMedicationsListHome = new ArrayList<Medicine>();

    /**
     * List of allergies
     */
    private ArrayList<Allergy> allergies = new ArrayList<>();

    /**
     * End Home Medications/Allergies
     */


    /**
     * Nullary patient constructor
     */
    public Patient() {

    }

    /**
     * Method for adding to the list of consultants
     * @param entry - the string entry you want to add
     */
    public void addConsultantList(String entry) {
        consultantList.add(entry);
    }

    /**
     * Method for adding to the list of tests
     * @param test - the test object to add
     */
    public void addTestList(Tests test) {
        listOfTests.add(test);
    }

    /**
     * Method for adding to the list of Medicines
     * @param meds- the medication you want to add
     */
    public void addPatientMedicationList(Medicine meds) {
        patientMedicationsList.add(meds);
    }

    /**
     * Method for adding to the list of Medicines at home
     * @param meds - the medication you want to add
     */
    public void addPatientMedicationListsHome(Medicine meds) {
        patientMedicationsListHome.add(meds);
    }


    /**
     * Method for adding to the list of Allergies
     * @param allergy - the allergy to add to the list
     */
    public void addAllergiesList(Allergy allergy) {
        allergies.add(allergy);
    }


    /**
     * The following methods are there to remove elements from the private arraylists
     */

    public void removeConsultantList(int position) {
        consultantList.remove(position);
    }

    public void removeTestList(int position) {
        listOfTests.remove(position);
    }

    public void removePatientMedicationList( int position) {
        patientMedicationsList.remove(position);
    }

    public void removePatientMedicationListHome( int position) {
        patientMedicationsListHome.remove(position);
    }

    public void removeAllergiesList(int position) {
        allergies.remove(position);
    }

    /*
    Verifies required fields and returns if compliant
     */
    public ArrayList<String> verify() {
        //FOR DEMONSTRATION PURPOSES - CODE BELOW
        ArrayList<String> missingFields = new ArrayList<String>();
        missingFields.add("PatientNPI");

        for (int i = 0; i < allergies.size(); i++) {
            if (!allergies.get(i).verifyAllergy()) {
                missingFields.add("set allergy in list");
            }
        }
        if (!chiefComplaint.verifyComplaint()) {
            missingFields.add("set chief complaint");
        }
        if (!codeStatus.verifyCodeStatus()) {
            missingFields.add("set code status");
        }
        if (!chiefComplaint.verifyComplaint()) {
            missingFields.add("set chief complaint");
        }
        if (!admDate.verifyDay()) {
            missingFields.add("set day");
        }
        if (!admDate.verifyMonth()) {
            missingFields.add("set month");
        }
        if (!admDate.verifyYear()) {
            missingFields.add("set year");
        }
        if (!patientDiagnosis.verifyPrimaryDiagnosis()) {
            missingFields.add("set patient primary diagnosis");
        }
        if (!hpi.verifyHistoryOfPresentIllness()) {
            missingFields.add("set history of present illness");
        }
        if (!medHistory.verifyMedicalHistory()) {
            missingFields.add("set patient medical history");
        }
        for (int i = 0; i < patientMedicationsList.size(); i++) {
            if (!patientMedicationsList.get(i).verifyMedicine()) {
                missingFields.add("set medicine item in list");
            }
            if (!patientMedicationsList.get(i).verifyMedicineCourse()) {
                missingFields.add("set medicine course in list");
            }
            if (!patientMedicationsList.get(i).verifyMedicineCompletedCourse()) {
                missingFields.add("set medicine completed course in list");
            }
        }
        if (!medRecNum.verifyMRN()) {
            missingFields.add("set medical record num");
        }
        if (!attendingName.verifyName()) {
            missingFields.add("set name of attending");
        }
        if (!pcpName.verifyName()) {
            missingFields.add("set name of pcp");
        }
        if (!patientName.verifyName()) {
            missingFields.add("set name of patient");
        }
        for (int i = 0; i < listOfTests.size(); i++) {
            if (!listOfTests.get(i).verifyTestName()) {
                missingFields.add("set test name");
            }
            if (!listOfTests.get(i).verifyTestStatus()) {
                missingFields.add("set test status");
            }
        }
        return missingFields;
    }

    /*
    Commits all object fields to database
     */
    public void update()
    {
        //
        ModelInterface.IO.updatePatient();
    }
}
