package hospitalisation;

import java.util.ArrayList;

public class Hopital {
    String nom_complet, adresse;
    ArrayList<Salle_hospitalisation> salles = new ArrayList<>();
    ArrayList<Employe> employes = new ArrayList<>();
    public Hopital(String nom_complet, String adresse){
        nom_complet = this.nom_complet;
        adresse = this.adresse;
    }
    public Lits avoir_lit_disponible(){
        for (Salle_hospitalisation element:salles){
            for(Lits lit : element.lits){
                if (!lit.estOccupe) return lit;
            }
        }
        return null;
    }
    public static Hopital populate() {
    	/**
    	 * Fonction pour g�n�rer rapidement un hopital pour les besoins de test.
    	 */
    	Hopital hopital = new Hopital("Sokhna Cambell", "Cit� Niakh");
    	hopital.employes.add(Personnel_medical.populate());
    	hopital.employes.add(Personnel_administratif.populate());
    	ArrayList<Lits> lits = new ArrayList<>();
    	lits.add(new Lits(3));
    	Salle_hospitalisation salle = new Salle_hospitalisation("E", 12, lits);
    	hopital.salles.add(salle);
    	return hopital;
    	
    }
    @Override
    public String toString() {
        return "Hopital{" +
                "nom_complet='" + nom_complet + '\'' +
                ", adresse='" + adresse + '\'' +
                ", personnel='" + employes + '\'' +
                ", salles='" + salles + '\'' +
                '}';
    }
}
