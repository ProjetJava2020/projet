package hospitalisation;


public class Personnel_administratif extends Employe {
    String role;
    public  Personnel_administratif(String prenom, String nom, int telephone, String date_de_naissance, String genre, String role){
        super(prenom,nom,telephone,date_de_naissance,genre);
        role = this.role;
    }

    public static Personnel_administratif populate() {
    	return new Personnel_administratif("Alioune", "Sarr", 785555534, "17-09-1992", "M", "comptable");
    }  
}