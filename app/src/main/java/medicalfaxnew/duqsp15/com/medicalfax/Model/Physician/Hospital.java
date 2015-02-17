package medicalfaxnew.duqsp15.com.medicalfax.Model.Physician;

/**
 * Created by austinpilz on 2/16/15.
 */
public class Hospital
{
    private String homeHospital;
    private String title;
    private String department;

    public Hospital()
    {
        //
    }

    /////GET/////


    /*
    Returns the physician's home hospital name
    @return String hospital
     */
    public String getHomeHospital()
    {
        return homeHospital;
    }

    /*
    Returns the physician's title at the hospital
    @return String title
     */
    public String getTitle()
    {
        return title;
    }

    /*
    Returns the physician's department at this hospital
    @return String dept.
     */
    public String getDepartment()
    {
        return department;
    }



    ///SETS///

    /*
    Sets the physician's home hospital name
    @param String hospital name
     */
    public void setHomeHospital(String h)
    {
        homeHospital = h;
    }

    /*
    Sets the physician's title
    @param String title
     */
    public void setTitle(String t)
    {
        title = t;
    }

    /*
    Sets the physician's department
    @param String department name
     */
    public void setDepartment(String d)
    {
        department = d;
    }

    //VERIFY//

    /*
    Returns true if HomeHospital is present
    @return Boolean
     */
    public boolean verifyHomeHospital()
    {
        if (homeHospital.isEmpty())
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    /*
    Returns true if title is present
    @return Boolean
     */
    public boolean verifyTitle()
    {
        if (title.isEmpty())
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    /*
    Returns true is HomeHospital is present
    @return Boolean
     */
    public boolean verifyDepartment()
    {
        if (department.isEmpty())
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}
