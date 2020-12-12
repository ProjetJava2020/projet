package hospitalisation;

import java.util.Date;

public class Patients {
    private String prenom,nom,sexe, adresse;
    Date date_de_naissance;
    int telephone;

    public Patients(String prenom,String nom,String sexe,Date date_de_naissance,int telephone,String adresse){
        prenom = this.prenom;
        nom = this.nom;
        sexe = this.sexe;
        date_de_naissance = this.date_de_naissance;
        adresse = this.adresse;
    }

    @Override
    public String toString() {
        return "Patients{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", adresse='" + adresse + '\'' +
                '}';
    }
    public static void main(String[] args) {

    }
    }
