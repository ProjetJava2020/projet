package hospitalisation;

public class Hopital {
    String nom_complet, adresse;
    public Hopital(String nom_complet, String adresse){
        nom_complet = this.nom_complet;
        adresse = this.adresse;
    }

    @Override
    public String toString() {
        return "Hopital{" +
                "nom_complet='" + nom_complet + '\'' +
                ", adresse='" + adresse + '\'' +
                '}';
    }
}
