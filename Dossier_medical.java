package hospitalisation;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Dossier_medical extends Dossier {

	public static ArrayList<Dossier_medical> dossier_medicaux = new ArrayList<Dossier_medical>();

	String groupe_sanguin, allergies;
	Personnel_medical medecin_traitant;
	HashMap<String, Object> autres_informations;
	ArrayList<Controle_medical> controles_medicaux = new ArrayList<Controle_medical>();

	public Dossier_medical(String date_creation, Patient patient, String groupe_sanguin, String allergies) {
		super(date_creation, patient);
		System.out.println(patient);
		this.groupe_sanguin = groupe_sanguin;
		this.allergies = allergies;
	}

	public Dossier_medical() {
	}

	@Override
	Dossier get_or_create_dossier() {
		/***
		 * Le personnel mï¿½dical entre en premier lieux le numï¿½ro de
		 * tï¿½lï¿½phone. S'il correspond ï¿½ un patient existent, le dossier
		 * est directement retournï¿½. Sinon, il continue ï¿½ entrer les autres
		 * informations
		 */
		String creation = new SimpleDateFormat("dd-MM-yy").format(new Date());
		int numero = Integer.parseInt(CustomScanner.scan("Entrer le num�ro de t�l�phone"));
		if (Dossier_medical.dossier_patient_existe(numero) != null)
			return Dossier_medical.dossier_patient_existe(numero);

		Patient patient = new Patient(CustomScanner.scan("Entrer le nom"), CustomScanner.scan("Entrer le prénom"),
				CustomScanner.scan("Entrer le genre (M/F)").toCharArray()[0],
				CustomScanner.scan("Entrer la date de naissance"), numero, CustomScanner.scan("Entrer l'adresse"));
		String groupe = CustomScanner.scan("Entrer le groupe sanguin");
		String allergies = CustomScanner.scan("Lister les allergies s�par�es par des virgules");
		return new Dossier_medical(creation, patient, groupe, allergies);
	}

	public Controle_medical effectuer_controle_medical() {
		return Controle_medical.ajouter_controle_medical();
	}

	public Examen ajouter_examen() {
		return Examen.creer_examen(this.patient);
	}

	public void attribuer_medecin(String prenom, String nom, int numero) {
		for (Personnel_medical personnel : Personnel_medical.personnels_medicaux) {
			if (personnel.prenom == prenom && personnel.nom == nom && personnel.telephone == numero
					&& personnel.titre == "medecin")
			{
				this.medecin_traitant = personnel;
				System.out.println("Le m�decin " +  personnel + "a correctement �t� attribu�!");
				return;
			}
			
		}
		System.out.println("M�decin introuvable.");
	}

	public void attribuer_lit(Hopital hopital) {
		/**
		 * Cette fonction permet d'attribuer un lit au patient. Pour cela, on s'aide de
		 * la fonction avoir_lit_disponible qui renvoie le premier lit non-occupé.
		 */
		Lits lit = hopital.avoir_lit_disponible();
		if (lit != null) {
			autres_informations.put("lit", lit);
			lit.estOccupe = true;
			System.out.println("Le lit" + lit.numero_lit + "a bien �t� attribu�");
		} else {
			System.out.println("Pas de lit disponible.");
		}

	}

	public void affichage_general() {
		/**
		 * C'est l'affichage général du dossier médical qui peut être fait par tout
		 * le personnel.
		 */
		System.out.println("Dossier_medical{patient=" + this.patient + '\'' + "groupe_sanguin='" + groupe_sanguin + '\''
				+ ", allergies='" + allergies + '\'' + '}');
	}

	public void affichage_detaille() {
		/**
		 * C'est l'affichage génral du dossier médical réservé uniquement au
		 * médecin.
		 */
		System.out.println("Dossier_medical{patient=" + this.patient + '\'' + "groupe_sanguin='" + groupe_sanguin + '\''
				+ ", allergies='" + allergies + '\'' + ", autres_informations='" + autres_informations + '\'' + '}');
	}

	public static Dossier_medical dossier_patient_existe(int telephone) {
		/**
		 * Cherche le patient dans la base de donn�es grace � son num�ro de
		 * t�l�phone.
		 */
		for (Dossier_medical element : dossier_medicaux) {
			System.out.println(element.patient.telephone);
			if (element.patient.telephone == telephone)
				return element;
		}
		return null;
	}

	public static void afficher_dossiers_medicaux() {
		/**
		 * Pour afficher l'ensemble des dossiers m�dicaux.
		 */
		for (Dossier_medical dossier : dossier_medicaux) {
			System.out.println(dossier);
		}
	}

	public Dossier_medical entrer_autres_informations(String titre, Object description) {
		autres_informations.put(titre, description);
		return (Dossier_medical) autres_informations.get(titre);
		
	}

	public static Dossier_medical populate() {
		Dossier_medical dossier = new Dossier_medical("17-03-202",
				new Patient("Ali", "Mbaye Nder", 'M', "17-09-1999", 11, "Mbour3"), "O+", "");
		dossier_medicaux.add(dossier);
		return dossier;
	}

}