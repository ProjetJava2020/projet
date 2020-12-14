package hospitalisation;

import java.util.ArrayList;

public class Personnel_medical extends Employe {
	String titre, specialite;

	public Personnel_medical(String prenom, String nom, int telephone, String date_de_naissance, String genre,
			String titre, String specialite) {
		super(prenom, nom, telephone, date_de_naissance, genre);
		this.titre = titre;
		this.specialite = specialite;
	}

	/**
	 * Fonction pour g�n�rer rapidement un personnel m�dical pour les besoins de
	 * test.
	 * 
	 * @return personnel medical
	 */
	public static Personnel_medical populate() {
		Employe<Personnel_medical> employer = new Employe<Personnel_medical>("Alioune", "Sarr", 
				785555534, "17-09-1992","M", "medecin", "Ophtalmologue");
		return (Personnel_medical) employer.employer;
	}

}
