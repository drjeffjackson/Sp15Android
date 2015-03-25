package medicalfaxnew.duqsp15.com.medicalfax;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.app.AlertDialog;
import android.content.DialogInterface;

import medicalfaxnew.duqsp15.com.medicalfax.Presenter.Interfaces.ViewPresenterInterFace;
import medicalfaxnew.duqsp15.com.medicalfax.Presenter.Presenter;


public class MainActivity extends ActionBarActivity implements ViewPresenterInterFace{

    private int SELECTED = -1;
    private final int REQ_CODE_SPEECH_INPUT = 100; //constant necessary for validating Dictation
    private Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new Presenter(this.getApplicationContext(), this);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("User Agreement");
        builder.setMessage("This app is not HIPPA compliant. It is for demo purposes only. Do not use real data. By clicking 'I agree' I as the user assume all liability.");

        builder.setPositiveButton("I agree", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                // Do nothing but close the dialog

                dialog.dismiss();
            }

        });

        builder.setNegativeButton("I disagree", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Do nothing
                System.exit(0);
            }
        });

        AlertDialog alert = builder.create();
        alert.show();
    }

    /*this method was written by Brady Sheehan on 2/18/2015
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

        // setFocus by decrement view.getId()
        // If it is not at the most top position, then move cursors up from current position
        // EditText.setSelection(int);
    }
    /** This method is called when Down Button is clicked
     *  It causes the cursor to move down once to the text field below the current position
     *  Created by: Kinardi Isnata, February 16 2015
     */
    public void down(View view)
    {

        // setFocus by increment view.getId()
        // If it is not at the most bottom position, then move cursors down from current position
        // EditText.setSelection(int);
    }

    /**
     * This method is called when the TextBox is touched for the second time
     * It extracts and saves the index of a EditText object, when an user performs a second touch on it.
     * NOTICE: Need to be fixed in a more sophisticated way, so that the user doesn't need to double click a EditText
     * @param view is a EditText
     */

    public void setSelection(View view)
    {
        SELECTED = view.getId();
        System.out.println(SELECTED);
    }

    /**
     * This method is called when the dictate_button is clicked
     * WARNING: For the EditText to be selected, it needs to be double clicked
     * @param view is the dictate button
     */
    public void dictates(View view)
    {

        presenter.startTranscription(SELECTED);
        SELECTED = -1;
    }

    @Override
    public void fillBox(int boxNum, String transcribedText) {
        EditText textBox = (EditText) findViewById(boxNum);
        textBox.setText(transcribedText);
    }
}
