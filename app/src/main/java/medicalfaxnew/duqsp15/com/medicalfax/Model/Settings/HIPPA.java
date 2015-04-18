package medicalfaxnew.duqsp15.com.medicalfax.Model.Settings;

/**
 * Created by Coder Thanatos on 4/17/2015.
 */

/*This HIPPA class holds the status on whether or not the user signed the initial HIPPA Waiver*/
public class HIPPA {
    /*HIPPAWaiver, hold the current result of the HIPPAWaiver.
    * False = User declined the waiver.
    * True = User accepted the waiver.*/
    private boolean HIPPAWaiver = false;

    /*Setter for HIPPAWaiver
    *@param HIPPAWaiver - boolean value of the HIPPAWaiver result*/
    public void setHIPPAWaiver(boolean HIPPAWaiver){this.HIPPAWaiver = HIPPAWaiver;}

    /*Getter/Verify method
    * this method will get the value of the HIPPWaiver from the database
    * @return HIPPAWaiver - boolean value of the HIPPAWaiver*/
    public boolean getHIPPAWaiver(){return this.HIPPAWaiver;}
}
