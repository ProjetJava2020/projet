package hospitalisation;

import java.util.Date;

public class Examen {
    Patients patient;
    Date date_examen;
    String type;
    String imagerie;
    public Examen(Patients patient, Date date_examen, String type, String imagerie){
        patient = this.patient;
        date_examen = this.date_examen;
        type = this.type;
        imagerie = this.imagerie;
    }

    @Override
    public String toString() {
        return "Examen{" +
                "patient=" + patient +
                ", date_examen=" + date_examen +
                ", type='" + type + '\'' +
                ", imagerie='" + imagerie + '\'' +
                '}';
    }
}
