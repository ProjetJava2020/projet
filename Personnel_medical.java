package hospitalisation;

import java.util.ArrayList;

public class Personnel_medical extends Employe{
	public static ArrayList<Personnel_medical> personnels_medicaux = new ArrayList<Personnel_medical>();
    String titre, specialite;

    public Personnel_medical(String prenom, String nom, int telephone, String date_de_naissance, String genre, String titre, String specialite){
        super(prenom,nom,telephone,date_de_naissance,genre);
        titre = this.titre;
        specialite = this.specialite;
    }
    
    public static Personnel_medical populate() {
    	/**
    	 * Fonction pour générer rapidement un personnel médical pour les besoins de test.
    	 */
    	personnels_medicaux.add(new Personnel_medical("Alioune", "Sarr", 785555534, "17-09-1992", "M", "medecin", "Ophtalmologue"));
    	return personnels_medicaux.get(0);
    }
    
}
