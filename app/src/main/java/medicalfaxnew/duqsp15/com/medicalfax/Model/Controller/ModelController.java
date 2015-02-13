package medicalfaxnew.duqsp15.com.medicalfax.Model.Controller;


        import medicalfaxnew.duqsp15.com.medicalfax.Model.Objects.*;
        import medicalfaxnew.duqsp15.com.medicalfax.Model.IO.*;
        import android.content.Context;

/**
 * Created by austinpilz on 2/11/15.
 */
public class ModelController
{
    public static Patient patient;
    public static Physician physician;
    public static InputOutput IO;
    public static ModelController MController;

    public ModelController(Context context)
    {
        this.patient = new Patient(); //Creates the default patient object
        this.physician = new Physician(); //Creates the default physician object
        this.IO = new InputOutput(context); //Creates IO object
            IO.loadPhysician(); //Loads database physician data
            IO.loadPatient(); //Loads database patient data
        this.MController = this; //Creates class instance pointer
    }
}
