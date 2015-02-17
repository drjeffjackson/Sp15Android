package medicalfaxnew.duqsp15.com.medicalfax.Model.Patient;

import java.util.ArrayList;

import medicalfaxnew.duqsp15.com.medicalfax.Model.Interface.ModelObj;

/**
 * Created by austinpilz on 2/16/15.
 * clairesaunders
 */

/**
 *
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
    private String chiefComplaint;
    /**
     * End Chief Complaint
     */

    /**
     * Begin History of present illness
     */
    private String hpi;
    /**
     * End History of present illness
     */


    /**
     * Begin Hospital Course
     */

    /**
     * End Hospital Course
     */


    /**
     *  Begin Consultants
     */
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
    public static final Tests patientTests = new Tests();

    // I'm not sure if there will be multiple tests, if there are

    public static final ArrayList<Tests> listOfTests = new ArrayList<>();
    /**
     * End Test/Procedure Results
     */


    /**
     * Begin Antibiotics
     */

    public static final Medicine meds = new Medicine();
    /**
     * List of medications the patient is on
     */
    private ArrayList<Medicine> patientMedicationsList;

    /**
     * End Antibiotics
     */


    /**
     * Begin Past Medical History
     */
    private static final MedicalHistory medHistory = new MedicalHistory();
    /**
     * End Past Medical History
     */


    /**
     * Begin Home Medications/Allergies
     */
    public static final Medicine homeMeds = new Medicine();

    /**
     * List of patient home medications
     */
    private ArrayList<Medicine> patientMedicationsListHome;

    /**
     * Allergy object
     */
    public static final Allergy allergy = new Allergy();

    /**
     * List of allergies
     */
    private ArrayList<Allergy> allergies;

    /**
     * End Home Medications/Allergies
     */


    /**
     * Nullary patient constructor
     */
    public Patient() {

    }

    /*
    Verifies required fields and returns if compliant
     */
    public ArrayList<String> verify()
    {
        //FOR DEMONSTRATION PURPOSES - CODE BELOW
        ArrayList<String> missingFields = new ArrayList<String>();
        missingFields.add("PhysicianNPI");

        return missingFields;
    }

    /*
    Commits all object fields to database
     */
    public void update() {
        //
    }
}
