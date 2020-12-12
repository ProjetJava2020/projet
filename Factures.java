package hospitalisation;

import java.util.Date;

public class Factures {
    Patients patient;
    String service, mutuelle;
    Date date;
    float montant;
    public Factures(Patients patient,String service, Date date, float montant, String mutuelle){
        patient = this.patient;
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

    public Factures etablir_facture(Patients patient,String service, Date date, Float montant, String mutuelle){
        Factures facture = new Factures(patient,service,date,montant,mutuelle);
        return facture;
    }

    public float getMontant(Factures facture) {
        return facture.montant;
    }
}
