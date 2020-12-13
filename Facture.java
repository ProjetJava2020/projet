package hospitalisation;

import java.text.DateFormat;
import java.util.Date;

public class Facture {
    String service, mutuelle;
    String date;
    float montant;
    public Facture(String service, String date, float montant, String mutuelle){
        service = this.service;
        date = this.date;
        montant = this.montant;
        mutuelle = this.mutuelle;
    }

    @Override
    public String toString() {
        if (this.mutuelle != null) {
            return "Factures{" +
                    "service='" + service + '\'' +
                    ", mutuelle='" + mutuelle + '\'' +
                    ", date=" + date +
                    ", montant=" + montant +
                    '}';
        }
        return "Factures{" +
                "service='" + service + '\'' +
                ", mutuelle='" + "Pas de mutuelle" + '\'' +
                ", date=" + date +
                ", montant=" + montant +
                '}';
    }

    public static Facture etablir_facture(){
    	/**
    	 * Fonction pour créer une nouvelle facture.
    	 */
    	String service = "Analyses Medicales";
    	String date = DateFormat.getDateTimeInstance(
				DateFormat.SHORT,
				DateFormat.SHORT
		).format(new Date());
    	float montant = 10000.0f;
    	String mutuelle = "Ndimbeul Ndiaboot";
        return new Facture(service, date, montant, mutuelle);
    }

    public float getMontant(Facture facture) {
        return facture.montant;
    }
}
