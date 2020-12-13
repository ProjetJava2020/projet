package hospitalisation;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Dossier_medical extends Dossier {
	String groupe_sanguin, allergies;
	Personnel_medical medecin_traitant;
	HashMap<String, String> autres_informations;
	ArrayList<Controle_medical> controles_medicaux = new ArrayList<Controle_medical>();

	public Dossier_medical(String date_creation, Patient patient, String groupe_sanguin, String allergies) {
		super(date_creation, patient);
		groupe_sanguin = this.groupe_sanguin;
		allergies = this.allergies;
	}

	@Override
	Dossier get_or_create_dossier() {
		/***
		 * Le personnel m�dical entre en premier lieux le num�ro de t�l�phone. S'il
		 * correspond � un patient existent, le dossier est directement retourn�. Sinon,
		 * il continue � entrer les autres informations
		 */
		String creation = new SimpleDateFormat("dd-MM-yy").format(new Date());
		int numero = 776735974;
		if (Dossier.dossier_patient_existe(numero) != null)
			return Dossier.dossier_patient_existe(numero);

		Patient patient = new Patient(
			"Alioune", 
			"Sarr",
			'M',
			"17-09-1998", 
			776735974,
			"Mbour 3"
		);
		return new Dossier_medical(creation, patient, "O+", "");
	}
	
	public Controle_medical effectuer_controle_medical(){
    	return Controle_medical.ajouter_controle_medical();        
    }
   
	public Examen ajouter_examen() {
		return Examen.creer_examen(this.patient);
	}

	public void attribuer_medecin(Personnel_medical medecin) {
		this.medecin_traitant = medecin;
	}
	
	public void affichage_general() {
		System.out.println("Dossier_medical{" + "groupe_sanguin='" + groupe_sanguin + '\'' + ", allergies='" + allergies
				+ '\'' + '}');
	}

	public void affichage_detaille(Personnel_medical personnel) {
		if (personnel.titre == "medecin") {
			System.out.println("Dossier_medical{" + "groupe_sanguin='" + groupe_sanguin + '\'' + ", allergies='"
					+ allergies + '\'' + ", autres_informations='" + autres_informations + '\'' + '}');
		}
	}

}
