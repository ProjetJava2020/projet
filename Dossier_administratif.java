package hospitalisation;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Dossier_administratif extends Dossier {
	
	public static ArrayList<Dossier_administratif> dossiers_administratifs = new ArrayList<>(); // Variable contenant
	// l'ensemble des																					// dossiers
	// administratifs
	String date_adhesion, date_sortie;
	ArrayList<Facture> factures;

	public Dossier_administratif(String date_creation, Patient patient, String date_adhesion) {
		super(date_creation, patient);
		this.date_adhesion = date_adhesion;
	}
	/**
	 * Cherche le patient dans la base de donn�es grace � son num�ro de t�l�phone.
	 */
	public static Dossier dossier_patient_existe(int telephone) {
		
		for(Dossier element:dossiers_administratifs) {
			if (element.patient.telephone == telephone) return element;
		}
		return null;
	}
	public Dossier_administratif() {}

	/***
	 * Le personnel administratif entre en premier lieux le numï¿½ro de
	 * tï¿½lï¿½phone. S'il correspond ï¿½ un patient existent, le dossier est
	 * directement retournï¿½. Sinon, il continue ï¿½ entrer les autres informations
	 */

	@Override
	Dossier get_or_create_dossier() {
				String creation = new SimpleDateFormat("dd-MM-yy").format(new Date());
		int numero = Integer.parseInt(CustomScanner.scan("Entrer le numéro de téléphone"));

		if (Dossier_administratif.dossier_patient_existe(numero) != null)
			return Dossier_administratif.dossier_patient_existe(numero);
		String date_adhesion = CustomScanner.scan("Entrer la date d'adhésion");

		Patient patient = new Patient(CustomScanner.scan("Entrer le nom"), CustomScanner.scan("Entrer le prénom"),
				CustomScanner.scan("Entrer le genre (M/F)").toCharArray()[0],
				CustomScanner.scan("Entrer la date de naissance"), numero, CustomScanner.scan("Entrer l'adresse"));
		return new Dossier_administratif(creation, patient, date_adhesion);
	}

	@Override
	public String toString() {
		return "Dossier_administratif{" + "date_adhesion=" + date_adhesion + ", date_sortie=" + date_sortie
				+ ", factures=" + factures + '}';
	}
	/**
	 * Pour afficher l'ensemble des dossiers m�dicaux.
	 */
	public static void afficher_dossiers_administratifs() {
		
		for (Dossier_administratif dossier : dossiers_administratifs) {
			System.out.println(dossier);
		}
	}
	/**
	 * Ajouter une nouvelle facture au dossier administratif.
	 */
	public void ajouter_facture() {
		factures.add(Facture.etablir_facture());
	}
	
	/**
	 * G�n�rer rapidement un dossier administratif
	 * @return
	 */
	public static Dossier_administratif populate() {
		Dossier_administratif dossier = new Dossier_administratif("17-03-202", new Patient("Alioune", "Sarr", 'M', "17-09-1992",776735974, "Mbour3"), "17-03-202");
		dossiers_administratifs.add(dossier);
    	return dossier;
    }
}