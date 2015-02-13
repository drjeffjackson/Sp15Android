package medicalfaxnew.duqsp15.com.medicalfax.Model.Objects;

import java.util.ArrayList;

/**
 * Created by austinpilz on 2/11/15.
 */
public class Patient {
    private String firstName, middleName, lastName, physicianFirstName,
            physicianLastName, firstNamePCP, lastNamePCP;
    private ArrayList<String> diagnosisList = new ArrayList();
    // private ArrayList<Integer> antibioticsList = new ArrayList();

    public void setFirstName(String firstName){
        // This method will the set the name of the Patient in the database
        //when database is finally set up, a setter will place the values in it.
        //Justin Chilleo
        this.firstName = firstName;

    }
    public void setMiddleName(String middleName){
        // This method will the set the name of the Patient in the database
        //when database is finally set up, a setter will place the values in it.
        //Justin Chilleo
        this.middleName = middleName;

    }
    public void seLastName(String lastName){
        // This method will the set the name of the Patient in the database
        //when database is finally set up, a setter will place the values in it.
        //Justin Chilleo
        this.lastName = lastName;

    }

    public void setName(String firstName, String lastName){
        //This method will set the name of the Patient, less a middle name.
        //when the database is finally set up, a setter will place the values in it.
        //Justin Chilleo
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName(){
        //This method will use a getter and return the string with the patient's first name
        //Justin Chilleo
        return firstName;
            /* For now this code will reference the variable, it will act as a place marker till the
            * actual location is made*/
    }

    public String getMiddleName(){
        //This method will use a getter and return the string with the patients middle name
        //Justin Chilleo
        return middleName;
            /* For now this code will reference the variable, it will act as a place marker till the
            * actual location is made*/
    }

    public String getLastName(){
        //This method will use a getter and return the string with the patients last name
        //Justin Chilleo
        return lastName;
            /* For now this code will reference the variable, it will act as a place marker till the
            * actual location is made*/
    }
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

    public void setDiagnosis(String diagnosis){
            /*This method will create an array list of all diagnosis's the patient has
            * this method only takes 1 string at a time, but will increase the arraylist size
            * by 1 every time to ensure there is room
            * Justin Chilleo*/
        this.diagnosisList.ensureCapacity(this.diagnosisList.size()+1);
        this.diagnosisList.add(diagnosis);


    }

    public ArrayList<String> getDiagnosisList(){
            /*This method will return the diagnosis arraylist
            * Justin Chilleo*/
        return diagnosisList;
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
    public void setPhysicianFirstName(String physicianFirstName){
        // This method will the set the name of the Physician in the database
        //when database is finally set up, a setter will place the values in it.
        //Justin Chilleo
        this.physicianFirstName = physicianFirstName;

    }
    public void setPhysicianLastName(String physicianLastName){
        // This method will the set the name of the Physician in the database
        //when database is finally set up, a setter will place the values in it.
        //Justin Chilleo
        this.physicianLastName = physicianLastName;

    }

    public String getPhysicianFirstName(){
        //This method will use a getter and return the string with the Physician's first name
        //Justin Chilleo
        return physicianFirstName;
         /* For now this code will reference the variable, it will act as a place marker till the
            * actual location is made*/
    }

    public String getPhysicianLastName(){
        //This method will use a getter and return the string with the Physician's last name
        //Justin Chilleo
        return physicianLastName;
         /* For now this code will reference the variable, it will act as a place marker till the
            * actual location is made*/
    }

    public Boolean[] verifyPhysicianName(){
        /*this method will verify there is a physician name in the data base
        * it will check the database for a first and last name, returning a boolean
        * array with the first field belonging to the first name and the second to the
        * last name. true = name exists, false = no name in database
        * Justin Chilleo*/


        Boolean[] verify = new Boolean[2];
        if(physicianFirstName == null){
            verify[0] = false;
        }
        else{
            verify[0] = true;
        }
        if(physicianLastName == null){
            verify[1] = false;
        }
        else{
            verify[1] = true;
        }
        return verify;
    }

    public void setPCPName(String firstNamePCP, String lastNamePCP){
        /*This method will set the names of the PCP into the database
        * Justin Chilleo*/
        this.firstNamePCP = firstNamePCP;
        this.lastNamePCP = lastNamePCP;
    }
    public String getPCPFirstName(){
        /*This method will return a string containing the first name of the PCP
        * Justin Chilleo*/

        return firstNamePCP;

    }
    public String getPCPLastName(){
        /*This method will return a string containing the first name of the PCP
        * Justin Chilleo*/

        return lastNamePCP;
    }
    public Boolean[] verifyPCP(){
        /*This method will take check to see if there is a PCP name in the data base.
        * It will return a boolean array, containing two fields. The first represents the
        * first name , and the second represents the last name.
        * True = there is a name there, False = there is no name there*/
        Boolean[] verifyPCP = new Boolean[2];

        if(firstNamePCP == null){
            verifyPCP[0] = false;
        }
        else{
            verifyPCP[0] = true;
        }
        if(lastNamePCP == null){
            verifyPCP[1] = false;
        }
        else{
            verifyPCP[1] = true;
        }
        return verifyPCP;
    }

}
