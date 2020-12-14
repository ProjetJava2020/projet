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
		date_adhesion = this.date_adhesion;
	}

	@Override
	Dossier get_or_create_dossier() {
		/***
		 * Le personnel administratif entre en premier lieux le numï¿½ro de
		 * tï¿½lï¿½phone. S'il correspond ï¿½ un patient existent, le dossier est
		 * directement retournï¿½. Sinon, il continue ï¿½ entrer les autres informations
		 */
		String creation = new SimpleDateFormat("dd-MM-yy").format(new Date());
		int numero = Integer.parseInt(CustomScanner.scan("Entrer le numéro de téléphone"));

		if (Dossier.dossier_patient_existe(numero) != null)
			return Dossier.dossier_patient_existe(numero);
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

	public void ajouter_facture() {
		factures.add(Facture.etablir_facture());
	}
}