package medicalfaxnew.duqsp15.com.medicalfax.Presenter.Interfaces;

/**
 * 
 * This interface needs to be implemented by the View object.
 *
 */
public interface ViewPresenterInterFace {
	/**
	 * Method called by the startTranscription() method of Presenter Interface.
	 * Displays a dialog box that alerts user recording is in progress.
	 */
	void displayRecordingScreen();

	/**
	 * Method called by the doneListening() method of Presenter Interface.
	 * Closes the dialog box to alert user that recording has stopped.
	 */
	void removeRecordingScreen();

	/**
	 * Method called by the doneListening() method of the Presenter Interface.
	 * Writes transcribed text to corresponding text box, as identified by
	 * boxNum.
	 * 
	 * @param boxNum
	 *            The integer representation of text box number.
	 * @param transcribedText
	 *            The text form of user dictation represented as a string.
	 */

	void fillBox(int boxNum, String transcribedText);
}
