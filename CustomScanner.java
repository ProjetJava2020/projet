package hospitalisation;

import java.util.Scanner;

public class CustomScanner {
	public static String scan(String message) {
		/**
		 * C'est une m�thode statique qui nous permettra de r�cup�rer les donn�es saisies au clavier.
		 */
		Scanner scan = new Scanner(System.in);
		System.out.println(message + ": ");
		String input = scan.nextLine();
		scan.close();
		return input;
	}
}
