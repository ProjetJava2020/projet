package hospitalisation;

import java.time.Instant;
import java.util.Date;

public class Dossier_medical extends Dossier{
    String groupe_sanguin, allergies;
    String[] autres_informations;
    public Dossier_medical(Date date_creation, Patients patient,String groupe_sanguin, String allergies, String[] autres_informations){
        super(date_creation, patient);
        groupe_sanguin = this.groupe_sanguin;
        allergies = this.allergies;
        autres_informations = this.autres_informations;
    }
    @Override
    Dossier getCreate_dossier() {
        return null;
    }
    public Dossier_medical effectuer_controle_medical(){
        return null;
    }
    public String toString(String affichage) {
        if (affichage == "détaillé"){
            return "Dossier_medical{" +
                    "groupe_sanguin='" + groupe_sanguin + '\'' +
                    ", allergies='" + allergies + '\'' +
                    ", autres_informations='" + autres_informations + '\'' +
                    '}';
        }
        else if (affichage == "général"){
            return "Dossier_medical{" +
                    "groupe_sanguin='" + groupe_sanguin + '\'' +
                    ", allergies='" + allergies + '\'' +
                    '}';
        }
        return "Type d'affichage non pris en charge, veuillez réessayer";
        }
    public Examen ajouter_examen(Patients patient,Date date_examen, String type, String imagerie){
        Examen examen = new Examen(patient,date_examen,type,imagerie);
        return examen;
        }
    }

