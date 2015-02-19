package medicalfaxnew.duqsp15.com.medicalfax.Presenter;

import medicalfaxnew.duqsp15.com.medicalfax.Model.ModelInterface;
import medicalfaxnew.duqsp15.com.medicalfax.Presenter.Interfaces.PresenterInterface;
import android.content.Context;
import android.app.Activity;
import java.util.ArrayList;

public class Presenter implements PresenterInterface
{
    public ModelInterface modelInterface;
    private int requestedBox;
    //Context is required for database in model

    public Presenter(Context context, Activity ac)
    {
        //Activity for dictation
        modelInterface = new ModelInterface(context, this, ac);
    }

	// ModelObject
	// ViewObject
	@Override
	public void startTranscription(int boxNum)
    {
        //Starts dictation in Model
		ModelInterface.dictation.getSpeechInput();
	}

    public void stopRequest() {
        // TODO Auto-generated method stub
        //NOT NEEDED anymore

    }

    public void doneListening(ArrayList<String> transcribedText)
    {
        //Called by model with dictation results :)
    }

}
