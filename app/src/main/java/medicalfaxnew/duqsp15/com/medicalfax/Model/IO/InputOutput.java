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
    private SQLiteDatabase database;

    public InputOutput(Context context) {
        mysqlHelper = new MySQLiteHelper(context);
        database = mysqlHelper.getWritableDatabase();
    }

    //Loads patient from database
    public void loadPatient()
    {
        mysqlHelper.loadPatient(database);
    }

    //Loads physician from database
    public void loadPhysician()
    {
        mysqlHelper.loadPhysician(database);
    }

    //Updates patient in database
    public void updatePatient()
    {
        mysqlHelper.updatePatient(database);
    }

    //Updates physician in database
    public void updatePhysician()
    {
        mysqlHelper.updatePhysician(database);
    }



}