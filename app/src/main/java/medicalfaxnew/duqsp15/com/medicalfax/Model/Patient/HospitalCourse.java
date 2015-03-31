package medicalfaxnew.duqsp15.com.medicalfax.Model.Patient;

/**
 * Created by Coder Barbie on 3/26/15.
 */
public class HospitalCourse {

    private String hospitalCourse;

    public HospitalCourse() {
        //
    }

    public HospitalCourse(String hospitalCourse) {
        this.hospitalCourse = hospitalCourse;
    }

    public void setHospitalCourse(String newCourse) {

        this.hospitalCourse = newCourse;
    }

    public String getHospitalCourse() {

        return hospitalCourse;
    }
}
