package medicalfaxnew.duqsp15.com.medicalfax;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.View.OnLongClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Spinner;
import android.widget.EditText;
import android.app.AlertDialog;
import android.content.DialogInterface;



import medicalfaxnew.duqsp15.com.medicalfax.Presenter.Interfaces.ViewPresenterInterFace;
import medicalfaxnew.duqsp15.com.medicalfax.Presenter.Presenter;


public class MainActivity extends ActionBarActivity implements ViewPresenterInterFace, OnTouchListener, OnLongClickListener{

    private final int REQ_CODE_SPEECH_INPUT = 100; //constant necessary for validating Dictation
    private Presenter presenter;
    private EditText selectedView;
//    private InputMethodManager inputMethodManager; // to hide and show keyboard
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new Presenter(this.getApplicationContext(), this);
//        inputMethodManager = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        popUpHIPPA();
        setListeners();
    }

    /*This method was written by Brady Sheehan on 2/18/2015
    * this method catches the startActivtyForResult call in Dictation class
    * and proceeds to extract the data from the Intent with its call to returnSpeech()
    * returnSpeech(data) will actually make a call to the presenter class with
    * the result of dictation
    * */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        //speech recognition (like this) must require an internet connection!
        super.onActivityResult(requestCode, resultCode, data);
        //verifies that
        if(requestCode == REQ_CODE_SPEECH_INPUT && resultCode == RESULT_OK && null != data) {
            presenter.modelInterface.dictation.returnSpeech(data);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    /** This method is called when Up Button is clicked
     *  It causes the cursor to move up once to the text field above the current position
     *  Created by: Kinardi Isnata, February 16 2015
     */
    public void up(View view)
    {
        if(selectedView != null && selectedView.getId() != R.id.Patient_Name)
        {
            if((selectedView.getId() -1) == R.id.code_status_spinner) {
                selectedView = (EditText) findViewById(selectedView.getId() - 2);
            }
            else
            {
                selectedView = (EditText) findViewById(selectedView.getId() - 1);
            }
            selectedView.requestFocus();
        }
    }
    /** This method is called when Down Button is clicked
     *  It causes the cursor to move down once to the text field below the current position
     *  Created by: Kinardi Isnata, February 16 2015
     */
    public void down(View view)
    {
        if(selectedView != null && selectedView.getId() != R.id.Home_Medications)
        {
            if((selectedView.getId() + 1) == R.id.code_status_spinner) {
                selectedView = (EditText) findViewById(selectedView.getId() + 2);
            }
            else
            {
                selectedView = (EditText) findViewById(selectedView.getId() + 1);
            }

            selectedView.requestFocus();
        }
    }

    /**
     * This method is called when the dictate_button is clicked
     * @param view is the dictate button
     */
    public void dictates(View view)
    {
        if(selectedView != null && selectedView.getId() != R.id.code_status_spinner) {
            presenter.startTranscription(selectedView.getId());
        }
    }
    /**
     * This method is called when the Submit_Button is clicked
     * @param view is the submit button
     */
    public void submits(View view)
    {
        if(selectedView != null)
            selectedView.setText("TEST");
    }
    @Override
    public void fillBox(int boxNum, String transcribedText) {
        EditText textBox = (EditText) findViewById(boxNum);
        textBox.setText(transcribedText);
    }

    /** This method changes focus based on the user's touch and hides the input keyboard
     * @param v the touched view
     * @param event MotionEvent's event
     * @return true if focus change is made
     * @return  false otherwise
     */
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP && v.getId() != R.id.code_status_spinner) {
            v.requestFocus();
            selectedView = (EditText) v;
//            inputMethodManager.hideSoftInputFromWindow(selectedView.getWindowToken(),InputMethodManager.RESULT_HIDDEN);
            return true;
        }
        return false;
    }
    /** This method changes focus based on the user's touch shows the input keyboard
     * @param v the touched viewt
     * @return true if long click is made
     * @return false otherwise
     */
    @Override
    public boolean onLongClick(View v) {
        if(v.getId() != R.id.code_status_spinner) {
            selectedView = (EditText) v;
            v.requestFocus();
            //  inputMethodManager.hideSoftInputFromWindow(selectedView.getWindowToken(),InputMethodManager.RESULT_SHOWN);
            return true;
        }
        return false;
    }


    private void popUpHIPPA()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("User Agreement");
        builder.setMessage("This app is not HIPPA compliant. It is for demo purposes only. Do not use real data. By clicking 'I agree' I as the user assume all liability.");
        builder.setPositiveButton("I agree", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss(); // Let the app continue
            }
        });

        builder.setNegativeButton("I disagree", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                System.exit(0); // Close the app
            }
        });

        AlertDialog alert = builder.create();
        alert.setCancelable(false);
        alert.show();  // This call causes an android.view.WindowLeaked: Activity medicalfaxnew.duqsp15.com.medicalfax.MainActivity has leaked window error
        // Exception happens at "medicalfaxnew.duqsp15.com.medicalfax.MainActivity.popUpHIPPA(MainActivity.java:178)"
    }
    private void setListeners()
    {
        EditText Patient_Name = (EditText) findViewById(R.id.Patient_Name);
        Patient_Name.setOnTouchListener(this);
        Patient_Name.setOnLongClickListener(this);
        EditText DOB = (EditText) findViewById(R.id.DOB);
        DOB.setOnTouchListener(this);
        DOB.setOnLongClickListener(this);
        EditText MRN = (EditText) findViewById(R.id.MRN);
        MRN.setOnTouchListener(this);
        MRN.setOnLongClickListener(this);
        EditText Admission_Date = (EditText) findViewById(R.id.Admission_Date);
        Admission_Date.setOnTouchListener(this);
        Admission_Date.setOnLongClickListener(this);
        EditText PCP = (EditText) findViewById(R.id.PCP);
        PCP.setOnTouchListener(this);
        PCP.setOnLongClickListener(this);
        EditText Attending_Physician_Name = (EditText) findViewById(R.id.Attending_Physician_Name);
        Attending_Physician_Name.setOnTouchListener(this);
        Attending_Physician_Name.setOnLongClickListener(this);
        EditText Title = (EditText) findViewById(R.id.Title);
        Title.setOnTouchListener(this);
        Title.setOnLongClickListener(this);
        EditText Department = (EditText) findViewById(R.id.Department);
        Department.setOnTouchListener(this);
        Department.setOnLongClickListener(this);
        EditText Home_Hospital = (EditText) findViewById(R.id.Home_Hospital);
        Home_Hospital.setOnTouchListener(this);
        Home_Hospital.setOnLongClickListener(this);
        EditText Phone_Number = (EditText) findViewById(R.id.Phone_Number);
        Phone_Number.setOnTouchListener(this);
        Phone_Number.setOnLongClickListener(this);
        EditText Email_Address = (EditText) findViewById(R.id.Email_Address);
        Email_Address.setOnTouchListener(this);
        Email_Address.setOnLongClickListener(this);
        EditText NPI_Number = (EditText) findViewById(R.id.NPI_Number);
        NPI_Number.setOnTouchListener(this);
        NPI_Number.setOnLongClickListener(this);
        EditText Chief_Complaint = (EditText) findViewById(R.id.Chief_Complaint);
        Chief_Complaint.setOnTouchListener(this);
        Chief_Complaint.setOnLongClickListener(this);
        EditText HPI = (EditText) findViewById(R.id.HPI);
        HPI.setOnTouchListener(this);
        HPI.setOnLongClickListener(this);
        EditText Hospital_Course = (EditText) findViewById(R.id.Hospital_Course);
        Hospital_Course.setOnTouchListener(this);
        Hospital_Course.setOnLongClickListener(this);
        EditText Consultants = (EditText) findViewById(R.id.Consultants);
        Consultants.setOnTouchListener(this);
        Consultants.setOnLongClickListener(this);
        EditText Primary = (EditText) findViewById(R.id.Primary);
        Primary.setOnTouchListener(this);
        Primary.setOnLongClickListener(this);
        EditText Secondary = (EditText) findViewById(R.id.Secondary);
        Secondary.setOnTouchListener(this);
        Secondary.setOnLongClickListener(this);
        EditText Complications = (EditText) findViewById(R.id.Complications);
        Complications.setOnTouchListener(this);
        Complications.setOnLongClickListener(this);
        EditText Finalized = (EditText) findViewById(R.id.Finalized);
        Finalized.setOnTouchListener(this);
        Finalized.setOnLongClickListener(this);
        EditText Pending = (EditText) findViewById(R.id.Pending);
        Pending.setOnTouchListener(this);
        Pending.setOnLongClickListener(this);
        EditText Completed_Course = (EditText) findViewById(R.id.Completed_Course);
        Completed_Course.setOnTouchListener(this);
        Completed_Course.setOnLongClickListener(this);
        EditText Current_Course = (EditText) findViewById(R.id.Current_Course);
        Current_Course.setOnTouchListener(this);
        Current_Course.setOnLongClickListener(this);
        EditText Past_Medical_History = (EditText) findViewById(R.id.Past_Medical_History);
        Past_Medical_History.setOnTouchListener(this);
        Past_Medical_History.setOnLongClickListener(this);
        EditText Home_Medications = (EditText) findViewById(R.id.Home_Medications);
        Home_Medications.setOnTouchListener(this);
        Home_Medications.setOnLongClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter.modelInterface.IO.getHelper() != null) {
            presenter.modelInterface.IO.getHelper().close();
        }
    }
}
