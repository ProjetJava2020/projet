package hospitalisation;

import java.util.ArrayList;

public class Hopital {
    String nom_complet, adresse;
    ArrayList<Salle_hospitalisation> salles = new ArrayList<>();

    public Hopital(String nom_complet, String adresse){
        nom_complet = this.nom_complet;
        adresse = this.adresse;
    }
    public Lits avoir_lit_disponible(){
        for (Salle_hospitalisation element:salles){
            for(Lits lit : element.lits){
                if (!lit.estOccupe) return lit;
            }
            System.out.println("Pas de lits disponibles pour le moment");
        }
        return null;
    }
    @Override
    public String toString() {
        return "Hopital{" +
                "nom_complet='" + nom_complet + '\'' +
                ", adresse='" + adresse + '\'' +
                '}';
    }
}
