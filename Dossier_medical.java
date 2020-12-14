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
	/***
	 * Le personnel mÃ¯Â¿Â½dical entre en premier lieux le numÃ¯Â¿Â½ro de
	 * tÃ¯Â¿Â½lÃ¯Â¿Â½phone. S'il correspond Ã¯Â¿Â½ un patient existent, le dossier
	 * est directement retournÃ¯Â¿Â½. Sinon, il continue Ã¯Â¿Â½ entrer les autres
	 * informations
	 */
	@Override
	Dossier get_or_create_dossier() {
		
		String creation = new SimpleDateFormat("dd-MM-yy").format(new Date());
		int numero = Integer.parseInt(CustomScanner.scan("Entrer le numéro de téléphone"));
		if (Dossier_medical.dossier_patient_existe(numero) != null)
			return Dossier_medical.dossier_patient_existe(numero);

		Patient patient = new Patient(CustomScanner.scan("Entrer le nom"), CustomScanner.scan("Entrer le prÃ©nom"),
				CustomScanner.scan("Entrer le genre (M/F)").toCharArray()[0],
				CustomScanner.scan("Entrer la date de naissance"), numero, CustomScanner.scan("Entrer l'adresse"));
		String groupe = CustomScanner.scan("Entrer le groupe sanguin");
		String allergies = CustomScanner.scan("Lister les allergies séparées par des virgules");
		return new Dossier_medical(creation, patient, groupe, allergies);
	}

	public Controle_medical effectuer_controle_medical() {
		return Controle_medical.ajouter_controle_medical();
	}

	public Examen ajouter_examen() {
		return Examen.creer_examen(this.patient);
	}

	public void attribuer_medecin(String prenom, String nom, int numero, Hopital hopital) {
		for (Employe personnel : hopital.employes) {
			try {
				if (personnel.prenom == prenom && personnel.nom == nom && personnel.telephone == numero
						&& ((Personnel_medical) personnel).titre == "medecin")
				{
					this.medecin_traitant = (Personnel_medical) personnel;
					System.out.println("Le médecin " +  personnel + "a correctement été attribué!");
					return;
				}
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println("Médecin introuvable.");
	}
	/**
	 * Cette fonction permet d'attribuer un lit au patient. Pour cela, on s'aide de
	 * la fonction avoir_lit_disponible qui renvoie le premier lit non-occupÃ©.
	 * @param hopital
	 */
	public void attribuer_lit(Hopital hopital) {
		
		Lits lit = hopital.avoir_lit_disponible();
		if (lit != null) {
			autres_informations.put("lit", lit);
			lit.estOccupe = true;
			System.out.println("Le lit" + lit.numero_lit + "a bien été attribué");
		} else {
			System.out.println("Pas de lit disponible.");
		}

	}

	/**
	 * C'est l'affichage gÃ©nÃ©ral du dossier mÃ©dical qui peut Ãªtre fait par tout
	 * le personnel.
	 */
	public void affichage_general() {
		
		System.out.println("Dossier_medical{patient=" + this.patient + '\'' + "groupe_sanguin='" + groupe_sanguin + '\''
				+ ", allergies='" + allergies + '\'' + '}');
	}
	/**
	 * C'est l'affichage gÃ©nral du dossier mÃ©dical rÃ©servÃ© uniquement au
	 * mÃ©decin.
	 */
	public void affichage_detaille() {
		
		System.out.println("Dossier_medical{patient=" + this.patient + '\'' + "groupe_sanguin='" + groupe_sanguin + '\''
				+ ", allergies='" + allergies + '\'' + ", autres_informations='" + autres_informations + '\'' + '}');
	}
	/**
	 * Cherche le patient dans la base de donnï¿½es grace ï¿½ son numï¿½ro de
	 * tï¿½lï¿½phone.
	 * @param numero_telephone
	 * @return dossier_medical
	 */
	public static Dossier_medical dossier_patient_existe(int telephone) {
		
		for (Dossier_medical element : dossier_medicaux) {
			if (element.patient.telephone == telephone)
				return element;
		}
		return null;
	}
	/**
	 * Pour afficher l'ensemble des dossiers médicaux.
	 */
	public static void afficher_dossiers_medicaux() {
		
		for (Dossier_medical dossier : dossier_medicaux) {
			System.out.println(dossier);
		}
	}
	/**
	 * C'est l'affichage gÃ©nÃ©ral du dossier mÃ©dical qui peut Ãªtre fait par tout
	 * le personnel.
	 */
	public String toString() {
		
		return "Dossier_medical{patient=" + this.patient + '\'' + "groupe_sanguin='" + groupe_sanguin + '\''
				+ ", allergies='" + allergies + '\'' + '}';
	}
	/**
	 * Enter d'atres informations relatives au dossier médical.
	 * @param titre
	 * @param description
	 * @return description
	 */
	public Object entrer_autres_informations(String titre, Object description) {
		autres_informations.put(titre, description);
		return autres_informations.get(titre);
		
	}
	/**
	 * Générer rapidement un dossier médical à des fins de test.
	 * @return dossier medical
	 */
	public static Dossier_medical populate() {
		Dossier_medical dossier = new Dossier_medical("17-03-202",
				new Patient("Ali", "Mbaye Nder", 'M', "17-09-1999", 776735974, "Mbour3"), "O+", "");
		dossier_medicaux.add(dossier);
		return dossier;
	}
	

}