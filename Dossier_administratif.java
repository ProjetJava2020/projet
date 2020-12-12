package hospitalisation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Dossier_administratif extends Dossier{
    Date date_adhesion, date_sortie;
    ArrayList<Factures> factures;
    public Dossier_administratif(Date date_creation, Patients patient,Date date_adhesion, Date date_sortie, ArrayList<Factures> factures){
        super(date_creation, patient);
        date_adhesion = this.date_adhesion;
        date_sortie = this.date_sortie;
        factures = this.factures;
    }

    @Override
    Dossier getCreate_dossier() {
        return null;
    }

    @Override
    public String toString() {
        return "Dossier_administratif{" +
                "date_adhesion=" + date_adhesion +
                ", date_sortie=" + date_sortie +
                ", factures=" + factures +
                '}';
    }

    public void setFactures(ArrayList<Factures> factures, Factures facture) {
        this.factures = factures;
        factures.add(facture);
    }
}
