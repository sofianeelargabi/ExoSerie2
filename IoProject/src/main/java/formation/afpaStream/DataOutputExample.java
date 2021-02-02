package formation.afpaStream;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class DataOutputExample {

	public static void main(String[] args) {  //CLASSE PERMETTANT D'ECRIRE DES DONNEES PLUS GRANDE QUE DES BYTES

		int codePostal = 59100;
		String nom = "Lille";
		long nbrHabitant = 230000;
		float temprature = 2.5F;

		try {
			OutputStream w = new FileOutputStream("toto/data.txt");
			DataOutputStream dos = new DataOutputStream(w);
			
			dos.writeInt(codePostal);
			dos.writeUTF(nom);
			dos.writeLong(nbrHabitant);
			dos.writeFloat(temprature);
			w.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		catch (IOException e) {
			
			e.printStackTrace();
		}

	}

}