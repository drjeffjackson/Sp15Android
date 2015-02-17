package medicalfaxnew.duqsp15.com.medicalfax.Model.Physician;

/**
 * Created by austinpilz on 2/16/15.
 */
public class Contact
{
    private String phoneNumber;
    private String emailAddress;

    public Contact()
    {
        //
    }


    //GETS//

    /*
    Returns the physicians phone number
    */
    public String getPhone()
    {
        return phoneNumber;
    }

    /*
    Returns the physicians email address
    */
    public String getEmail()
    {
        return emailAddress;
    }



    //SETS//

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




    //VERIFY//

    /*
    Verifies that the email is present
    @return Boolean
     */
    public Boolean verifyEmail()
    {
        if (emailAddress.isEmpty())
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    /*
    Verifies that the phone is present
    @return Boolean
     */
    public Boolean verifyPhone()
    {
        if (phoneNumber.isEmpty())
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}
