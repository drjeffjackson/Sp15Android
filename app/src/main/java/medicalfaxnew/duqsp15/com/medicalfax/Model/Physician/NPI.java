package medicalfaxnew.duqsp15.com.medicalfax.Model.Physician;

/**
 * Created by austinpilz on 2/16/15.
 */
public class NPI
{
    private String NPI;

    public NPI()
    {
        //
    }

    /*
    Gets the physician's NPI #
    @return String NPI
     */
    public String getNPI()
    {
        return NPI;
    }

    /*
    Sets the physician's NPI #
    @param String NPI
     */
    public void setNPI(String n)
    {
        NPI = n;
    }


    /*
    Verifies the NPI is present
    @return Boolean
     */
    public Boolean verifyNPI()
    {
        if (NPI.isEmpty())
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}
