package medicalfaxnew.duqsp15.com.medicalfax.Presenter;

import medicalfaxnew.duqsp15.com.medicalfax.Model.ModelInterface;
import medicalfaxnew.duqsp15.com.medicalfax.MainActivity;
import medicalfaxnew.duqsp15.com.medicalfax.Presenter.Interfaces.PresenterInterface;
import android.content.Context;
import android.app.Activity;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/**
 * This class contains the functions pertaining to the Presenter.
 */

public class Presenter implements PresenterInterface
{

    /**
     * The object representing the modelInterface.
     */
    public ModelInterface modelInterface;
    /**
     * Identifies which box was selected for dictation.
     */
    private int requestedBox;
    /**
     * The object representing the MainActivity class.
     */
    public MainActivity ac;
    //Context is required for database in model

    /**
     * This constructor will initialize a new Presenter object with a provided Context and Activity.
     * @param context The object representing the Context.
     * @param act The object representing the Activity.
     */
    public Presenter(Context context, Activity act)
    {
        //Activity for dictation

    	ac=(MainActivity)act;
        modelInterface = new ModelInterface(context, this, act);
        requestedBox = -1;
        File f = GenerateHTML(context);

        FileInputStream in = null;
        try {
            in = context.openFileInput("htmlCode.html");
        }
        catch(FileNotFoundException q) {}
        InputStreamReader inputStreamReader = new InputStreamReader(in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line=null;
        try {
            line = bufferedReader.readLine();
            Log.i("======", line);
            bufferedReader.close();
            inputStreamReader.close();
            in.close();
        }catch(IOException j){
            Log.i("========", "IO error");}
    }

	// ModelObject
	// ViewObject

    /**
     * Notifies the Model via the ModelInterface to begin dictation.
     * @param boxNum The number id from the textbox where transcribed text is to appear.
     */
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

    /**
     * Retrieves transcribed text from dictation and sends it the appropriate textbox.
     * Also checks for errors in the textbox selection.
     * @param transcribedText ArrayList containing the transcribed text from dictation.
     */
    public void doneListening(ArrayList<String> transcribedText)
    {
        System.err.println("requestedBox = " + requestedBox);
        if(requestedBox !=-1){ //error checking for the View group, if it's -1, no box was selected
            System.err.println("string = " + transcribedText.get(0));
            ac.fillBox(requestedBox, transcribedText.get(0));
            //Called by model with dictation results :)//
        }
        requestedBox = -1; //need to reset value for error checking
    }

    public String assembleHTML()
    {
        HTMLTable patientTable = new HTMLTable();
        for(int i=0; i<7; i++)
        {
            patientTable.add(new HTMLTableRow());
        }
        patientTable.get(0).add("Name");
        patientTable.get(0).add(modelInterface.patient.patientName.getName());

        patientTable.get(1).add("MRN#");
        patientTable.get(1).add(modelInterface.patient.medRecNum.getMrn());

        patientTable.get(2).add ("DOB");
        patientTable.get(2).add(modelInterface.patient.dateOfBirth.getDay()+"/"+modelInterface.patient.dateOfBirth.getMonth()+"/"+modelInterface.patient.dateOfBirth.getYear());

        patientTable.get(3).add ("Date of Admittance");
        patientTable.get(3).add(modelInterface.patient.admDate.getDay()+"/"+modelInterface.patient.admDate.getMonth()+"/"+modelInterface.patient.admDate.getYear());

        patientTable.get(4).add ("Code Status");
        patientTable.get(4).add(modelInterface.patient.codeStatus.getCodeStatus());

        patientTable.get(5).add ("Attending Name");
        patientTable.get(5).add(modelInterface.patient.attendingName.getName());

        patientTable.get(6).add ("PCP Name");
        patientTable.get(6).add(modelInterface.patient.pcpName.getName());

        HTMLTable physicianTable = new HTMLTable();
        for(int i=0; i<4; i++){
            physicianTable.add(new HTMLTableRow());
        }

        physicianTable.get(0).add("Name");
        physicianTable.get(0).add(modelInterface.physician.name.getName());

        physicianTable.get(1).add(modelInterface.physician.hospital.getHomeHospital());
        physicianTable.get(1).add(modelInterface.physician.hospital.getDepartment()+"-"+modelInterface.physician.hospital.getTitle());

        physicianTable.get(2).add("NPI#");
        physicianTable.get(2).add(modelInterface.physician.npi.getNPI());

        physicianTable.get(3).add(modelInterface.physician.contact.getEmail());
        physicianTable.get(3).add(modelInterface.physician.contact.getPhone());

        String str = null;
        str+="<!DOCTYPE html>";
        str+="<html>";
        str+=new HTMLHeader("Patient").toString();
        str+=patientTable.toString();
        str+=new HTMLHeader("Physician").toString();
        str+=physicianTable.toString();
        str+=new HTMLHeader("Chief Complaint").toString();
        str+=new HTMLParagraph(modelInterface.patient.chiefComplaint.getChiefComplaint());
        str+=new HTMLHeader("HPI").toString();
        str+=new HTMLParagraph(modelInterface.patient.hpi.getHPI());
        str+=new HTMLHeader("Hospital Course");
        str+=new HTMLParagraph(modelInterface.patient.hospitalCourse.getHospitalCourse());
        str+=new HTMLHeader("Relevant Medical History");
        str+=new HTMLParagraph(modelInterface.patient.medHistory.getMedicalHistory());
        str+=new HTMLHeader("Patient Diagnosis");
        str+=new HTMLParagraph(modelInterface.patient.patientDiagnosis.getPrimaryDiagnosis());
        str+=new HTMLParagraph(modelInterface.patient.patientDiagnosis.getSecondaryDiagnosis());
        str+=new HTMLParagraph(modelInterface.patient.patientDiagnosis.getComplications());
        str+="</html>";
        return str;
    }

    public File GenerateHTML(Context con)
    {
        BufferedWriter bw = null;
        File file = new File(con.getFilesDir(), "htmlCode.html");
        try {
            FileOutputStream fou = con.openFileOutput(file.getName(), Context.MODE_APPEND);
            bw = new BufferedWriter(new OutputStreamWriter(fou));
            try {
                String htmlResult = assembleHTML();
                Log.i("==============",htmlResult);
                bw.write(htmlResult);
                bw.flush();
                bw.close();
                fou.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return file;
    }


}
