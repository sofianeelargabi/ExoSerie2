package exosWRSerie1;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class Exo1Output {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int cpt=0;
//		try {
//			System.out.println("Nom du fichier à créer ?");
//			String f = scan.nextLine();
//			OutputStream w = new FileOutputStream(f);
//			DataOutputStream dos = new DataOutputStream(w);
//			System.out.println("Combien de personne voulez-vous créer ?");
//			double nbPersonne = scan.nextDouble();
//		    char [] nomTab = {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '};
//		    char [] prenomTab = {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '};
//		    char [] naissanceTab = {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '};
//			do {			
//			
//			System.out.println("Entrez le nom: ");
//			String nom = scan.next();
//			for (int i = 0; i < nomTab.length&&(i<nom.length()); i++) {
//		
//					nomTab[i]=nom.charAt(i);
//					
//				}
//			for (int i = 0; i < nomTab.length; i++) {
//				dos.writeChar(nomTab[i]);
//			}	
//			System.out.println("Entrez le prénom: ");
//			String prenom = scan.next();
//			for (int i = 0; i < prenomTab.length&&(i<prenom.length()); i++) {
//				
//				prenomTab[i]=prenom.charAt(i);
//				
//			}
//			for (int i = 0; i < prenomTab.length; i++) {
//				dos.writeChar(prenomTab[i]);
//			}	
//			
//			System.out.println("Entrez la date de naissance: ");
//			String naissance = scan.next();
//			for (int i = 0; i < naissanceTab.length&&(i<naissance.length()); i++) {
//				
//				naissanceTab[i]=naissance.charAt(i);
//				
//			}
//			for (int i = 0; i < naissanceTab.length; i++) {
//				dos.writeChar(naissanceTab[i]);
//			}	
//		
//			cpt++;
//			}
//			while (cpt<nbPersonne);
//			
//		
//
//			w.close();
//			System.out.println("****fin création****");
//		} catch (FileNotFoundException e) {
//
//			e.printStackTrace();
//		}
//
//		catch (IOException e) {
//
//			e.printStackTrace();
//		}
		
	
		try {
			System.out.println("Nom du fichier à créer ?");
			String f = scan.nextLine();
			OutputStream w = new FileOutputStream(f);
			DataOutputStream dos = new DataOutputStream(w);
			System.out.println("Combien de personne voulez-vous créer ?");
			double nbPersonne = scan.nextDouble();
		
			
			do {			
			
			System.out.println("Entrez le nom: ");
			String nom = scan.next();
			System.out.println("Entrez le prénom: ");
			String prenom = scan.next();
			System.out.println("Entrez la date de naissance: ");
			String naissance = scan.next();
			
			
			dos.writeUTF(nom);
			dos.writeUTF(prenom);
			dos.writeUTF(naissance);
			cpt++;
			}
			while (cpt<nbPersonne);
			
		

			w.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		catch (IOException e) {

			e.printStackTrace();
		}

	}

}
