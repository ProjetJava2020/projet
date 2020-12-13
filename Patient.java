package hospitalisation;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Patient {
	public String prenom, nom, adresse;
	char sexe;
	String date_de_naissance;
	int telephone;

	public Patient(String prenom, String nom, char sexe, String date_de_naissance, int telephone, String adresse) {
		this.prenom = prenom;
		this.nom = nom;
		this.sexe = sexe;
		this.date_de_naissance = date_de_naissance;// new SimpleDateFormat("ddMMyy").format(new Date());
		this.adresse = adresse;
	}
	
	
	@Override
	public String toString() {
		return "Patients{" + "nom='" + nom + '\'' + ", prenom='" + prenom + '\'' + ", adresse='" + adresse + '\'' + '}';
	}

}
