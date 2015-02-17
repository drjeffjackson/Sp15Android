package medicalfaxnew.duqsp15.com.medicalfax.Model.Patient;

/**
 * Created by claire on 2/17/15.
 */
public class Allergy {

    private String allergy;

    /**
     * nullary constructor
     */
    public Allergy() {

    }

    /**
     * Setter for Allergy
     *
     * @param newAllergy - sets the String field for allergy
     */
    public void setAllergy(String newAllergy) {
        allergy = newAllergy;
    }


    /**
     * Getter for Allergy
     *
     * @return - allergy
     */
    public String getAllergy() {
        return allergy;
    }


}