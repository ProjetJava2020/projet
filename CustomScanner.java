package hospitalisation;

import java.util.Scanner;

public class CustomScanner {
    public static String scan(String message) {
        /**
         * C'est une méthode statique qui nous permettra de récupérer les données saisies au clavier.
         */
        Scanner scan = new Scanner(System.in);
        System.out.println(message + ": ");
        String input = scan.next();
        scan.close();
        return input;
    }
}
