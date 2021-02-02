package exosWRSerie2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Exo6Student implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nom;
	private String prenom;
	private String mdp;
	private List<Double> notes = new LinkedList<Double>();

	static HashMap<String, Exo6Student> elevenote = new HashMap<String, Exo6Student>();

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int cpt = 0;
		boolean ajout = true;
		try {

			OutputStream w = new FileOutputStream("nomDeLetudiant.student");
			ObjectOutputStream dos = new ObjectOutputStream(w);
			
			
			System.out.println("Veuillez entrer votre nom");
			String nom = scan.next();
			System.out.println("Veuillez entrer votre prénom");
			String prenom = scan.next();
			LinkedList<Double> notes = new LinkedList<Double>();
			Exo6Student e = null ;
			System.out.println("Combien de notes voulez-vous entrer ?");
			double nbNote = scan.nextDouble();
			scan.nextLine();
			while (ajout) {
				if (nbNote > 0) {
					do {
						System.out.println("Veuillez entrer votre note");
						double note = scan.nextDouble();

						if (note >= 0 && note <= 20) {
							notes.add(note);
							cpt++;
							 e = new Exo6Student(nom, prenom, "mentalist", notes);
							 elevenote.put(nom, e);
							
							
							ajout = false;

						} else {
							System.err.println("Veuillez saisir une note comprise entre 0 et 20");
							scan.nextLine();
						}
					} while (cpt < nbNote);

				} else {
					System.err.println("Le nombre de notes doit être supérieur à zéro");
					break;

				}
			}
			if (ajout==false) {
				dos.writeObject(e);
//				dos.writeObject(elevenote.get(nom).getNom());
//				dos.writeObject(elevenote.get(nom).getPrenom());
//				dos.writeObject(elevenote.get(nom).getNotes());
				w.close();
			}
		} catch (InputMismatchException e) {
			System.err.println("Saisie non valide");
			scan.nextLine();

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		moyenne();
	}

	public Exo6Student() {

	}

	public Exo6Student(String nom, String prenom, String mdp, LinkedList<Double> notes) {
		this.nom = nom;
		this.prenom = prenom;
		this.mdp = mdp;
		this.notes = notes;
	}

	public String toString() {
		return "Nom : " + nom + "  Prénom : " + prenom;

	}

	public static double moyenne() {
		Scanner scan = new Scanner(System.in);
		boolean ajout = true;
		try {
			while (ajout) {
				System.out.println("Pour quel élève souhaitez-vous afficher la moyenne, veuillez entrer son nom ?");
				String nom = scan.next();
				scan.nextLine();

				if (elevenote.containsKey(nom)) {
					if (elevenote.get(nom).getNotes().isEmpty()) {
						System.out.println("L'élève " + elevenote.get(nom).toString() + " n'a pas de notes");
					} else {
						List<Double> notesEleve = elevenote.get(nom).getNotes();
						Double noteEleve = 0.;
						Double moyenneNoteEleve = 0.;
						for (Double n : notesEleve) {
							noteEleve += n;
						}
						moyenneNoteEleve = noteEleve / notesEleve.size();
						System.out.println("L'élève " + elevenote.get(nom).toString() + " a une moyenne de :  "
								+ moyenneNoteEleve);

						return moyenneNoteEleve;
					}
				} else {
					System.err.println("Aucun élève ne correspond à votre recherche");

				}
			}
		} catch (InputMismatchException e) {
			System.err.println("Saisie non valide");
			scan.nextLine();
		} catch (NullPointerException e) {
			System.err.println("Aucun élève ne correspond à votre recherche");
			scan.nextLine();
		}
		return 0;

	}
	public String getNom() {
		return nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public String getMdp() {
		return mdp;
	}
	public List<Double> getNotes() {
		return notes;
	}
}
