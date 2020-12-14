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
			System.out.println("Personnel Médical:");
			System.out.println("1:MÃ©decin");
			System.out.println("2:Infirmier");

			System.out.println("Personnel Administratif");
			System.out.println("3: Comptable / Receptionniste");

			rep = Integer.parseInt(CustomScanner.scan("choix"));
			continue_or_exit(rep);
			switch (rep) {
			case 1:
				do {
					System.out.println("Vous êtes connecté en tant que médecin");
					System.out.println("Actions :");

					System.out.println("1:Ourvir un dossier mÃ©dical");

					System.out.println("2:Afficher l'ensemble des dossiers mÃ©dicaux");
					rep = Integer.parseInt(CustomScanner.scan("choix"));
					continue_or_exit(rep);
					switch (rep) {
					case 1:
						int numero = Integer.parseInt(CustomScanner.scan("NumÃ©ro tÃ©lÃ©phone"));
						dossier_m = Dossier_medical.dossier_patient_existe(numero);
						dossier_m.affichage_general();
						do {
							System.out.println("Actions :");
							System.out.println("1. Ajouter examen");
							System.out.println("2. Affichage détaillé");
							System.out.println("3. Effectuer controle médical");
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
					System.out.println("Vous êtes connecté en tant qu'infirmier");
					System.out.println("Actions :");

					System.out.println("1. Ouvrir dossier médical patient");
					System.out.println("2. Creer dossier médical");

					rep = Integer.parseInt(CustomScanner.scan("choix"));
					continue_or_exit(rep);
					switch (rep) {
					case 1:
						dossier_m = (Dossier_medical) Dossier_medical
								.dossier_patient_existe(Integer.parseInt(CustomScanner.scan("NumÃ©ro tÃ©lÃ©phone")));
						do {
							System.out.println("Actions :");

							System.out.println("2. Effectuer un contrÃ´le mÃ©dical");
							System.out.println("3. Attribuer mÃ©decin traitant");
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
								dossier_m.attribuer_medecin(CustomScanner.scan("Entrer le prénom du médecin"),
										CustomScanner.scan("Entrer le nom du médecin"),
										Integer.parseInt(CustomScanner.scan("Entrer son numéro de téléphone")));
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
					System.out.println("Vous êtes connecté en tant que comptable/réceptionniste");
					System.out.println("Actions :");
					System.out.println("1. Ouvrir dossier administratif");
					System.out.println("2. Afficher tous les dossiers administratifs");
					System.out.println("3. Afficher tous les dossiers médicaux");
					System.out.println("4. Nouveau dossier Administatif");
					rep = Integer.parseInt(CustomScanner.scan("choix"));
					switch (rep) {
					case 1:
						dossier_a = (Dossier_administratif) Dossier_administratif
								.dossier_patient_existe(Integer.parseInt(CustomScanner.scan("NumÃ©ro tÃ©lÃ©phone")));
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
