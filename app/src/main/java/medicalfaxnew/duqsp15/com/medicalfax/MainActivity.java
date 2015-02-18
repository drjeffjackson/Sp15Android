package medicalfaxnew.duqsp15.com.medicalfax;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {

    private int SELECTED = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
     * @param view is the dictate button
     */

    public void setSelection(View view)
    {
        SELECTED = view.getId();
        System.out.println(SELECTED);
    }

    /**
     * Set the selected EditText with the transcribed text
     * WARNING: For the Edittext to be selected, it needs to be double clicked
     * @param view
     */
    public void dictates(View view)
    {
        String test = "HeLLLooo"; //for test
        if(SELECTED >= 0) {
            EditText textBox = (EditText) findViewById(SELECTED);
            textBox.setText(test);
        }
        SELECTED = -1;
    }

}
