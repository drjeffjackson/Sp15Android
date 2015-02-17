package medicalfaxnew.duqsp15.com.medicalfax.Model.Physician;

import medicalfaxnew.duqsp15.com.medicalfax.Model.Interface.ModelObj;
import medicalfaxnew.duqsp15.com.medicalfax.Model.Patient.*;
import java.util.ArrayList;

/**
 * Created by austinpilz on 2/16/15.
 */
public class Physician implements ModelObj
{
    public static final Name name = new Name();
    public static final Hospital hospital = new Hospital();
    public static final NPI npi = new NPI();
    public static final Contact contact = new Contact();

    /*
    Physician constructor
     */
    public Physician()
    {
      //
    }


    /*
    Verifies that all required fields are present in the physician object. Returns an array list of all fields missing
    @return ArrayList<String>
     */
    public ArrayList<String> verify()
    {
        //FOR DEMONSTRATION PURPOSES - CODE BELOW
        ArrayList<String> missingFields = new ArrayList<String>();
        missingFields.add("PhysicianNPI");

        return missingFields;
    }

    /*
   Commits object fields to database
    */
    public void update()
    {
        //COMING SOON!
    }
}
