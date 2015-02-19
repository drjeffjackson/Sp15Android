package medicalfaxnew.duqsp15.com.medicalfax;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import medicalfaxnew.duqsp15.com.medicalfax.Presenter.Interfaces.ViewPresenterInterFace;
import medicalfaxnew.duqsp15.com.medicalfax.Presenter.Presenter;


public class MainActivity extends ActionBarActivity implements ViewPresenterInterFace{

    private int SELECTED = -1;
    //public Dictation dictation;
    private final int REQ_CODE_SPEECH_INPUT = 100;
    private Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new Presenter(this.getApplicationContext(), this);

        //dictation = new Dictation(this);//we must pass the activity to use it outside the class
        //dictate.getSpeech();
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

        if(requestCode == REQ_CODE_SPEECH_INPUT && resultCode == RESULT_OK && null != data) {
            presenter.modelInterface.dictation.returnSpeech(data);
            //dictation.returnSpeech(data); //returnSpeech(data) will return an ArrayList<STRING>
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
     * This method is called when the dictate button is pressed
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
     * Set the selected EditText with the transcribed text
     * WARNING: For the EditText to be selected, it needs to be double clicked
     * @param view is the dictate button
     */

    public void dictates(View view)
    {
        String test = "View Group YAY"; //for test
        if(SELECTED >= 0)
        {
            fillBox(SELECTED, test);
        }
        SELECTED = -1;
    }
 //

    @Override
    public void fillBox(int boxNum, String transcribedText) {
        EditText textBox = (EditText) findViewById(boxNum);
        textBox.setText(transcribedText);
    }
}
