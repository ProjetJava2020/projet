package hospitalisation;

import java.util.ArrayList;

public class Salle_hospitalisation {
    String batiment;
    int numero_salle;
    ArrayList<Lits> lits = new ArrayList<>();
    ArrayList<Salle_hospitalisation> salles = new ArrayList<>();
    public  Salle_hospitalisation(String batiment, int numero_salle, ArrayList<Lits> lits){
        batiment = this.batiment;
        numero_salle = this.numero_salle;
        lits = this.lits;
    }

    @Override
    public String toString() {
        return "Salle_hospitalisation{" +
                "batiment='" + batiment + '\'' +
                ", numero_salle=" + numero_salle +
                '}';
    }
    public ArrayList<Lits> get_lits_disponibles(){
        for (Salle_hospitalisation element:salles){
            if (element.lits != null){
                return element.lits;
            }
            System.out.println("Pas de lits disponibles pour le moment");
        }
        return null;
    }
    public Dossier_medical attribuer_lit(){
        lits = get_lits_disponibles();
        int telephone= 11111;
        Dossier_medical dossier_medical = (Dossier_medical) Dossier_medical.dossier_patient_existe(telephone);
        for (Lits element:lits){
            if (element != null){
                dossier_medical.autres_informations.put("lit", lits.get(0));
                return dossier_medical;
            }
            System.out.println("Pas de lits disponibles pour le moment");
        }
        Lits lit =  lits.get(0);
        salles.remove(lit);
        return null;
    }
    public void liberer_lit() {
        int telephone= 11111;
        Dossier_medical dossier_medical = (Dossier_medical) Dossier_medical.dossier_patient_existe(telephone);
        Lits lit = (Lits) dossier_medical.autres_informations.get("lit");
        dossier_medical.autres_informations.remove("lit");
        for(Salle_hospitalisation element: salles){
            if(element.numero_salle == lit.numero_salle){
                salles.add(element);
            }
        }
    }
}
