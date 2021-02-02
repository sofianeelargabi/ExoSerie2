package exosWRSerie2;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Exo1 {

	public static void main(String[] args) {

		String path = "C:/Users/afpa/eclipse-workspace/IoProject";
		testFile(path);
		
	}

	public static void testFile(String path) {
		File file = new File(path);

		System.out.println("Path exists ? " + file.exists());
		System.out.println("File is Directory ? " + file.isDirectory());
		System.out.println("File is File ? " + file.isFile());

		if (!file.exists()) {
			if (file.isFile()) {
				try {
					file.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else if (file.isDirectory()) {
				file.mkdirs();
			}
		} else if (file.exists()) {
			if (file.isDirectory()) {

				fetchSubFile(file, "");

			}
		}
	}

	public static void filterFile(final File file, String espace) {
		if (file.isDirectory()) {
			File[] children = file.listFiles();

			for (File child : children) {

				List<String> names = Arrays.asList(child.getName());
				//Conversion de la liste en stream
				Stream<String> allNames = names.stream();
				filterFile(child, espace);
				// Creation d'un autre stream avec la condition de filtre
				Stream<String> longNames = allNames.filter(str -> child.getName().endsWith(".java"));
				// Affichage des fichiers
				longNames.forEach(str -> System.out.println(str));
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