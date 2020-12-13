package hospitalisation;

public class Lits extends Salle_hospitalisation {
    int numero_lit;
    public Lits (String batiment, int numero_salle, int numero_lit){
        super(batiment, numero_salle);
        numero_lit = this.numero_lit;
    }

    @Override
    public String toString() {
        return "Lits{" +
                "numero_lit=" + numero_lit +
                ", batiment='" + batiment + '\'' +
                ", numero_salle=" + numero_salle +
                '}';
    }

}
