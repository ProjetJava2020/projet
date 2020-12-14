package hospitalisation;


public class Employe {
    String prenom, nom, genre;
    int telephone;
    String date_de_naissance;
    public Employe(String prenom, String nom, int telephone, String date_de_naissance, String genre){
        this.prenom = prenom;
        this.nom = nom;
        this.telephone = telephone;
        this.date_de_naissance = date_de_naissance;
        this.genre = genre;
    }
    @Override
    public String toString() {
    	return "{Prenom:" +prenom + "/nom:" + nom + "/genre:" + genre + "/téléphone: "+ telephone;
    }
}