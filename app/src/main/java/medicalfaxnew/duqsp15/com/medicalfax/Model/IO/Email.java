package medicalfaxnew.duqsp15.com.medicalfax.Model.IO;

import android.app.Activity;
import android.net.Uri;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import medicalfaxnew.duqsp15.com.medicalfax.Model.ModelInterface;

public class Email {
    /**
     * created by Xun Yang, on 3/30/2015,working with Joel and Phil
     */

    public Activity activity;
    ModelInterface modelE;
    public Email(Activity ac, ModelInterface model)
    {
        modelE=model;
        activity=ac;
    }
    public void sendEmail(String body, Uri u){
        Log.w("=============",u.toString());
        /* ACTION_SEND indicates that one attachment will be sent. */
        Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
        /* Make sure that only an email app handles this. */
        emailIntent.setData(Uri.parse("mailto:"));
        /* Set flags to allow the Uri to be edited. */
        emailIntent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        emailIntent.setFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
        emailIntent.setType("text/plain");
        /* Passes the subject for the email. */
        emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "patient information");
        /* Passes the body of the email. */
        emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, body);
        /* Passes the attachment as a Uri. */
        emailIntent.putExtra(Intent.EXTRA_STREAM, u);
        try {
            activity.startActivity(Intent.createChooser(emailIntent, "Choose an email client from..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(activity, "No email client configured on system.",
                    Toast.LENGTH_LONG).show();
        }
    }
}

