package medicalfaxnew.duqsp15.com.medicalfax.Model.IO;


/**
 * Created by austinpilz on 2/11/15.
 */
        import android.content.Context;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;
        import android.util.Log;
        import android.content.ContentValues;

public class MySQLiteHelper extends SQLiteOpenHelper
{

    //Physician
    public final String TABLE_PHYSICIAN = "Physician";
    public final String PHYSICIAN_COLUMN_ID = "ID";
    public final String PHYSICIAN_COLUMN_FIRST = "FirstName";
    public final String PHYSICIAN_COLUMN_LAST = "LastName";
    public final String PHYSICIAN_COLUMN_NPI = "NPI";
    public final String PHYSICIAN_COLUMN_HOSPITAL = "Hospital";
    public final String PHYSICIAN_COLUMN_DEPARTMENT = "Department";
    public final String PHYSICIAN_COLUMN_TITLE = "Title";
    public final String PHYSICIAN_COLUMN_PHONE = "Phone";
    public final String PHYSICIAN_COLUMN_EMAIL = "Email";

    private final String PHYSICIAN_TABLE_CREATE = "create table "
            + TABLE_PHYSICIAN + "(" + PHYSICIAN_COLUMN_ID
            + " integer primary key autoincrement, "
            + PHYSICIAN_COLUMN_FIRST + " text not null,"
            + PHYSICIAN_COLUMN_LAST + " text not null,"
            + PHYSICIAN_COLUMN_NPI + " text not null,"
            + PHYSICIAN_COLUMN_HOSPITAL + " text not null,"
            + PHYSICIAN_COLUMN_DEPARTMENT + " text not null,"
            + PHYSICIAN_COLUMN_TITLE + " text not null,"
            + PHYSICIAN_COLUMN_PHONE + " text not null,"
            + PHYSICIAN_COLUMN_EMAIL + " text not null"
            + ");";


    //GENERAL DATABASE
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "JacksonJ";



    public MySQLiteHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /*
    Creates the Physician and Patient tables
     */
    @Override
    public void onCreate(SQLiteDatabase database)
    {
        database.execSQL(PHYSICIAN_TABLE_CREATE); //Creates Physician Table
        createPatient(database); //Creates initial patient row
        // database.execSQL(PATIENT_TABLE_CREATE); //Creates Patient Table
        createPhysician(database); //creates initial physician row
    }

    /*
    Creates and inserts the first patient row in the database with blank values
     */
    private void createPatient(SQLiteDatabase database)
    {
        //
    }

    /*
    Creates and inserts the first physician row in the database with blank values
     */
    private void createPhysician(SQLiteDatabase database)
    {
        ContentValues cv = new ContentValues();

        cv.put(PHYSICIAN_COLUMN_ID, 1);
        cv.put(PHYSICIAN_COLUMN_FIRST, "");
        cv.put(PHYSICIAN_COLUMN_LAST, "");
        cv.put(PHYSICIAN_COLUMN_NPI, "");
        cv.put(PHYSICIAN_COLUMN_HOSPITAL, "");
        cv.put(PHYSICIAN_COLUMN_DEPARTMENT, "");
        cv.put(PHYSICIAN_COLUMN_TITLE, "");
        cv.put(PHYSICIAN_COLUMN_PHONE, "");
        cv.put(PHYSICIAN_COLUMN_EMAIL, "");
        database.insert(TABLE_PHYSICIAN, PHYSICIAN_COLUMN_ID, cv); //Insert statement

    }

    /*
    Upgrades the database if database version is newer than that of existing database
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(MySQLiteHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        //db.execSQL("DROP TABLE IF EXISTS " + TABLE_COMMENTS);
        onCreate(db);
    }

}