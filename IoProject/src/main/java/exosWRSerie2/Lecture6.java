package exosWRSerie2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;


public class Lecture6 {
	public static void main(String[] args) {
		InputStream is;
		try {
			is = new FileInputStream("nomDeLetudiant.student");
			ObjectInputStream dis = new ObjectInputStream(is);

			try {
				Exo6Student elevenote = (Exo6Student) dis.readObject();
				

				System.out.println(elevenote.getNotes());

				System.out.println();

				dis.close();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();

		}

	}
}
