package medicalfaxnew.duqsp15.com.medicalfax.Model.Patient;
/**
 * The Name class contains the fields firstName, middleName, and lastName and
 * the corresponding methods to modify them
 * 
 * @author claire
 *
 */
public class Name {
	/**
	 * Class Fields : firstName, middleName, lastName
	 */
	private String firstName; // first name of doctor or patient

	private String middleName; // middle name of doctor or patient

	private String lastName;	//last name of the doctor or patient
	
	private String namePrefix; //prefix like Dr.
	
	/**
	 * This constructor handles the case of existing first and last name
	 * @param firstName
	 * @param lastName
	 */
	public Name(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

    public Name()
    {
        //
    }

	/**
	 * This constructor handles the case of existing first, middle, and last name
	 * @param firstName - first name 
	 * @param middleName - middle name
	 * @param lastName - last name
	 */
	public Name(String firstName, String middleName, String lastName) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
	}

	/**
	 * Setter for firstName
	 * @param newName
	 */
	public void setFirstName(String newName) {
		firstName = newName;
	}

	/**
	 * Setter for middleName
	 * @param newName
	 */
	public void setMiddleName(String newName) {
		middleName = newName;
	}

	/**
	 * Setter for lastName
	 * @param newName
	 */
	public void setLastName(String newName) {
		lastName = newName;
	}
	
	/**
	 * Setter for namePrefix
	 * @param newNamePrefix
	 */
	public void setNamePrefix(String newNamePrefix) {
		namePrefix = newNamePrefix;
	}
	
	public void setFullNameFML(String first, String middle, String last) {
		this.setFirstName(first);
		this.setMiddleName(middle);
		this.setLastName(last);
	}
	
	public void setFullNameFL(String first, String last) {
		this.setFirstName(first);
		this.setLastName(last);
	}

    /**
     * Verify the first name is included
     * @return boolean indicating inclusion of required field
     */
    public boolean verifyNameF(){
        if(firstName.isEmpty()){
            return false;
        }
        return true;
    }
    /**
     * Verify the last name is included
     * @return boolean indicating inclusion of required field
     */
    public boolean verifyNameL(){
        if(lastName.isEmpty()){
            return false;
        }
        return true;
    }


	/**
	 * Getter for firstName
	 * @return first name of doctor or patient
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Getter for middleName
	 * @return middle name of doctor or patient
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * Getter for lastName
	 * @return last name of doctor or patient
	 */
	public String getLastName() {
		return lastName;
	}
	
	public String getNamePrefix() {
		return namePrefix;
	}
	
	public String getFullNameFML() {
		return firstName + " " + middleName + " " + lastName;
	}
	
	public String getFullNameFL() {
		return firstName + " " + lastName;
	}
}
