package medicalfaxnew.duqsp15.com.medicalfax.Model.Dictation;

import java.util.ArrayList;
import java.util.Locale;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.widget.Toast;

import medicalfaxnew.duqsp15.com.medicalfax.R;

/**
 * Created by austinpilz on 2/16/15.
 * Edited by Brady Sheehan and Justin Chilleo on 2/16/15
 * Added getSpeechInput() and returnSpeech() methods - Brady Sheehan 2/18/15
 */
public class Dictation
{
    public Activity activity;
    private boolean processing;
    private final int REQ_CODE_SPEECH_INPUT = 100;

    public Dictation(Activity ac) //need access to the activity in this class for speech
    {
        activity = ac;
    }
    public Dictation() {} //here just to compile
    /**
     * Creates the Intent for speech recognition and starts the activity
     * the results of the activity are caught in onActivityForResult() in the main method
     * @author Brady Sheehan
     * @param none
     * @exception ActivityNotFoundException
     * @return void
     */
    public void getSpeechInput(){

        //this creates its own activity
        //http://developer.android.com/reference/android/app/Activity.html#startActivityForResult%28android.content.Intent%2c%20int%29
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        ArrayList<String> result = null;
        try{
            activity.startActivityForResult(intent, REQ_CODE_SPEECH_INPUT); //this is called on the implicit activity that was created
        }catch(ActivityNotFoundException a){
            Toast.makeText(activity.getApplicationContext(),activity.getString(R.string.speech_not_supported),Toast.LENGTH_SHORT ).show();
        }
    }

    /**
     * Needs to be passed the intent from the main method in onActivityResult()
     * it will then extract the EXTRA_RESULTS which is the dictation from the
     * intent object and pass the results of dictation to the presenter object.
     * @author Brady Sheehan
     * @param Intent
     * @exception none
     * @return void
     */
    public void returnSpeech(Intent data){
        ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
        //call function in presenter that passes the ArrayList<String>
    }
}
