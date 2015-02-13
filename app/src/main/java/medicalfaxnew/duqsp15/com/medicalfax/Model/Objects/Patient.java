package medicalfaxnew.duqsp15.com.medicalfax.Model.Objects;

import java.util.ArrayList;

import medicalfaxnew.duqsp15.com.medicalfax.Model.Controller.ModelController;

/**
 * Created by austinpilz on 2/11/15.
 */
public class Patient {

    private String firstName;
    private String middleName;
    private String lastName;
    private String PCPFirst;
    private String PCPLast;
    private ArrayList<String> diagnosisList;
    private ArrayList<Integer> antibioticsList;

    public Patient()
    {
        diagnosisList = new ArrayList();
        antibioticsList = new ArrayList();
    }

    /////////////////////////////////////////GET Methods////////////////////////////////////////


    /*
    Returns the patient's first name
    @return String first name
     */
    public String getFirstName()
    {
        return firstName;
    }

    /*
    Returns the patient's middle name
    @return String middle name
     */
    public String getMiddleName()
    {
        return middleName;
    }

    /*
    Returns the patient's last name
    @return String last name
     */
    public String getLastName()
    {
        return lastName;
    }

    /*
    Returns the patient PCP's first name
    @return String PCP first name
     */
    public String getPCPFirstName()
    {
        return PCPFirst;
    }

    /*
    Returns the patient PCP's last name
    @return String PCP last name
     */
    public String getPCPLastName()
    {
        return PCPLast;
    }

    /*
    Returns the patient diagnosis list
    @return ArrayList<String> diagnosis
     */
    public ArrayList<String> getDiagnosisList(){
            /*This method will return the diagnosis arraylist
            * Justin Chilleo*/
        return diagnosisList;
    }




    /////////////////////////////////////SET Methods///////////////////////////////////////////////
    /*
    Sets the patient first name
    @param String first
     */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    /*
    Sets the patient middle name
    @param String middle
     */
    public void setMiddleName(String middleName)
    {
        this.middleName = middleName;
    }

    /*
    Sets the patient last name
    @param String last
     */
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    /*
    Sets the patient first and last name
    @param String first
    @param String last
     */
    public void setName(String firstName, String lastName)
    {
        setFirstName(firstName);
        setLastName(lastName);
    }

    /*
    Sets the patient PCP's first name
    @param String first
     */
    public void setPCPFirst(String first)
    {
        this.PCPFirst = first;
    }

    /*
    Sets the patient PCP's last name
    @param String last
     */
    public void setPCPLast(String last)
    {
        this.PCPLast = last;
    }

    /*
    Sets the pateitn PCP's full name
    @param String first
    @param String last
     */
    public void setPCPName(String first, String last)
    {
        setPCPFirst(first);
        setPCPLast(last);
    }

    /*
    Adds antibiotic to antibiotics list
    @param Integer antibiotic number
     */
    public void addAntibiotic(Integer anti)
    {
        antibioticsList.add(anti);
    }

    /*
    Removes antibiotic from antibiotics list
    @param Integer antibiotic number
     */
    public void removeAntibiotic(Integer anti)
    {
        antibioticsList.remove(anti);
    }

    /*
    Clears the list of antibiotics
     */
    public void clearAntibiotics()
    {
        antibioticsList.clear();
    }

    /*
    Adds diagnosis to diagnosis array
    @param String diagnosis
     */
    public void addDiagnosis(String diagnosis)
    {
        //JC - Increases size before adding to list to ensure capacity
        this.diagnosisList.ensureCapacity(this.diagnosisList.size()+1);
        this.diagnosisList.add(diagnosis);
    }


    ////////////////////////////////////VERIFY Methods/////////////////////////////////////////////
    public Boolean[] verifyName(){
        //This will check to see if there is a patient name in the database.
        //After checking for a name it will return a boolean array.
        //True = name is there
        //False = no name exists
        Boolean[] verify = new Boolean[3];
        if(firstName == null) {
            verify[0] = false;
        }
        else{
            verify[0] = true;
        }
        if(middleName == null){
            verify[1] = false;
        }
        else{
            verify[1] = true;
        }
        if(lastName == null){
            verify[2] = false;
        }
        else{
            verify[2] = true;
        }

        return verify;
    }





    public Boolean verifyDiagnosisList(){
            /*This method will allow the for checking if there are any diagnosis present in the
            * database. True = there are, False = no diagnosis loaded.
            * Justin Chilleo*/

        if(diagnosisList.isEmpty()) {
            return false;
        }
        else{
            return true;
        }
    }

    /*
    Verifies that there is a name in each of the patient PCP fields (first & Last)
    Returns an array of booleans. Cell 0 is first name, Cell 1 is last name
    false = no name, true = name present
    @return Boolean[]
     */
    public Boolean[] verifyPCP()
    {
        Boolean[] verifyPCP = new Boolean[2];

        if (getPCPFirstName().isEmpty())
        {
            verifyPCP[0] = false;
        }
        else
        {
            verifyPCP[0] = true;
        }


        if (getPCPLastName().isEmpty())
        {
            verifyPCP[1] = false;
        }
        else
        {
            verifyPCP[1] = true;
        }

        return verifyPCP;
    }

    /*
   Commits all changes to physician into the database. Takes data from Physician object fields and stores them in the database
    */
    public void commit()
    {
        ModelController.IO.updatePatient();
    }

}
