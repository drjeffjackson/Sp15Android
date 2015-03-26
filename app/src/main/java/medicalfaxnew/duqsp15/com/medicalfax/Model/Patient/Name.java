package medicalfaxnew.duqsp15.com.medicalfax.Model.Patient;

/**
 * Created by Coder Barbie
 */

/**
 * The Name class contains the fields firstName, middleName, and lastName and
 * the corresponding methods to modify them
 */
public class Name {
    /**
     * Class Fields : fullName
     */
    private String fullName;

    /**
     * @param fullName
     */
    public Name(String fullName) {
        this.fullName = fullName;
    }

    public Name() {
        //
    }

    /**
     * Setter for firstName
     *
     * @param newName
     */
    public void setName(String newName) {

        fullName = newName;
    }

    /**
     * Getter for fullName
     *
     * @return full name of doctor or patient
     */
    public String getName() {

        return fullName;
    }

    /**
     * Verify the full name is included
     *
     * @return boolean indicating inclusion of required field
     */
    public boolean verifyName() {
        if (fullName.isEmpty()) {
            return false;
        }
        return true;
    }

}
