package hospitalisation;

import java.util.ArrayList;
import java.util.Date;

public class Dossier {
	public static ArrayList<Dossier> tous_les_dossiers = new ArrayList<>();

    public String date_creation;
    public Patient patient;
    
    public Dossier(String date_creation, Patient patient){
        date_creation = this.date_creation;
        patient = this.patient;
    }
    Dossier get_or_create_dossier() {
		return null;
    };
    
    public static Dossier dossier_patient_existe(int telephone) {
		/**
		 * Cherche le patient dans la base de donn�es grace � son num�ro de t�l�phone.
		 */
		for(Dossier element:tous_les_dossiers) {
			if (element.patient.telephone == telephone) return element;
		}
		return null;
	}
}
