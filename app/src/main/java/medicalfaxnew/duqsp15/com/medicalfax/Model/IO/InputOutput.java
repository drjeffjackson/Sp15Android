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
public class InputOutput {
    private MySQLiteHelper mysqlHelper; //SQL Helper

    public InputOutput(Context context) {
        context.deleteDatabase("JacksonJ"); //TEMPORARY
        mysqlHelper = new MySQLiteHelper(context);

    }

    //Loads patient from database
    public void loadPatient()
    {
        mysqlHelper.loadPatient(mysqlHelper.getWritableDatabase());
    }

    //Loads physician from database
    public void loadPhysician()
    {
        mysqlHelper.loadPhysician(mysqlHelper.getWritableDatabase());
    }

    //Updates patient in database
    public void updatePatient()
    {
        mysqlHelper.updatePatient(mysqlHelper.getWritableDatabase());
    }

    //Updates physician in database
    public void updatePhysician()
    {
        mysqlHelper.updatePhysician(mysqlHelper.getWritableDatabase());
    }

    //Called by view timer to automatically save data to database
    public void autoSave()
    {
        updatePatient();
        updatePhysician();
    }

    //Returns MySQLite helper
    public MySQLiteHelper getHelper()
    {
        return mysqlHelper;
    }



}