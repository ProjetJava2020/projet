package hospitalisation;

/**
 * Classe m�re dossier. Peut etre m�dical comme administratif
 */
public class Dossier {
	
    public String date_creation;
    public Patient patient;
    
    public Dossier(String date_creation, Patient patient){
        this.date_creation = date_creation;
        this.patient = patient;
    }
    public Dossier() {}
    Dossier get_or_create_dossier() {
		return null;
    };
    
    public Patient getPatient() {
    	return this.patient; 
    }
    
}
