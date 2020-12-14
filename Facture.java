package hospitalisation;

/**
 * The Class Facture.
 */
public class Facture {
    String service, mutuelle;
    String date;
    float montant;

    public Facture(String service, String date, float montant, String mutuelle) {
        service = this.service;
        date = this.date;
        montant = this.montant;
        mutuelle = this.mutuelle;
    }

    @Override
    public String toString() {
        return "Factures{" + "service='" + service + '\'' + ", mutuelle='" + mutuelle + '\'' + ", date=" + date
                + ", montant=" + montant + '}';
    }
    /**
     * Fonction pour créer une nouvelle facture.
     */
    public static Facture etablir_facture() {
        
        String service = "Analyses Medicales";
        String date = CustomScanner.scan("Entrer la date de facturation");
        float montant = Float.parseFloat(CustomScanner.scan("Entrer le montant de la facture"));
        String mutuelle = CustomScanner.scan("Entrer le nom de la mutuelle");
        return new Facture(service, date, montant, mutuelle);
    }

    /**
	 * Gets the montant.
	 *
	 * @param facture
	 *            the facture
	 * @return the montant
	 */
    public float getMontant(Facture facture) {
        return facture.montant;
    }
}