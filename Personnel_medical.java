package hospitalisation;

import java.util.Date;

public class Personnel_medical extends Employe{
    String titre, specialite;
    public Personnel_medical(String prenom, String nom, int telephone, Date date_de_naissance, String genre, String titre, String specialite){
        super(prenom,nom,telephone,date_de_naissance,genre);
        titre = this.titre;
        specialite = this.specialite;
    }
    public Dossier_medical effectuer_controle_medical(){
        return null;
    }
    public Dossier_medical attribuer_medecin_traitant(){
        return null;
    }
}
