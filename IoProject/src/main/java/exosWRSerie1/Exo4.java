package exosWRSerie1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Exo4 {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Veuillez entrez le pathName du repertoire:");
			String pathName = sc.nextLine();

			File file = new File(pathName);
			System.out.println("Path exist ? " + file.exists());

			if (file.exists()) {
				fetchSubFile(file, "");
			} else {

				file.mkdirs();
				File[] roots = File.listRoots();
				for (File root : roots)
					System.out.println(root.getAbsolutePath());

			}
		}

	}

	public static void fetchSubFile(final File file, String espace) {
		String rep = "REPERTOIRE";
		String fich = "FICHIER";
		espace = (file.isDirectory()) ? String.valueOf(rep) : String.valueOf(fich);
		if (file.isDirectory()) {
			System.out.println(file.getName() + "  " + espace);
		} else {
			System.out.println(file.getName() + "  " + espace + " " + file.length() + " octets");
		}
		if (file.isDirectory()) {
			File[] children = file.listFiles();

			for (File child : children) {
				fetchSubFile(child, espace);
			}
		}
	}
}
