package hospitalisation;

import java.util.Scanner;

public class CustomScanner {
	static Scanner scanner = new Scanner(System.in);

	public static String scan(String message) {
		/**
		 * C'est une m�thode statique qui nous permettra de r�cup�rer les donn�es
		 * saisies au clavier.
		 */
		System.out.println(message + ": ");
		String input = scanner.nextLine();
		return input;
	}
}
