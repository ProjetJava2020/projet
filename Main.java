package hospitalisation;

public class Main {
	public static void continue_or_exit(int rep) {
		if (rep == 0)
			System.exit(0);
	}
	
	public static void main(String[] args) {
		Dossier_medical dossier_m;
		Dossier_administratif dossier_a;
		Dossier_medical.populate();
		Dossier_administratif.populate();
		Hopital hopital = Hopital.populate();
		System.out.println(hopital);
		System.out.println("Appuyer sur 0 lorsqu'une liste de choix s'affiche pour quitter le programme");
		int rep;
		do {

			System.out.println("se connecter en tant que :");
			System.out.println("Personnel M�dical:");
			System.out.println("1:Médecin");
			System.out.println("2:Infirmier");

			System.out.println("Personnel Administratif");
			System.out.println("3: Comptable / Receptionniste");

			rep = Integer.parseInt(CustomScanner.scan("choix"));
			continue_or_exit(rep);
			switch (rep) {
			case 1:
				do {
					System.out.println("Vous �tes connect� en tant que m�decin");
					System.out.println("Actions :");

					System.out.println("1:Ourvir un dossier médical");

					System.out.println("2:Afficher l'ensemble des dossiers médicaux");
					rep = Integer.parseInt(CustomScanner.scan("choix"));
					continue_or_exit(rep);
					switch (rep) {
					case 1:
						int numero = Integer.parseInt(CustomScanner.scan("Numéro téléphone"));
						dossier_m = Dossier_medical.dossier_patient_existe(numero);
						dossier_m.affichage_general();
						do {
							System.out.println("Actions :");
							System.out.println("1. Ajouter examen");
							System.out.println("2. Affichage d�taill�");
							System.out.println("3. Effectuer controle m�dical");
							rep = Integer.parseInt(CustomScanner.scan("choix"));
							continue_or_exit(rep);
							switch (rep) {
							case 1:
								dossier_m.ajouter_examen();
								break;
							case 2:
								dossier_m.affichage_detaille();
								break;
							case 3:
								dossier_m.effectuer_controle_medical();
							default:
								System.out.println("Choix non pris en compte!");
							}
						} while (rep != 1 && rep != 2 && rep != 3);

						break;
					case 2:
						Dossier_medical.afficher_dossiers_medicaux();
						break;
					default:
						System.out.println("entrer 1 ou 2");
						break;
					}
				} while (rep != 1 && rep != 2);
				break;
			case 2:
				do {
					System.out.println("Vous �tes connect� en tant qu'infirmier");
					System.out.println("Actions :");

					System.out.println("1. Ouvrir dossier m�dical patient");
					System.out.println("2. Creer dossier m�dical");

					rep = Integer.parseInt(CustomScanner.scan("choix"));
					continue_or_exit(rep);
					switch (rep) {
					case 1:
						dossier_m = (Dossier_medical) Dossier_medical
								.dossier_patient_existe(Integer.parseInt(CustomScanner.scan("Numéro téléphone")));
						do {
							System.out.println("Actions :");

							System.out.println("2. Effectuer un contrôle médical");
							System.out.println("3. Attribuer médecin traitant");
							System.out.println("4. Attribuer un lit");
							rep = Integer.parseInt(CustomScanner.scan("choix"));
							continue_or_exit(rep);
							switch (rep) {
							case 1:
								dossier_m.affichage_general();
								break;
							case 2:
								dossier_m.effectuer_controle_medical();
								break;
							case 3:
								dossier_m.attribuer_medecin(CustomScanner.scan("Entrer le pr�nom du m�decin"),
										CustomScanner.scan("Entrer le nom du m�decin"),
										Integer.parseInt(CustomScanner.scan("Entrer son num�ro de t�l�phone")));
								break;
							case 4:
								dossier_m.attribuer_lit(hopital);
							default:
								System.out.println("entrer 1, 2 ou 3");
							}

						} while (rep != 1 && rep != 2 && rep != 3 && rep != 4);
						break;
					case 2:
						dossier_m = (Dossier_medical) new Dossier_medical().get_or_create_dossier();
						System.out.println(dossier_m);
					default:
						System.out.println("Vous n'avez que les choix suivant:");
						break;
					}
				} while (rep != 1 && rep != 2 && rep != 3);
				break;
			case 3:
				do {
					System.out.println("Vous �tes connect� en tant que comptable/r�ceptionniste");
					System.out.println("Actions :");
					System.out.println("1. Ouvrir dossier administratif");
					System.out.println("2. Afficher tous les dossiers administratifs");
					System.out.println("3. Afficher tous les dossiers m�dicaux");
					System.out.println("4. Nouveau dossier Administatif");
					rep = Integer.parseInt(CustomScanner.scan("choix"));
					switch (rep) {
					case 1:
						dossier_a = (Dossier_administratif) Dossier_administratif
								.dossier_patient_existe(Integer.parseInt(CustomScanner.scan("Numéro téléphone")));
						System.out.println(dossier_a);
						break;
					case 2:
						Dossier_administratif.afficher_dossiers_administratifs();
						break;
					case 3:
						Dossier_medical.afficher_dossiers_medicaux();
						break;
					case 4:
						dossier_a = (Dossier_administratif) new Dossier_administratif()
								.get_or_create_dossier();
						dossier_a.toString();
					default:
						System.out.println("Entrer 1, 2, 3, ou 4.");
						break;
					}

				} while (rep != 1 && rep != 2 && rep != 3 && rep != 4);
				break;
			default:
				System.out.println("Choix non prix en compte");
				break;
			}

		} while (true);
	}
}
