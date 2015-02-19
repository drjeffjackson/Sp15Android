package medicalfaxnew.duqsp15.com.medicalfax.Presenter;

import medicalfaxnew.duqsp15.com.medicalfax.Model.ModelInterface;
import medicalfaxnew.duqsp15.com.medicalfax.MainActivity;
import medicalfaxnew.duqsp15.com.medicalfax.Presenter.Interfaces.PresenterInterface;
import android.content.Context;
import android.app.Activity;
import java.util.ArrayList;

public class Presenter implements PresenterInterface
{
    public ModelInterface modelInterface;
    private int requestedBox;
    public MainActivity ac;
    //Context is required for database in model

    public Presenter(Context context, Activity act)
    {
        //Activity for dictation
    	ac=(MainActivity)act;
        modelInterface = new ModelInterface(context, this, act);
    }

	// ModelObject
	// ViewObject
	@Override
	public void startTranscription(int boxNum)
    {
        requestedBox = boxNum;
		ModelInterface.dictation.getSpeechInput();
	}

    public void stopRequest() {
        // TODO Auto-generated method stub
        //NOT NEEDED anymore

    }

    public void doneListening(ArrayList<String> transcribedText)
    {
        System.err.println("string = " + transcribedText.get(0));
    	ac.fillBox(requestedBox, transcribedText.get(0));
        //Called by model with dictation results :)//
    }

}
