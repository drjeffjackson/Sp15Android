package medicalfaxnew.duqsp15.com.medicalfax.Model.IO;

        import android.content.Context;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import java.util.List;
        import java.util.Arrays;

        import medicalfaxnew.duqsp15.com.medicalfax.Model.ModelInterface;

/**
 * Created by austinpilz on 2/11/15.
 */
public class InputOutput
{
    private MySQLiteHelper mysqlHelper; //SQL Helper
    private SQLiteDatabase database;

    public InputOutput(Context context)
    {
        mysqlHelper = new MySQLiteHelper(context);
        database = mysqlHelper.getWritableDatabase();
    }

    /*
    Loads database physician data into patient object
     */
    public void loadPatient()
    {   /*


        //Selects the row with the patient ID of 1, since that's the row where we store all the data
        Cursor c= database.rawQuery("SELECT * FROM " + mysqlHelper.TABLE_PATIENT + " WHERE ID =?", new String []{"1"});
        c.moveToFirst();

        //Sets the patient object fields with database values
        ModelInterface.patient.setFirstName(c.getString(c.getColumnIndex(mysqlHelper.PATIENT_COLUMN_FIRST)));
        ModelInterface.patient.setMiddleName(c.getString(c.getColumnIndex(mysqlHelper.PATIENT_COLUMN_MIDDLE)));
        ModelInterface.patient.setLastName(c.getString(c.getColumnIndex(mysqlHelper.PATIENT_COLUMN_LAST)));
        ModelInterface.patient.setPCPFirst(c.getString(c.getColumnIndex(mysqlHelper.PATIENT_COLUMN_PCPFirst)));
        ModelInterface.patient.setPCPLast(c.getString(c.getColumnIndex(mysqlHelper.PATIENT_COLUMN_PCPLast)));

        //Now when we load the array lists, they're stored separated by commas, so we have to explode them
        String tmpDiagnosis = c.getString(c.getColumnIndex(mysqlHelper.PATIENT_COLUMN_DIAGNOSIS));
        String tmpAntibiotics = c.getString(c.getColumnIndex(mysqlHelper.PATIENT_COLUMN_ANTIBIOTIC));

        List<String> diagnosisList = Arrays.asList(tmpDiagnosis.split(","));
        List<String> antibioticsList = Arrays.asList(tmpAntibiotics.split(","));

        //For loops to add them via methods
        for (String diagnosis : diagnosisList)
        {
            ModelInterface.patient.addDiagnosis(diagnosis);
        }

        for (String antibiotic : antibioticsList)
        {
            ModelInterface.patient.addAntibiotic(Integer.parseInt(antibiotic)); //Parses into integer since stored via string in db
        }
        */


    }

    /*
    Loads database physician data into physician object
     */
    public void loadPhysician()
    {
        /*


        //Selects the row with the physician ID of 1, since that's the row where we store all the data
        Cursor c= database.rawQuery("SELECT * FROM " + mysqlHelper.TABLE_PHYSICIAN + " WHERE ID =?", new String []{"1"});
        c.moveToFirst();

        //Sets the physician object fields with database values
        ModelInterface.physician.setFirstName(c.getString(c.getColumnIndex(mysqlHelper.PHYSICIAN_COLUMN_FIRST)));
        ModelInterface.physician.setLastName(c.getString(c.getColumnIndex(mysqlHelper.PHYSICIAN_COLUMN_LAST)));
        ModelInterface.physician.setNPI(c.getString(c.getColumnIndex(mysqlHelper.PHYSICIAN_COLUMN_NPI)));
        ModelInterface.physician.setHomeHospital(c.getString(c.getColumnIndex(mysqlHelper.PHYSICIAN_COLUMN_HOSPITAL)));
        ModelInterface.physician.setDepartment(c.getString(c.getColumnIndex(mysqlHelper.PHYSICIAN_COLUMN_DEPARTMENT)));
        ModelInterface.physician.setTitle(c.getString(c.getColumnIndex(mysqlHelper.PHYSICIAN_COLUMN_TITLE)));
        ModelInterface.physician.setPhone(c.getString(c.getColumnIndex(mysqlHelper.PHYSICIAN_COLUMN_PHONE)));
        ModelInterface.physician.setEmail(c.getString(c.getColumnIndex(mysqlHelper.PHYSICIAN_COLUMN_EMAIL)));

        */

    }

    /*
    Updates all patient information in database by using patient object fields as data source
     */
    public void updatePatient()
    {
        //Coming soon
    }

    /*
     Updates all physician information in database by using patient object fields as data source
      */
    public void updatePhysician()
    {
        //Coming soon
    }

    /*
    Updates all patient data to blank
     */
    private void deletePatient()
    {
        //Coming soon
    }

    /*
    Updates all physician data to blank
     */
    private void deletePhysician()
    {
        //Coming soon
    }


}
