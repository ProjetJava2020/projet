package hospitalisation;

public class AliMain {
    public static void main(String[] args) {
        int rep;
        do {

            System.out.println("se connecter en tant que :");

            System.out.println("1:M�decin");

            System.out.println("2:Infirmier");

            System.out.println("3:Comptable");

            System.out.println("4:R�ceptionniste");

            rep = Integer.parseInt(CustomScanner.scan("choix"));
            switch (rep) {
                case 1:
                    do {

                        System.out.println("Actions :");

                        System.out.println("1:Afficher dossier m�dical patient");

                        System.out.println("2:Afficher l'ensemble des dossiers m�dicaux");
                        rep = Integer.parseInt(CustomScanner.scan("choix"));
                        switch (rep) {
                            case 1:
                                Dossier_medical dossier = (Dossier_medical) Dossier_medical.dossier_patient_existe(Integer.parseInt(CustomScanner.scan("Num�ro t�l�phone")));
                                dossier.affichage_detaille();
                                do {
                                    System.out.println("Actions :");
                                    System.out.println("1:Ajouter examen");
                                    rep = Integer.parseInt(CustomScanner.scan("choix"));

                                    switch (rep) {
                                        case 1:
                                            dossier.ajouter_examen();
                                        default:
                                            System.out.println("entrer 1");
                                    }
                                } while (rep != 1);

                                break;
                            case 2:
                                System.out.println(Dossier_medical.tous_les_dossiers);
                                break;
                            default:
                                System.out.println("entrer 1 ou 2");
                        }
                    } while (rep != 2);
                case 2:
                    do {

                        System.out.println("Actions :");

                        System.out.println("1:Entrer num�ro t�l�phone");

                        rep = Integer.parseInt(CustomScanner.scan("choix"));
                        switch (rep) {
                            case 1:
                                Dossier_medical dossier = (Dossier_medical) Dossier_medical.dossier_patient_existe(Integer.parseInt(CustomScanner.scan("Num�ro t�l�phone")));
                                do {
                                    System.out.println("Actions :");

                                    System.out.println("1:Afficher dossier m�dical");
                                    System.out.println("2:Effectuer un contr�le m�dical");
                                    System.out.println("3:Attribuer m�decin traitant");
                                    rep = Integer.parseInt(CustomScanner.scan("choix"));
                                    switch (rep) {
                                        case 1:
                                            dossier.affichage_general();
                                            break;
                                        case 2:
                                            dossier.effectuer_controle_medical();
                                            break;
                                        case 3:
                                            dossier.attribuer_medecin(new Personnel_medical("oueee","oue",111,"aaa","M","medecin",""));
                                            break;
                                        default:
                                            System.out.println("entrer 1, 2 ou 3");
                                    }

                                } while (rep != 3);
                            default:
                                System.out.println("entrer 1");
                        }
                    } while (rep != 1);
            }
        } while (rep != 5);


    }
}