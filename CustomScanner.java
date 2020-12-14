package hospitalisation;

import java.util.Scanner;

public class CustomScanner {
    static Scanner scanner = new Scanner(System.in);
    public static String scan(String message) {
        /**
         * C'est une méthode statique qui nous permettra de récupérer les données saisies au clavier.
         */
        System.out.println(message + ": ");
        String input = scanner.next();
        return input;
    }
}
