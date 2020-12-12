package hospitalisation;

import java.util.Date;

public class Employe {
    String prenom, nom, genre;
    int telephone;
    Date date_de_naissance;
    public Employe(String prenom, String nom, int telephone, Date date_de_naissance, String genre){
        prenom = this.prenom;
        nom = this.nom;
        telephone = this.telephone;
        date_de_naissance = this.date_de_naissance;
        genre = this.genre;
    }
}
