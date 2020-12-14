package hospitalisation;

import java.text.DateFormat;
import java.util.Date;

public class Examen {
	Patient patient;
	String date_examen;
	String type;
	String imagerie;

	public Examen(String date_examen, String type, String imagerie) {
		date_examen = this.date_examen;
		type = this.type;
		imagerie = this.imagerie;
	}

	public static Examen creer_examen(Patient patient) {
		/**
		 * Ceci est une fonction static nous permettant de creer un exmamen pour le
		 * dossier medical du patient.
		 */
		String date_examen = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT).format(new Date());
		String type = CustomScanner.scan("Entrer le type d'examen");
		String imagerie = CustomScanner.scan("Entrer le path de l'image");
		return new Examen(date_examen, type, imagerie);
	}

	@Override
	public String toString() {
		/**
		 * Affichage de l'examen.
		 */
		return "Examen{date_examen=" + date_examen + ", type='" + type + '\'' + ", imagerie='" + imagerie + '\'' + '}';
	}
}
