package medicalfaxnew.duqsp15.com.medicalfax.Presenter;

import medicalfaxnew.duqsp15.com.medicalfax.Model.ModelInterface;
import medicalfaxnew.duqsp15.com.medicalfax.Presenter.Interfaces.PresenterInterface;
import android.content.Context;

public class Presenter implements PresenterInterface
{
    private ModelInterface modelInterface;
    //Context is required for database in model

    public Presenter(Context context)
    {
        modelInterface = new ModelInterface(context, this);
    }

	// ModelObject
	// ViewObject
	@Override
	public void startTranscription(int boxNum) {
		// TODO Auto-generated method stub

	}

	@Override
	public void doneListening(String transcribedText) {
		// TODO Auto-generated method stub

	}

    public void stopRequest() {
        // TODO Auto-generated method stub

    }

}
