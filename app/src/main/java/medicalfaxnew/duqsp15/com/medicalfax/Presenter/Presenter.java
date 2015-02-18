package medicalfaxnew.duqsp15.com.medicalfax.Presenter;

import medicalfaxnew.duqsp15.com.medicalfax.Model.ModelInterface;
import medicalfaxnew.duqsp15.com.medicalfax.Presenter.Interfaces.PresenterInterface;
import android.content.Context;

public class Presenter implements PresenterInterface
{
    private ModelInterface modelInterface;
    private int requestedBox;
    //Context is required for database in model

    public Presenter(Context context)
    {
        modelInterface = new ModelInterface(context, this);
    }

	// ModelObject
	// ViewObject
	@Override
	public void startTranscription(int boxNum) {
		ModelInterface.dictation.startTranscription();
		
	}

	@Override
	public void doneListening(ArrayList<String> transcribedText) {
		//view.fillBox(requestedBox, concatenatedText)
	}

    public void stopRequest() {
        // TODO Auto-generated method stub

    }

}
