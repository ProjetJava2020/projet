package hospitalisation;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Dossier_medical extends Dossier {
	
	public static ArrayList<Dossier_medical> tous_les_dossiers = new ArrayList<>();

	String groupe_sanguin, allergies;
	Personnel_medical medecin_traitant;
	HashMap<String, Object> autres_informations;
	ArrayList<Controle_medical> controles_medicaux = new ArrayList<Controle_medical>();

    public Dossier_medical(String date_creation, Patient patient, String groupe_sanguin, String allergies) {
        super(date_creation, patient);
        groupe_sanguin = this.groupe_sanguin;
        allergies = this.allergies;
    }

    @Override
    Dossier get_or_create_dossier() {
        /***
         * Le personnel mï¿½dical entre en premier lieux le numï¿½ro de tï¿½lï¿½phone.
         * S'il correspond ï¿½ un patient existent, le dossier est directement
         * retournï¿½. Sinon, il continue ï¿½ entrer les autres informations
         */
        String creation = new SimpleDateFormat("dd-MM-yy").format(new Date());
        int numero = 776735974;
        if (Dossier.dossier_patient_existe(numero) != null)
            return Dossier.dossier_patient_existe(numero);

        Patient patient = new Patient(CustomScanner.scan("Entrer le nom"), CustomScanner.scan("Entrer le prénom"),
                CustomScanner.scan("Entrer le genre (M/F)").toCharArray()[0],
                CustomScanner.scan("Entrer la date de naissance"), numero, CustomScanner.scan("Entrer l'adresse"));

        return new Dossier_medical(creation, patient, "O+", "");
    }

    public Controle_medical effectuer_controle_medical() {
        return Controle_medical.ajouter_controle_medical();
    }

    public Examen ajouter_examen() {
        return Examen.creer_examen(this.patient);
    }

    public void attribuer_medecin(Personnel_medical medecin) {
        this.medecin_traitant = medecin;
    }

    public void attribuer_lit(Hopital hopital) {
        /**
         * Cette fonction permet d'attribuer un lit au patient. Pour cela, on s'aide de
         * la fonction avoir_lit_disponible qui renvoie le premier lit non-occupé.
         */
        Lits lit = hopital.avoir_lit_disponible();
        autres_informations.put("lit", lit);
        lit.estOccupe = true;
    }

    public void affichage_general() {
        /**
         * C'est l'affichage général du dossier médical qui peut être fait par tout le personnel.
         */
        System.out.println("Dossier_medical{" + "groupe_sanguin='" + groupe_sanguin + '\'' + ", allergies='" + allergies
                + '\'' + '}');
    }

    public void affichage_detaille() {
        /**
         * C'est l'affichage génral du dossier médical réservé uniquement au médecin.
         */
        System.out.println("Dossier_medical{" + "groupe_sanguin='" + groupe_sanguin + '\'' + ", allergies='" + allergies
                + '\'' + ", autres_informations='" + autres_informations + '\'' + '}');
    }

    public Dossier_medical set_autres_informations() {
        return null;
    }
    public static Dossier_medical populate() {
    	Dossier_medical dossier = new Dossier_medical("17-03-202", new Patient("Ali", "Mbaye Nder", 'M', "17-09-1999",776735974, "Mbour3"), "O+", "");
		tous_les_dossiers.add(dossier);
    	return dossier;
    }

}