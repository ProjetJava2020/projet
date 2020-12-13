package hospitalisation;

import java.text.DateFormat;
import java.util.Date;

public class Controle_medical {
	String date_controle;  // La date du controle medical
	String tension_arterielle; // Exemple Diatole/Systole
	int temperature;  // En celcius
	
	Controle_medical(String tension, int temp){
		date_controle = DateFormat.getDateTimeInstance(
				DateFormat.SHORT,
				DateFormat.SHORT
		).format(new Date());
		
		temperature = temp;
	}
	
	public static Controle_medical ajouter_controle_medical() {
		/**
		 * Fonction pour ajouer une nouveau controle médical au dossier du client
		 */
		String tension_arterielle = "7/12";
		int temperature = 37;
		return new Controle_medical(tension_arterielle, temperature	);
	}
}
