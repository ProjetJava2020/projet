package hospitalisation;

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
		this.telephone = telephone;
		System.out.println(telephone);
	}
	
	
	@Override
	public String toString() {
		return "Patients{" + "nom='" + nom + '\'' + ", prenom='" + prenom + '\'' + ", adresse='" + adresse + '\'' + '}';
	}


}
