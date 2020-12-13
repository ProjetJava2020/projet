package hospitalisation;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Dossier_administratif extends Dossier {
	String date_adhesion, date_sortie;
	ArrayList<Facture> factures;

	public Dossier_administratif(String date_creation, Patient patient, String date_adhesion) {
		super(date_creation, patient);
		date_adhesion = this.date_adhesion;
	}

	@Override
	Dossier get_or_create_dossier() {
		/***
		 * Le personnel administratif entre en premier lieux le num�ro de t�l�phone. S'il
		 * correspond � un patient existent, le dossier est directement retourn�. Sinon,
		 * il continue � entrer les autres informations
		 */
		String creation = new SimpleDateFormat("dd-MM-yy").format(new Date());
		int numero = 776735974;
		if (Dossier.dossier_patient_existe(numero) != null)
			return Dossier.dossier_patient_existe(numero);
		String date_adhesion = "17-09-2020";

		Patient patient = new Patient(
			"Alioune", 
			"Sarr",
			'M',
			"17-09-1998", 
			776735974,
			"Mbour 3"
		);
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
