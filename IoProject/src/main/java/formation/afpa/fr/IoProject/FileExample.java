package formation.afpa.fr.IoProject;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class FileExample {
public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez entrez le pathName du repertoire:");
		String pathName = sc.nextLine();
		//créer un fichier représente un chemin
		File file = new File(pathName);
	
		//verifiez s'il existe
		System.out.println("Path exist ? " +file.exists());
		
		if(file.exists()) {
			getInfosFile(file);
			fetchSubFile(file,"***");
		}else {
			//Creer le repertoire donné par le chemin
			file.mkdirs();
			File[] roots = File.listRoots();
			for(File root : roots)
				System.out.println(root.getAbsolutePath());

			getInfosFile(file);
		}
		
		String nameFile = sc.nextLine();
		File fichier = new File(pathName+"/"+nameFile);
		if(!fichier.exists()) {
			try {
				fichier.createNewFile();
				getInfosFile(fichier);
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		
		
	}

	public static void fetchSubFile(final File file, String espace) {

		espace = (file.isDirectory()) ? espace.replaceAll("\\.", "-") : espace.replaceAll("\\-", "=");
		System.out.println(espace + " " + file.getName());

		if (file.isDirectory()) {
			File[] children = file.listFiles();
			espace += "***";
			for(File child: children) {
				fetchSubFile(child,espace);
			}
		}
	}

	private static void getInfosFile(File file) {
		System.out.println("=================================");
		System.out.println("Directory ? " + file.isDirectory());
		System.out.println("Simple Name :" + file.getName());
		System.out.println("Absolute Path :" + file.getAbsolutePath());
		System.out.println("Length(bytes):" + file.length());
		long lastModifyMillis = file.lastModified();
		Date lastModifyDate = new Date(lastModifyMillis);
		System.out.println("Last modify date :" + lastModifyDate);
	}

}