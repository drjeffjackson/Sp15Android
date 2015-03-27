package medicalfaxnew.duqsp15.com.medicalfax.Model.Patient;

/**
 * Created by Coder Barbie
 */


/**
 * The class allergy provides the setters and getters for the allergy field.
 * In the future, one can add a variable for notes or severity of allergy.
 */
public class Allergy {

    private String allergy;

    /**
     * nullary constructor
     */
    public Allergy()
    {

    }

    /*
    String constructor
     */
    public Allergy(String newAllergy)
    {
        setAllergy(newAllergy);
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

    /*
        Verifies that the allergy
        @return Boolean
         */
    public Boolean verifyAllergy() {
        if (allergy.isEmpty()) {
            return false;
        }
        return true;
    }

}