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
    @author Brady Sheehan
     */
    public ArrayList<String> verify()
    {
        ArrayList<String> missingFields = new ArrayList<String>();
        if(name.verifyNameF()){
            missingFields.add("setFirstName");
        }
        if(name.verifyNameL()){
            missingFields.add("setLastName");
        }
        if(!hospital.verifyDepartment()){
            missingFields.add("setDepartment");
        }
        if(!hospital.verifyHomeHospital()){
            missingFields.add("setHomeHospital");
        }
//        if(!hospital.verifyTitle()){ //probably not required
//            missingFields.add("setTitle");
//        }
        if(!npi.verifyNPI()){
            missingFields.add("setNPI");
        }
        if(contact.verifyEmail()){
            missingFields.add("setEmail");
        }
//        if(contact.verifyPhone()){ //probably not required
//            missingFields.add("setPhone");
//        }
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
