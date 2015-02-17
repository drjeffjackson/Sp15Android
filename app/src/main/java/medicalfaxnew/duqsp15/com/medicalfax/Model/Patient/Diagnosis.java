package medicalfaxnew.duqsp15.com.medicalfax.Model.Patient;
public class Diagnosis
{

	String primaryDiagnosis;
	String secondaryDiagnosis;
	String complications;

	public Diagnosis(String primaryDiagnosis) {
		primaryDiagnosis = this.primaryDiagnosis;
	}

    public Diagnosis(){};

	public Diagnosis(String primaryDiagnosis, String secondaryDiagnosis) {
		primaryDiagnosis = this.primaryDiagnosis;
		secondaryDiagnosis = this.secondaryDiagnosis;
	}

	public void setPrimaryDiagnosis(String newPrimaryDiagnosis) {
		primaryDiagnosis = newPrimaryDiagnosis;
	}

	public void setSecondaryDiagnosis(String newSecondaryDiagnosis) {
		secondaryDiagnosis = newSecondaryDiagnosis;
	}
	
	public void setComplications(String newComplications) {
		complications = newComplications;
	}
	
	public String getPrimaryDiagnosis() {
		return primaryDiagnosis;
	}
	
	public String getSecondaryDiagnosis() {
		return secondaryDiagnosis;
	}
	
	public String getComplications() {
		return complications;
	}
	
}
