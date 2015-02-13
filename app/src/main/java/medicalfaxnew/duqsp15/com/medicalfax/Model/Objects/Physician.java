package medicalfaxnew.duqsp15.com.medicalfax.Model.Objects;

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
        //Load data from Controller database function
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



    //Set Methods
    /*
    Sets the physicians first name and commits change to database
     */
    public void setFirstName(String f)
    {
        this.firstName = f;
        //Controller.IO.updatePatient();

    }

    /*
    Sets the physicians last name and commits change to database
     */
    public void setLastName(String l)
    {
        this.lastName = l;
        //Controller.IO.updatePatient();

    }

    /*
    Sets the physician NPI and commits change to database
     */
    public void setNPI(String n)
    {
        this.NPI = n;
        //Controller.IO.updatePatient();

    }

    /*
    Sets the physicians home hospital and commits change to database
     */
    public void setHomeHospital(String h)
    {
        this.homeHospital = h;
        //Controller.IO.updatePatient();

    }

    /*
    Sets the physicians department and commits change to database
     */
    public void setDepartment(String d)
    {
        this.Department = d;
        //Controller.IO.updatePatient();

    }

    /*
    Sets the physicians title and commits change to database
     */
    public void setTitle(String t)
    {
        this.Title = t;
        //Controller.IO.updatePatient();

    }

    /*
    Sets the physicians email and commits change to database
     */
    public void setEmail(String e)
    {
        this.emailAddress = e;
        //Controller.IO.updatePatient();

    }

    /*
    Sets the physicians phone and commits change to database
     */
    public void setPhone(String p)
    {
        this.phoneNumber = p;
        //Controller.IO.updatePatient();

    }
}
