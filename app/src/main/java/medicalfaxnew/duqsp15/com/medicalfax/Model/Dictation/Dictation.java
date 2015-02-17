package medicalfaxnew.duqsp15.com.medicalfax.Model.Dictation;

import java.util.ArrayList;
import java.util.Locale;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by austinpilz on 2/16/15.
 * Edited by Brady Sheehan and Justin Chilleo on 2/16/15
 */
public class Dictation
{
    private boolean processing;

    public Dictation()
    {
        //
    }
    
    //method for signifying start of dictation
    //that way they can signify a loading bar or something (??)
    public boolean dictationStarted(){
        //return true
        //try{}catch(){}
        getSpeech();
        return true;

    }
    
    //method that will actually return the speechs
    public String getSpeech(){
        String s = "Sorry, dictation is currently down";
        return s;
        
    }
    
}
