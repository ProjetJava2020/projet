package hospitalisation;

import java.util.Date;

public abstract class Dossier {
    private Date date_creation;
    private Patients patient;
    public Dossier(Date date_creation, Patients patient){
        date_creation = this.date_creation;
        patient = this.patient;
    }
    abstract Dossier getCreate_dossier();
}
