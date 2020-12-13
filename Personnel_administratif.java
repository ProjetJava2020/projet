package hospitalisation;

import java.util.Date;

public class Personnel_administratif extends Employe {
    String role;
    public  Personnel_administratif(String prenom, String nom, int telephone, Date date_de_naissance, String genre, String role){
        super(prenom,nom,telephone,date_de_naissance,genre);
        role = this.role;
    }
}
