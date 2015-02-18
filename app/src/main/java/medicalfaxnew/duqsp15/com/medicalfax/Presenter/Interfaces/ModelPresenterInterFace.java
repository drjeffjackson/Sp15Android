package medicalfaxnew.duqsp15.com.medicalfax.Presenter.Interfaces;
/**
 * 
 * This interface needs to be implemented by the Model object.
 *
 */
public interface ModelPresenterInterFace {
	/**
	 * Method called by startTranscription() method of Presenter Interface.
	 * Begins taking voice input from user dictation. Once listening is
	 * complete, method calls doneListening() method of Presenter Class with the
	 * transcribed text as a parameter. If an error is encountered, error
	 * message should be passed as a text string to doneListening() method in
	 * Presenter Object.
	 */
	void startListening();

	/**
	 * Called by stopRequest() method in the Presenter Interface. Method calls
	 * doneListening() method of Presenter Class with the transcribed text as a
	 * parameter. If an error is encountered, error message should be passed as
	 * a text string to doneListening() method in Presenter Object.
	 */

	void stopListening();
}
