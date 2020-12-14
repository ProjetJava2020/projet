package hospitalisation;


public class Personnel_medical extends Employe{
    String titre, specialite;

    public Personnel_medical(String prenom, String nom, int telephone, String date_de_naissance, String genre, String titre, String specialite){
        super(prenom,nom,telephone,date_de_naissance,genre);
        titre = this.titre;
        specialite = this.specialite;
    }
    
    public static Personnel_medical populate() {
    	return new Personnel_medical("Alioune", "Sarr", 785555534, "17-09-1992", "M", "medecin", "Ophtalmologue");
    }
    
}
