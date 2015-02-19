package medicalfaxnew.duqsp15.com.medicalfax.Presenter.Interfaces;

/**
 * Created by austinpilz on 2/19/15.
 */
public interface ModelPresenterInterface
{

        /**
         * Method called by startTranscription() method of Presenter Interface.
         * Begins taking voice input from user dictation. Once listening is
         * complete, method calls doneListening() method of Presenter Class with the
         * transcribed text as a parameter. If an error is encountered, error
         * message should be passed as a text string to doneListening() method in
         * Presenter Object.
         */
        void startTranscription();

        /**
         * Called by stopRequest() method in the Presenter Interface. Method calls
         * doneListening() method of Presenter Class with the transcribed text as a
         * parameter. If an error is encountered, error message should be passed as
         * a text string to doneListening() method in Presenter Object.
         */

        void stopTranscription();

    }
