package medicalfaxnew.duqsp15.com.medicalfax.Model.Parser;
import medicalfaxnew.duqsp15.com.medicalfax.Model.Patient.*;


import medicalfaxnew.duqsp15.com.medicalfax.Model.Dictation.Dictation;

/**
 * Created by Coder Barber & Brady on 4/13/15.
 */

public class DictationParser {

    String dictationString;
    /**
     * Nullary constructor
     */
    public DictationParser() {
    }

    /**
     * Constructor passing in one string
     * @param dictationString the string being passed in to parse
     */
    public DictationParser(String dictationString) {

        this.dictationString = dictationString;
    }

    /**
     * This methods takes in a string, sets it to lowercase and splits into array using stop
     * @param dictationString string being passed in to be parsed
     */
   public void parseString(String dictationString) {
       String dictation = dictationString.toLowerCase();
       final String[] arr = dictation.split(" stop");
       storeString(arr);
   }

    /**
     * This method stores the parsed elements into the model
     * @param arr this is the array of elements parsed by stop
     */
   public void storeString(String arr[]) {
       for (int i = 0; i < arr.length; i++) {
           //Patient ID
           if (arr[i].contains("name")) {
               final String[] arrName = arr[i].split("name ");
               Name newName = new Name(arrName[1]);
           }
           else if (arr[i].contains("dob")) {
               final String[] arrDOB = arr[i].split("dob ");
               final String[] arrDOB2 = arrDOB[1].split(" ");
               Date DOB = new Date(arrDOB2[0],arrDOB2[1], arrDOB2[2]);
           }
           else if (arr[i].contains("mrn")) {
               final String[] arrMRN = arr[i].split("mrn ");
               MRN mrn = new MRN(arrMRN[1]);
           }
           else if (arr[i].contains("admission date")) {
               final String[] arrDate = arr[i].split("admission date ");
               final String[] arrDate2 = arrDate[1].split(" ");
               Date admDate = new Date(arrDate2[0],arrDate2[1], arrDate2[2]);
           }
           else if (arr[i].contains("pcp")) {
               final String[] arrPCP = arr[i].split("pcp ");
               Name pcp = new Name(arrPCP[1]);
           }
           else if (arr[i].contains("code status")) {
               final String[] arrStatus = arr[i].split("code status ");
               CodeStatus code = new CodeStatus(arrStatus[1]);
           }

           // end patient ID

           //BEGIN ATTENDING PHYSICIAN

           else if (arr[i].contains("attending")) {
               final String[] arrAttending = arr[i].split("attending ");
               Name attending = new Name(arrAttending[1]);
           }



           else if (arr[i].contains("chief complaint")) {
               final String[] arrComplaint = arr[i].split("chief complaint ");
               ChiefComplaint complaint = new ChiefComplaint(arrComplaint[1]);
           }
           else if (arr[i].contains("hpi")) {
               final String[] arrHPI = arr[i].split("hpi ");
           }
           else if (arr[i].contains("hospital course")) {
               final String[] arrHospitalCourse = arr[i].split("hospital course ");
               HospitalCourse course = new HospitalCourse(arrHospitalCourse[1]);
           }
           else if (arr[i].contains("consultants")) {
               final String[] arrConsultants = arr[i].split("consultants ");
               System.out.println(arrConsultants[1]);
           }
           else if (arr[i].contains("diagnosis")) {
               final String[] arrDiagnosis = arr[i].split("diagnosis ");
               Diagnosis diagnosis = new Diagnosis(arrDiagnosis[1]);
           }
           else if (arr[i].contains("test")) {
               final String[] arrTests = arr[i].split("test ");
               final String[] arrTests2 = arrTests[1].split("status");
               Tests test = new Tests(arrTests2[0],arrTests2[1].split("status ")[0]);
           }
           else if (arr[i].contains("medications")) {
               final String[] arrMeds = arr[i].split("medications ");
               Medicine med = new Medicine(arrMeds[1].split("course")[0], arrMeds[1].split("course")[1].split("completed")[0],arrMeds[1].split("completed")[1]);
           }
           else if (arr[i].contains("medical history")) {
               final String[] arrHistory = arr[i].split("medical history ");
               MedicalHistory medHistory = new MedicalHistory(arrHistory[1]);
           }
           else if (arr[i].contains("allergies")) {
               final String[] arrAllergies = arr[i].split("allergies ");
               Allergy allergy = new Allergy(arrAllergies[1]);
           }
       }

   }

}
