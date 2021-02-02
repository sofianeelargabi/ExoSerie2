package exosWRSerie1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Scanner;

public class Exo3Input {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		try {

			File file = new File("testo");
			file.createNewFile();
			System.out.println("Veuillez entrer le chemin du fichier");
			String chemin = scan.next();
			InputStream in = new FileInputStream(chemin);
			Reader reader = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(reader);

			String s = null;
			int i = 0;
			String count = "";
			int counter = 0;
			int nbCarac = 60;
			String v = null;
			while ((s = br.readLine()) != null) {

				if (s.length() > nbCarac) {
					counter++;
					count = String.format("% 4d", counter);
					System.out.print(count + " : ");
					int j = 0;
					while (s.length() > nbCarac) {

						if (9999 < counter) {
							return;
						}
						if (j == 0) {
							System.out.println(s.substring(0, nbCarac));
						} else {
							System.out.println("       " + s.substring(0, nbCarac));
						}
						j++;
						s = s.substring(nbCarac, s.length());
						
					}
					 v = s;
				}

				if (s.length() < nbCarac) {
					if(v!=s) {
					counter++;
					count = String.format("% 4d", counter);
					System.out.println(count + " : " + s);
				}
					else {
						count = String.format("% 4d", counter);
						System.out.println("       " +s);
					}
				}
				
			}

			br.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}