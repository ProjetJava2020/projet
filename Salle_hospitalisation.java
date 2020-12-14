package hospitalisation;

import java.util.ArrayList;

public class Salle_hospitalisation {
    String batiment;
    int numero_salle;
    ArrayList<Lits> lits = new ArrayList<>();

    public Salle_hospitalisation(String batiment, int numero_salle, ArrayList<Lits> lits) {
        batiment = this.batiment;
        numero_salle = this.numero_salle;
        lits = this.lits;
    }

    @Override
    public String toString() {
        return "Salle_hospitalisation{" + "batiment='" + batiment + '\'' + ", numero_salle=" + numero_salle + '}';
    }
}