package hospitalisation;

import java.util.Date;

public class Personnel_medical extends Employe{
    String titre, specialite;

    public Personnel_medical(String prenom, String nom, int telephone, String date_de_naissance, String genre, String titre, String specialite){
        super(prenom,nom,telephone,date_de_naissance,genre);
        titre = this.titre;
        specialite = this.specialite;
    }

}