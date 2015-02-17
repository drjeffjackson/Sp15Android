/**
 * 
 * This interface needs to be implemented by the Presenter object.
 *
 */
public interface PresenterInterface {
	/**
	 * Method called by button press within the View Class. Method calls
	 * startListening() and displayRecordingScreen() from the Model object and
	 * View object respectively.
	 * 
	 * @param boxNum
	 *            The integer representation of text box number.
	 */
	void startTranscription(int boxNum);

	/**
	 * Method is called by the View object as the result of a "stop recording"
	 * button press. Calls stopListening() method in the Model class.
	 */
	void stopRequest();

	/**
	 * Method is called by the method startListening() and/or stopListening() in
	 * the Model object. Calls removeRecordingScreen() and fillBox() methods of
	 * the View object.
	 * 
	 * @param transcribedText
	 *            The text form of user dictation represented as a string.
	 */
	void doneListening(String transcribedText);
}
