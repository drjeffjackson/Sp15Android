package medicalfaxnew.duqsp15.com.medicalfax.Model.Patient;

/**
 * Created by Coder Barbie
 */
public class Medicine {

    private String medicine; // this is the medicine the patient is taking
    private String medicineCourse; // this is the period of time the medication
    // is prescribed
    private String medicineCompletedCourse; // this is how much medicine the
    // patient has actually taken

    /**
     * Constructor for class. We are requiring that all fields for the medicine
     * are met
     *
     * @param medicine                - name of the prescribed medicine (String)
     * @param medicineCourse          - how the medicine is to be taken over time (String)
     * @param medicineCompletedCourse - how much the patient has taken (String)
     */
    public Medicine(String medicine, String medicineCourse,
                    String medicineCompletedCourse) {
        this.medicine = medicine ;
        this.medicineCourse = medicineCourse ;
        // this might be easier to implement by using the dates...
        this.medicineCompletedCourse = medicineCompletedCourse;
    }


    public Medicine() {
        //Empty Constructor
    }

    /**
     * Setters
     */

    /**
     * @param newMedicine
     */
    public void setMedicine(String newMedicine) {
        medicine = newMedicine;
    }


    /**
     * @param newMedicineCourse
     */
    public void setMedicineCourse(String newMedicineCourse) {
        medicineCourse = newMedicineCourse;
    }

    /**
     * @param newMedicineCompletedCourse
     */
    public void setMedicineCompletedCourse(String newMedicineCompletedCourse) {
        medicineCompletedCourse = newMedicineCompletedCourse;
    }

    /**
     * Getters
     */


    /**
     * @return
     */
    public String getMedicine() {

        return medicine;
    }

    /**
     * @return
     */
    public String getMedicineCourse() {

        return medicineCourse;
    }

    /**
     * @return
     */
    public String getMedicineCompletedCourse() {

        return medicineCompletedCourse;
    }


    /*
   Verifies that the medicine field is present
   @return Boolean
    */
    public Boolean verifyMedicine() {
        if (medicine.isEmpty()) {
            return false;
        }
        return true;
    }

    /*
  Verifies that the medicine course field is present
  @return Boolean
   */
    public Boolean verifyMedicineCourse() {
        if (medicineCourse.isEmpty()) {
            return false;
        }
        return true;
    }

    /*
  Verifies that the medicine field is present
  @return Boolean
   */
    public Boolean verifyMedicineCompletedCourse() {
        if (medicineCompletedCourse.isEmpty()) {
            return false;
        }
        return true;
    }

}
