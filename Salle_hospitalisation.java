package hospitalisation;

public class Salle_hospitalisation {
    String batiment;
    int numero_salle;
    public  Salle_hospitalisation(String batiment, int numero_salle){
        batiment = this.batiment;
        numero_salle = this.numero_salle;
    }

    @Override
    public String toString() {
        return "Salle_hospitalisation{" +
                "batiment='" + batiment + '\'' +
                ", numero_salle=" + numero_salle +
                '}';
    }
}
