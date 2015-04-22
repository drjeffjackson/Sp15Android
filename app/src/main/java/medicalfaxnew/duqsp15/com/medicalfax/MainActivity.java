package medicalfaxnew.duqsp15.com.medicalfax;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.PopupWindow;
import android.widget.EditText;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.MenuInflater;
import android.widget.Toast;
import java.util.Timer;
import java.util.TimerTask;

import medicalfaxnew.duqsp15.com.medicalfax.Presenter.Interfaces.ViewPresenterInterFace;
import medicalfaxnew.duqsp15.com.medicalfax.Presenter.Presenter;


public class MainActivity extends ActionBarActivity implements ViewPresenterInterFace, OnTouchListener{

    private final int REQ_CODE_SPEECH_INPUT = 100; //constant necessary for validating Dictation
    private Presenter presenter;
    private EditText selectedView;
    private InputMethodManager inputMethodManager; // to hide and show keyboard
    private int keyboardState = 0;
    private boolean continuousDictation = false;
    private boolean agree = false; //may need to be saved to the database and moved to the model level

    private WebView htmlViewer; //View that displays the HTML code
    private PopupWindow popUpPreview; //The physical popup window
    private View popUpPreviewLayout; //The design/layout of the popup window

    private long actionDownTime = -1, actionUpTime = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new Presenter(this.getApplicationContext(), this);
        inputMethodManager = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        setListeners();
        createPopUpPreview();
        MyTimerTask save = new MyTimerTask(presenter);
        Timer myTimer = new Timer();
        myTimer.schedule(save, 60000, 60000);
        if(!getAgreement()) { popUpHIPPA();}
        if(getAgreement()) {initialDictation();}
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setIcon(R.drawable.ic_launcher);
    }

     /**
     * This method catches the startActivtyForResult call in Dictation class
     * and proceeds to extract the data from the Intent with its call to returnSpeech()
     * returnSpeech(data) will actually make a call to the presenter class with
     * the result of dictation if continuous dictation is not enabled.
     * If continuous dictation is enabled, data is immediately stored in the database and
     * no additional call is made to presenter.
     * @author Brady Sheehan
     * @return void
     */
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
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.items, menu);
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement\
        //converted to a switch statement by Coder Thanatos
        switch(id) {
            case R.id.action_submit:
                submits(selectedView);
                return true;
            case R.id.Cont_Dictation:
                setContinuousDictation(true);
                Toast.makeText(getApplicationContext(), "Continuous Dictation preference set!", Toast.LENGTH_LONG).show();
                presenter.modelInterface.physician.setContinuousDictation(continuousDictation);
                item.setChecked(true);
                break;
            case R.id.NonCont_Dictation:
                setContinuousDictation(false);
                Toast.makeText(getApplicationContext(), "NonContinuous Dictation preference set!", Toast.LENGTH_LONG).show();
                presenter.modelInterface.physician.setContinuousDictation(continuousDictation);
                item.setChecked(false);
                break;
            case R.id.action_tab_down:
                down(selectedView);
                break;
            case R.id.action_tab_up:
                up(selectedView);
                break;
            case R.id.action_keybaord:
                showKeyboard(selectedView);
                break;
            case R.id.action_dictation:
                dictates(selectedView);
                break;
        }

        return super.onOptionsItemSelected(item);
    }



    /** This method creates the preview pop up
     *
     */
    private void createPopUpPreview()
    {
        LayoutInflater layoutInflater
                = (LayoutInflater)getBaseContext()
                .getSystemService(LAYOUT_INFLATER_SERVICE);
        popUpPreviewLayout = layoutInflater.inflate(R.layout.preview_popup, null);
        popUpPreview = new PopupWindow(
                popUpPreviewLayout,
                LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT);

    }

    /** This method displays the popup preview, sets up the HTML document preview
     *
     */
    private void popUpPreview()
    {
        presenter.saveData();

        htmlViewer = (WebView) popUpPreviewLayout.findViewById(R.id.HTMLView);
        htmlViewer.getSettings().setJavaScriptEnabled(true);
        htmlViewer.loadDataWithBaseURL(null, presenter.assembleHTML(), "text/html", "utf-8", null);

        if(!popUpPreview.isShowing()) {
            popUpPreview.showAtLocation(findViewById(R.id.main_view), Gravity.CENTER, 0, 0);
        }
    }

    /** This method is called by send button in the popup preview
     *
     * @param v: the send_button
     */
    public void send(View v)
    {
        presenter.sendEmail();
    }

    /** This method closes the popup preview
     *
     * @param v: the close_button
     */
    public void close(View v)
    {
        if(popUpPreview.isShowing()) {
            popUpPreview.dismiss();
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
/**
 **
 ** TODO
 *******THIS METHOD NEEDS TO BE FIXED AFTER THE SAVE FUNCTION IS DONE!! THIS LENGTHY CODE IS MERELY AN EMERGENCY SOLUTION!!*****
 **
 **/

//        EditText[] field = presenter.getRequiredFields();
        boolean testsPassed = true;
//        if(field.length > 0) {
//            for (int i = 0; i < field.length; i++) {
//                if (field[i].getText().toString().isEmpty()) {
//                    field[i].setError("Field is required");
//                }
//            }
//            testsPassed = false;
//        }


        EditText Patient_Name = (EditText) findViewById(R.id.Patient_Name);
        if (Patient_Name.getText().toString().isEmpty()) {
            Patient_Name.setError("Field is required");
            testsPassed=false;
        }
        else{
            Patient_Name.setError(null);
        }

        EditText DOB = (EditText) findViewById(R.id.DOB);
        if (DOB.getText().toString().isEmpty()) {
            DOB.setError("Field is required");
            testsPassed=false;
        }
        else{
            DOB.setError(null);
        }
        EditText MRN = (EditText) findViewById(R.id.MRN);
        if (MRN.getText().toString().isEmpty()) {
            MRN.setError("Field is required");
            testsPassed=false;
        }
        else{
            MRN.setError(null);
        }

        EditText Admission_Date = (EditText) findViewById(R.id.Admission_Date);
        if (Admission_Date.getText().toString().isEmpty()) {
            Admission_Date.setError("Field is required");
            testsPassed=false;
        }
        else{
            Admission_Date.setError(null);
        }
        EditText Attending_Physician_Name = (EditText) findViewById(R.id.Attending_Physician_Name);
        if (Attending_Physician_Name.getText().toString().isEmpty()) {
            Attending_Physician_Name.setError("Field is required");
            testsPassed=false;
        }
        else{
            Attending_Physician_Name.setError(null);
        }

        EditText HPI = (EditText) findViewById(R.id.HPI);
        if (HPI.getText().toString().isEmpty()) {
            HPI.setError("Field is required");
            testsPassed=false;
        }
        else{
            HPI.setError(null);
        }
        EditText Hospital_Course = (EditText) findViewById(R.id.Hospital_Course);
        if (Hospital_Course.getText().toString().isEmpty()) {
            Hospital_Course.setError("Field is required");
            testsPassed=false;
        }
        else{
            Hospital_Course.setError(null);
        }

        EditText Chief_Complaint = (EditText) findViewById(R.id.Chief_Complaint);
        if (Chief_Complaint.getText().toString().isEmpty()) {
            Chief_Complaint.setError("Field is required");
            testsPassed=false;
        }
        else{
            Chief_Complaint.setError(null);
        }

        EditText Home_Medications = (EditText) findViewById(R.id.Home_Medications);
        if (Home_Medications.getText().toString().isEmpty()) {
            Home_Medications.setError("Field is required");
            testsPassed=false;
        }
        else{
            Home_Medications.setError(null);
        }
        EditText Primary = (EditText) findViewById(R.id.Primary);
        if (Primary.getText().toString().isEmpty()) {
            Primary.setError("Field is required");
        }
        else{
            Primary.setError(null);
        }
        EditText Secondary = (EditText) findViewById(R.id.Secondary);
        if (Secondary.getText().toString().isEmpty()) {
            Secondary.setError("Field is required");
            testsPassed=false;
        }
        else{
            Secondary.setError(null);
        }

        if(testsPassed)
            popUpPreview();
    }

    /** This method is called when Up Button is clicked
     *  It causes the cursor to move up once to the text field above the current position
     *  Created by: Kinardi Isnata, February 16 2015
     */
    public void up(View view)
    {
        if(selectedView != null) {
            selectedView = (EditText) selectedView.focusSearch(selectedView.FOCUS_UP);
            selectedView.requestFocus();
        }
    }
    /** This method is called when Down Button is clicked
     *  It causes the cursor to move down once to the text field below the current position
     *  Created by: Kinardi Isnata, February 16 2015
     */
    public void down(View view)
    {
        if(selectedView != null) {
            selectedView = (EditText) selectedView.focusSearch(selectedView.FOCUS_DOWN);
            selectedView.requestFocus();
        }
    }
    /** This method is called by the Show_Keyboard button to show and hide the soft input
     *
     * @param v the button
     */
    public void showKeyboard(View v)
    {
        if(keyboardState == InputMethodManager.RESULT_HIDDEN) {
            inputMethodManager.showSoftInput(selectedView, InputMethodManager.SHOW_IMPLICIT);
            keyboardState = InputMethodManager.RESULT_SHOWN;
        }
        else
        {
            inputMethodManager.hideSoftInputFromWindow(selectedView.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            keyboardState = InputMethodManager.RESULT_HIDDEN;
        }
    }

    private void popUpHIPPA()
    {
        if(!getAgreement()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("User Agreement");
            builder.setMessage("This app is not HIPPA compliant. It is for demo purposes only. Do not use real data. By clicking 'I agree' I as the user assume all liability.");
            builder.setPositiveButton("I agree", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    setAgreement(true);
                    dialog.dismiss(); // Let the app continue
                    initialDictation();
                }
            });

            builder.setNegativeButton("I disagree", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    setAgreement(false);
                    System.exit(0); // Close the app
                }
            });

            AlertDialog alert = builder.create();
            alert.setCancelable(false);
            alert.show();  // This call causes an android.view.WindowLeaked: Activity medicalfaxnew.duqsp15.com.medicalfax.MainActivity has leaked window error
            // Exception happens at "medicalfaxnew.duqsp15.com.medicalfax.MainActivity.popUpHIPPA(MainActivity.java:178)"
        }
    }

    /** This method starts dictation on the first focused view
     *
     */
    private void initialDictation()
    {
        dictates(selectedView);
    }

    /** This method set an onTouchListener to all the EditText objects so that they are touchable
     *  and set focus on the first EditText
     */
    private void setListeners()
    {
        EditText currentView = (EditText) findViewById(R.id.Patient_Name);
        selectedView = currentView;
        selectedView.requestFocus();
        currentView.setOnTouchListener(this);
        EditText nextView = (EditText) currentView.focusSearch(currentView.FOCUS_DOWN);
        while(!currentView.equals(nextView))
        {
            currentView = nextView;
            currentView.setOnTouchListener(this);
            nextView = (EditText) currentView.focusSearch(currentView.FOCUS_DOWN);
        }
    }

    /** This method changes focus based on the user's touch and hides the input keyboard
     * @param v the touched view
     * @param event MotionEvent's event
     * @return true if focus change is made
     */
    @Override
    public boolean onTouch(View v, MotionEvent event) {
       if (event.getAction() == MotionEvent.ACTION_UP) {
            actionUpTime = event.getEventTime() - actionDownTime;
            if (actionUpTime > 0 && v.getId() != R.id.code_status_spinner) {
                v.requestFocus();
                selectedView = (EditText) v;
                if (actionUpTime < 600) {
                    inputMethodManager.hideSoftInputFromWindow(selectedView.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                    keyboardState = InputMethodManager.RESULT_HIDDEN;
                } else {
                    inputMethodManager.showSoftInput(selectedView, InputMethodManager.SHOW_IMPLICIT);
                    keyboardState = InputMethodManager.RESULT_SHOWN;
                }
            }
            return true;
        }
        actionDownTime = event.getDownTime();
        return false;
    }
    @Override
    public void fillBox(int boxNum, String transcribedText) {
        EditText textBox = (EditText) findViewById(boxNum);
        String currentMessage = textBox.getText().toString();
        if(currentMessage == null)
        {
            textBox.setText(transcribedText);
        }
        else if(!currentMessage.isEmpty()) {
                textBox.setText(currentMessage + " " + transcribedText);
            }
            else {
                textBox.setText(transcribedText);
            }
        if((currentMessage = textBox.getText().toString()) != null) {
            textBox.setSelection(currentMessage.length());
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter.modelInterface.IO.getHelper() != null) {
            presenter.modelInterface.IO.getHelper().close();
        }
    }
    public void onBackPressed()
    {
        if(popUpPreview.isShowing())
        {
            popUpPreview.dismiss();
            return;
        }
        presenter.saveData();
        super.onBackPressed();
    }
public void setAgreement(boolean a)
{
    agree = a;
}
    public boolean getAgreement()
    {
        return agree;
    }
    public void setContinuousDictation(boolean cd)
    {
        continuousDictation = cd;
    }
    public boolean getContinuousDictation()
    {
        return continuousDictation;
    }

}


class MyTimerTask extends TimerTask {
    public Presenter update;

    public MyTimerTask(Presenter p)
    {
        update = p;
    }
    public void run() {
        update.updateDatabase();
    }
}
