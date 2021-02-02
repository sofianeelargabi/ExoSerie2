package exosWRSerie2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Scanner;

public class Exo5 {

	public static void main(String[] args) {
		contientMot();
	}

	public static String contientMot() {
		Scanner scan = new Scanner(System.in);
		String mot = null;
		try {
			InputStream is = new FileInputStream("testo");
			Reader reader = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(reader);
			String s = null;
			int i = 0;
			System.out.println("Veuillez entrer le mot à rechercher : ");
			mot = scan.next();
			while ((s = br.readLine()) != null) {
				i++;
				if (s.contains(mot)) {

					System.out.println("(" + i + ":" + s.indexOf(mot) + ")" + s);
				}
			}

			br.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();

		}
		return mot;

	}

}
