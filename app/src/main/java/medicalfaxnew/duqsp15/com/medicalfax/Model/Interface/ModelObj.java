package medicalfaxnew.duqsp15.com.medicalfax.Model.Interface;


import java.util.ArrayList;

/**
 * Created by austinpilz on 2/16/15.
 */
public interface ModelObj
{
    //For patient and physician objects

    public ArrayList<String> verify(); //Verify method that returns status if required fields are present
    public void update(); //commits object data into database

}
