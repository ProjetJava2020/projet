package hospitalisation;


@SuppressWarnings("rawtypes")
public class Employe <T extends Employe> {
    String prenom, nom, genre;
    int telephone;
    String date_de_naissance;
    T employer;
    public Employe(String prenom, String nom, int telephone, String date_de_naissance, String genre){
        this.prenom = prenom;
        this.nom = nom;
        this.telephone = telephone;
        this.date_de_naissance = date_de_naissance;
        this.genre = genre;
    }
    /**
     * C'est un constructeur pour creer un personnel medical.
     * @param prenom
     * @param nom
     * @param telephone
     * @param date_de_naissance
     * @param genre
     * @param titre
     * @param specialite
     */
	@SuppressWarnings("unchecked")
	public Employe(String prenom, String nom, int telephone, String date_de_naissance,
			String genre, String titre, String specialite)
	{
		
        employer = (T) new Personnel_medical(prenom, nom, telephone, date_de_naissance, 
        		genre, titre, specialite);
    }
	
	/**
	 * C'est un constructeur pour instancier un personnel administratif.
	 * @param prenom
	 * @param nom
	 * @param telephone
	 * @param date_de_naissance
	 * @param genre
	 * @param role
	 */
	@SuppressWarnings("unchecked")
	public  Employe(String prenom, String nom, int telephone, String date_de_naissance, 
			String genre, String role)
	{
		employer = (T) new Personnel_administratif(prenom, nom, telephone, date_de_naissance, genre, role);
    }
	
    @Override
    public String toString() {
    	return "{Prenom:" +prenom + "/nom:" + nom + "/genre:" + genre + "/téléphone: "+ telephone;
    }
}