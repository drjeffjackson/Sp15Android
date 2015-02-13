package medicalfaxnew.duqsp15.com.medicalfax.Model.IO;

        import android.content.Context;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;

        import medicalfaxnew.duqsp15.com.medicalfax.Model.Controller.ModelController;

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
    {
        //
    }

    /*
    Loads database physician data into physician object
     */
    public void loadPhysician()
    {
        //Selects the row with the physician ID of 1, since that's the row where we store all the data
        Cursor c= database.rawQuery("SELECT * FROM " + mysqlHelper.TABLE_PHYSICIAN + " WHERE ID =?", new String []{"1"});
        c.moveToFirst();

        //Sets the physician object fields with database values
        ModelController.physician.setFirstName(c.getString(c.getColumnIndex(mysqlHelper.PHYSICIAN_COLUMN_FIRST)));
        ModelController.physician.setLastName(c.getString(c.getColumnIndex(mysqlHelper.PHYSICIAN_COLUMN_LAST)));
        ModelController.physician.setNPI(c.getString(c.getColumnIndex(mysqlHelper.PHYSICIAN_COLUMN_NPI)));
        ModelController.physician.setHomeHospital(c.getString(c.getColumnIndex(mysqlHelper.PHYSICIAN_COLUMN_HOSPITAL)));
        ModelController.physician.setDepartment(c.getString(c.getColumnIndex(mysqlHelper.PHYSICIAN_COLUMN_DEPARTMENT)));
        ModelController.physician.setTitle(c.getString(c.getColumnIndex(mysqlHelper.PHYSICIAN_COLUMN_TITLE)));
        ModelController.physician.setPhone(c.getString(c.getColumnIndex(mysqlHelper.PHYSICIAN_COLUMN_PHONE)));
        ModelController.physician.setEmail(c.getString(c.getColumnIndex(mysqlHelper.PHYSICIAN_COLUMN_EMAIL)));

    }

    /*
    When called, takes
     */
    protected void updatePatient()
    {
        //hi
    }

    /*
    When called, takes
    @param field name
     */
    protected void updatePhysician(String field)
    {
        //
    }

    /*
    Updates all patient data to blank
     */
    public void deletePatient()
    {
        //
    }

    /*
    Updates all physician data to blank
     */
    public void deletePhysician()
    {
        //
    }


}
