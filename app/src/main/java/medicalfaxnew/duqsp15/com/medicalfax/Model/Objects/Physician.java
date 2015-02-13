package medicalfaxnew.duqsp15.com.medicalfax.Model.Objects;

import medicalfaxnew.duqsp15.com.medicalfax.Model.Controller.ModelController;

/**
 * Created by austinpilz on 2/11/15.
 */
public class Physician
{
    private String firstName;
    private String lastName;
    private String NPI;
    private String homeHospital;
    private String Department;
    private String Title;
    private String phoneNumber;
    private String emailAddress;

    /*
    Constructor for Physician class
     */
    public Physician()
    {
        //Data for physician is automatically loaded by IO on app startup
    }

    /*
    Returns the physicians first name
     */
    public String getFirstName()
    {
        return firstName;
    }

    /*
    Returns the physicians last name
     */
    public String getLastName()
    {
        return lastName;
    }

    /*
    Returns the physicians NPI number
     */
    public String getNPI()
    {
        return NPI;
    }

    /*
    Returns the physicians home hospital name
     */
    public String getHomeHospital()
    {
        return homeHospital;
    }

    /*
    Returns the physicians department within home hospital
     */
    public String getDepartment()
    {
        return Department;
    }

    /*
    Returns the physicians home hospital name
    */
    public String getTitle()
    {
        return Title;
    }

    /*
    Returns the physicians phone number
    */
    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    /*
    Returns the physicians email address
    */
    public String getEmailAddress()
    {
        return emailAddress;
    }



    ////////////////////////////////////Set Methods///////////////////////////
    /*
    Sets the physicians first name
    @param String first
     */
    public void setFirstName(String f)
    {
        this.firstName = f;
        

    }

    /*
    Sets the physicians last name
    @param String last
     */
    public void setLastName(String l)
    {
        this.lastName = l;
        

    }

    /*
    Sets the physician NPI
    @String NPI#
     */
    public void setNPI(String n)
    {
        this.NPI = n;
        

    }

    /*
    Sets the physicians home hospital
    @String hospital
     */
    public void setHomeHospital(String h)
    {
        this.homeHospital = h;
        

    }

    /*
    Sets the physicians department
    @param String department
     */
    public void setDepartment(String d)
    {
        this.Department = d;
        

    }

    /*
    Sets the physicians title
    @param String title
     */
    public void setTitle(String t)
    {
        this.Title = t;
        

    }

    /*
    Sets the physicians email
    @param String email
     */
    public void setEmail(String e)
    {
        this.emailAddress = e;
        

    }

    /*
    Sets the physicians phone
    @param String phone
     */
    public void setPhone(String p)
    {
        this.phoneNumber = p;
        

    }

    /*
    Commits all changes to physician into the database. Takes data from Physician object fields and stores them in the database
     */
    public void commit()
    {
        ModelController.IO.updatePhysician(); //Updates all database row info with data in object fields
    }
}
